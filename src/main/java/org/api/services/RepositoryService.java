package org.api.services;

import org.api.dto.RepositoryDto;

import java.util.List;

public interface RepositoryService {
    List<RepositoryDto> getAll();
}
