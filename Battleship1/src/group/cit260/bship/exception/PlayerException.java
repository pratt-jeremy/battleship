/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group.cit260.bship.exception;

/**
 *
 * @author jeremy
 */


public class PlayerException extends Exception {

    public PlayerException() {
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }
    
}
