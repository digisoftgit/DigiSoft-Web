package com.digisoft.com.digisoftitweb.security.services.positonsCategory.impl;

import com.digisoft.com.digisoftitweb.security.entity.positionscategory.PositionsCategories;
import com.digisoft.com.digisoftitweb.security.repository.PositionCategoryRepository;
import com.digisoft.com.digisoftitweb.security.services.positonsCategory.PositionsCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionCategoryServiceImpl implements PositionsCategoryService {
    private final PositionCategoryRepository positionCategoryRepository;
    private final String[] positionCategories = {"Administration", "Stuff"};

    @Override
    public void fillData() {
        List<PositionsCategories> allCategories = positionCategoryRepository.findAll();
        if (allCategories.isEmpty()) {
            for (String positionCategory : positionCategories) {
                PositionsCategories positionsCategories = new PositionsCategories();
                positionsCategories.setPositionCategoryName(positionCategory);
                positionCategoryRepository.save(positionsCategories);
            }
        }
    }
}