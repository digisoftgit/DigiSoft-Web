package com.digisoft.com.digisoftitweb.security.services.positonsCategory.impl;

import com.digisoft.com.digisoftitweb.security.services.positonsCategory.PositionsCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionCategoryServiceImpl implements PositionsCategoryService {

    private final String[] positionCategories = {"Administration", "Students", "Teachers"};


    @Override
    public void fillData() {

    }
}