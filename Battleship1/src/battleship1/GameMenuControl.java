/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Jeremy and Melanie
 */
public class GameMenuControl {
    
    private Game game;
    private Board board;


    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.getBoard(); 
    }

        
    public Point playerTakesTurn(Players player, Point selectedLocation) {
        Point locationMarkerPlaced = null;

         if (player ==  null) {
            new BattleshipsError().displayError("You must start a new game first.");
            return null;
        }

        if (!player.getPlayerType().equals(Players.REGULAR_PLAYER) && 
            !player.getPlayerType().equals(Players.COMPUTER_PLAYER)) {
            new BattleshipsError().displayError("GameCommands - takeTurn: invalidPlayerTYpe");
            return null;
        }

        if (this.game.getStatus().equals(Game.NEW_GAME)) {
            this.game.setStatus(Game.PLAYING);
        }        
        else if (!this.game.getStatus().equals(Game.PLAYING )) {
            new BattleshipsError().displayError("There is no active game. "
                    + "You must start a new game before you can take a turn");
        }
        
       
        
        String playerType = player.getPlayerType();

        if (playerType.equals(Players.REGULAR_PLAYER)) {
            this.regularTurn(player, selectedLocation);
            locationMarkerPlaced = selectedLocation;
        }
        else if (playerType.equals(Players.COMPUTER_PLAYER)) {
            locationMarkerPlaced = this.coumputerTakesTurn(player);
        }

        this.alternatePlayers();

        return locationMarkerPlaced;
    }
    
    public void takeTurn(Point selectedLocation) {
        Players currentPlayer = this.game.getCurrentPlayer();
        Players otherPlayer = this.game.getOtherPlayer();
        
        String playerType = currentPlayer.getPlayerType(); 

        if (this.game.getGameType().equals(Game.ONE_PLAYER)) {
            if (currentPlayer.getPlayerType().equals(Players.REGULAR_PLAYER)) {
                this.playerTakesTurn(currentPlayer, selectedLocation);
                if (this.game.getStatus().equals(Game.PLAYING)) { // game over ?
                    return;
                }
                
                this.playerTakesTurn(otherPlayer, selectedLocation);
                String message = "The computer also took it's turn. "
                        + " it is your turn again " + currentPlayer.getName();
            }
            if (currentPlayer.getPlayerType().equals(Players.COMPUTER_PLAYER)) {
                this.playerTakesTurn(currentPlayer, selectedLocation);
                this.alternatePlayers();                
            } 
        } 
        else if (this.game.getGameType().equals(Game.TWO_PLAYER)) {
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
    
    public boolean regularTurn(Players player, Point location){
        if (location == null) {
            new BattleshipsError().displayError("GameCommands - regularTurn: location is null");
            return false;
        }
        
        if (game.getStatus().equals(game.PLAYING) && 
            game.getStatus().equals(Game.NEW_GAME)) {
            new BattleshipsError().displayError("There is no active game. "
                    + "You must start a new game before you can take a turn");
            return false;
        }

        game.setStatus(Game.PLAYING);
        this.markLocation(player, location);
        
        return true;
    }
    
    public Point coumputerTakesTurn(Players player) {
        // computer takes turn
        game.setStatus(Game.PLAYING); 
        Point location = this.getComputersSelection();
        this.markLocation(player, location);
        return location;
    }
    

    
    
    private void markLocation(Players player, Point location) {
 
        this.game.getBoard().occupyLocation(player, location.x, location.y);
        
        boolean aWinner = this.isWinner();
        if (aWinner) { // game won already
            this.game.recordWinner();
            this.game.setStatus(Game.WINNER);
            return;
        }
        
        this.game.setStatus(Game.PLAYING);
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

    
    public void startNewGame(Game game) {
        game.start();
        this.clearTheBoard();
    }
  
    
    
    public void clearTheBoard() {
        Players[][] locations = this.game.getBoard().getBoardLocations();
        
        for (int i = 0; i < this.board.getBoardLocations().length; i++) {
            Players[] rowlocations = locations[i];
            for (int j = 0; j < rowlocations.length; j++) {
                rowlocations[j] = null;
            }
        }
    }


    private boolean isTie() {
        Players[][] locations = this.board.getBoardLocations();

        for (int row = 0; row < locations.length; row++) {
            Players[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                Players location = rowLocations[col];
                if (locations[row][col] == null) { // square not taken yet
                    return false;
                }
            }
        }

        return true;
    }

    
    private boolean isWinner() {

        Players[][] locations = this.board.getBoardLocations();

        for (int row = 0; row < locations.length; row++) {
            Players[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                if (threeInARow(row, col, locations)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean threeInARow(int row, int col, Players[][] boardLocations) {
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

    private Point findWinningLocation(Players player) {
        Point coordinate = new Point();
        Players[][] locations = this.board.getBoardLocations();
        for (int row = 0; row < locations.length; row++) {
            Players[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                Players location = rowLocations[col];
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
        Players[][] locations = this.board.getBoardLocations();

        // create list of empty locations
        for (int row = 0; row < locations.length; row++) {
            Players[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                Players location = rowLocations[col];
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
