package org.api.services.impl;

import org.api.bean.dto.CustomerDestDto;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.repository.ICustomerDestRepository;
import org.api.services.ICustomerDestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDestServiceImpl implements ICustomerDestService {
    @Autowired
    private ICustomerDestRepository customerDestRepository;
    @Override
    public List<CustomerDestDto> getAll(String keyword) {
        return customerDestRepository.getAll(keyword);
    }

    @Override
    public CustomerDestDto getCustomerDestByCode(String destinationCode) {
        return customerDestRepository.findByCode(destinationCode);
    }

    @Override
    public CustomerDeliveryDestEntity createCustomerDest(CustomerDeliveryDestEntity customerDest) {
        return customerDestRepository.save(customerDest);
    }
}
