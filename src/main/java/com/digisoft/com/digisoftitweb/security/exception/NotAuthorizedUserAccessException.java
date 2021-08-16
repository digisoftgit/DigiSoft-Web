package com.digisoft.com.digisoftitweb.security.exception;

public class NotAuthorizedUserAccessException extends RuntimeException{

    public NotAuthorizedUserAccessException() {
        super("User not authorized.");
    }
}
