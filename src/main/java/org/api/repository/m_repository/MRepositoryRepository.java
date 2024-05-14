package org.api.repository.m_repository;

import org.api.bean.jpa.RepositoryEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MRepositoryRepository extends BaseRepository<RepositoryEntity, Integer> {

    @Query("SELECT r FROM RepositoryEntity r WHERE r.delFlg = '0'")
    List<RepositoryEntity> findAllRepository();
}
