package com.digisoft.com.digisoftitweb.security.services.user.impl;

import com.digisoft.com.digisoftitweb.security.entity.webuser.WebUser;
import com.digisoft.com.digisoftitweb.security.enums.AuthProvider;
import com.digisoft.com.digisoftitweb.security.repository.RoleRepository;
import com.digisoft.com.digisoftitweb.security.repository.WebUserRepository;
import com.digisoft.com.digisoftitweb.security.services.user.CommandUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandUserServiceImplementation implements CommandUserService {

    private final WebUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void addAdmin() {
        boolean adminUser = userRepository.existsByEmail("admin@admin.com");
        if(!adminUser) {
            WebUser user = new WebUser();
            user.setFirstName("General");
            user.setLastName("Admin");
            user.setEmail("admin@admin.com");
            user.setPassword("mnbvcxz00A!");
            user.setProvider(AuthProvider.local);
            user.setEmailVerified(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList(roleRepository.findByName("ROLE_ADMIN")));

            userRepository.save(user);
        }
    }
}
