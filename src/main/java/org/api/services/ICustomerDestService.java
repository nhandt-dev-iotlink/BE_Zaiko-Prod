package org.api.services;

import org.api.bean.dto.CustomerDestDto;
import org.api.bean.dto.CustomerDto;

import java.util.List;

public interface ICustomerDestService {
    List<CustomerDestDto> getAll(String keyword);
}
