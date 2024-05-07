package org.api.services.impl;

import org.api.bean.dto.CustomerDto;
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
}
