package org.api.services.impl;

import org.api.annotation.LogExecutionTime;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.SupplierEntity;
import org.api.bean.mapper.SupplierMapper;
import org.api.bean.reponse.dto.SupplierDTO;
import org.api.repository.supplier.SupplierRepository;
import org.api.services.SupplierService;
import org.api.utils.ApiValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierMapper supplierMapper;



    @Override
    public List<SupplierDTO> getAllSupplier() {
        List<SupplierEntity> entities = supplierRepository.findAllSuppliers();
        if(entities.isEmpty()){
            return  null;
        }
        return entities.stream()
                .map(supplierMapper) // Chuyển đổi
                .collect(Collectors.toList());


    }

    @Override
    public List<SupplierDTO> findSuppliersByKeyword(String param) {
        List<SupplierEntity> entities =supplierRepository.findSuppliersByKeyword(param);
        if(!entities.isEmpty()){
            return entities.stream()
                    .map(supplierMapper) // Chuyển đổi
                    .collect(Collectors.toList());
        }
        return null;

    }


}
