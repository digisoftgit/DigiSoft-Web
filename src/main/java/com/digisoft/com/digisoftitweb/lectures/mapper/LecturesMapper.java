package com.digisoft.com.digisoftitweb.lectures.mapper;

import com.digisoft.com.digisoftitweb.lectures.entity.LecturesEntity;
import com.digisoft.com.digisoftitweb.lectures.entity.request.LecturesRequest;
import com.digisoft.com.digisoftitweb.lectures.entity.response.LecturesResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LecturesMapper {
    public List<LecturesResponse> toResponse(List<LecturesEntity> all) {
        return all.stream()
                .map(e-> new LecturesResponse(
                        e.getId(),
                        e.getLectureName(),
                        e.getLectureDescription()
                )).collect(Collectors.toList());
    }

    public LecturesEntity toObject(LecturesResponse lecturesResponse) {
        return LecturesEntity.builder()
                .lectureName(lecturesResponse.getLectureName())
                .lectureDescription(lecturesResponse.getLectureDescription())
                .build();
    }

    public LecturesEntity toObjectRequest(LecturesRequest lecturesRequest) {
        return LecturesEntity.builder()
                .lectureName(lecturesRequest.getLectureName())
                .lectureDescription(lecturesRequest.getLectureDescription())
                .build();
    }

    public LecturesResponse toSaveResponse(LecturesEntity lecturesRequest) {
        return LecturesResponse.builder()
                .id(lecturesRequest.getId())
                .lectureName(lecturesRequest.getLectureName())
                .lectureDescription(lecturesRequest.getLectureDescription())
                .build();
    }
}
