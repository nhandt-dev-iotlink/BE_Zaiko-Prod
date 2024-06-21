package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.InventoryOutputPlanDTO;
import org.api.bean.reponse.dto.PlanFormDTO;
import org.api.bean.reponse.dto.PlanOutputDTO;
import org.api.utils.ApiValidateException;

import java.util.List;

public interface InventoryPlanOutputSerice {

    public ResultBean getPlanOutputWithKey(Integer inventoryOutputId) throws ApiValidateException;

    public ResultBean createInventoryOutputPlan(PlanFormDTO json) throws ApiValidateException ,Exception;

    public ResultBean removeInventoryOutputPlan (Integer inventoryId) throws ApiValidateException ,Exception;

    public ResultBean getOutputDetailById(Integer id) throws ApiValidateException;

    public ResultBean updateInventoryOutputPlan(String json) throws Exception;
}
