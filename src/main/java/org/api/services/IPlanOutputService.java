package org.api.services;

import org.api.bean.dto.OutputDto;

public interface IPlanOutputService {

    OutputDto findInventoryOutputById(Integer id);
}
