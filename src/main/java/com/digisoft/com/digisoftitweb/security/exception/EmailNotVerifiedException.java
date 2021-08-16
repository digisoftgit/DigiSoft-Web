package com.digisoft.com.digisoftitweb.security.exception;

public class EmailNotVerifiedException extends RuntimeException{

    public EmailNotVerifiedException() {
        super("Your Email is not verified yet.");
    }
}
