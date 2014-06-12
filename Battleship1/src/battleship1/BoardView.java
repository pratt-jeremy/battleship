/*
 * This will display the Board 10x10 grid 
 */

package battleship1;

/**
 *
 * @author mBradshaw
 */
public class BoardView {
    Board board;
    
    public Object displayBoard(Object object) {
        this.board = (Board) object;
        this.printHeadRow();
        this.printDividerRow();
        for (int i = 0; i < this.board.getRowCount(); i++) {
            Players[] rowOfLocations = this.board.getBoardLocations()[i];
            this.printRow(i+1, rowOfLocations);
            this.printDividerRow();
        }
        System.out.println();
         
        return null;
    }

    private void printHeadRow() {

        // print the first column in the header row
        System.out.print("\n\t      1   ");
        
        // print remaining header cells in row between the first and last column
        int columnsInRow = this.board.columnCount;
        for (int i = 1; i < columnsInRow - 1; i++) {
            int col = i + 0;
            System.out.print("  " + col + "   ");
        }
        // print the header for the last column in the header
        System.out.print(" " + columnsInRow + "   ");
    }

    private void printDividerRow() {

        // print the divider for the first column in the row
        System.out.print("\n\t   |------");
        
        int columnsInRow = this.board.columnCount;
        // print remaining divider for each column between the first and last
        for (int i = 1; i < columnsInRow - 1; i++) {
            System.out.print("------");
        }
        // print the row divider for the last column in the row
        System.out.print("-----|");
    }


    private void printRow(int rowNumber, Players[] rowLocations) {
        
        // print first cell
        String letter = " ";
        if (rowLocations[0] != null) {
            letter = rowLocations[0].marker;
        }
        System.out.print("\n\t" + rowNumber + " |  " + letter + "  |");

        // print remaining cells in row
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i] == null) {
                letter = " ";
            } else {
                letter = rowLocations[i].marker;
            }
            System.out.print("  " + letter + "  |");
        }
    }


}



