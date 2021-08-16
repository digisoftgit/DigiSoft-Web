package com.digisoft.com.digisoftitweb.security.entity.role;

import com.digisoft.com.digisoftitweb.security.entity.base.BaseEntity;
import com.digisoft.com.digisoftitweb.security.entity.privelege.Privilege;
import com.digisoft.com.digisoftitweb.security.entity.webuser.WebUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "role")
public class Role extends BaseEntity {

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<WebUser> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

}