package com.digisoft.com.digisoftitweb.security.exception;

public class RoleNameNotFoundException extends RuntimeException{
    public RoleNameNotFoundException() {
        super("Role not found exception.");
    }
}
