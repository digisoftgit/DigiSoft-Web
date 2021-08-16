package com.digisoft.com.digisoftitweb.security.exception;

public class AdminCanNotBeUpdateException extends RuntimeException{
    public AdminCanNotBeUpdateException() {
        super("Sorry Admin role can not be updated.");
    }
}
