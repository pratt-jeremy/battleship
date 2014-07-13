/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.exception;

/**
 *
 * @author Niethy
 */
public class MarkerException extends Exception {

    public MarkerException() {
    }

    public MarkerException(String message) {
        super(message);
    }

    public MarkerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkerException(Throwable cause) {
        super(cause);
    }

    public MarkerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
