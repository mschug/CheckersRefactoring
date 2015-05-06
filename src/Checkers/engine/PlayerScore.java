package Checkers.engine;

/**
 * Data storage for the ScoreboardController class.
 * Each player has a name, number of wins, draws, and number of games played.
 * @author mss9627
 */
public class PlayerScore implements Comparable {
    public static final int WIN = 3;
    public static final int DRAW = 1;
    public static final int LOSS = 0;
    
    private final String name;
    private int wins;
    private int draws;
    private int games;
    
    /**
     * Creates a new PlayerScore object, and confirms that the win rate
     * for this player can be valid.
     * 
     * @param playerName The player's name.
     * @param numWins    The total number of wins for this player.
     * @param numDraws   The total number of draws for this player.
     * @param numGames   The combined wins, draws, and losses for this player.
     */
    public PlayerScore( String playerName, int numWins, int numDraws, int numGames ){
        name = playerName;
        wins = numWins;
        draws = numDraws;
        games = numGames;
        checkValidity();
    }
    
    /**
     * Checks whether a user has made a manual, invalid change to the score file.
     * If a record has a win percentage greater than 100%, reset both the wins 
     * and games played to 0.
     */
    private void checkValidity(){
        if( draws < 0 ) draws = 0;
        if( wins < 0 ) wins = 0;
        if( games < 0 ) games = 0;
        
        if( games < (wins + draws) ){
            System.out.println( "Games played for " + name + " are invalid.");
            System.out.println( "The record for " + name + "has been reset.");
            games = 0;
            wins = 0;
            draws = 0;
        }
    }
    
    /**
     * Updates a player's record after a game is completed.
     *
     * @param hasWon WIN (3) for a win, DRAW(1) for a draw, or LOSS (0) for a loss
     */
    public void addGame( int status ){
        games++;
        if( status == WIN ) wins++;
        if( status == DRAW ) draws++;
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
    
    /*
     * Used to print various statistics for the player.
     * Score is based on a 3-1-0 system, such as in football leagues.
     * Average score per game is used to determine ranking.
     */
    public String getName(){ return name; }
    public int getWins(){ return wins; }
    public int getDraws(){ return draws; }
    public int getGames(){ return games; }
    public int getLosses(){ return games - (wins + draws); }
    public int getScore(){ return 3 * wins + draws; }
    public double getAverageScore(){ return getScore() / (double) games; }

    /**
     * Used to sort a list of players by name.
     * This is required to add new players in sorted order.
     *
     * @param p The PlayerScore being compared with this object.
     * @return 1 or -1 based on the average number of points per game (max is 3).
     *         If average is equal, rank based on games played.
     *         If both are equal, the players are sorted by name.
     */    
    @Override
    public int compareTo( Object p ) {
        if( p instanceof PlayerScore ){
            PlayerScore temp = (PlayerScore) p;
            
            if( this.getAverageScore() > temp.getAverageScore() ) return 1;
            else if( this.getAverageScore() < temp.getAverageScore() ) return -1;
            else if( games > temp.getGames() ) return 1;
            else if( games < temp.getGames() ) return -1;
            
            return name.compareTo(temp.getName());
        }
        throw new ClassCastException( "Object must be of type PlayerScore." );
    }
    
    /**
     * Creates a comma separated string for the PlayerScore to place in the CSV file.
     * @return a string in the format name,wins,draws,games
     */
    @Override
    public String toString(){
        String winNum = Integer.toString(wins);
        String drawNum = Integer.toString(draws);
        String gameNum = Integer.toString(games);
        return name + "," + winNum + "," + drawNum + "," + gameNum;
    }
    
}
