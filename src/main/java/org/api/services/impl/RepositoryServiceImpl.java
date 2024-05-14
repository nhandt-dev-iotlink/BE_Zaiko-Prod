package org.api.services.impl;

import org.api.dto.RepositoryDto;
import org.api.repository.repo.RepositoryRepo;
import org.api.services.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private RepositoryRepo repositoryRepo;
    @Override
    public List<RepositoryDto> getAll() {
        return repositoryRepo.getAll();
    }
}
