package com.digisoft.com.digisoftitweb.lectures.service.impl;

import com.digisoft.com.digisoftitweb.exceptions.LectureAlreadyExistException;
import com.digisoft.com.digisoftitweb.exceptions.lectureNotFoundException;
import com.digisoft.com.digisoftitweb.lectures.entity.LecturesEntity;
import com.digisoft.com.digisoftitweb.lectures.entity.request.LecturesRequest;
import com.digisoft.com.digisoftitweb.lectures.entity.response.LecturesResponse;
import com.digisoft.com.digisoftitweb.lectures.mapper.LecturesMapper;
import com.digisoft.com.digisoftitweb.lectures.repository.LecturesRepository;
import com.digisoft.com.digisoftitweb.lectures.service.LecturesService;
import com.digisoft.com.digisoftitweb.utils.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class LecturesServiceImpl implements LecturesService {
    private final LecturesRepository lecturesRepository;
    private final LecturesMapper lecturesMapper;
    private final String[] lecturesArray = {
            "Java Core",
            "IOS",
            "Android",
            "Backend JavaEE",
            "Phyton",
            "FrontEnd Html css javascript",
            "ReactJS",
            "Angular", "Vue", "Next", "NodeJS", "Kotlin", "C", "C++", "Hello world", "DevOps"
    };

    private final String[] descriptionArray = {
            "Java Core",
            "IOS",
            "Android",
            "Backend JavaEE",
            "Phyton",
            "FrontEnd Html css javascript",
            "ReactJS",
            "Angular", "Vue", "Next", "NodeJS", "Kotlin", "C", "C++", "Hello world", "DevOps"
    };

    public BaseResponse<?> showAll() {
        List<LecturesResponse> response = lecturesMapper.toResponse(lecturesRepository.findAll());
        return new BaseResponse<>(new Date(), HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), response);
    }

    @Override
    public void fillLectures() {
        IntStream.range(0, lecturesArray.length)
                .mapToObj(i -> LecturesResponse
                        .builder()
                        .lectureName(lecturesArray[i])
                        .lectureDescription(descriptionArray[i])
                        .build()).map(lecturesMapper::toObject).forEach(lecturesRepository::save);
    }

    @Override
    public BaseResponse<?> add(@Valid LecturesRequest lecturesRequest) {
        if (lecturesRepository.findByLectureName(lecturesRequest.getLectureName()) != null)
            throw new LectureAlreadyExistException(lecturesRequest.getLectureName());
        LecturesEntity lecturesEntity = lecturesMapper.toObjectRequest(lecturesRequest);
        LecturesResponse response = lecturesMapper.toSaveResponse(lecturesRepository.save(lecturesEntity));
        return new BaseResponse<>(new Date(), HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), response);
    }

    @Override
    public BaseResponse<?> update(@Valid LecturesRequest lecturesRequest) {
        if (!lecturesRepository.existsById(lecturesRequest.getId()))
            throw new lectureNotFoundException(lecturesRequest.getLectureName());
        LecturesEntity lecturesEntity = lecturesMapper.toObjectRequest(lecturesRequest);
        lecturesEntity.setId(lecturesRequest.getId());
        LecturesEntity updated = lecturesRepository.save(lecturesEntity);
        LecturesResponse response = lecturesMapper.toSaveResponse(updated);
        return new BaseResponse<>(new Date(), HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), response);
    }

    @Override
    public BaseResponse<?> delete(Long id) {
        if (!lecturesRepository.existsById(id))
            throw new lectureNotFoundException("");
        lecturesRepository.deleteById(id);
        return new BaseResponse<>(new Date(), HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), "Deleted successfully");
    }
}
