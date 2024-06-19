package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.api.utils.CourseEntityId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_course")
@IdClass(CourseEntityId.class)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class CourseEntity extends CommonEntity implements Serializable {
    @Id
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer company_id;

    //routeCode
    @Id
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String route_code;

    //courseCode
    @Id
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String course_code;

    @Id
    //courseName
    @Column(name = "course_name")
    @JsonProperty("courseName")
    private String course_name;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;
}
