/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit210.tictactoe.views;

import byui.cit210.tictactoe.intefaces.DisplayInfo;
import byui.cit210.tictactoe.models.Board;
import byui.cit210.tictactoe.models.Player;

/**
 *
 * @author jacksonrkj
 */
public class BoardView implements DisplayInfo {
    
    Board board;
    
    @Override
    public Object display(Object object) {
        this.board = (Board) object;
        this.printHeadRow();
        this.printDividerRow();
        for (int i = 0; i < this.board.getRowCount(); i++) {
            Player[] rowOfLocations = this.board.getBoardLocations()[i];
            this.printRow(i+1, rowOfLocations);
            this.printDividerRow();
        }
        System.out.println();
         
        return null;
    }

    private void printHeadRow() {

        // print first cell

        System.out.print("\n\t      1   ");
        int columnsInRow = this.board.getColumnCount();
        // print remaining cells in row
        for (int i = 1; i < columnsInRow - 1; i++) {
            int col = i + 1;
            System.out.print("  " + col + "   ");
        }
        System.out.print(" " + columnsInRow + "   ");
    }

    private void printDividerRow() {

        // print first cell

        System.out.print("\n\t  |------");
        int columnsInRow = this.board.getColumnCount();
        // print remaining cells in row
        for (int i = 1; i < columnsInRow - 1; i++) {
            System.out.print("------");
        }
        System.out.print("-----|");
    }

    private void printRow(int rowNumber, Player[] rowLocations) {
        
        // print first cell
        String letter = " ";
        if (rowLocations[0] != null) {
            letter = rowLocations[0].getMarker();
        }
        System.out.print("\n\t" + rowNumber + " |  " + letter + "  |");

        // print remaining cells in row
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i] == null) {
                letter = " ";
            } else {
                letter = rowLocations[i].getMarker();
            }
            System.out.print("  " + letter + "  |");
        }
    }

}
