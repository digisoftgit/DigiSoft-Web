package com.digisoft.com.digisoftitweb.security.mapper;

import com.digisoft.com.digisoftitweb.security.entity.position.Positions;
import com.digisoft.com.digisoftitweb.security.entity.position.response.PositionsResponse;
import com.digisoft.com.digisoftitweb.security.entity.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PositionsMapper {
    private final PositionCategoryMapper positionCategoryMapper;

    public List<PositionsResponse> toResponse(List<Positions> all) {
        return all.stream()
                .map(e -> new PositionsResponse(
                        positionCategoryMapper.toPositionCategoryResponse(e.getPositionsCategories()),
                        e.getId(),
                        e.getPositionName(),
                        e.getPositionIcon(),
                        e.getPositionDetails()
                ))
                .collect(Collectors.toList());
    }

    public List<PositionsResponse> getRolesPositions(List<Positions> all, List<Role> roleList) {
        Set<PositionsResponse> setResponse = new LinkedHashSet<>();
            for (Positions value : all) {
                PositionsResponse positions = PositionsResponse.builder()
                        .id(value.getId())
                        .positionIcon(value.getPositionIcon())
                        .positionName(value.getPositionName())
                        .positionDetails(value.getPositionDetails())
                        .positionsCategoriesResponse(positionCategoryMapper.toPositionCategoryResponse(value.getPositionsCategories()))
                        .build();
                assert false;
                setResponse.add(positions);

        }
        return new ArrayList<>(setResponse);
    }
}
