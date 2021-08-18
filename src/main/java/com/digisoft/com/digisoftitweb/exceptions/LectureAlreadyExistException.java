package com.digisoft.com.digisoftitweb.exceptions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LectureAlreadyExistException extends RuntimeException {
    public LectureAlreadyExistException(@NotNull @NotBlank String lectureName) {
        super(lectureName + " already registered in our database.");
    }
}
