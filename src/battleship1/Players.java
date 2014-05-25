/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author J.Pratt
 */
public class Players {
    public static final String REGULAR_PLAYER = "REGULAR";
    public static final String COMPUTER_PLAYER = "COMPUTER"; 
    String name;
    String alias;
    long wins = 0;
    long losses = 0;
    String gender;
    double age = 0;
    public String marker;
    private String playerType;
        
    
    public Players() {    
}


    public Players(String playerType, String marker) {
        this.playerType = playerType;
        this.marker = marker;
    }
    
    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
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



    public void displayName() {
        System.out.println("\t\tAhoy! Me name is " + this.name);
    }
    public double getWinningPercentage() {
     
        if (wins < 0 ) {
            System.out.println("\n\tThe number of wins must be "
                    + "greater than or equal to zero.");
            return -999;
        }
        
        if (losses < 0 ) {
            System.out.println("\n\tThe number of losses must be "
                    + "greater than or equal to zero.");
            return -999;
        }
                
        double totalScore = wins + losses;
        
        if (totalScore ==  0) {
            return 0;
        }
        
        double winLossRatio = wins / totalScore;
        return winLossRatio * 100;
    }



}