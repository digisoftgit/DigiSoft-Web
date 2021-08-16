package com.digisoft.com.digisoftitweb.security.exception;

public class EmailAlreadyUsedException extends RuntimeException{
    public EmailAlreadyUsedException() {
        super("Email address already registered.");
    }
}
