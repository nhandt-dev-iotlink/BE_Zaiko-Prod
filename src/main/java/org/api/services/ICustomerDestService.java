package org.api.services;

import org.api.bean.dto.CustomerDestDto;
import org.api.bean.jpa.CustomerDeliveryDestEntity;

import java.util.List;

public interface ICustomerDestService {
    List<CustomerDestDto> getAll(String keyword);

    CustomerDestDto getCustomerDestByCode(String destinationCode);

    CustomerDeliveryDestEntity createCustomerDest(CustomerDeliveryDestEntity customerDest);
}
