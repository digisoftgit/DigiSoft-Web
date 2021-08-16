package com.digisoft.com.digisoftitweb.security.entity.positionscategory;

import com.digisoft.com.digisoftitweb.security.entity.base.BaseEntity;
import com.digisoft.com.digisoftitweb.security.entity.position.Positions;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions_category")
public class PositionsCategories extends BaseEntity {
    @JsonManagedReference
    @OneToMany(mappedBy="positionsCategories")
    private List<Positions> positions;

    private String positionCategoryName;
}
