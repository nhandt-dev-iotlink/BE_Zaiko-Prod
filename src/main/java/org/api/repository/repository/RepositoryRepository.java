package org.api.repository.repository;


import org.api.bean.jpa.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryRepository extends JpaRepository<RepositoryEntity,Integer> {
    @Query("SELECT r FROM RepositoryEntity r WHERE r.delFlg = '0'")
    List<RepositoryEntity> findAll();
}

