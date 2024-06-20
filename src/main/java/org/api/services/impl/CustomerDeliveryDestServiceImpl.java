package org.api.services.impl;


import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.SupplierEntity;
import org.api.bean.mapper.CustomerDeliveryDestMapper;
import org.api.bean.mapper.CustomerMapper;
import org.api.bean.reponse.dto.CustomerDTO;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.api.bean.reponse.dto.SupplierDTO;
import org.api.repository.customer.CustomerRepository;
import org.api.repository.customerDeliveryDest.CustomerDeliveryDestRepository;
import org.api.services.CustomerDeliveryDestService;
import org.api.services.CustomerService;
import org.api.utils.ApiValidateException;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class CustomerDeliveryDestServiceImpl implements CustomerDeliveryDestService {

    @Autowired
    CustomerDeliveryDestRepository customerDeliveryDestRepository;

    @Autowired
    CustomerDeliveryDestMapper customerDeliveryDestMapper;

    @Override
    public List<CustomerDeliveryDestDTO> getAllCustomerDelivery() {
        List<CustomerDeliveryDestEntity> entities = customerDeliveryDestRepository.findAll();
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(entity ->customerDeliveryDestMapper.customerDeliveryDestToCustomerDeliveryDestDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDeliveryDestDTO> findCustomerDeliveryByKeyword(String param) {
        List<CustomerDeliveryDestEntity> entities = customerDeliveryDestRepository.findCustomerDeliveryDestByKeyword(param);
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(entity -> customerDeliveryDestMapper.customerDeliveryDestToCustomerDeliveryDestDto(entity))
                .collect(Collectors.toList());
    }
    @Override
    public CustomerDeliveryDestDTO getCustomerDeliveryDestByCode(String customerCode) {
        CustomerDeliveryDestEntity entities=customerDeliveryDestRepository.getCustomerDeliveryByCode(customerCode);
        if (entities==null){
            return  null;
        }
        return customerDeliveryDestMapper.customerDeliveryDestToCustomerDeliveryDestDto(entities);
    }
    @Override
    @Transactional
    public ResultBean createCustomerDeliveryDest(CustomerDeliveryDestEntity deliveryDest) throws ApiValidateException, Exception {
        if(customerDeliveryDestRepository.existsByDeliveryDestinationId(deliveryDest.getDeliveryDestinationId())){
            throw new ApiValidateException(Constants.STATUS_BAD_REQUEST, "Customer with code " + deliveryDest.getDeliveryDestinationId() + " already exists.");
        }
        CustomerDeliveryDestEntity saveDeliveryDest= customerDeliveryDestRepository.save(deliveryDest);
        return new ResultBean(saveDeliveryDest,Constants.STATUS_201,Constants.STATUS_OK);
    }

}
