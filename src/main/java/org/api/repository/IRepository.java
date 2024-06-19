package org.api.repository;

import org.api.bean.dto.RepositoryDto;
import org.api.bean.jpa.RepositoryEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepository extends BaseRepository<RepositoryEntity, Integer> {
    @Query(value = " SELECT " +
            "   repository_id as repositoryId, " +
            "   repository_code as repositoryCode, " +
            "   repository_name as repositoryName  " +
            " FROM m_repository WHERE del_flg = 0 " +
            " order by repositoryCode asc ", nativeQuery = true)
    List<RepositoryDto> getAll();
}
