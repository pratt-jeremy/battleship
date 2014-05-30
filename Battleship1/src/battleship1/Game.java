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
public class Game {
    static Object ONE_PLAYER;
    static Object ONE_PLAYERS;
    static Boolean PLAYER_A_DEFAULT_MARKER;
    static String EXIT;


  
    String gameType;
    Players playerA;
    Players playerB;
    Players currentPlayer;
    Players winner;
    Players loser;
    Board board;
    Ships ships;
    Ships hits;
    
    public Game() {
        this.playerA = new Players();
        this.playerA.name = "Dave";
        this.playerB = new Players();
        this.playerB.name = "Johnny";
        
        
    }

    Game(Object ONE_PLAYER) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void displayWinningMessage(){
        System.out.println(
                "\n\tSuperb " + this.winner.name 
                + "\n\t you sunk all of " + this.loser.name + "'s Battleships!"
                + "\n\tYou Win!");
    }
    public void displayPlayers() {
        System.out.println("\n\tWe welcome our fearless champions back");
        this.playerA.displayName();
        this.playerB.displayName();
    }
}
