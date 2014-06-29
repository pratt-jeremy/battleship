/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author J. Pratt
 */
public class Game {
    public static final String PLAYER_A_DEFAULT_MARKER = "X";
    public static final String PLAYER_B_DEFAULT_MARKER = "O";
    
    public static final String ONE_PLAYER = "ONE_PLAYER";
    public static final String TWO_PLAYER = "TWO_PLAYER";
    
    public static final String CONTINUE = "CONTINUE";
    public static final String NEW_GAME = "NEW_GAME";
    public static final String PLAYING = "PLAYING"; 
    public static final String WINNER = "WINNER"; 
    public static final String TIE = "TIE"; 
    public static final String QUIT = "QUIT"; 
    public static final String ERROR = "ERROR";
    public static final String EXIT = "EXIT";

    private String gameType;
    private battleship1.Player playerA;
    private battleship1.Player playerB;
    private battleship1.Player currentPlayer;
    private battleship1.Player otherPlayer;
    private battleship1.Player winner;
    private battleship1.Player loser;
    private String status;
    private battleship1.Board board;
   

    

    public Game() {
        

        
       this.playerA = new battleship1.Player();
       this.playerB = new battleship1.Player();
       
       this.playerA.setMarker(Game.PLAYER_A_DEFAULT_MARKER);
       this.playerB.setMarker(Game.PLAYER_B_DEFAULT_MARKER);
    }

    public Game(String gameType) {
        this();

        this.gameType = gameType;
        this.board = new battleship1.Board(10,10);
        
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public battleship1.Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(battleship1.Player playerA) {
        this.playerA = playerA;
    }

    public battleship1.Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(battleship1.Player playerB) {
        this.playerB = playerB;
    }

    public battleship1.Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(battleship1.Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public battleship1.Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(battleship1.Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public battleship1.Player getWinner() {
        return winner;
    }

    public void setWinner(battleship1.Player winner) {
        this.winner = winner;
    }

    public battleship1.Player getLoser() {
        return loser;
    }

    public void setLoser(battleship1.Player loser) {
        this.loser = loser;
    }

    public battleship1.Board getBoard() {
        return board;
    }

    public void setBoard(battleship1.Board board) {
        this.board = board;
    }




    public void start() {

        this.setPlayingOrder(playerA, playerB);

        // clear the board
        this.board.clearTheBoard();
        this.setStatus(Game.NEW_GAME);
    }

    public void setPlayingOrder(battleship1.Player player1, battleship1.Player player2) {

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

        this.setStatus(Game.WINNER);
        
    }

    public void recordTie() {
        long player1Ties = this.playerA.getTies();
        player1Ties++;
        this.playerA.setTies(player1Ties);
        long player2Ties = this.playerB.getTies();
        player2Ties++;
        this.playerB.setTies(player2Ties);

        this.setStatus(Game.TIE);
       
    }



    public String getWinningMessage () {
        return "\n\t*******************************************************************************"
             + "\n\t Congratulations " + winner.getName() + "! You won the game."
             + "\n\t Sorry " + loser.getName() + ", You are the loser." 
             + "\n\t*******************************************************************************";
    }

    public String getTiedMessage () {
       return "\n\t*******************************************************************************"
             + "\n\t The game is a tie. Better luck next time!" 
             + "\n\t*******************************************************************************";
    }
}


