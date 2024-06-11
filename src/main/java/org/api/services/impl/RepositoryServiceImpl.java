package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.RepositoryEntity;
import org.api.dto.RepositoryDto;
import org.api.mapper.RepositoryMapper;
import org.api.repository.repo.RepositoryRepo;
import org.api.services.RepositoryService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private RepositoryRepo repositoryRepo;
    @Autowired
    private RepositoryMapper mapper;
    @Override
    public List<RepositoryDto> getAll() {
        return repositoryRepo.getAll();
    }

    @Override
    public ResultBean findById(Integer id) throws Exception {
        Optional<RepositoryEntity> entityOptional = repositoryRepo.findById(id);
        if(entityOptional.isPresent()){
            RepositoryEntity entity = entityOptional.orElseThrow(()->  new EntityNotFoundException("Entity not found"));
            RepositoryDto dto = mapper.toDto(entity);
            return new ResultBean(dto, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }

        return new ResultBean( Constants.STATUS_NOT_FOUND, Constants.MESSAGE_OK);
    }
}
