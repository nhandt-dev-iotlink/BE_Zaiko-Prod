package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.PlanFormDTO;
import org.api.bean.reponse.dto.PlanOutputDTO;
import org.api.utils.ApiValidateException;

import java.util.List;

public interface InventoryPlanOutputSerice {

    public PlanOutputDTO getPlanOutputWithKey(Integer key);

    public ResultBean createInventoryOutputPlan(PlanFormDTO json) throws ApiValidateException ,Exception;

    public ResultBean removeInventoryOutputPlan (Integer inventoryId, List<Integer> inventoryDetailId) throws ApiValidateException ,Exception;

    public ResultBean getOutputDetailById(Integer id) throws ApiValidateException;
}
