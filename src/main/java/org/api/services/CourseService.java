package org.api.services;

import org.api.bean.ResultBean;

import java.util.List;

public interface CourseService {
    ResultBean getAll() throws Exception;

    ResultBean getByRoute(String code) throws Exception;
}
