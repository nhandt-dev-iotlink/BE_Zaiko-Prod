package org.api.services;

import org.api.bean.reponse.dto.RouteDTO;

import java.util.List;

public interface RouteService {

    public List<RouteDTO> getAll();
}
