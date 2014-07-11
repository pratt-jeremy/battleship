/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import group.cit260.bship.exception.GameException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import jeremy.cit260.bship.models.Player;
import jeremy.cit260.bship.enume.PlayerType;
/**
 *
 * @author Jeremy and Melanie
 */
public class GameMenuControl {
    private final jeremy.cit260.bship.models.Game game;
    private final jeremy.cit260.bship.models.Board board;


    public GameMenuControl(jeremy.cit260.bship.models.Game game) {
        this.game = game;
        this.board = game.getBoard(); 
    }

        
    public Point playerTakesTurn(jeremy.cit260.bship.models.Player player, Point selectedLocation) throws GameException {
        Point locationMarkerPlaced = null;

         if (player ==  null) {
            new BattleshipsError().displayError("You must start a new game first.");
            return null;
        }

        if (!player.getPlayerType().equals(PlayerType.REGULAR_PLAYER) && 
            !player.getPlayerType().equals(PlayerType.COMPUTER_PLAYER)) {
            new BattleshipsError().displayError("GameCommands - takeTurn: invalidPlayerTYpe");
            return null;
        }

        if (this.game.getStatus().equals(jeremy.cit260.bship.models.Game.NEW_GAME)) {
            this.game.setStatus(jeremy.cit260.bship.models.Game.PLAYING);
        }        
        else if (!this.game.getStatus().equals(jeremy.cit260.bship.models.Game.PLAYING )) {
            new BattleshipsError().displayError("There is no active game. "
                    + "You must start a new game before you can take a turn");
        }
        
       
        
        PlayerType playerType = player.getPlayerType();

        if (playerType.equals(PlayerType.REGULAR_PLAYER)) {
            this.regularTurn(player, selectedLocation);
            locationMarkerPlaced = selectedLocation;
        }
        else if (playerType.equals(PlayerType.COMPUTER_PLAYER)) {
            locationMarkerPlaced = this.coumputerTakesTurn(player);
        }

        this.alternatePlayers();

        return locationMarkerPlaced;
    }
    
    public void takeTurn(Point selectedLocation) throws GameException {
        jeremy.cit260.bship.models.Player currentPlayer = this.game.getCurrentPlayer();
        jeremy.cit260.bship.models.Player otherPlayer = this.game.getOtherPlayer();
        
        PlayerType playerType = currentPlayer.getPlayerType(); 

        if (this.game.getGameType().equals(jeremy.cit260.bship.models.Game.ONE_PLAYER)) {
            if (currentPlayer.getPlayerType().equals(PlayerType.REGULAR_PLAYER)) {
                this.playerTakesTurn(currentPlayer, selectedLocation);
                if (this.game.getStatus().equals(jeremy.cit260.bship.models.Game.PLAYING)) { // game over ?
                    return;
                }
                
                this.playerTakesTurn(otherPlayer, selectedLocation);
                String message = "The computer also took it's turn. "
                        + " it is your turn again " + currentPlayer.getName();
            }
            if (currentPlayer.getPlayerType().equals(PlayerType.COMPUTER_PLAYER)) {
                this.playerTakesTurn(currentPlayer, selectedLocation);
                this.alternatePlayers();                
            } 
        } 
        else if (this.game.getGameType().equals(jeremy.cit260.bship.models.Game.TWO_PLAYER)) {
            this.playerTakesTurn(currentPlayer, selectedLocation);
            this.alternatePlayers();
        }
        



    }
    
    public void alternatePlayers() {
        if (this.game.getCurrentPlayer() == this.game.getPlayerA()) {
            this.game.setCurrentPlayer(this.game.getPlayerB());
            this.game.setOtherPlayer(this.game.getPlayerA());
        } else {
            this.game.setCurrentPlayer(this.game.getPlayerA());
            this.game.setOtherPlayer(this.game.getPlayerB());
        }
    }
    
