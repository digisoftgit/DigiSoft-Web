package com.digisoft.com.digisoftitweb.security.exception;

public class AdminDisabledUserException extends RuntimeException{

    public AdminDisabledUserException(String message) {
        super(message);
    }
}
