package com.digisoft.com.digisoftitweb.exceptions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class lectureNotFoundException extends RuntimeException {
    public lectureNotFoundException(@NotNull @NotBlank String lectureName) {
        super("Lecture with name " + lectureName + " not found.");
    }
}
