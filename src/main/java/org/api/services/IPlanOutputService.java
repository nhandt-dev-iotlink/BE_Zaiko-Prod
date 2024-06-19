package org.api.services;

import org.api.bean.dto.*;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;

import java.util.List;

public interface IPlanOutputService {

    OutputDto findInventoryOutputById(Integer id);


    List<OutputPlanDetailDto> getPlanOutputDetail(Integer id);

    Boolean checkOutputByCode(String code);

    CustomerAndDestDto getCustomerInfo(String code);

    ProductSearchDto getProductInfo(String code);

    InventoryPlanOutputDetailEntity savePlanOutputDetail(InventoryPlanOutputDetailEntity inventoryPlanOutputDetail);

    List<InventoryPlanOutputDetailEntity> findByOutputId(Integer inventoryOutputId);
}
