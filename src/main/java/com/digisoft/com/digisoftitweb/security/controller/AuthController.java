package com.digisoft.com.digisoftitweb.security.controller;

import com.digisoft.com.digisoftitweb.security.annotations.binding.BindingManager;
import com.digisoft.com.digisoftitweb.security.api.AuthApi;
import com.digisoft.com.digisoftitweb.security.entity.role.Role;
import com.digisoft.com.digisoftitweb.security.entity.webuser.WebUser;
import com.digisoft.com.digisoftitweb.security.entity.webuser.request.WebUserRequest;
import com.digisoft.com.digisoftitweb.security.entity.webuser.response.WebUserShortResponse;
import com.digisoft.com.digisoftitweb.security.enums.AuthProvider;
import com.digisoft.com.digisoftitweb.security.exception.EmailAlreadyUsedException;
import com.digisoft.com.digisoftitweb.security.exception.EmailNotVerifiedException;
import com.digisoft.com.digisoftitweb.security.exception.OldPasswordErrorException;
import com.digisoft.com.digisoftitweb.security.exception.RoleNameNotExistException;
import com.digisoft.com.digisoftitweb.security.exception.UserNotFoundException;
import com.digisoft.com.digisoftitweb.security.payload.ApiResponse;
import com.digisoft.com.digisoftitweb.security.payload.AuthResponse;
import com.digisoft.com.digisoftitweb.security.payload.LoginRequest;
import com.digisoft.com.digisoftitweb.security.payload.SignUpRequest;
import com.digisoft.com.digisoftitweb.security.payload.UserResponse;
import com.digisoft.com.digisoftitweb.security.repository.RoleRepository;
import com.digisoft.com.digisoftitweb.security.repository.WebUserRepository;
import com.digisoft.com.digisoftitweb.security.security.TokenProvider;
import com.digisoft.com.digisoftitweb.security.util.CookieUtils;
import com.digisoft.com.digisoftitweb.security.util.UserUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.digisoft.com.digisoftitweb.security.util.CookieUtils.HEADER_NAME;


@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController<T> implements AuthApi {

    private final AuthenticationManager authenticationManager;

    private final WebUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    private final RoleRepository roleRepository;

    private final BindingManager bindingManager;

    private final UserUtils userUtils;


    @SneakyThrows
    @Override
    public ResponseEntity<?> authenticateUser(@Valid LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Optional<WebUser> webUser = userRepository.findByEmail(loginRequest.getEmail());
        if (webUser.get().getEmailVerified()) {
            String token = tokenProvider.createToken(authentication);
            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            log.info("authorities {} ", authorities);
            AuthResponse authResponse = AuthResponse
                    .builder()
                    .accessToken(CookieUtils.serialize(token))
                    .tokenType("Bearer")
                    .webUser(WebUserShortResponse
                            .builder()
                            .id(webUser.get().getId())
                            .email(webUser.get().getEmail())
                            .firstName(webUser.get().getFirstName())
                            .lastName(webUser.get().getLastName())
                            .imageUrl(webUser.get().getImageUrl())
                            .phoneNumber(webUser.get().getPhoneNumber())
                            .roles(webUser.get().getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                            .build())
                    .build();
            log.info("AuthResponse authResponse = AuthResponse");
            return ResponseEntity.ok()
                    .body(authResponse);
        } else {
            throw new EmailNotVerifiedException();
        }

    }

    @Override
    public ResponseEntity<?> registerUser(@Valid SignUpRequest signUpRequest,
                                          BindingResult bindingResult) {
        bindingManager.bindingCheck(bindingResult);
        if (userRepository.existsByEmail(signUpRequest.getEmail())) throw new EmailAlreadyUsedException();
        if (roleRepository.existsByName(signUpRequest.getRoles().getName()) == null)
            throw new RoleNameNotExistException();

        WebUser user = new WebUser();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);
        if (signUpRequest.getRoles().getName().toLowerCase().contains("admin")) {
            user.setEmailVerified(true);
        }
        user.setEmailVerified(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList(roleRepository.findByName(signUpRequest.getRoles().getName())));
        WebUser result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully."));
    }

    @Async
    @Override
    public CompletableFuture<ResponseEntity<?>> checkUser() {
        WebUser webUser = userUtils.getUserId();
        return CompletableFuture.completedFuture(ResponseEntity.accepted()
                .body(new ApiResponse(true, webUser.getEmail())));
    }


    @Override
    public ResponseEntity<?> logout(HttpServletRequest request) {
        WebUser webUser = userUtils.getUserId();
        String token = tokenProvider.createLogoutToken(webUser);
        log.info("token {} ", token);
        String bearerToken = request.getHeader(HEADER_NAME);
        String accessTokens = bearerToken.substring(7, bearerToken.length());
        String logoutTokenSerialize = CookieUtils.serialize(token);
        return token.equals(accessTokens) ? ResponseEntity.accepted().body(new ApiResponse(false, "Logout not successful")) :
                ResponseEntity.ok().body(new ApiResponse(true, "logout successfully.", logoutTokenSerialize));
    }

    @Override
    public ResponseEntity<?> changePass(HttpServletRequest request,
                                        WebUserRequest webUserRequest,
                                        BindingResult bindingResult) {
        WebUser webUser = userUtils.getUserId();
        bindingManager.bindingCheck(bindingResult);
        WebUser oldUser = userRepository.findById(webUser.getId())
                .orElseThrow(() -> new UserNotFoundException(
                        "User id not found"));

        if (!passwordEncoder.matches(webUserRequest.getOldPassword(), webUser.getPassword()))
            throw new OldPasswordErrorException();

        oldUser.setPassword(passwordEncoder.encode(webUserRequest.getPassword()));
        userRepository.save(oldUser);

        logout(request);
        return ResponseEntity.accepted().body(new ApiResponse(true, "Password changed successfully."));


    }

    @Override
    public ResponseEntity<?> userDetails() {
        WebUser webUser = userUtils.getUserId();
        log.info("webUser {} ", webUser);
        return ResponseEntity.ok().body(
                UserResponse
                        .builder()
                        .webUser(WebUserShortResponse
                                .builder()
                                .id(webUser.getId())
                                .email(webUser.getEmail())
                                .firstName(webUser.getFirstName())
                                .lastName(webUser.getLastName())
                                .imageUrl(webUser.getImageUrl())
                                .phoneNumber(webUser.getPhoneNumber())
                                .roles(webUser.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                                .build())
                        .build());
    }

    @Override
    public ResponseEntity<?> updateUserDetail(WebUserRequest webUserRequest) {
        if (userRepository.existsByEmail(webUserRequest.getEmail())) throw new EmailAlreadyUsedException();
        WebUser webUser = userUtils.getUserId();
        WebUser user = new WebUser();
        user.setId(webUserRequest.getId());
        user.setFirstName(webUserRequest.getFirstName());
        user.setLastName(webUserRequest.getLastName());
        user.setEmail(webUserRequest.getEmail());
        user.setProvider(AuthProvider.local);
        user.setEmailVerified(false);
        user.setRoles(webUser.getRoles());
        user.setPassword(webUser.getPassword());
        userRepository.save(user);
        ResponseEntity<?> response = userDetails();
        return ResponseEntity.ok().body(response);

    }
}
