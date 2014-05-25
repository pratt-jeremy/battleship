/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author J.Pratt
 */
public class Battleship {
    
    
    String name;
    String instructions = "This is the game of Battleship \n\n"
            + "Two players duke it out in an epic war game involving \n"
            + "battleships and a grid.  Both players take turns trying to \n"
            + "guess the locations of the other player's ships.  The first \n"
            + "player to find all their opponents ships wins the game. \n\n"
            + "Anchors away!!! \n\n";
    
    public static void main(String[] args) {
        Battleship myGame = new Battleship();
        
   
        myGame.displayHelp();
        
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.getInput();      
        
    }
    public void getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name = input.next();
    }
    
    public void displayHelp() {
        System.out.println("\nWelcome " + this.name + "\n");
        System.out.println(this.instructions);
    }
}
