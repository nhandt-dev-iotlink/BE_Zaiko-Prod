package org.api.services;

import org.api.bean.reponse.dto.PlanOutputDTO;

public interface InventoryPlanOutputSerice {

    public PlanOutputDTO getPlanOutputWithKey(Integer key);
}
