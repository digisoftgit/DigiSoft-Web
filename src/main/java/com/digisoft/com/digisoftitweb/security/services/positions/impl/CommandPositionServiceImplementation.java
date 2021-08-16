package com.digisoft.com.digisoftitweb.security.services.positions.impl;


import com.digisoft.com.digisoftitweb.security.repository.PositionCategoryRepository;
import com.digisoft.com.digisoftitweb.security.repository.PositionsRepository;
import com.digisoft.com.digisoftitweb.security.services.positions.CommandPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandPositionServiceImplementation implements CommandPositionService {
    private final PositionCategoryRepository positionCategoryRepository;
    private final PositionsRepository positionsRepository;

    @Override
    public void academyData() {

    }
}
