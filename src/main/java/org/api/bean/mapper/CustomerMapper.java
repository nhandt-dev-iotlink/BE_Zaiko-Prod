package org.api.bean.mapper;


import org.api.bean.jpa.CustomerEntity;
import org.api.bean.reponse.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class CustomerMapper implements Function<CustomerEntity, CustomerDTO> {
    @Override
    public CustomerDTO apply(CustomerEntity customer) {
        return CustomerDTO.builder()
                .customerId(customer.getCustomerId())
                .customerCode(customer.getCustomerCode())
                .customerName(customer.getCustomerName())
                .build();
    }
}


