package com.frances.relink.exception;

public class ShortenLinkExistsException extends Throwable {
    private String message;

    public ShortenLinkExistsException(String message) {
        super(message);
        this.message = message;
    }

    public ShortenLinkExistsException() {

    }
}
