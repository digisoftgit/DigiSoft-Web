package com.digisoft.com.digisoftitweb.security.entity.webuser.request;

import com.digisoft.com.digisoftitweb.security.annotations.PasswordPolicy;
import com.digisoft.com.digisoftitweb.security.entity.role.Role;
import com.digisoft.com.digisoftitweb.security.enums.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUserRequest {
    private Long id;
    private String firstName;

    private String lastName;

    private String name = "";
    @Email
    private String email;

    private String imageUrl = "https://";

    private Boolean emailVerified = false;
    @PasswordPolicy
    private String password;
    @PasswordPolicy
    private String oldPassword;

    private AuthProvider provider = AuthProvider.local;

    private String providerId = "";

    private Boolean phoneNumberVerified = false;

    private String phoneNumber = "";

    private Boolean enable = true;

    private Collection<Role> roles;
}
