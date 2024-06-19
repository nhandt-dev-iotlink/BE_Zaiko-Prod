package org.api.services.impl;

import org.api.bean.dto.*;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.repository.IPlanOutputRepository;
import org.api.services.IPlanOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanOutputServiceImpl implements IPlanOutputService {
    @Autowired
    private IPlanOutputRepository planOutputRepository;

    @Override
    public OutputDto findInventoryOutputById(Integer id) {
        return planOutputRepository.getOutputById(id);
    }

    @Override
    public List<OutputPlanDetailDto> getPlanOutputDetail(Integer id) {
        return planOutputRepository.getPlanOutputDetail(id);
    }

    @Override
    public Boolean checkOutputByCode(String code) {
        OutputDto planOutput = planOutputRepository.findOutputBySlipNo(code);
        System.out.println(planOutput);
        return planOutput != null;

    }

    @Override
    public CustomerAndDestDto getCustomerInfo(String code) {
        return planOutputRepository.getCustomerInfo(code);
    }

    @Override
    public ProductSearchDto getProductInfo(String code) {
        return planOutputRepository.getProductInfo(code);
    }

    @Override
    public InventoryPlanOutputDetailEntity savePlanOutputDetail(InventoryPlanOutputDetailEntity inventoryPlanOutputDetail) {
        return planOutputRepository.save(inventoryPlanOutputDetail);
    }

    @Override
    public List<InventoryPlanOutputDetailEntity> findByOutputId(Integer inventoryOutputId) {
        List<InventoryPlanOutputDetailEntity> planOutputDetailList = new ArrayList<>();
        planOutputDetailList = planOutputRepository.findByInventoryOutputId(inventoryOutputId);
        return planOutputDetailList;
    }

}
