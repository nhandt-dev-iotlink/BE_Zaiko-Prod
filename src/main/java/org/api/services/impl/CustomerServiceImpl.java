package org.api.services.impl;

import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.mapper.CustomerMapper;
import org.api.bean.reponse.dto.CustomerDTO;
import org.api.repository.customer.CustomerRepository;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public List<CustomerDTO> getAllActiveCustomers() {
        List<CustomerEntity> entities = customerRepository.findAllCustomers();
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(entity -> customerMapper.customerToCustomerDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findCustomerByKeyword(String param) {
        List<CustomerEntity> entities = customerRepository.findCustomerKeyword(param);
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(entity -> customerMapper.customerToCustomerDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByCode(String customerCode) {
        CustomerEntity entity = customerRepository.getCustomerEntityByCode(customerCode);
        return customerMapper.customerToCustomerDto(entity);
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        CustomerEntity entity = customerRepository.getCustomerEntityById(id);
        return customerMapper.customerToCustomerDto(entity);
    }

    @Override
    @Transactional
    public ResultBean createCustomer(CustomerEntity customer) throws ApiValidateException, Exception {

        if (customerRepository.existsById(customer.getCustomerId())) {
            throw new ApiValidateException(Constants.STATUS_BAD_REQUEST, "Customer with code " + customer.getCustomerCode() + " already exists.");
        }
        CustomerEntity savedCustomer = customerRepository.save(customer);
        return new ResultBean(savedCustomer, Constants.STATUS_201, Constants.MESSAGE_OK);

    }
}