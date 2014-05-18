/*
 * Display the main menu
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author MBradshaw
 */
public class MainMenuView {
      private static final String[][] menuItems = {
        {"1", "One player game"},
        {"2", "Two player game"},
        {"H", "Help"},
        {"X", "Exit Battleship Board"},
        {"Math Assignment", "Here is my Math Assignment 4*4: " + 4*4}      
    }; 
  
    MainMenuControl mainMenuControl = new MainMenuControl();
    
    public MainMenuView() {

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
                case "1":
                    this.mainMenuControl.startGame(1);
                    break;
                case "2":
                    this.mainMenuControl.startGame(2);
                    break;
                case "H":
                    this.mainMenuControl.displayHelpMenu();            
                    break;
                case "X":
                    break;
                default: 
                    new BattleshipsError().displayError("Invalid command. Please enter a valid command.");
                    continue;                    
            }
        } while (!command.equals("X"));

        return;
    }
    

    
    
   public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter your choices:");

        
        for (int i = 0; i < MainMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        
        }
        System.out.println("\t===============================================================\n");
    }   
    
}
