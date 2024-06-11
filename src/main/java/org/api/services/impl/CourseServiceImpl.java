package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CourseEntity;
import org.api.dto.CourseDto;
import org.api.mapper.CourseMapper;
import org.api.repository.course.CourseRepository;
import org.api.services.CourseService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper mapper;
    @Override
    public ResultBean getAll() throws Exception {
        List<CourseEntity> entityList = courseRepository.getAll();
        if(entityList.isEmpty()){
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        List<CourseDto> dtoList = mapper.map(entityList);
        return new ResultBean(dtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
    }

    @Override
    public ResultBean getByRoute(String code) throws Exception {
        List<CourseEntity> entityList = courseRepository.getByRoute(code);
        if(entityList.isEmpty()){
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        List<CourseDto> dtoList = mapper.map(entityList);
        return new ResultBean(dtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
    }
}
