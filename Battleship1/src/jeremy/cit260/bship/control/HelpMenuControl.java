/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import group.cit260.bship.exception.BattleshipException;
import jeremy.cit260.bship.enume.ErrorType;
import jeremy.cit260.bship.enume.HelpType;

/**
 *
 * @author mt
 */
public class HelpMenuControl {
    
    public String getHelpText(HelpType command) throws BattleshipException {
        String helpText = "";
        switch (command) {
            case INSTRUCTIONS:
            case ONE_PERSON_GAME:
            case TWO_PERSON_GAME:
            case PLAYER:
            case BOARD:
            case MARKER:
                helpText = command.getHelpText();
                break;
            default:
                throw new BattleshipException(ErrorType.ERROR105.getMessage());
        }

        return helpText;
    }
    
}
