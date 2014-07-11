/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.exception;

/**
 *
 * @author Jeremy and Melanie
 */
public class MenuException extends Exception {

    public MenuException() {
    }

    public MenuException(String message) {
        super(message);
    }

    public MenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuException(Throwable cause) {
        super(cause);
    }

    public Exception displayError(String invalid_command_Please_enter_a_valid_comm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

