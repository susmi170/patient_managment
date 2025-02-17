package com.janitri.phr.exception;

/**
 * this is a custom exception to handle patient not found
 */
public class PatientNotFoundException extends Exception{

    public PatientNotFoundException() {
        super();
    }

    public PatientNotFoundException(final String message) {
        super(message);
    }
}
