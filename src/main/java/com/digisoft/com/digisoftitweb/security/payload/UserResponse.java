package com.digisoft.com.digisoftitweb.security.payload;

import com.digisoft.com.digisoftitweb.security.entity.webuser.response.WebUserShortResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private WebUserShortResponse webUser;
}
