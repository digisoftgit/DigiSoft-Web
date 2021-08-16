package com.digisoft.com.digisoftitweb.security.services.positions.impl;


import com.digisoft.com.digisoftitweb.security.entity.position.Positions;
import com.digisoft.com.digisoftitweb.security.entity.positionscategory.PositionsCategories;
import com.digisoft.com.digisoftitweb.security.repository.PositionCategoryRepository;
import com.digisoft.com.digisoftitweb.security.repository.PositionsRepository;
import com.digisoft.com.digisoftitweb.security.services.positions.CommandPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommandPositionServiceImplementation implements CommandPositionService {
    private final PositionCategoryRepository positionCategoryRepository;
    private final PositionsRepository positionsRepository;

    //administration full pack
    private final String[] positionsAdministration = {"Administration"};
    private final String[] positionsAdministrationDetails = {"As the job position suggests, assistant managers are responsible for helping the general admin with the execution of his tasks."};
    private final String[] getPositionsAdministrationImages = {"manager.png"};

    //Management full pack
    private final String[] positionsManagement = {"Student","Teacher"};
    private final String[] positionsManagementDetails = {"As the position suggests, This section is for adding new Student to the academy.",
            "As the position suggests, This section is for adding new Teacher to the academy."};
    private final String[] getPositionsManagementImages = {
            "student.jpeg","teacher.png"};

    @Override
    public void fillAdministrationData() {
        List<PositionsCategories> allCategories = positionCategoryRepository.findAll();
        for (PositionsCategories allCategory : allCategories) {
            if (allCategory.getPositionCategoryName().equalsIgnoreCase("Administration")) {
                for (int i = 0; i < positionsAdministration.length; i++) {
                    Positions positions = new Positions();
                    positions.setPositionsCategories(allCategory);
                    positions.setPositionName(positionsAdministration[i]);
                    positions.setPositionDetails(positionsAdministrationDetails[i]);
                    positions.setPositionIcon(getPositionsAdministrationImages[i]);
                    positionsRepository.save(positions);
                }
            }

        }
    }

    public void fillManagementData() {
        List<PositionsCategories> allCategories = positionCategoryRepository.findAll();
        for (PositionsCategories allCategory : allCategories) {
            if (allCategory.getPositionCategoryName().equalsIgnoreCase("Management")) {
                for (int i = 0; i < positionsManagement.length; i++) {
                    Positions positions = new Positions();
                    positions.setPositionsCategories(allCategory);
                    positions.setPositionName(positionsManagement[i]);
                    positions.setPositionDetails(positionsManagementDetails[i]);
                    positions.setPositionIcon(getPositionsManagementImages[i]);
                    positionsRepository.save(positions);
                }
            }
        }
    }

}
