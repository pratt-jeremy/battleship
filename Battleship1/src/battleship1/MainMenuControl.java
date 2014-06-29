/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author Jeremy and Melanie
 */
public class MainMenuControl {
    
    private static final String PLAYER_A_DEFAULT_MARKER = "X";
    private static final String PLAYER_B_DEFAULT_MARKER = "O";
    
    public battleship1.Game create(String gameType) {
        battleship1.Game game = null;
        battleship1.Player playerA = null;
        battleship1.Player playerB = null;
        
        if (gameType == null) {
            throw new IllegalArgumentException ("MainCommands - create: gameType is null");
        }
        
        if (gameType.equals(battleship1.Game.ONE_PLAYER)) {
            game = new battleship1.Game(battleship1.Game.ONE_PLAYER);
            playerA = new battleship1.Player(battleship1.Player.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            playerB = new battleship1.Player(battleship1.Player.COMPUTER_PLAYER, PLAYER_B_DEFAULT_MARKER);
        }
        else if (gameType.equals(battleship1.Game.TWO_PLAYER)) {
            game = new battleship1.Game(battleship1.Game.TWO_PLAYER);
            playerA = new battleship1.Player(battleship1.Player.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            playerB = new battleship1.Player(battleship1.Player.REGULAR_PLAYER, PLAYER_B_DEFAULT_MARKER);

        }
         
        game.setPlayerA(playerA);
        game.setPlayerB(playerB);
        
        game.setStatus(battleship1.Game.CONTINUE);
        
        return game;
    } 
    
}


