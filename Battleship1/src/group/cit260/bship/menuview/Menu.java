/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.menuview;

import jeremy.cit260.bship.control.Battleship;
import jeremy.cit260.bship.control.BattleshipsError;
import java.util.Scanner;

/**
 *
 * @author Jeremy and Melanie
 */
public abstract class Menu {

    private String[][] menuItems = null;

    public Menu() {
    }

    public Menu(String[][] menuItems) {
        this();
        this.menuItems = menuItems;
    }
    
    // This is an abstract function. It specifies that all sub-classes must
    // implement this function.
    public abstract String executeCommands(Object object);
    
    public String[][] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String[][] menuItems) {
        this.menuItems = menuItems;
    }

    
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (String[] menuItem : this.menuItems) {
            System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
        }
        System.out.println("\t===============================================================\n");
    }

    private boolean validCommand(String command) {
        String[][] items = this.menuItems;

        for (String[] item : this.menuItems) {
            if (item[0].equals(command)) {
                return true;
            }
        }
        return false;
    }

    protected final String getCommand() {

        Scanner inFile = Battleship.getInputFile();
        String command;
        boolean valid = false;
        do {
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            valid = validCommand(command);
            if (!validCommand(command)) {
                new BattleshipsError().displayError("Invalid command. Please enter a valid command.");
            }
                
        } while (!valid);
        
        return command;
    }


}