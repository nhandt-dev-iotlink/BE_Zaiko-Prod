package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.SupplierEntity;
import org.api.dto.SupplierDto;
import org.api.repository.supplier.SupplierRepository;
import org.api.services.SupplierService;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public ResultBean getAll(String param) throws ApiValidateException {
        List<SupplierDto> supplierDtoList = supplierRepository.getAll(param);
        if(!supplierDtoList.isEmpty()){
            return new ResultBean(supplierDtoList, Constants.STATUS_OK,Constants.MESSAGE_OK);
        }else {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
    }

    @Override
    public SupplierEntity findByCode(String supplierCode) {
        return supplierRepository.findByCode(supplierCode);
    }
}
