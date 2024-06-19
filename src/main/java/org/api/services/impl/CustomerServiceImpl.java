package org.api.services.impl;

import org.api.bean.dto.CustomerDto;
import org.api.bean.jpa.CustomerEntity;
import org.api.repository.ICustomerRepository;
import org.api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<CustomerDto> getAll(String keyword) {
        return customerRepository.getAll(keyword);
    }

    @Override
    public CustomerDto getByCode(String customerCode) {
        return customerRepository.getByCode(customerCode);
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity newCustomer) {
        return customerRepository.save(newCustomer);
    }
}
