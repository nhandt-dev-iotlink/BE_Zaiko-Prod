package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerEntity;
import org.api.dto.CustomerDto;
import org.api.mapper.CustomerMapper;
import org.api.repository.customer.CustomerRepository;
import org.api.services.CustomerService;
import org.api.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public ResultBean getAll(String customerName) throws ApiValidateException {
        List<CustomerDto> customerDtoList =  customerRepository.getAll(customerName);
        if (!customerDtoList.isEmpty()) {
            return new ResultBean(customerDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
//            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.CUSTOMER_ID,
//                    MessageUtils.getMessage(Constants.ID_BKE00019, null, ItemNameUtils.getItemName(ConstantColumns.CUSTOMER_ID, ALIAS)));
        }
    }

    @Override
    public ResultBean getAllByCode(String code) throws Exception {
        CustomerDto dto = customerRepository.getAllByCode(code);
        if(dto == null){
            return new ResultBean(Constants.STATUS_NOT_FOUND, Constants.MESSAGE_OK);
        }
        return new ResultBean(dto,Constants.STATUS_OK,Constants.MESSAGE_OK);
    }

    @Override
    public CustomerEntity findOneCustomerByCode(String code) throws Exception {
        return customerRepository.findCustomerByCode(code);
    }

    @Override
    public ResultBean saveCustomer(CustomerDto dto) throws Exception {
        CustomerEntity entityToSave = customerMapper.toEntity(dto);
        CustomerEntity customerReturn = customerRepository.save(entityToSave);
        return new ResultBean(customerReturn, Constants.STATUS_201, Constants.MESSAGE_OK);
    }
}
