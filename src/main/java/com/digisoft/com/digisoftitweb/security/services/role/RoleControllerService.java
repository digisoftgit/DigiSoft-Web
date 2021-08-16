package com.digisoft.com.digisoftitweb.security.services.role;


import com.digisoft.com.digisoftitweb.security.base.BaseResponse;
import com.digisoft.com.digisoftitweb.security.entity.position.response.PositionsResponse;
import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;

import java.util.List;
import java.util.Map;

public interface RoleControllerService {

    BaseResponse<?> manageCollection(RoleRequest roleRequest);
    Map<String, List<PositionsResponse>> all();
}
