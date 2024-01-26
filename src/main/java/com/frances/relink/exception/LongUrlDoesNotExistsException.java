package com.frances.relink.exception;

public class LongUrlDoesNotExistsException extends Throwable {
    private String message;

    public LongUrlDoesNotExistsException(String message) {
        super(message);
        this.message = message;
    }

    public LongUrlDoesNotExistsException() {

    }
}
