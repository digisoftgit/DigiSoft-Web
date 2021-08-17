package com.digisoft.com.digisoftitweb.security.util;

import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RolEUtils {
    private static final String ROLE_START = "ROLE_";

    public String getFinalName(RoleRequest roleRequest) {
        String finalRoleName = "";
        finalRoleName = roleRequest.getName().contains(" ") ? roleRequest.getName().replace(" ", "_") : roleRequest.getName().toUpperCase();
        log.info("finalRoleName {} ", finalRoleName);
        return ROLE_START + finalRoleName.toUpperCase();
    }

    public String getFinalName(String role) {
        String finalRoleName = "";
        finalRoleName = role.contains(" ") ? role.replace(" ", "_") : role.toUpperCase();
        log.info("finalRoleName {} ", finalRoleName);
        return ROLE_START + finalRoleName.toUpperCase();
    }
}
