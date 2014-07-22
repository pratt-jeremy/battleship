/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import jeremy.cit260.bship.models.Game;
import jeremy.cit260.bship.models.Player;

/**
 *
 * @author mBradshaw
 */

    public class PlayerNameMenuControl {
    
    public static void savePlayersNames(Game game, String playerAName, String playerBName) {
       if (game == null 
               || playerAName == null
               || playerBName == null) {
           throw new IllegalArgumentException("savePlayersNames - parameter value is null");
       }
       Player playerA = game.getPlayerA();
       Player playerB = game.getPlayerB();
       playerA.setName(playerAName);
       playerB.setName(playerBName);
    }
    }  



