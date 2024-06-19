package org.api.services;

import org.api.bean.dto.CustomerDto;
import org.api.bean.jpa.CustomerEntity;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAll(String keyword);

    CustomerDto getByCode(String customerCode);

    CustomerEntity createCustomer(CustomerEntity newCustomer);
}
