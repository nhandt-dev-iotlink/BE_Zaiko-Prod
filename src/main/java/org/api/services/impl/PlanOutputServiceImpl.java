package org.api.services.impl;

import org.api.bean.dto.OutputDto;
import org.api.repository.IPlanOutputRepository;
import org.api.services.IPlanOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanOutputServiceImpl implements IPlanOutputService {
    @Autowired
    private IPlanOutputRepository planOutputRepository;
    @Override
    public OutputDto findInventoryOutputById(Integer id) {
        return planOutputRepository.getOutputById(id);
    }
}
