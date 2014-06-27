/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;

import java.awt.Dimension;

/**
 *
 * @author Jeremy and Melanie
 */
public class GamePreferencesMenuControl {
    
    private Game game;

    public GamePreferencesMenuControl() {
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
    
    public boolean saveMarker(Players player, String marker) { 

        if (player == null  ||  marker == null) {
            new BattleshipsError().displayError("saveMarker - player or marker is invalid");
            return false;
        }

   
           
        // update the players markers
        player.setMarker(marker);
        
        return true;
    }
        
    
    public boolean saveDimensions(Dimension dimension)  {
        // validate inputs
        if (this.game.getStatus().equals(Game.PLAYING)) {
            new BattleshipsError().displayError("You can not change the dimensions "
              + "of the board once the game has been started. "
              + "\nStart a new game and then change the dimensions "
              + "of the board. ");
            return false;
        }
        
        
        if (dimension == null) {
            new BattleshipsError().displayError(
                    "The number of rows must be between 3 -10 and the "
                    + "number of columns must be between 3 -10 ");
            return false;
        }
        
        int boardRowCount = dimension.width;
        int boardColumnCount= dimension.height;
        
        if (boardRowCount < 3 || boardRowCount > 10) {
            new BattleshipsError().displayError(
                    "The number of rows must be between 3 -10 and the "
                    + "number of columns must be between 3 -10 ");
            return false;
        }

        if (boardColumnCount < 3 || boardColumnCount > 10) {
            new BattleshipsError().displayError(
                    "The number of rows must be between 3 -10 and the "
                    + "number of columns must be between 3 -10 ");
            return false;
        }

        // no change in the board size so return
        if (boardRowCount == this.game.getBoard().getRowCount() &&
            boardColumnCount == this.game.getBoard().getColumnCount()) {
            return true;
        }
        
        // change the size board
        Players[][] boardLocations = new Players[boardRowCount][boardColumnCount];
        this.game.getBoard().getBoardDimensions().setLocation(boardRowCount, boardRowCount);
        this.game.getBoard().setBoardLocations(boardLocations);
        
        Dimension boardDimensions = new Dimension(boardRowCount, boardColumnCount);
        
        return true;
    }
    
    
    
}
