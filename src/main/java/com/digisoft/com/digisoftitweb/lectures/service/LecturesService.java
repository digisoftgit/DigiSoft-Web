package com.digisoft.com.digisoftitweb.lectures.service;


import com.digisoft.com.digisoftitweb.lectures.entity.request.LecturesRequest;
import com.digisoft.com.digisoftitweb.utils.base.BaseResponse;

public interface LecturesService {
    BaseResponse<?> showAll();

    void fillLectures();

    BaseResponse<?> add(LecturesRequest lecturesRequest);

    BaseResponse<?> update(LecturesRequest lecturesRequest);

    BaseResponse<?> delete(Long id);
}
