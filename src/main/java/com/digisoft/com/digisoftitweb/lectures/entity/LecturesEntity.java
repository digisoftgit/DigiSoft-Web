package com.digisoft.com.digisoftitweb.lectures.entity;

import com.digisoft.com.digisoftitweb.security.entity.base.BaseEntity;
import com.digisoft.com.digisoftitweb.security.entity.webuser.WebUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lecture_entity")
public class LecturesEntity extends BaseEntity {

    @Column(name = "lecture_name",columnDefinition = "varchar(255) default ''")
    private String lectureName;
    @Lob
    private String lectureDescription;
    @Lob
    private String lecturesDetails;
    @ManyToMany(mappedBy = "lectures")
    private Collection<WebUser> users;
}
