package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.dto.InventoryProductTypeDto;
import org.api.repository.commonSetting.CommonSettingRepository;
import org.api.services.CommonSettingService;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonSettingServiceImpl implements CommonSettingService {
    @Autowired
    private CommonSettingRepository commonSettingRepository;
//    @Autowired
//    private InventoryProductTypeMapper inventoryProductTypeMapper;
    @Override
    public ResultBean getAllInventoryProductType() throws ApiValidateException {
//        List<CommonSettingEntity> inventoryProductTypeList = commonSettingRepository.getAllInventoryProductType();
        List<InventoryProductTypeDto> inventoryProductTypeDtoList =  commonSettingRepository.getAllInventoryProductType();
        if(!inventoryProductTypeDtoList.isEmpty()){
//            inventoryProductTypeDtoList = inventoryProductTypeMapper.map(inventoryProductTypeList);
            return new ResultBean(inventoryProductTypeDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
    }
}
