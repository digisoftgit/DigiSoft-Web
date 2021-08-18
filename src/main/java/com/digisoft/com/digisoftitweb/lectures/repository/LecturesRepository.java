package com.digisoft.com.digisoftitweb.lectures.repository;

import com.digisoft.com.digisoftitweb.lectures.entity.LecturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LecturesRepository extends JpaRepository<LecturesEntity,Long> {
    @Query("select e from LecturesEntity e where e.lectureName like %?1%")
    LecturesEntity findByName(String lecture);

    LecturesEntity findByLectureName(String lecture);

    @Query("select e from LecturesEntity e where e.lectureName like %?1%")
    LecturesEntity existsByName(String lectureName);
}
