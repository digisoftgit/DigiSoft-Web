package com.digisoft.com.digisoftitweb.security.entity.position.request;

import com.digisoft.com.digisoftitweb.security.entity.positionscategory.PositionsCategories;
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
public class PositionsRequest {
    private Long id;
    private PositionsCategories positionsCategories;
    private String positionName;
    private String positionIcon;
    private String positionDetails;
}
