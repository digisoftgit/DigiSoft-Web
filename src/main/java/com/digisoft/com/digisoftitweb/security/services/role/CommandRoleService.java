package com.digisoft.com.digisoftitweb.security.services.role;


import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;

@FunctionalInterface
public interface CommandRoleService {
    void createAdminRole(RoleRequest roleRequest);
}
