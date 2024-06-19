package org.api.controller;


import io.lettuce.core.dynamic.annotation.Param;
import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.api.bean.reponse.dto.PlanOutputDTO;
import org.api.services.InventoryPlanOutputSerice;
import org.api.utils.Constants;
import org.api.utils.Paging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@LogExecutionTime
@RestController
public class InventoryPlanOutputController {

    @Autowired
    private InventoryPlanOutputSerice planOutputSerice;
    private static final Logger log = LoggerFactory.getLogger(InventoryPlanOutputController.class);

    @GetMapping(value = "/api/inventory-output-plan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPlanOutputByID(@PathVariable Integer id) {
        PlanOutputDTO planOutputDTO = planOutputSerice.getPlanOutputWithKey(id);

        if (planOutputDTO == null) {
            ResultBean emptyResult = new ResultBean(Constants.STATUS_BAD_REQUEST, "No Content");
            return new ResponseEntity<>(emptyResult, HttpStatus.OK);
        }


        ResultBean resultBean = new ResultBean(planOutputDTO, Constants.STATUS_OK, Constants.STATUS_OK);
        return new ResponseEntity<>(resultBean, HttpStatus.OK);
    }

    @GetMapping(value = "/api/inventory-output-plan-detail",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPlanOutputDetailByID(@RequestParam("inventoryOutputId") Integer inventoryOutputId ){
     return  null;
    }


}
