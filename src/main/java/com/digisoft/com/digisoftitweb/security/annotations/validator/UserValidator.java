package com.digisoft.com.digisoftitweb.security.annotations.validator;

import com.digisoft.com.digisoftitweb.security.entity.webuser.WebUser;
import com.digisoft.com.digisoftitweb.security.exception.UserNotFoundException;
import com.digisoft.com.digisoftitweb.security.exception.constance.ExceptionConstance;
import com.digisoft.com.digisoftitweb.security.repository.WebUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final WebUserRepository userRepository;
    protected final JwtValidator jwtValidator;

    @Async
    public void checkUser(String accessedToken){
        userRepository
                .findById((Long.parseLong(
                        jwtValidator.validate(accessedToken))))
                .orElseThrow(() -> new UserNotFoundException(
                        ExceptionConstance.USER_NOT_FOUND_EXCEPTION));
    }
    @Async
    public WebUser getCurrentUser(String accessedToken) {
        return userRepository
                .findById((Long.parseLong(
                        jwtValidator.validate(accessedToken))))
                .orElseThrow(() -> new UserNotFoundException(
                        ExceptionConstance.USER_NOT_FOUND_EXCEPTION));
    }
}
