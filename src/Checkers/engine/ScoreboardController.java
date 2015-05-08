package Checkers.engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
    private BufferedReader fileIn;
    private BufferedWriter fileOut;
    private ArrayList<PlayerScore> players;
    
    public ScoreboardController(){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/Checkers/engine/scoreboard.csv");
        try {
            fileIn = new BufferedReader( new FileReader( filePath ) );
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
        
        if( params.length != 4 ){
            System.out.println( "Input line was invalid." );
            System.out.println( "Line \"" + line + "\" will be erased upon the next save.");
        }
        
        String name = params[0];
        int wins = tryParse( params[1] );
        int draws = tryParse( params[2] );
        int games = tryParse( params[3] );
        
        PlayerScore p = new PlayerScore(name, wins, draws, games);
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
     * Called once a game is completed.
     * Updates the scores of both players and saves the updated scoreboard.
     * 
     * @param playerOne The name of the first player.
     * @param playerTwo The name of the second player.
     * @param winner    1 for a Player 1 win, 2 for a Player 2 win, or 0 for a draw.
     */
    public void updateScores( String playerOne, String playerTwo, int winner ){
        PlayerScore p1 = null;
        PlayerScore p2 = null;
        for( PlayerScore p : players ){
            if( p.getName().equals( playerOne ) ){
                p1 = p;
            } else if( p.getName().equals( playerTwo ) ){
                p2 = p;
            }
            if( p1 != null && p2 != null ){
                break;
            }
        }
        
        if( p1 == null ){
            p1 = new PlayerScore( playerOne, 0, 0, 0 );
            players.add( p1 );
        }
        if( p2 == null ){
            p2 = new PlayerScore( playerTwo, 0, 0, 0 );
            players.add( p2 );
        }
        
        if( winner == 1 ){
            p1.addGame( PlayerScore.WIN );
            p2.addGame( PlayerScore.LOSS );
        } else if( winner == 2 ){
            p1.addGame( PlayerScore.LOSS );
            p2.addGame( PlayerScore.WIN );
        } else {
            p1.addGame( PlayerScore.DRAW );
            p2.addGame( PlayerScore.DRAW );
        }
        
        saveFile();
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
    
    /**
     * Deletes all players from the scoreboard and overwrites the scoreboard file.
     */
    public void resetScores(){
        players.clear();
        saveFile();
    }

    public ArrayList<PlayerScore> getScores() {
        return players;
    }
}
