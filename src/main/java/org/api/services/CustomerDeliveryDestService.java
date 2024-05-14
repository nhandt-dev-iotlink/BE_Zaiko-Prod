package org.api.services;

import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;

import java.util.List;

public interface CustomerDeliveryDestService {
    public List<CustomerDeliveryDestDTO> getAllCustomerDelivery();

    public List<CustomerDeliveryDestDTO> findCustomerDeliveryByKeyword(String param);
}
