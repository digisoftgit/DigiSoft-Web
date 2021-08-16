package com.digisoft.com.digisoftitweb.security.exception;

public class CookiesNotFoundException extends RuntimeException{
    public CookiesNotFoundException() {
        super("Cookie not found.");
    }
}
