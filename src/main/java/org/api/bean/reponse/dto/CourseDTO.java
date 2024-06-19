package org.api.bean.reponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


@Getter
@Setter
public class CourseDTO implements Serializable {
    private Integer company_id;
    //routeCode
    private String route_code;
    //courseCode
    private String course_code;
    //courseName
    private String course_name;
    //notes
    private String notes;
}
