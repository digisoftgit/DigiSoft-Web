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
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addAdmin() {
        boolean adminUser = userRepository.existsByEmail("admin@admin.com");
        if(!adminUser) {
            WebUser user = WebUser.builder()
                    .firstName("General")
                    .lastName("Admin")
                    .name("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("mnbvcxz00A!"))
                    .emailVerified(true)
                    .imageUrl("https://")
                    .enable(true)
                    .provider(AuthProvider.local)
                    .phoneNumber("")
                    .phoneNumberVerified(true)
                    .roles(Collections.singletonList(roleRepository.findByName("ROLE_ADMIN")))
                    .build();

            userRepository.save(user);
        }
    }
}
