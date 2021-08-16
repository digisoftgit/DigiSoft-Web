package com.digisoft.com.digisoftitweb.security.mapper;


import com.digisoft.com.digisoftitweb.security.entity.privelege.Privilege;
import com.digisoft.com.digisoftitweb.security.entity.privelege.response.PrivilegeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrivilegeMapper {
    public List<PrivilegeResponse> toPrivilegeNameResponseList(List<Privilege> all) {
        return all.stream()
                .map(e -> new PrivilegeResponse(
                        e.getId(),
                        e.getCreatedDate().getTime(),
                        e.getUpdatedDate().getTime(),
                        e.getName()
                )).collect(Collectors.toList());
    }
}
