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
class MainMenuControl {

        public void createPlayerList() {
        GetPlayersListView getPlayersListView = new GetPlayersListView();
        String[] listOfPlayersNames = getPlayersListView.getInput();
        
        // create the list of players named
        Players[] playerList = new Players[listOfPlayersNames.length];
                               
        for (int i = 0; i < playerList.length; i++) {
            String playersName = listOfPlayersNames[i];
            Players newPlayer = new Players();
            newPlayer.name = playersName;
            // add new player to player list
            playerList[i] = newPlayer;          
        }
        
        Battleship.setPlayerList(playerList);
        
    }
        
    public void startGame(long noPlayers) {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            new BattleshipsError().displayError("startGame - invalid number of players specified.");
            return;
        }
        
        Game game;
        if (noPlayers == 1) {
            game = this.createGame("ONE_PLAYER");
        }
        else {
            game = this.createGame("TWO_PLAYER");
        }

        GameMenuView gameMenu = new GameMenuView(game);
        gameMenu.getInput();
    }

    
    
     private Game createGame(String gameType) {
        Game game = null;
        Players playerA = null;
        Players playerB = null;
        
        if (gameType == null) {
            new BattleshipsError().displayError("MainCommands - create: gameType is null");
            return null;
        }
        
        if (gameType.equals(Game.ONE_PLAYER)) {
            game = new Game(Game.ONE_PLAYER);
            playerA = new Players(Players.REGULAR_PLAYER, game.PLAYER_A_DEFAULT_MARKER);
            playerA.name = "Player 1";
            playerB = new Players(Players.COMPUTER_PLAYER, game.PLAYER_B_DEFAULT_MARKER);
            playerB.name = "Computer";
        }
        else if (gameType.equals(Game.TWO_PLAYER)) {
            game = new Game(Game.TWO_PLAYER);
            playerA = new Players(Players.REGULAR_PLAYER, game.PLAYER_A_DEFAULT_MARKER);
            playerA.name = "Player 1";
            playerB = new Players(Players.REGULAR_PLAYER, game.PLAYER_B_DEFAULT_MARKER);
            playerB.name = "Player 2";

        }
        
        // set default players
        game.playerA = playerA;
        game.playerB = playerB;
        
        // set default markers for each player
        playerA.marker = "X";
        playerB.marker = "O";
        
        // select the name of the players of the game

                
        // set default markers for each player
        game.playerA.marker = "X";
        game.playerB.marker = "O";
        
        // set the game status to game not yet in playing mode
        game.status = Game.NO_ACTIVE_GAME;
        
        return game;
    } 
    
    
    private String quitGame() {
        System.out.println("\n\tAre you sure you want to quit? (Y or N)");
        Scanner inFile = new Scanner(System.in);
        String answer = inFile.next().trim().toUpperCase();
        if (answer.equals("Y")) {
            return Game.EXIT;
        }

        return Game.PLAYING;
    }
    
    
    /*
     * Display help menu action
     */
    public void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.getInput();
    }
    
}
