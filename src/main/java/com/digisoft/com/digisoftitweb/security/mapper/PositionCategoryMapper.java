package com.digisoft.com.digisoftitweb.security.mapper;

import com.digisoft.com.digisoftitweb.security.entity.positionscategory.PositionsCategories;
import com.digisoft.com.digisoftitweb.security.entity.positionscategory.response.PositionsCategoriesResponse;
import org.springframework.stereotype.Component;

@Component
public class PositionCategoryMapper {
    public PositionsCategoriesResponse toPositionCategoryResponse(PositionsCategories positionsCategories) {
        return PositionsCategoriesResponse.builder().id(positionsCategories.getId()).positionCategoryName(positionsCategories.getPositionCategoryName()).build();
    }
}
