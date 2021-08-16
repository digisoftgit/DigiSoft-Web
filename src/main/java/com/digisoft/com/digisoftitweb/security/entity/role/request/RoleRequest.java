package com.digisoft.com.digisoftitweb.security.entity.role.request;

import com.digisoft.com.digisoftitweb.security.entity.privelege.response.PrivilegeResponse;
import com.digisoft.com.digisoftitweb.security.entity.webuser.response.WebUserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleRequest {
    private Long id;
    private String name;
    private Collection<WebUserResponse> users;
    private Collection<PrivilegeResponse> privileges;
    private Collection<RoleRequest> roleRequestsCollection;
    private Boolean isSelected;
}
