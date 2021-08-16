package com.digisoft.com.digisoftitweb.security.controller;

import com.digisoft.com.digisoftitweb.security.api.PrivilegeApi;
import com.digisoft.com.digisoftitweb.security.base.BaseResponse;
import com.digisoft.com.digisoftitweb.security.services.privilege.impl.PrivilegesControllerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PrivilegeController implements PrivilegeApi {
    private final PrivilegesControllerServiceImpl privilegesControllerService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public ResponseEntity<BaseResponse<?>> all(String accessToken) {
        BaseResponse<?> response = privilegesControllerService.all(accessToken);
        return new ResponseEntity<>(response,response.getMessage());
    }
}