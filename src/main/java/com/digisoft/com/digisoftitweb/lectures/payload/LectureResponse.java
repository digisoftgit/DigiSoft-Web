package com.digisoft.com.digisoftitweb.lectures.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureResponse<T> {
    private HttpStatus status;
    private int code;
    private T data;
}
