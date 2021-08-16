package com.digisoft.com.digisoftitweb.security.exception;

public class AdminCanNotBeDeleteException extends RuntimeException{
    public AdminCanNotBeDeleteException() {
        super("Admin Can not be delete.");
    }
}
