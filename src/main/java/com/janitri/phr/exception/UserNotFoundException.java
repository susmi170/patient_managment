package com.janitri.phr.exception;

/**
 * this is a custom exception to handle user not found
 */
public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message) {
        super(message);
    }
}
