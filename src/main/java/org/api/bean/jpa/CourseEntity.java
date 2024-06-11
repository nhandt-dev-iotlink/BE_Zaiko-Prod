package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_course")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@IdClass(CourseEntityId.class)
public class CourseEntity extends CommonEntity{
    @Id
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //routeCode
    @Id
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String routeCode;

    //courseCode
    @Id
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String courseCode;

    //courseName
    @Column(name = "course_name",
            nullable = false)
    @JsonProperty("courseName")
    private String courseName;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;
}
