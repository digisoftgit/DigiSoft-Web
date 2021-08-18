package com.digisoft.com.digisoftitweb.exceptions;

public class LectureNameNotExistException extends RuntimeException{

    public LectureNameNotExistException() {
        super("Lecture not found.");
    }
}
