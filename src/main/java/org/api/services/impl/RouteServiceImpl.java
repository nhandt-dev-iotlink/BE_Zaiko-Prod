package org.api.services.impl;


import org.api.bean.dto.RouteDto;

import org.api.repository.IRouteRepository;
import org.api.services.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RouteServiceImpl implements IRouteService {
    @Autowired
    private IRouteRepository routeRepository;

    @Override
    public List<RouteDto> getAll() {
        return routeRepository.getAll();
    }
}
