package org.api.repository;

import org.api.bean.dto.RepositoryDto;
import org.api.bean.jpa.RepositoryEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepository extends BaseRepository<RepositoryEntity, Integer> {
    @Query(value = " SELECT \n " +
            "   repository_id as repositoryId,\n " +
            "   repository_name as repositoryName \n " +
            "FROM m_repository order by repositoryId asc ", nativeQuery = true)
    List<RepositoryDto> getAll();
}
