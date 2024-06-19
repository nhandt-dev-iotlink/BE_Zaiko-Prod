package org.api.services;

import org.api.bean.jpa.RepositoryEntity;
import org.api.bean.reponse.dto.RepositoryDTO;

import java.util.List;

public interface RepositoryService {

    public List<RepositoryDTO> getAll();
}
