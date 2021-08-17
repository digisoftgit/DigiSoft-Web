package com.digisoft.com.digisoftitweb.security.entity.position.response;

import com.digisoft.com.digisoftitweb.security.entity.positionscategory.response.PositionsCategoriesResponse;
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
public class PositionsResponse {

    private PositionsCategoriesResponse positionsCategoriesResponse;
    private Long id;
    private String positionName;
    private String positionIcon;
    private String positionDetails;

}
