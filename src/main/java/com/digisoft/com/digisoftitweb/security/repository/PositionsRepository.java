package com.digisoft.com.digisoftitweb.security.repository;


import com.digisoft.com.digisoftitweb.security.entity.position.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PositionsRepository extends JpaRepository<Positions,Long> {

    @Query("select e from Positions e where e.positionName like %?1%")
    Positions existsByName(String name);
}
