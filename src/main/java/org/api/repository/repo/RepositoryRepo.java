package org.api.repository.repo;

import org.api.bean.jpa.RepositoryEntity;
import org.api.dto.RepositoryDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryRepo extends BaseRepository<RepositoryEntity, Integer> {
    @Query(value = "SELECT new org.api.dto.RepositoryDto(a.repositoryId, a.repositoryCode, a.repositoryName) FROM RepositoryEntity a WHERE a.delFlg = '0'")
    List<RepositoryDto> getAll();
}
