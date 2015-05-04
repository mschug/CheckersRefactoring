package Checkers.engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Uses a CSV file to load and store a persistent scoreboard, listing the
 * all-time win record for each name entered into the second screen of the game.
 * @author mss9627
 */
public class ScoreboardController {
    public static final boolean WIN = true;
    public static final boolean LOSE = false;
    public static final boolean DRAW = false;
    private BufferedReader fileIn;
    private BufferedWriter fileOut;
    private ArrayList<PlayerScore> players;
    
    public ScoreboardController(){
        try {
            fileIn = new BufferedReader( new FileReader("scoreboard.csv") );
        } catch( FileNotFoundException e ){
            System.err.println( "Error opening file - creating empty score file." );
            try {
                FileOutputStream out = new FileOutputStream("scoreboard.csv");
                out.close();
                fileIn = new BufferedReader( new FileReader("scoreboard.csv") );
            } catch( IOException io ){}
        }
        
        players = new ArrayList<>();
        try {
            while( fileIn.ready() ){
                parseLine( fileIn.readLine() );
            }
            fileIn.close();
        } catch( IOException e ){}
    }
    
    /**
     * Processes each input line, creating PlayerScore objects for each line.
     * Removes invalid input lines from the scoreboard.
     * 
     * @param line The next input line to read.
     */
    private void parseLine( String line ){
        String[] params = line.split(",");
        
        if( params.length != 3 ){
            System.out.println( "Input line was invalid." );
            System.out.println( "Line \"" + line + "\" will be erased upon the next save.");
        }
        
        String name = params[0];
        int wins = tryParse( params[1] );
        int games = tryParse( params[2] );
        
        PlayerScore p = new PlayerScore(name, wins, games);
        players.add( p );
    }
    
    /*
     * Attempts to parse an integer from a line in the CSV file.
     * 
     * @param num The string of (what should be) an integer.
     * @return the value of num if valid, or 0 if invalid.
     */
    private int tryParse( String num ){
        try {
            return Integer.parseInt( num );
        } catch( NumberFormatException e ){
            return 0;
        }
    }
    
    /**
     * Overwrites the CSV file, saving new records from the players list.
     * Any invalid lines found while opening the file are erased.
     */
    private void saveFile(){
        try {
            fileOut = new BufferedWriter( new FileWriter("scoreboard.csv") );
            for( PlayerScore p : players ){
                fileOut.write( p.toString() );
                fileOut.newLine();
            }
            fileOut.close();
        } catch( FileNotFoundException f ){
        } catch( IOException io ){}
    }
    
}
