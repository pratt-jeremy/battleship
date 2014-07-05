/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import jeremy.cit260.bship.enume.PlayerType;

/**
 *
 * @author Jeremy and Melanie
 */
public class MainMenuControl {
    
    private static final String PLAYER_A_DEFAULT_MARKER = "X";
    private static final String PLAYER_B_DEFAULT_MARKER = "O";
    
    public jeremy.cit260.bship.models.Game create(String gameType) {
        jeremy.cit260.bship.models.Game game = null;
        jeremy.cit260.bship.models.Player playerA = null;
        jeremy.cit260.bship.models.Player playerB = null;
        
        if (gameType == null) {
            throw new IllegalArgumentException ("MainCommands - create: gameType is null");
        }
        
        if (gameType.equals(jeremy.cit260.bship.models.Game.ONE_PLAYER)) {
            game = new jeremy.cit260.bship.models.Game(jeremy.cit260.bship.models.Game.ONE_PLAYER);
            playerA = new jeremy.cit260.bship.models.Player(PlayerType.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            playerB = new jeremy.cit260.bship.models.Player(PlayerType.COMPUTER_PLAYER, PLAYER_B_DEFAULT_MARKER);
        }
        else if (gameType.equals(jeremy.cit260.bship.models.Game.TWO_PLAYER)) {
            game = new jeremy.cit260.bship.models.Game(jeremy.cit260.bship.models.Game.TWO_PLAYER);
            playerA = new jeremy.cit260.bship.models.Player(PlayerType.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            playerB = new jeremy.cit260.bship.models.Player(PlayerType.REGULAR_PLAYER, PLAYER_B_DEFAULT_MARKER);

        }
         
        game.setPlayerA(playerA);
        game.setPlayerB(playerB);
        
        game.setStatus(jeremy.cit260.bship.models.Game.CONTINUE);
        
        return game;
    } 
    
}


