package org.api.services;

import org.api.bean.dto.ProductDto;
import org.api.bean.dto.RouteDto;

import java.util.List;

public interface IRouteService {
    List<RouteDto> getAll();
}
