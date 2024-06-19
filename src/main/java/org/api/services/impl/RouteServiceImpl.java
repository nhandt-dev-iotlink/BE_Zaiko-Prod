package org.api.services.impl;


import org.api.bean.jpa.RouteEntity;
import org.api.bean.mapper.RouteMapper;
import org.api.bean.reponse.dto.RouteDTO;
import org.api.repository.route.RouteRepository;
import org.api.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository repository;

    @Autowired
    RouteMapper routeMapper;

    @Override
    public List<RouteDTO> getAll() {
        List<RouteEntity> entities =repository.findAll();
        if (entities.isEmpty()) {
            return null;
        }
        return entities.stream()
                .map(entity -> routeMapper.routeToRouteDto(entity))
                .collect(Collectors.toList());
    }
}
