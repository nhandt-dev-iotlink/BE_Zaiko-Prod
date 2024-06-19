package org.api.services.impl;


import org.api.annotation.LogExecutionTime;
import org.api.bean.jpa.RepositoryEntity;
import org.api.bean.mapper.RepositoryMapper;
import org.api.bean.reponse.dto.RepositoryDTO;
import org.api.repository.repository.RepositoryRepository;
import org.api.services.RepositoryService;
import org.api.utils.ApiValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    RepositoryRepository repositoryRepository;

    @Autowired
    RepositoryMapper repositoryMapper;

    @Override
    public List<RepositoryDTO> getAll() {
        List<RepositoryEntity> repositories = repositoryRepository.findAll();
        if (repositories.isEmpty()) {
            return Collections.emptyList();
        }
        return repositories.stream()
                .map(repository -> repositoryMapper.repositoryToRepositoryDto(repository))
                .collect(Collectors.toList());
    }

}
