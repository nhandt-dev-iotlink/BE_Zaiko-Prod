package org.api.services;

import org.api.bean.jpa.RepositoryEntity;

import java.util.List;

public interface RepositoryService {

    public List<RepositoryEntity> getAll();
}
