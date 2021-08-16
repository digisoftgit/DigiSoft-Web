package com.digisoft.com.digisoftitweb.security.repository;


import com.digisoft.com.digisoftitweb.security.entity.positionscategory.PositionsCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionCategoryRepository extends JpaRepository<PositionsCategories,Long> {
}
