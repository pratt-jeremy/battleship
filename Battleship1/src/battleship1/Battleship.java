/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;



import java.util.Scanner;


/**
 *
 * @author Jeremy and Melanie
 */


public class Battleship {
     
    private static final Scanner inFile = new Scanner(System.in);
    private static final HelpMenuView helpMenu = new HelpMenuView();

    private static final GamePreferencesMenuView GamePreferencesMenu = new GamePreferencesMenuView();
    
    // Instance variables
    private static String[] nameList;
    
    private final static String welcome = 
              "\n\t***********************************************************************"
            + "\n\t* Welcome to the game of Battleships!                                 *"                            
            + "\n\t* You will be playing against an opponent. The object of the game     *"
            + "\n\t* is to guess the locations of all the ships of your opponent.       *"
            + "\n\t* Players will hide 5 ships. Then the opponent will be given a number *" 
            + "\n\t* of chances.                                                         *"
            + "\n\t* Good Luck!!!                                                        *"
            + "\n\t***********************************************************************"
            + "\n";

    
    private Players[] players = new Players[10];

    public Battleship() {
        
    }
        
    public static Scanner getInputFile() {
        return Battleship.inFile;
    }
    
    public static HelpMenuView getHelpMenu() {
        return Battleship.helpMenu;
    }


    public static GamePreferencesMenuView getGamePreferencesMenu() {
        return GamePreferencesMenu;
    }

    public static String[] getNameList() {
        return nameList;
    }

    public static void setNameList(String[] nameList) {
        Battleship.nameList = nameList;
    }

    public Players[] getPlayers() {
        return players;
    }

    public void setPlayers(Players[] players) {
        this.players = players;
    }

        
    public static void main(String[] args) {
        Battleship battleship = new Battleship();
        battleship.display();
        Battleship.nameList = battleship.getPlayerNames();
        MainMenuView mainMenu = new MainMenuView();

        mainMenu.executeCommands(null);
        Battleship.inFile.close();
    }
    
    private void display() {
        System.out.println(Battleship.welcome);
    }

    
    private String[] getPlayerNames() {
        
        String[] playerNames = new String[10];
        Scanner inFile = Battleship.getInputFile();
        
        System.out.println("\n\t---------------------------------------------------------------");
        System.out.println("\t Enter a list of names of those who will be playing Battleship. ");
        System.out.println("\t---------------------------------------------------------------");
        
        int playerIndex = 0;
        boolean done = false;
        while (playerIndex < 10  && !done) { 
            System.out.println("\tPlease enter the name of a player or enter \"Q\" to quit.");
            String name;
            name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1) {
                new BattleshipsError().displayError("\tA name must be at least one character long. Try again.");
                continue;
            }

            if (name.toUpperCase().equals("Q")) { // quit?
                done = true;
                break;
            } 
            
            // add name to list of player names
            playerNames[playerIndex] = name;
            playerIndex++;

        }
        
        String[] newNameList = new String[playerIndex];
        for (int i = 0; i < playerIndex; i++) {
            newNameList[i] = playerNames[i];          
        }
        
        sortList(newNameList);
        
        return newNameList;
    }
    
    public String[] sortList(String[] names) {
        String tmpName;
        boolean notDone = true;
        while(notDone) {
            
            notDone = false; // assume that you done
            for (int i = 0; i < names.length-1; i++) {
                int compareResult = names[i].compareTo(names[i+1]);
                if (compareResult > 0) {
                    // swap names
                    tmpName = names[i];
                    names[i] = names[i+1];
                    names[i+1] = tmpName;
                    notDone = true;
                } 
            }
        }

        return names;
    }
    
}
