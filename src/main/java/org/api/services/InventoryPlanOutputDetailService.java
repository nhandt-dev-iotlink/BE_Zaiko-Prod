package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.api.dto.PlanFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryPlanOutputDetailService {
    Page<InventoryPlanOutputDetailDto> getAllInventoryPlanOutputDetailByInventoryOutputId(Pageable pageable, Integer inventoryOutputId) throws Exception;

    ResultBean addNewDetailByInventoryOutputId(List<InventoryPlanOutputDetailDto> dto) throws Exception;

    ResultBean deletePlanOutputDetailByOutputId(Integer id) throws Exception;

    ResultBean savePlanOutputDetail(InventoryPlanOutputDetailDto dto, InventoryOutputEntity outputEntity) throws Exception;
}
