/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author mBradshaw
 */
    public class MainMenuView extends Menu {
    
    private static final String[][] menuItems = {
        {"1", "One player game"},
        {"2", "Two player game"},
        {"H", "Help"},
        {"X", "Exit Battleships"}
    }; 
  
    battleship1.MainMenuControl mainCommands = new battleship1.MainMenuControl();
    
    public MainMenuView() {
        super(MainMenuView.menuItems);
    }
    
    @Override
    public String executeCommands(Object object) {       
        
        String gameStatus = battleship1.Game.PLAYING;
        do {
            this.display();

            // get commaned entered
            String command = this.getCommand();
            switch (command) {
                case "1":
                    this.startGame(1);
                    break;
                case "2":
                    this.startGame(2);
                    break;
                case "H":
                    battleship1.HelpMenuView helpMenu = Battleship.getHelpMenu();
                    helpMenu.executeCommands(null);
                    break;
                case "X":
                    return battleship1.Game.EXIT;
            }
        } while (!gameStatus.equals(battleship1.Game.EXIT));

        return battleship1.Game.EXIT;
    }

    private void startGame(long noPlayers) {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            new BattleshipsError().displayError("startGame - invalid number of players specified.");
            return;
        }
        
        battleship1.Game game;
        if (noPlayers == 1) {
            game = this.mainCommands.create(battleship1.Game.ONE_PLAYER);
        }
        else {
            game = this.mainCommands.create(battleship1.Game.TWO_PLAYER);
        }
        
        battleship1.SelectPlayersView selectPlayersView = new battleship1.SelectPlayersView(game);
        String status = (String) selectPlayersView.selectPlayers(Battleship.getNameList());
        if (status.equals(battleship1.Game.QUIT)) {
            return;
        }

        battleship1.GameMenuView gameMenu = new battleship1.GameMenuView(game);
        gameMenu.executeCommands(game);
    }

    private String quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return battleship1.Game.EXIT;
        }

        return battleship1.Game.PLAYING;
    }

    }


