package Checkers.engine;

/**
 * Data storage for the ScoreboardController class.
 * Each player has a name, number of wins, and number of games played.
 * @author mss9627
 */
public class PlayerScore implements Comparable {
    private final String name;
    private int wins;
    private int games;
    
    /**
     * Creates a new PlayerScore object, and confirms that the win rate
     * for this player can be valid.
     * 
     * @param playerName The player's name.
     * @param numWins    The total number of wins for this player.
     * @param numGames   The combined wins, losses, and draws for this player.
     */
    public PlayerScore( String playerName, int numWins, int numGames ){
        name = playerName;
        wins = numWins;
        games = numGames;
        checkValidity();
    }
    
    /**
     * Checks whether a user has made a manual, invalid change to the score file.
     * If a record has a win percentage greater than 100%, reset both the wins 
     * and games played to 0.
     */
    private void checkValidity(){
        if( games < 0 ) games = 0;
        if( wins < 0 ) wins = 0;
        
        if( games < wins ){
            System.out.println( "Games played for " + name + " are invalid.");
            System.out.println( "The record for " + name + "has been reset.");
            games = 0;
            wins = 0;
        }
    }
    
    /**
     * Updates a player's record after a game is completed.
     *
     * @param hasWon True for a player winning a game.
     */
    public void addGame( boolean hasWon ){
        games++;
        if( hasWon ) wins++;
    }
    
    /**
     * Returns the percentage of won games for the given player.
     * A player with no games played is considered to have a 0% win rate.
     * 
     * @return the percentage of wins to total games out of 100%
     */
    public double getWinPercentage(){
        if( games == 0 ) return 0;
        return ((double) wins / games) * 100;
    }
    
    public String getName(){ return name; }
    public int getWins(){ return wins; }
    public int getGames(){ return games; }

    /**
     * Used to sort a list of players by name.
     * This is required to add new players in sorted order.
     *
     * @param p The PlayerScore being compared with this object.
     * @return positive if this player's name is lexicographically ahead of the 
     *         other player's name, negative if lexicographically behind, or 
     *         zero if equal.
     */    
    @Override
    public int compareTo( Object p ) {
        if( p instanceof PlayerScore ){
            PlayerScore temp = (PlayerScore) p;
            return name.compareTo( temp.getName() );
        }
        throw new ClassCastException( "Object must be of type PlayerScore." );
    }
    
    /**
     * Creates a comma separated string for the PlayerScore to place in the CSV file.
     * @return a string in the format name,wins,games
     */
    @Override
    public String toString(){
        String winNum = Integer.toString(wins);
        String gameNum = Integer.toString(games);
        return name + "," + winNum + "," + gameNum;
    }
    
}
