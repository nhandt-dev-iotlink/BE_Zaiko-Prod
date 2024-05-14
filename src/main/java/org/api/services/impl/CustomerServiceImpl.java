package org.api.services.impl;

import org.api.annotation.LogExecutionTime;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.mapper.CustomerMapper;
import org.api.bean.reponse.dto.CustomerDTO;
import org.api.repository.customer.CustomerRepository;
import org.api.services.CustomerService;
import org.api.utils.ApiValidateException;
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
                .map(customerMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findCustomerByKeyword(String param) {
        List<CustomerEntity> entities = customerRepository.findCustomerKeyword(param);
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(customerMapper)
                .collect(Collectors.toList());
    }

}
