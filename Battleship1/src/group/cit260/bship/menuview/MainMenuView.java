/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.menuview;

import group.cit260.bship.exception.MenuException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeremy.cit260.bship.control.Battleship;
import jeremy.cit260.bship.control.BattleshipsError;

/**
 *
 * @author mBradshaw
 */
  /**  public class MainMenuView extends Menu {
    
    private static final String[][] menuItems = {
        {"1", "One player game"},
        {"2", "Two player game"},
        {"H", "Help"},
        {"X", "Exit Battleships"}
    }; 
  
    jeremy.cit260.bship.control.MainMenuControl mainCommands = new jeremy.cit260.bship.control.MainMenuControl();
    
    public MainMenuView() {
        super(MainMenuView.menuItems);
    }
    
    public Object getInput(Object object) {       
        
        String gameStatus = jeremy.cit260.bship.models.Game.PLAYING;
        do {
            this.display();

            // get commaned entered
            String command = null;
            try {
                command = this.getCommand();
            } catch (MenuException ex) {
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (command) {
                case "1":
                    this.startGame(1);
                    break;
                case "2":
                    this.startGame(2);
                    break;
                case "H":
                    group.cit260.bship.menuview.HelpMenuView helpMenu = Battleship.getHelpMenu();
                    helpMenu.executeCommands(null);
                    break;
                case "X":
                    return jeremy.cit260.bship.models.Game.EXIT;
            }
        } while (!gameStatus.equals(jeremy.cit260.bship.models.Game.EXIT));

        return jeremy.cit260.bship.models.Game.EXIT;
    }

    private void startGame(long noPlayers) {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            new BattleshipsError().displayError("startGame - invalid number of players specified.");
            return;
        }
        
        jeremy.cit260.bship.models.Game game;
        if (noPlayers == 1) {
            game = this.mainCommands.create(jeremy.cit260.bship.models.Game.ONE_PLAYER);
        }
        else {
            game = this.mainCommands.create(jeremy.cit260.bship.models.Game.TWO_PLAYER);
        }
        
        jeremy.cit260.bship.gameview.SelectPlayersView selectPlayersView = new jeremy.cit260.bship.gameview.SelectPlayersView(game);
        String status = (String) selectPlayersView.selectPlayers(Battleship.getNameList());
        if (status.equals(jeremy.cit260.bship.models.Game.QUIT)) {
            return;
        }

        group.cit260.bship.menuview.GameMenuView gameMenu = new group.cit260.bship.menuview.GameMenuView(game);
        gameMenu.executeCommands(game);
    }

    private String quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return jeremy.cit260.bship.models.Game.EXIT;
        }

        return jeremy.cit260.bship.models.Game.PLAYING;
    }

    @Override
    public String executeCommands(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
*/

