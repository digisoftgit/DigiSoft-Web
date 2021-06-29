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
public class BaseResponse<T> {
    private Date date;
    private HttpStatus status;
    private int code;
    private T data;
}