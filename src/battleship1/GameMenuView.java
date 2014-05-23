/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author nnd771
 */
import java.util.Scanner;


public class GameMenuView {
    
    private Game game;
    private GameMenuControl gameMenuControl ; 


    private final static String[][] menuItems = {
        {"T", "Take your turn"},
        {"D", "Display the board"},
        {"N", "New Game"},
        {"P", "Change game preferences"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };

    public GameMenuView(Game game) {
        this.gameMenuControl = new GameMenuControl(game);
        
    }

    
    
    public void getInput() {
   
        String command;
        Scanner inFile = new Scanner(System.in);

        do {    
            this.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "T":
                    this.gameMenuControl.takeTurn();
                    break;
                case "D":
                    gameMenuControl.displayBoard();
                    break;
                case "N":
                    gameMenuControl.startNewGame();
                    break;
                case "P":
                    gameMenuControl.displayPreferencesMenu();
                    break;
                case "H":
                    gameMenuControl.displayHelpMenu();
                    break;
                case "Q":                   
                    break;
                default: 
                    new BattleshipsError().displayError("Invalid command. Please enter a valid command.");
                    continue;                              
            }
        } while (!command.equals("Q"));

        return;
    }
    


    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < GameMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
  
}