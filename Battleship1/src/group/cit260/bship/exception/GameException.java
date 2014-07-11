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
public class GameException extends Exception {

    public GameException() {
    }

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameException(Throwable cause) {
        super(cause);
    } 

    public Exception displayError(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
