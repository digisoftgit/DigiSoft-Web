package com.digisoft.com.digisoftitweb.security.entity.position;

import com.digisoft.com.digisoftitweb.security.entity.base.BaseEntity;
import com.digisoft.com.digisoftitweb.security.entity.positionscategory.PositionsCategories;
import com.digisoft.com.digisoftitweb.security.entity.privelege.Privilege;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions")
public class Positions extends BaseEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private PositionsCategories positionsCategories;
    private String positionName;
    private String positionIcon;
    @Lob
    private String positionDetails;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;
}
