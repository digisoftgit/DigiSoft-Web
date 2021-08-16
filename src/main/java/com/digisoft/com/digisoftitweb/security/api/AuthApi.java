package com.digisoft.com.digisoftitweb.security.api;

import com.digisoft.com.digisoftitweb.security.entity.webuser.request.WebUserRequest;
import com.digisoft.com.digisoftitweb.security.payload.LoginRequest;
import com.digisoft.com.digisoftitweb.security.payload.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/auth")
public interface AuthApi {

    @PostMapping("/login")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest,
                                   BindingResult bindingResult);

    @PostMapping("/check")
    CompletableFuture<ResponseEntity<?>> checkUser();

    @PostMapping("/logout")
    ResponseEntity<?> logout(HttpServletRequest request);

    @PutMapping("/admin/change/password")
    ResponseEntity<?> changePass(HttpServletRequest request,
                                 @Valid @RequestBody WebUserRequest webUserRequest,
                                 BindingResult bindingResult);

    @GetMapping("/user")
    ResponseEntity<?> userDetails();

    @PutMapping("/user/update")
    ResponseEntity<?> updateUserDetail(@RequestBody WebUserRequest webUserRequest);

}