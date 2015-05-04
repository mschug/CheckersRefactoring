package Checkers.engine;

/**
 * Data storage for the ScoreboardController class.
 * Each player has a name, number of wins, and number of games played.
 * @author mss9627
 */
public class PlayerScore implements Comparable {
    private String name;
    private int wins;
    private int games;
    
    public PlayerScore( String playerName, int numWins, int numGames ){
        name = playerName;
        wins = numWins;
        games = numGames;
        checkValidity();
    }
    
    /*
     * Checks whether a user has made a manual, invalid change to the score file.
     * If a record has a win percentage greater than 100%, reset both the wins 
     * and games played to 0.
     */
    private boolean checkValidity(){
        if( games < wins ){
            System.out.println( "Games played for " + name + " are invalid.");
            System.out.println( "The record for " + name + "has been reset.");
            games = 0;
            wins = 0;
            return false;
        }
        return true;
    }
    
    /*
     * Updates a player's record after a game is completed.
     */
    public void addGame( boolean hasWon ){
        games++;
        if( hasWon ) wins++;
    }
    
    /*
     * Returns the percentage of won games for the given player.
     * A player with no games played is considered to have a 0% win rate.
     */
    public double getWinPercentage(){
        if( games == 0 ) return 0;
        return ((double) wins) / games;
    }
    
    public String getName(){
        return name;
    }
    
    public int getWins(){
        return wins;
    }
    
    public int getGames(){
        return games;
    }

    /*
     * Used to sort a list of players by name.
     * This is required to add new players in sorted order.
     */
    @Override
    public int compareTo( Object p ) {
        if( p instanceof PlayerScore ){
            PlayerScore temp = (PlayerScore) p;
            return name.compareTo( temp.getName() );
        }
        throw new ClassCastException( "Object must be of type PlayerScore." );
    }
    
}
