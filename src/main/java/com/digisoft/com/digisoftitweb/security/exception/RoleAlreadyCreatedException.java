package com.digisoft.com.digisoftitweb.security.exception;

public class RoleAlreadyCreatedException extends RuntimeException{
    public RoleAlreadyCreatedException() {
        super("Already found, please try another name.");
    }
}
