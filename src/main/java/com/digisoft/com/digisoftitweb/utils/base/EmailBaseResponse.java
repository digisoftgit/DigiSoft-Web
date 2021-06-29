package com.digisoft.com.digisoftitweb.utils.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailBaseResponse<T> {
    private Date date;
    private Boolean status;
    private HttpStatus httpStatus;
}
