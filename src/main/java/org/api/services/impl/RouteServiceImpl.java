package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.RouteEntity;
import org.api.dto.RouteDto;
import org.api.mapper.RouteMapper;
import org.api.repository.route.RouteRepository;
import org.api.services.RouteService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteMapper mapper;
    @Override
    public ResultBean getAll() throws Exception {
        List<RouteEntity> entityList = routeRepository.getAll();
        if(entityList.isEmpty()){
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        List<RouteDto> dtoList = mapper.map(entityList);
        return new ResultBean(dtoList,Constants.STATUS_OK, Constants.MESSAGE_OK);

    }
}
