package com.digisoft.com.digisoftitweb.security.controller;

import com.digisoft.com.digisoftitweb.security.api.RoleApi;
import com.digisoft.com.digisoftitweb.security.base.BaseResponse;
import com.digisoft.com.digisoftitweb.security.entity.position.response.PositionsResponse;
import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;
import com.digisoft.com.digisoftitweb.security.services.role.impl.RoleControllerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RoleController implements RoleApi {

    private final RoleControllerServiceImpl roleControllerService;

    @Override
    public ResponseEntity<BaseResponse<?>> updatePositions(RoleRequest roleRequest) {
        BaseResponse<?> response = roleControllerService.manageCollection(roleRequest);
        return new ResponseEntity<>(response,response.getMessage());
    }

    @Override
    public ResponseEntity<BaseResponse<?>> all() {
        Map<String, List<PositionsResponse>> responseMap = roleControllerService.all();
        BaseResponse<?> response = new BaseResponse<>(new Date(), true, HttpStatus.OK, responseMap);
        return new ResponseEntity<>(response, response.getMessage());
    }
}
