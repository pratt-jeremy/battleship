/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;


/**
 *
 * @author Jeremy and Melanie
 */
public class Players {
    
    public static final String REGULAR_PLAYER = "REGULAR";
    public static final String COMPUTER_PLAYER = "COMPUTER"; 

    public String name;
    public String playerType;
    public long wins = 0;
    public long losses = 0;
    public String marker;
   
    

    public Players() {
    }

    public Players(String playerType, String marker) {
        this.playerType = playerType;
        this.marker = marker;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }




    
    
    
    private double getWinningPercentage() {
        double totalScore = this.getWins() + this.getLosses();
        
        if (totalScore ==  0) {
            return 0;
        }
        
        double winLossRatio = this.getWins() / totalScore;
        return winLossRatio*100;
    }

    public String getPlayerStastics() {
        String playerStatistics = 
                this.getName() + " has won "
                + this.getWinningPercentage() + "% of the games."
                + "\n\t" + this.getWins() + " wins, "
                + this.getLosses() + " losses";
        
        return playerStatistics;
    }

    
}
