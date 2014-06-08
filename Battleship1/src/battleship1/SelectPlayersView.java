/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;

import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public class SelectPlayersView {
    
    private Game game;
    private Players[] playerList;

    public SelectPlayersView(Game game) {
        this.game = game;
        playerList = Battleship.getPlayerList();
    }

    
    public boolean getInput() {
        
        this.displayNameList(); // display the list of names
        
        // if one player game
        if (Game.ONE_PLAYER.equals(this.game.gameType )) {
           System.out.println("\tPlease enter the number of the player.");

            // get the players name
            Players player = this.getPlayer();
            if (player ==  null) {
                return false;
            }
           
            this.game.playerA = player;
            this.game.playerB.name = "Computer";
        }
        
        // else two player game
        else { 
            System.out.println("\tPlease enter the number of the first player.");
            // get first players name
            Players player1 = this.getPlayer();
            if (player1 ==  null) {
                return false;
            }
             

          
            System.out.println("\tPlease enter the number of the second player.");
            Players player2 = this.getPlayer();
            if (player2 ==  null) {
                return false;
            }
            
            this.game.playerA = player1;
            this.game.playerB = player2;
            
        }
        
        return true;
        
    }
    

    public Players getPlayer() {
        
        Players player = null;
        Scanner inFile = new Scanner(System.in);
        
        boolean valid = false;
        while (!valid) {
            String strNumber = inFile.nextLine();
            
            if (strNumber.length() < 1) { 
                new BattleshipsError().displayError(
                        "You must enter a number associated with the name or "
                        + "enter a \"Q\" to quit. Try again.");
                continue;
            }
            
            strNumber = strNumber.trim();    
            strNumber = strNumber.substring(0, 1); 
            
            if (strNumber.toUpperCase().equals("Q")) { 
                return null;
            }
                    
            if (!strNumber.matches("[0-9]+")) { 
                new BattleshipsError().displayError(
                        "You must enter a number associated with the name or "
                        + "enter a \"Q\" to quit. Try again.");
                continue;
            }
            
            int numberSelected = Integer.parseInt(strNumber);
            
       
            if (numberSelected < 1  ||  numberSelected > this.playerList.length) {
                new BattleshipsError().displayError(
                        "Invalid number. You must enter a number between "
                        + "1 and " + this.playerList.length 
                        + "or enter a \"Q\" to quit. Try again.");
                continue;
            }
            
            player = this.playerList[numberSelected-1];
            
            if (game.playerA.equals(player) || 
                game.playerB.equals(player) ) {  
                new BattleshipsError().displayError(
                        "That player has already been selected. "
                        + "Select a different player "
                        + "or enter a \"Q\" to quit. Try again.");
                continue;
            }
            
            
            
            valid = true;
      
        } while (!valid);
        
        return player;
    }
    
    
    public void displayNameList() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tSelect the player/s who will be playing the game.");
        System.out.println("\tEnter the number of a player below:");

        for (int i = 0; i < this.playerList.length; i++) {
            int namePosition = i+1;
            System.out.println("\t   " + namePosition + "\t" + playerList[i].name);
        }
        System.out.println("\t===============================================================\n");
    }
     
    
}
