package com.digisoft.com.digisoftitweb.security.util;

import com.digisoft.com.digisoftitweb.security.entity.webuser.WebUser;
import com.digisoft.com.digisoftitweb.security.exception.NotAuthorizedUserAccessException;
import com.digisoft.com.digisoftitweb.security.repository.WebUserRepository;
import com.digisoft.com.digisoftitweb.security.security.UserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtils {
    private final WebUserRepository webUserRepository;

    public WebUser getUserId() {
        Object webUsers = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (webUsers.equals("anonymousUser")) throw new NotAuthorizedUserAccessException();
        Long userId = ((UserBuilder) webUsers).getId();
        return webUserRepository.getById(userId);

    }
}