    public boolean regularTurn (jeremy.cit260.bship.models.Player player, Point location) throws GameException{
        if (location == null) {
            new BattleshipsError().displayError("GameCommands - regularTurn: location is null");
            return false;
        }
        
        if (game.getStatus().equals(game.PLAYING) && 
            game.getStatus().equals(jeremy.cit260.bship.models.Game.NEW_GAME)) {
            new BattleshipsError().displayError("There is no active game. "
                    + "You must start a new game before you can take a turn");
            return false;
        }

        game.setStatus(jeremy.cit260.bship.models.Game.PLAYING);
        this.markLocation(player, location);
        
        return true;
    }
    
    public Point coumputerTakesTurn(jeremy.cit260.bship.models.Player player) throws GameException {
        // computer takes turn
        game.setStatus(jeremy.cit260.bship.models.Game.PLAYING); 
        Point location = this.getComputersSelection();
        this.markLocation(player, location);
        return location;
    }
    

    
    
    private void markLocation(jeremy.cit260.bship.models.Player player, Point location) throws GameException {
 
        this.game.getBoard().occupyLocation(player, location.x, location.y);
        if (this.isTie()) { // game tied already
            this.game.recordTie();
            this.game.setStatus(jeremy.cit260.bship.models.Game.TIE);
            return;
        }

        boolean aWinner = this.isWinner();
        if (aWinner) { // game won already
            this.game.recordWinner();
            this.game.setStatus(jeremy.cit260.bship.models.Game.WINNER);
            return;
        }
        
        this.game.setStatus(jeremy.cit260.bship.models.Game.PLAYING);
    }
    
    
    
    private Point getComputersSelection() {
        Point coordinate;

        coordinate = this.findWinningLocation(game.getCurrentPlayer());
        if (coordinate != null) { // winning location found for computer
            return coordinate;
        }

        // find winning location for other player
        coordinate = this.findWinningLocation(game.getOtherPlayer());
        if (coordinate == null) { // no winning location found for other player
            coordinate = this.chooseRandomLocation();

            if (coordinate == null) {
                new BattleshipsError().displayError("No empty locations found on the board");
                return null;
            }
        }
   
        return coordinate;
    }

    
    public void startNewGame(jeremy.cit260.bship.models.Game game) {
        game.start();
        this.clearTheBoard();
    }
  
    
    
    public void clearTheBoard() {
        jeremy.cit260.bship.models.Player[][] locations = this.game.getBoard().getBoardLocations();
        
        for (int i = 0; i < this.board.getBoardLocations().length; i++) {
            jeremy.cit260.bship.models.Player[] rowlocations = locations[i];
            for (int j = 0; j < rowlocations.length; j++) {
                rowlocations[j] = null;
            }
        }
    }


