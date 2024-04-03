package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_course")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class CourseEntity extends CommonEntity{
    @Id
    @Column(name = "company_id",
            nullable = false)
    @JsonProperty("companyId")
    private Integer company_id;

    //routeCode
    @Id
    @Column(name = "route_code",
            nullable = false)
    @JsonProperty("routeCode")
    private String route_code;

    //courseCode
    @Id
    @Column(name = "course_code",
            nullable = false)
    @JsonProperty("courseCode")
    private String course_code;

    //courseName
    @Column(name = "course_name",
            nullable = false)
    @JsonProperty("courseName")
    private String course_name;

    //notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;
}
