package org.api.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class CourseEntityId implements Serializable {
    private Integer company_id;
    private String route_code;
    private String course_code;
}
