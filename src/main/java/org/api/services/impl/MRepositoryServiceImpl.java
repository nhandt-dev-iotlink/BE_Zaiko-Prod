package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.RepositoryEntity;
import org.api.dto.repository.response.RepositoryDropDownDTO;
import org.api.repository.m_repository.MRepositoryRepository;
import org.api.services.MRepositoryService;
import org.api.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MRepositoryServiceImpl implements MRepositoryService {
    private final ModelMapper modelMapper;
    private final MRepositoryRepository mRepositoryRepository;

    public MRepositoryServiceImpl(MRepositoryRepository mRepositoryRepository, ModelMapper modelMapper) {
        this.mRepositoryRepository = mRepositoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResultBean getAllRepository() {
        List<RepositoryEntity> repositoryEntities = mRepositoryRepository.findAllRepository();
        if(!repositoryEntities.isEmpty()){
            List<RepositoryDropDownDTO> repositoryDropDownDTOList = new ArrayList<>();
            repositoryEntities.forEach(repositoryEntity ->
                    repositoryDropDownDTOList.add(
                            modelMapper.map(repositoryEntity, RepositoryDropDownDTO.class))
            );
            return new ResultBean(repositoryDropDownDTOList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }

        return new ResultBean(null, Constants.STATUS_NOT_FOUND, "Not Found");
    }
}
