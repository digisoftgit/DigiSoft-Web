package com.digisoft.com.digisoftitweb.security.entity.privelege;

import com.digisoft.com.digisoftitweb.security.entity.base.BaseEntity;
import com.digisoft.com.digisoftitweb.security.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "privilege")
public class Privilege extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}