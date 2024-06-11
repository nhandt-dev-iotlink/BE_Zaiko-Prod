package org.api.repository.location;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.LocationEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends BaseRepository<LocationEntity, Integer> {
    List<LocationEntity> getAllByRepositoryId(@Param("id") Integer id);

}
