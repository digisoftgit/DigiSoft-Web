package com.digisoft.com.digisoftitweb.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestsException extends RuntimeException {
    public BadRequestsException(String message) {
        super(message);
    }
}
