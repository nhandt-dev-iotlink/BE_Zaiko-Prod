package org.api.services.impl;

import org.api.bean.dto.LocationDto;
import org.api.repository.ILocationRepository;
import org.api.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;
    @Override
    public List<LocationDto> getAll() {
        return locationRepository.getAll();
    }

    @Override
    public List<LocationDto> getByRepo(Integer repositoryId) {
        return locationRepository.getByRepo(repositoryId);
    }
}
