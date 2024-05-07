package org.api.services;

import org.api.bean.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAll(String keyword);
}
