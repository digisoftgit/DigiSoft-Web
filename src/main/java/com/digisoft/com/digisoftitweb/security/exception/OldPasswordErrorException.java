package com.digisoft.com.digisoftitweb.security.exception;

public class OldPasswordErrorException extends RuntimeException{
    public OldPasswordErrorException() {
        super("Old password not matches.");
    }
}