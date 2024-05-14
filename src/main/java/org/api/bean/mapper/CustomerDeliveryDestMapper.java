package org.api.bean.mapper;

import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerDeliveryDestMapper implements Function<CustomerDeliveryDestEntity, CustomerDeliveryDestDTO> {

    @Override
    public CustomerDeliveryDestDTO apply(CustomerDeliveryDestEntity entity) {
        return CustomerDeliveryDestDTO.builder()
                .deliveryDestinationId(entity.getDeliveryDestinationId())
                .companyId(entity.getCompanyId())
                .customerId(entity.getCustomerId())
                .destinationCode(entity.getDestinationCode())
                .departmentName(entity.getDepartmentName())
                .picName(entity.getPicName())
                .phoneNumber(entity.getPhoneNumber())
                .address1(entity.getAddress1())
                .leadTime(entity.getLeadTime())
                .build();
    }
}
