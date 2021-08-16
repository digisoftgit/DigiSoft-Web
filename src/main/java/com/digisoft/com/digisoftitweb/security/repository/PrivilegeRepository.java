package com.digisoft.com.digisoftitweb.security.repository;


import com.digisoft.com.digisoftitweb.security.entity.privelege.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    Privilege findByName(String name);
}
