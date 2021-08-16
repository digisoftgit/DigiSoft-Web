package com.digisoft.com.digisoftitweb.security.services.privilege;

import com.digisoft.com.digisoftitweb.security.base.BaseResponse;

public interface PrivilegeControllerService {
    BaseResponse<?> all(String accessToken);
}
