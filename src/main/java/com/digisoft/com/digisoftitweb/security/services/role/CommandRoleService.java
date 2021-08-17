package com.digisoft.com.digisoftitweb.security.services.role;


import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;

public interface CommandRoleService {
    void createAdminRole(RoleRequest roleRequest);
    void createOtherRoles();
}
