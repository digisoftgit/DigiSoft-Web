package com.digisoft.com.digisoftitweb.security.payload;

import com.digisoft.com.digisoftitweb.lectures.entity.LecturesEntity;
import com.digisoft.com.digisoftitweb.security.annotations.PasswordPolicy;
import com.digisoft.com.digisoftitweb.security.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @PasswordPolicy
    private String password;

    private Role roles;

    private LecturesEntity lectures;

}
