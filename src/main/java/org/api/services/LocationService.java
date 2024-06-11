package org.api.services;

import org.api.bean.ResultBean;

public interface LocationService {
    ResultBean getAllByRepositoryId(Integer repositoryId) throws Exception;
}
