package org.api.services.impl;


import org.api.annotation.LogExecutionTime;
import org.api.bean.jpa.RepositoryEntity;
import org.api.repository.repository.RepositoryRepository;
import org.api.services.RepositoryService;
import org.api.utils.ApiValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    RepositoryRepository repositoryRepository;
    @Override
    public List<RepositoryEntity> getAll() {
        List<RepositoryEntity> repositories = repositoryRepository.findAll();

        if (repositories.isEmpty()) {
            return Collections.emptyList(); // Trả về danh sách rỗng
        }
        return repositories;
    }
}
