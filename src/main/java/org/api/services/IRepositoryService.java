package org.api.services;

import org.api.bean.dto.RepositoryDto;

import java.util.List;

public interface IRepositoryService {
    List<RepositoryDto> getAll();
}
