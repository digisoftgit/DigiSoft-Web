package com.digisoft.com.digisoftitweb.lectures.controller;

import com.digisoft.com.digisoftitweb.lectures.api.LectureApi;
import com.digisoft.com.digisoftitweb.lectures.entity.request.LecturesRequest;
import com.digisoft.com.digisoftitweb.lectures.payload.LectureResponse;
import com.digisoft.com.digisoftitweb.lectures.service.LecturesService;
import com.digisoft.com.digisoftitweb.utils.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LecturesController implements LectureApi {
    private final LecturesService lecturesService;

    @Override
    public ResponseEntity<?> showAll() {
        BaseResponse<?> response = lecturesService.showAll();
        return ResponseEntity.ok().body(
                LectureResponse.builder()
                        .status(response.getStatus())
                        .code(response.getStatus().value())
                        .data(response.getData())
                        .build());
    }

    @Override
    public ResponseEntity<?> add(LecturesRequest lecturesRequest) {
        BaseResponse<?> response = lecturesService.add(lecturesRequest);
        return ResponseEntity.ok()
                .body(LectureResponse.builder()
                        .status(response.getStatus())
                        .code(response.getStatus().value())
                        .data(response.getData())
                        .build());
    }

    @Override
    public ResponseEntity<?> update(LecturesRequest lecturesRequest) {
        BaseResponse<?> response = lecturesService.update(lecturesRequest);
        return ResponseEntity.ok()
                .body(LectureResponse.builder()
                        .status(response.getStatus())
                        .code(response.getStatus().value())
                        .data(response.getData())
                        .build());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        BaseResponse<?> response = lecturesService.delete(id);
        return ResponseEntity.ok()
                .body(LectureResponse.builder()
                        .status(response.getStatus())
                        .code(response.getStatus().value())
                        .data(response.getData())
                        .build());
    }
}
