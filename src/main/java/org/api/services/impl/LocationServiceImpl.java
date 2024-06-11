package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.LocationEntity;
import org.api.dto.LocationDto;
import org.api.mapper.LocationMapper;
import org.api.repository.location.LocationRepository;
import org.api.services.LocationService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationMapper mapper;
    @Override
    public ResultBean getAllByRepositoryId(Integer repositoryId) throws Exception {
        List<LocationEntity> locationEntityList = locationRepository.getAllByRepositoryId(repositoryId);
        if (!locationEntityList.isEmpty()){
            List<LocationDto> dtoList = mapper.map(locationEntityList);
            return new ResultBean(dtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(new ArrayList<>(), Constants.STATUS_NOT_FOUND, Constants.MESSAGE_OK);
    }
}
