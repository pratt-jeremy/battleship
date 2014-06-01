
package battleship1;


import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */




public class GamePreferencesMenuView  {
    Game game;
    private final GamePreferencesMenuControl gamePreferenceControl;

    private final static String[][] menuItems = {
        {"1", "Change Marker of the first Player's Ships"},
        {"2", "Change Marker of the second Player's Ships"},
        {"S", "Change the Number of Ships on the Board"},
        {"Q", "Return to game menu"}
    };

    public GamePreferencesMenuView(Game game) {
        this.game = game;
        gamePreferenceControl = new GamePreferencesMenuControl(game);
    }

    
    public void getInput() {       
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "1":
                    this.gamePreferenceControl.getMarker(this.game.playerA);
                    break;
                case "2":
                    this.gamePreferenceControl.getMarker(this.game.playerB);
                    break;
                case "S":
                    this.gamePreferenceControl.getShips();
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

        for (int i = 0; i < GamePreferencesMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
 
}
