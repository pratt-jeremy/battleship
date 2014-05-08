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
public class Board {
    int rowCount = 10;
    int columnCount = 10;
    
    Location[][] boardLocations;
    
    public Board() {
    }
    
    public void displaySize() {
        System.out.println("\n\t The board is a " + this.rowCount + "by " + 
                this.columnCount + "grid.");
    }
}
