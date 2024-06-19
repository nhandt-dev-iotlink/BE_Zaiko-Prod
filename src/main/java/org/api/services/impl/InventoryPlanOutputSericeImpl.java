package org.api.services.impl;


import org.api.bean.reponse.dto.PlanOutputDTO;
import org.api.repository.plan.InventoryPlanOutputRepository;
import org.api.services.InventoryPlanOutputSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class InventoryPlanOutputSericeImpl implements InventoryPlanOutputSerice {

    @Autowired
    InventoryPlanOutputRepository planOutputRepository;


    @Override
    public PlanOutputDTO getPlanOutputWithKey(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        PlanOutputDTO planOutputDTO = planOutputRepository.findPlanOutputWithKey(key);
        if (planOutputDTO == null) {
            throw new EntityNotFoundException("Plan output not found for key: " + key);
        }
        return planOutputDTO;
    }
}
