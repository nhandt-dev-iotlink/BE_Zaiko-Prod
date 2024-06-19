package org.api.services;


import org.api.bean.reponse.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    public List<CourseDTO> getAll();
}
