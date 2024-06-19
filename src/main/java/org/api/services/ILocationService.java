package org.api.services;

import org.api.bean.dto.LocationDto;

import java.util.List;

public interface ILocationService {
    List<LocationDto> getAll();

    List<LocationDto> getByRepo(Integer repositoryId);
}
