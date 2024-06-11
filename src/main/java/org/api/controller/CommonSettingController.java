package org.api.controller;

import org.api.bean.ResultBean;
import org.api.services.CommonSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/common/setting")
public class CommonSettingController {
    @Autowired
    private CommonSettingService commonSettingService;
    @GetMapping("/inventory-product-type")
    public ResponseEntity<ResultBean> getAllInventoryProductType() throws Exception{
        ResultBean resultBean = null;
        resultBean = commonSettingService.getAllInventoryProductType();
        return new ResponseEntity<>(resultBean, HttpStatus.OK);
    }
}
