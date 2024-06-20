package org.api.services;

import org.api.bean.jpa.LocationEntity;
import org.api.bean.reponse.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> LOCATION_ENTITIES();


    List<LocationDTO> LOCATION_BY_REPOSITORY_ID(Integer repo_id);
}
