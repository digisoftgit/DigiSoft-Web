package com.digisoft.com.digisoftitweb.lectures.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturesRequest {
    private Long id;
    @NotNull
    @NotBlank
    private String lectureName;

    private String lectureDescription;
}
