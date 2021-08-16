package com.digisoft.com.digisoftitweb.security.entity.role.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponse {
    private Long id;
    private String name;

}
