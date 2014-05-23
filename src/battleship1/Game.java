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
    public final static String PLAYER_A_DEFAULT_MARKER = "X";
    public final static String PLAYER_B_DEFAULT_MARKER = "O";
       
    public static final String ONE_PLAYER = "ONE_PLAYER";
    public static final String TWO_PLAYER = "TWO_PLAYER";
    
    public static final String CONTINUE = "CONTINUE";
    public static final String NEW_GAME = "NEW_GAME";
    public static final String PLAYING = "PLAYING"; 
    public static final String WINNER = "WINNER"; 
    public static final String QUIT = "QUIT"; 
    public static final String ERROR = "ERROR";
    public static final String EXIT = "EXIT";
    String gameType;
    Players playerA;
    Players playerB;
    Players currentPlayer;
    Players winner;
    Players loser;
    Board board;
    Ships ships;
    Ships hits;
    private String status;
    private Players otherPlayer;
    
    public Game() {
   
       this.playerA = new Players();
       this.playerB = new Players();
       
       this.playerA.setMarker(Game.PLAYER_A_DEFAULT_MARKER);
       this.playerB.setMarker(Game.PLAYER_B_DEFAULT_MARKER);
    }

    public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.board = new Board(10, 10);
        
    }


    public void start() {

        this.setPlayingOrder(playerA, playerB);

        // clear the board
        this.board.clearTheBoard();
        this.status = Game.NEW_GAME;
    }

    public void setPlayingOrder(Players player1, Players player2) {

        double randomValue = Math.random();

        if (randomValue < 0.5) {
            this.currentPlayer = player1;
            this.otherPlayer = player2;
        } else {
            this.otherPlayer = player2;
            this.currentPlayer = player1;
        }

    }

    public void recordWinner() {
        if (this.currentPlayer == this.playerA) {
            this.winner = this.playerA;
            this.loser = this.playerB;
        } else {
            this.winner = this.playerB;
            this.loser = this.playerA;
        }

        long noWins = this.winner.getWins();
        noWins++;
        this.winner.setWins(noWins);
        long noLosses = this.loser.getLosses();
        noLosses++;
        this.loser.setLosses(noLosses);

        this.status = Game.WINNER;
        
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
