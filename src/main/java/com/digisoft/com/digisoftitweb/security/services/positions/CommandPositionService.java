package com.digisoft.com.digisoftitweb.security.services.positions;

import com.digisoft.com.digisoftitweb.security.base.BaseResponse;

public interface CommandPositionService {
    void fillAdministrationData();
    void fillManagementData();

    BaseResponse<?> all();
}
