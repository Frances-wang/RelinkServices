package com.frances.relink.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    @Value(value = "${data.exception.message3}")
    private String message3;

    @ExceptionHandler(value = InvalidUrlException.class)
    public ResponseEntity invalidUrlException(InvalidUrlException invalidUrlException) {
        return new ResponseEntity(message1, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = LongUrlDoesNotExistsException.class)
    public ResponseEntity longUrlDoesNotExistsException(LongUrlDoesNotExistsException longUrlDoesNotExistsException) {
        return new ResponseEntity(message2, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ShortenLinkExistsException.class)
    public ResponseEntity shortenLinkExistsException(ShortenLinkExistsException shortenLinkExistsException) {
        return new ResponseEntity(message3, HttpStatus.BAD_REQUEST);
    }
}
