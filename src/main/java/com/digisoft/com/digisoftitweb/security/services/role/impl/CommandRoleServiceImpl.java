package com.digisoft.com.digisoftitweb.security.services.role.impl;

import com.digisoft.com.digisoftitweb.security.entity.role.Role;
import com.digisoft.com.digisoftitweb.security.entity.role.request.RoleRequest;
import com.digisoft.com.digisoftitweb.security.mapper.RoleMapper;
import com.digisoft.com.digisoftitweb.security.repository.RoleRepository;
import com.digisoft.com.digisoftitweb.security.services.role.CommandRoleService;
import com.digisoft.com.digisoftitweb.security.util.RolEUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandRoleServiceImpl implements CommandRoleService {
    private static final String ROLE_START = "ROLE_";
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final RolEUtils roleConverterManager;
    private final String[] otherRoles = {"Student", "teacher"};

    @Override
    public void createAdminRole(RoleRequest roleRequest) {
        String roleName = roleConverterManager.getFinalName(roleRequest);
        if (roleRepository.existsByName(roleName) == null) {
            Role role = roleMapper.toRoleEntity(roleName);
            roleMapper.toResponse(roleRepository.save(role));
        }
    }

    public String getFinalName(RoleRequest roleRequest) {
        String finalRoleName = "";
        finalRoleName = roleRequest.getName().contains(" ") ? roleRequest.getName().replace(" ", "_") : roleRequest.getName().toUpperCase();
        log.info("finalRoleName {} ", finalRoleName);
        return ROLE_START + finalRoleName.toUpperCase();
    }

    @Override
    public void createOtherRoles() {
        Arrays.stream(otherRoles).map(otherRole ->
                RoleRequest.builder().name(otherRole).build()).map(this::getFinalName)
                .filter(roleName -> roleRepository.existsByName(roleName) == null)
                .map(roleMapper::toRoleEntity).forEach(role -> roleMapper.toResponse(roleRepository.save(role)));
    }
}
