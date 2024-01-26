package com.frances.relink.exception;

public class InvalidUrlException extends Throwable{
    private String message;

    public InvalidUrlException(String message) {
        super(message);
        this.message = message;
    }

    public InvalidUrlException() {

    }
}
