package org.api.services.impl;

import org.api.bean.dto.RepositoryDto;
import org.api.repository.IRepository;
import org.api.services.IRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryServiceImpl implements IRepositoryService {
    @Autowired
    private IRepository repository;
    @Override
    public List<RepositoryDto> getAll() {
        return repository.getAll();
    }
}
