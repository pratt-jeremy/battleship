/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.gameview;

import jeremy.cit260.bship.control.Battleship;
import jeremy.cit260.bship.control.Battleship;
import java.awt.Point;
import java.util.Scanner;
import java.util.regex.Pattern;
import jeremy.cit260.bship.control.BattleshipsError;
import jeremy.cit260.bship.control.BattleshipsError;
import jeremy.cit260.bship.control.BattleshipsError;

/**
 *
 * @author Jeremy and Melanie
 */
/* public class GetLocationView {
     private jeremy.cit260.bship.models.Game game;
    
    public Object getLocation(Object object) {
        this.game = (jeremy.cit260.bship.models.Game) object;
        Scanner inFile = Battleship.getInputFile(); // get input file 

        // prompt for the row and column numbers
        System.out.println("\n\n\t" + game.getCurrentPlayer().getName() + " it is your turn."
                + " Enter a row and column number (For example: 1 3)");

        // read the row and column coordinates
        String[] coordinates;
        Point location = null;
        
        boolean valid = false;

        do {
            String strRowColumn = inFile.nextLine(); // read in row and column
            strRowColumn = strRowColumn.trim(); // trim all blanks from front and end 
                
            strRowColumn = strRowColumn.replace(',', ' '); // replace commas with a blank
            coordinates = strRowColumn.split("\\s"); // tokenize the string

            if (coordinates.length < 1) { // no coordinates specified
                new BattleshipsError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }    

            else if (coordinates.length == 1) { // only one coordinate
                if (coordinates[0].toUpperCase().equals("Q")) { // Quit?
                    return null;
                } else { // wrong number of values entered.
                    new BattleshipsError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                    continue;
                }
            }

            // user java regular expression to check for valid integer number?
            Pattern digitPattern = Pattern.compile(".*\\D.*");
            if (digitPattern.matcher(coordinates[0]).matches()  || 
                digitPattern.matcher(coordinates[1]).matches()
               ) {
                new BattleshipsError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);
            
            jeremy.cit260.bship.models.Board board = game.getBoard();
            if (row < 1   ||  row > board.getRowCount() ||
                column < 1  ||  column > board.getColumnCount()) {
                new BattleshipsError().displayError(
                        "Enter a valid number of rows and columns from 3 to 10. Try again.");
                continue;
            }

            location = new Point(row-1, column-1);
            valid = true;

        } while (!valid);
        
        return location;
            
    }

}
*/
