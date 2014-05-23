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
public class GameMenuControl {

    private Game game;
    private Board board;

    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.board;
    }

       
    
   public void takeTurn() {
        System.out.println("\n\ttakeTurn() called");
    }
   
       
   public void displayBoard() {
        System.out.println("\n\tdisplayBoard() called");
    }
   
   
    public void startNewGame() {
        System.out.println("\n\tstartNewGame() called");
    }
    
    
            
    public void displayPreferencesMenu() {
        GamePreferencesMenuView gamePreferencesMenu = new GamePreferencesMenuView(this.game);
        gamePreferencesMenu.getInput();
    }
    
    
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.getInput();
    }
    

    
    
    
}