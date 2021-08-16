package com.digisoft.com.digisoftitweb.security.exception;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String userNotFoundException) {
        super("User not registered exception.");
    }

}
