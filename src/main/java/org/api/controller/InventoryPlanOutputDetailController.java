package org.api.controller;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;

import org.api.bean.reponse.dto.InventoryOutputPlanDTO;
import org.api.bean.reponse.dto.PlanFormDTO;
import org.api.bean.reponse.dto.PlanOutputDTO;
import org.api.services.InventoryPlanOutputSerice;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.api.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@LogExecutionTime
@RestController
public class InventoryPlanOutputDetailController {
    @Autowired
    private InventoryPlanOutputSerice planOutputSerice;
    private static final Logger log = LoggerFactory.getLogger(InventoryPlanOutputDetailController.class);

    @GetMapping(value = "/api/inventory-output-plan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getPlanOutputByID(@PathVariable Integer id) throws ApiValidateException {
        ResultBean resultBean = null;
        resultBean = planOutputSerice.getPlanOutputWithKey(id);
        if (resultBean == null) {
            ResultBean emptyResult = new ResultBean(Constants.STATUS_NO_CONTENT,Constants.MESSAGE_NO_CONTENT);
            return new ResponseEntity<>(emptyResult, HttpStatus.OK);
        }
        return new ResponseEntity<>(resultBean, HttpStatus.OK);
    }

    @GetMapping(value = "/api/inventory-output-plan-detail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> getPlanOutputDetailByID(@PathVariable Integer id ) throws Exception {
        ResultBean resultBean = null;
        resultBean = planOutputSerice.getOutputDetailById(id);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @PostMapping(value = "/api/inventory-output-plan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultBean  createInventoryOutputPlan(@RequestBody PlanFormDTO planForm) {
        try {
            return planOutputSerice.createInventoryOutputPlan(planForm);
        } catch (ApiValidateException e) {
            return new ResultBean(Constants.STATUS_BAD_REQUEST, Constants.MESSAGE_BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBean(Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
        }
    }

    @PutMapping("/api/inventory-output-plan")
    public ResponseEntity<ResultBean> updateInventoryOutputPlan(@RequestBody String json) throws Exception {
        ResultBean resultBean = null;
        resultBean = planOutputSerice.updateInventoryOutputPlan(json);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/inventory-output-plan/{inventoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultBean> removeInventoryOutputPlan(@PathVariable("inventoryId") Integer inventoryId) throws Exception, ApiValidateException  {
             ResultBean resultBean = null;
            if (inventoryId == null ) {
                return ResponseEntity.badRequest().body(new ResultBean(null, Constants.STATUS_BAD_REQUEST, Constants.MESSAGE_SYSTEM_ERROR));
            }
            resultBean = planOutputSerice.removeInventoryOutputPlan(inventoryId);
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);

    }


}





