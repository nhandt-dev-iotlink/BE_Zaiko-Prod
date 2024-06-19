package org.api.services.impl;

import org.api.bean.dto.InputProductStatusDto;
import org.api.bean.dto.OutputPlanDetailDto;
import org.api.repository.IProductStatusRepository;
import org.api.services.IProductStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStatusServiceImpl implements IProductStatusService {
    private IProductStatusRepository productStatusRepository;

    @Override
    public List<InputProductStatusDto> getPlanOutputDetail() {
        return productStatusRepository.getAll();
    }
}
