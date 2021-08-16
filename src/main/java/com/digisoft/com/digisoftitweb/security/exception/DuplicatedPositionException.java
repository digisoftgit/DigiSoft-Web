package com.digisoft.com.digisoftitweb.security.exception;

public class DuplicatedPositionException extends RuntimeException{

    public DuplicatedPositionException() {
        super("You have duplicated values in the request.");
    }
}
