package com.digisoft.com.digisoftitweb.security.services.privilege.impl;

import com.digisoft.com.digisoftitweb.security.base.BaseResponse;
import com.digisoft.com.digisoftitweb.security.entity.privelege.response.PrivilegeResponse;
import com.digisoft.com.digisoftitweb.security.mapper.PrivilegeMapper;
import com.digisoft.com.digisoftitweb.security.repository.PrivilegeRepository;
import com.digisoft.com.digisoftitweb.security.services.privilege.PrivilegeControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivilegesControllerServiceImpl implements PrivilegeControllerService {

    private final PrivilegeRepository privilegeRepository;
    private final PrivilegeMapper privilegeMapper;

    @Override
    public BaseResponse<?> all(String accessToken) {

        List<PrivilegeResponse> response = null;
        try {
            response = privilegeMapper.toPrivilegeNameResponseList(privilegeRepository.findAll());
        } catch (Exception e) {
            return new BaseResponse<>(new Date(), false, HttpStatus.CONFLICT, e.getMessage());
        }
        return new BaseResponse<>(new Date(), true, HttpStatus.OK, response);
    }


}
