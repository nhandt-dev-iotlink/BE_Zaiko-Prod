package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.reponse.dto.CustomerDeliveryDestDTO;
import org.api.utils.ApiValidateException;

import java.util.List;

public interface CustomerDeliveryDestService {
    public List<CustomerDeliveryDestDTO> getAllCustomerDelivery();

    public List<CustomerDeliveryDestDTO> findCustomerDeliveryByKeyword(String param);

    public CustomerDeliveryDestDTO getCustomerDeliveryDestByCode(String customerCode);

    public ResultBean createCustomerDeliveryDest(CustomerDeliveryDestEntity deliveryDest) throws ApiValidateException, Exception;
}