    private boolean isTie() {
        jeremy.cit260.bship.models.Player[][] locations = this.board.getBoardLocations();

        for (Player[] rowLocations : locations) {
            for (int col = 0; col < rowLocations.length; col++) {
                jeremy.cit260.bship.models.Player location = rowLocations[col];
                if (rowLocations[col] == null) {
                    // square not taken yet
                    return false;
                }
            }
        }

        return true;
    }

    
    private boolean isWinner() {

        jeremy.cit260.bship.models.Player[][] locations = this.board.getBoardLocations();

        for (int row = 0; row < locations.length; row++) {
            jeremy.cit260.bship.models.Player[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                if (threeInARow(row, col, locations)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean threeInARow(int row, int col, jeremy.cit260.bship.models.Player[][] boardLocations) {
        boolean winner = false;

        int columnLength = boardLocations[row].length;
        int rowLength = boardLocations.length;

        // square not taken yet
        if (boardLocations[row][col] == null) {
            return false;
        } // search for three adjacent horizontally
        else if (row < rowLength && col < columnLength - 2
                && boardLocations[row][col] == boardLocations[row][col + 1]
                && boardLocations[row][col] == boardLocations[row][col + 2]) {
            return true;
        } // search for three adjacent vertically
        else if (row < rowLength - 2 && col < columnLength
                && boardLocations[row][col] == boardLocations[row + 1][col]
                && boardLocations[row][col] == boardLocations[row + 2][col]) {
            return true;
        } // search for three adjacent diagonally leaning backward
        else if (row < rowLength - 2 && col < columnLength - 2
                && boardLocations[row][col] == boardLocations[row + 1][col + 1]
                && boardLocations[row][col] == boardLocations[row + 2][col + 2]) {
            return true;
        } // search for three adjacent diagonally learning forward
        else if (row < rowLength - 2 && col > 1
                && boardLocations[row][col] == boardLocations[row + 1][col - 1]
                && boardLocations[row][col] == boardLocations[row + 2][col - 2]) {
            return true;
        }

        return false;
    }

    private Point findWinningLocation(jeremy.cit260.bship.models.Player player) {
        Point coordinate = new Point();
        jeremy.cit260.bship.models.Player[][] locations = this.board.getBoardLocations();
        for (int row = 0; row < locations.length; row++) {
            jeremy.cit260.bship.models.Player[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                jeremy.cit260.bship.models.Player location = rowLocations[col];
                coordinate.setLocation(row, col);

                if (rowLocations[col] != null) { // location is occupied
                    continue;
                }

                // search for three adjacent horizontally
                if ((row < locations.length
                        && col < rowLocations.length - 2)
                        && (locations[row][col + 1] == player
                        && locations[row][col + 2] == player)) {
                    return coordinate;
                } else if ((row < locations.length
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row][col - 1] == player
                        && locations[row][col + 1] == player)) {
                    return coordinate;
                } else if ((row < locations.length && col > 1)
                        && (locations[row][col - 1] == player
                        && locations[row][col - 2] == player)) {
                    return coordinate;
                } // search for three adjacent vertically
                else if ((row < locations.length - 2
                        && col < rowLocations.length)
                        && (locations[row + 1][col] == player
                        && locations[row + 2][col] == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col < rowLocations.length)
                        && (locations[row - 1][col] == player
                        && locations[row + 1][col] == player)) {
                    return coordinate;
                } else if ((row > 1 && col < rowLocations.length)
                        && (locations[row - 1][col] == player
                        && locations[row - 2][col] == player)) {
                    return coordinate;
                } // search for three adjacent diagonally leaning backward
                else if ((row < locations.length - 2
                        && col < rowLocations.length - 2)
                        && (locations[row + 1][col + 1] == player
                        && locations[row + 2][col + 2] == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row - 1][col + 1] == player
                        && locations[row + 1][col - 1] == player)) {
                    return coordinate;
                } else if ((row > 1 && col > 1)
                        && (locations[row - 1][col - 1] == player
                        && locations[row - 2][col - 2] == player)) {
                    return coordinate;
                } // search for three adjacent diagonally learning forward
                else if ((row < locations.length - 2 && col > 1)
                        && (locations[row + 1][col - 1] == player
                        && locations[row + 2][col - 2] == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row - 1][col + 1] == player
                        && locations[row + 1][col - 1] == player)) {
                    return coordinate;
                } else if ((row > 1 && col < rowLocations.length - 2)
                        && (locations[row - 1][col + 1] == player
                        && locations[row - 2][col + 2] == player)) {
                    return coordinate;
                }
            }
        }

        return null; // not found
    }

    private Point chooseRandomLocation() {
        Point randomLocation;

        ArrayList<Point> listOfEmptyLocations = new ArrayList<>();
        jeremy.cit260.bship.models.Player[][] locations = this.board.getBoardLocations();

        // create list of empty locations
        for (int row = 0; row < locations.length; row++) {
            jeremy.cit260.bship.models.Player[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                jeremy.cit260.bship.models.Player location = rowLocations[col];
                if (location == null) { // location not occupied?
                    listOfEmptyLocations.add(new Point(row, col));
                }
            }
        }

        int noOfEmptyLocations = listOfEmptyLocations.size();

        if (noOfEmptyLocations == 0) { // no empty locations?
            return null;
        } else if (listOfEmptyLocations.size() == 1) { // only one empty location?
            randomLocation = listOfEmptyLocations.get(0);
            return randomLocation;
        } else { // randomly choose one of the empty locations
            int randomNumber = new Random().nextInt(noOfEmptyLocations);
            randomLocation = listOfEmptyLocations.get(randomNumber);
            return randomLocation;
        }
    }
    
}

