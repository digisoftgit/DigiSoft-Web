package com.digisoft.com.digisoftitweb.security.api;

import com.digisoft.com.digisoftitweb.security.base.BaseResponse;
import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/role/admin")
public interface RoleApi {

    @GetMapping("/all")
    ResponseEntity<BaseResponse<?>> all();

    @PostMapping("/save")
    ResponseEntity<BaseResponse<?>> updatePositions(@RequestBody RoleRequest roleRequest);
}
