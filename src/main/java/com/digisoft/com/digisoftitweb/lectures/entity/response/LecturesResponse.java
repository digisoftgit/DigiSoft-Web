package com.digisoft.com.digisoftitweb.lectures.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturesResponse {
    private Long id;
    private String lectureName;
    private String lectureDescription;
}
