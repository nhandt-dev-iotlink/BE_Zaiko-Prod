package org.api.services;

import org.api.bean.ResultBean;
import org.api.dto.RepositoryDto;

import java.util.List;

public interface RepositoryService {
    List<RepositoryDto> getAll();

    ResultBean findById(Integer id) throws Exception;
}
