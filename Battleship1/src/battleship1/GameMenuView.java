/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.awt.Point;

/**
 *
 * @author Jeremy & Melanie
 */
public class GameMenuView extends Menu {
    
    private battleship1.Game game;
    private final battleship1.GameMenuControl gameCommands; 
    private final GetLocationView getLocation = new GetLocationView();
    private battleship1.BoardView displayBoard = new battleship1.BoardView();

    private final static String[][] menuItems = {
        {"T", "Take your turn"},
        {"D", "Display the board"},
        {"N", "New Game"},
        {"R", "Report stastics"},
        {"P", "Change game preferences"},
        {"H", "Help"},
        {"Q", "Quit"}
    };

    public GameMenuView(battleship1.Game game) {
        super(GameMenuView.menuItems);
        this.gameCommands = new battleship1.GameMenuControl(game);
    }

    public battleship1.BoardView getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(battleship1.BoardView displayBoard) {
        this.displayBoard = displayBoard;
    }

    

    @Override
    public String executeCommands(Object object) {
        this.game = (battleship1.Game) object;

        String gameStatus = battleship1.Game.CONTINUE;
        do {
     
            this.display();
            
            // get commaned entered
            String command = this.getCommand();
            switch (command) {
                case "T":
                    this.takeTurn();
                    break;
                case "D":
                    this.displayBoard.display(game.getBoard());
                    break;
                case "N":
                    gameCommands.startNewGame(game);
                    this.displayBoard.display(game.getBoard());
                    break;
                case "R":
                    this.displayStatistics();
                    break;
                case "P":
                    GamePreferencesMenuView gamePreferencesMenu = Battleship.getGamePreferencesMenu();
                    gamePreferencesMenu.display();
                    gamePreferencesMenu.executeCommands(this.game);
                    break;
                case "H":
                    battleship1.HelpMenuView helpMenu = Battleship.getHelpMenu();
                    helpMenu.executeCommands(null);
                    break;
                case "Q":
                    gameStatus = battleship1.Game.QUIT;
                    break;
            }
        } while (!gameStatus.equals(battleship1.Game.QUIT));

        return battleship1.Game.PLAYING;
    }
    
    
   private void takeTurn() {
        String playersMarker;
        Point selectedLocation;

        if (!this.game.getStatus().equals(battleship1.Game.NEW_GAME) && 
            !this.game.getStatus().equals(battleship1.Game.PLAYING)) {
            new BattleshipsError().displayError(
                    "There is no active game. You must start a new game before "
                    + "you can take a turn");
            return;
        }
        battleship1.Player currentPlayer = this.game.getCurrentPlayer();
        battleship1.Player otherPlayer = this.game.getOtherPlayer();

        // get location for first player
        selectedLocation = (Point) getLocation.getLocation(this.game);
        if (selectedLocation == null) {
            return;
        }

        // regular players turn
        Point locationMarkerPlaced = 
                this.gameCommands.playerTakesTurn(currentPlayer, selectedLocation);

        if (this.gameOver()) { // game won or tied?  
            return;
        }

        if (this.game.getGameType() == null ? battleship1.Game.ONE_PLAYER == null : this.game.getGameType().equals(battleship1.Game.ONE_PLAYER)) {
            // computers turn
            locationMarkerPlaced = this.gameCommands.playerTakesTurn(otherPlayer, null);

            if (this.gameOver()) { // game won or tied?
                return;
            }
        }


        // display board and prompt for next player's turn
        this.displayBoard.display(game.getBoard());
        String promptNextPlayer = getNextPlayerMessage(otherPlayer);
        System.out.println("\n\n\t" + promptNextPlayer);


    }

    private boolean gameOver() {
        boolean done = false;
        switch (this.game.getStatus()) {
            case battleship1.Game.TIE:
                // a tie?
                System.out.println("\n\n\t" + this.game.getTiedMessage());
                done = true;
                break;
            case battleship1.Game.WINNER:
                // a win?
                System.out.println("\n\n\t" + this.game.getWinningMessage());
                done = true;
                break;
        }
        
        if (done) {
            this.displayBoard.display(this.game.getBoard());
        }
        

        return done;
    }
    
        
    private String getNextPlayerMessage(battleship1.Player player) {
        if (this.game.getGameType().equals(battleship1.Game.ONE_PLAYER)) {
            return "The computer took it's turn. It is now your turn. "
                    + player.getName();
        } else {
            return "It is now your turn "
                    + player.getName();
        }
    }
    
    
    private void displayStatistics() {
        String playerAStatistics = this.game.getPlayerA().getPlayerStastics();
        String playerBStatistics = this.game.getPlayerB().getPlayerStastics();
        System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t " + playerAStatistics);
        System.out.println("\n\t " + playerBStatistics);
        System.out.println("\t+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


   
}

