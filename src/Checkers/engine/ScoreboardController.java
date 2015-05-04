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
    private BufferedReader fileIn;
    private BufferedWriter fileOut;
    private ArrayList players;
    
    public ScoreboardController(){
        try {
            fileIn = new BufferedReader( new FileReader("scoreboard.csv") );
        } catch( FileNotFoundException e ){
            System.err.println( "Error opening file - creating empty score file." );
            try {
                FileOutputStream out = new FileOutputStream("scoreboard.csv");
                out.close();
                fileIn = new BufferedReader( new FileReader("scoreboard.csv") );
            } catch( IOException io ){
                io.printStackTrace();
            }
        }
        
        players = new ArrayList<PlayerScore>();
    }
}
