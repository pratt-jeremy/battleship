/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import jeremy.cit260.bship.models.Player;
import group.cit260.bship.menuview.GamePreferencesMenuView;
import java.util.Scanner;


/**
 *
 * @author Jeremy & Melanie
 */
public class Battleship {

    /**
     * @param args the command line arguments
     */
          
    private static final Scanner inFile = new Scanner(System.in);
    private static final group.cit260.bship.menuview.HelpMenuView helpMenu = new group.cit260.bship.menuview.HelpMenuView();

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

    private Player[] players = new Player[10];

    public Battleship() {
        
    }
        
    public static Scanner getInputFile() {
        return Battleship.inFile;
    }
    
    public static group.cit260.bship.menuview.HelpMenuView getHelpMenu() {
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

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

        
    public static void main(String[] args) {
        Battleship battleship1 = new Battleship();
        battleship1.display();
        Battleship.nameList = battleship1.getPlayerNames();
        group.cit260.bship.menuview.MainMenuView mainMenu = new group.cit260.bship.menuview.MainMenuView();

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
        System.out.println("\t Please enter a list of names of those who will be playing Battleships. ");
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
        System.arraycopy(playerNames, 0, newNameList, 0, playerIndex);
        
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


    
