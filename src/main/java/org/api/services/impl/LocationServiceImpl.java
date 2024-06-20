package org.api.services.impl;

import org.api.bean.jpa.LocationEntity;
import org.api.bean.mapper.LocationMapper;
import org.api.bean.reponse.dto.LocationDTO;
import org.api.repository.location.LocationRepository;
import org.api.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationMapper locationMapper;

    @Override
    public List<LocationDTO> LOCATION_ENTITIES() {

        List<LocationEntity> entities =locationRepository.getLocationEntityList();
        if (entities.isEmpty()) {
            return null;
        }
        return entities.stream()
                .map(entity -> locationMapper.locationToLocationDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<LocationDTO> LOCATION_BY_REPOSITORY_ID(Integer repo_id) {
        List<LocationEntity> entities =locationRepository.getLocationByRepoId(repo_id);
        if(entities.isEmpty()){
            return null;
        }
        return entities.stream()
                .map(entity -> locationMapper.locationToLocationDto(entity))
                .collect(Collectors.toList());
    }


}
