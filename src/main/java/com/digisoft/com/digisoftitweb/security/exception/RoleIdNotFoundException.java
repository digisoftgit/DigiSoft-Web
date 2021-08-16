package com.digisoft.com.digisoftitweb.security.exception;

public class RoleIdNotFoundException extends RuntimeException{
    public RoleIdNotFoundException() {
        super("Role id not found.");
    }
}
