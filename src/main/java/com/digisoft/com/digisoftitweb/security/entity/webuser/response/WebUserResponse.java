package com.digisoft.com.digisoftitweb.security.entity.webuser.response;

import com.digisoft.com.digisoftitweb.security.enums.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUserResponse {
    private Long id;
    private String firstName;

    private String lastName;
    @Column(columnDefinition="varchar 255 default ''")
    private String username;

    private String email;
    @Column(columnDefinition="varchar 255 default 'https://'")
    private String imageUrl;

    private Boolean emailVerified = false;

    @Transient
    private String password;

    private AuthProvider provider = AuthProvider.local;
    @Column(columnDefinition="varchar 255 default ''")
    private String providerId;
    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean phoneNumberVerified;
    @Column(columnDefinition="varchar 255 default ''")
    private String phoneNumber;

    private Boolean enable = true;

    private List<String> roles;
}
