package com.digisoft.com.digisoftitweb.security.exception;

public class RoleNameNotExistException extends RuntimeException{
    public RoleNameNotExistException() {
        super("Role name not found.");
    }
}
