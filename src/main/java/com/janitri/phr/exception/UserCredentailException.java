package com.janitri.phr.exception;

/**
 * this is a custom exception to handle user not found
 */
public class UserCredentailException extends Exception{

    public UserCredentailException() {
        super();
    }

    public UserCredentailException(final String message) {
        super(message);
    }
}
