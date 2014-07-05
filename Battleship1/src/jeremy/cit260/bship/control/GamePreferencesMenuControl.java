/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import java.awt.Dimension;

/**
 *
 * @author Jermey and Melanie
 */
public class GamePreferencesMenuControl {
       
    private jeremy.cit260.bship.models.Game game;

    public GamePreferencesMenuControl() {
    }

    public jeremy.cit260.bship.models.Game getGame() {
        return game;
    }

    public void setGame(jeremy.cit260.bship.models.Game game) {
        this.game = game;
    }
    
    
    
    public boolean saveMarker(jeremy.cit260.bship.models.Player player, String marker) { 

        if (player == null  ||  marker == null) {
            new BattleshipsError().displayError("saveMarker - player or marker is invalid");
            return false;
        }

   
        if (game.getPlayerA().getMarker().equals(game.getPlayerB().getMarker())) {
            new BattleshipsError().displayError("Both players can not use the same character for a marker.");
            return false;
        }
        
        // update the players markers
        player.setMarker(marker);
        
        return true;
    }
        
    
    public boolean saveDimensions(Dimension dimension)  {
        // validate inputs
        if (this.game.getStatus().equals(jeremy.cit260.bship.models.Game.PLAYING)) {
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
        jeremy.cit260.bship.models.Player[][] boardLocations = new jeremy.cit260.bship.models.Player[boardRowCount][boardColumnCount];
        this.game.getBoard().getBoardDimensions().setLocation(boardRowCount, boardRowCount);
        this.game.getBoard().setBoardLocations(boardLocations);
        
        Dimension boardDimensions = new Dimension(boardRowCount, boardColumnCount);
        
        return true;
    }
    
    
    
}

