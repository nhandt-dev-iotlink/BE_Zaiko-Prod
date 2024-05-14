package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.dto.customerDeliveryDest.response.CustomerDeliveryDestDialogDTO;
import org.api.repository.customerDeliveryDest.CustomerDeliveryDestRepository;
import org.api.services.CustomerDeliveryDestService;
import org.api.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDeliveryDestServiceImpl implements CustomerDeliveryDestService {
    private final CustomerDeliveryDestRepository customerDeliverDestRepository;

    public CustomerDeliveryDestServiceImpl(CustomerDeliveryDestRepository customerDeliverDestRepository) {
        this.customerDeliverDestRepository = customerDeliverDestRepository;
    }

    @Override
    public ResultBean getAllCustomerDeliveryDestDialog() {
        List<CustomerDeliveryDestDialogDTO> customerDeliveryDestDialogDTOS =
                customerDeliverDestRepository.findAllCustomerDeliveryDest();
//        if(!customerDeliveryDestDialogDTOS.isEmpty()){
//            return new ResultBean(customerDeliveryDestDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
        return (!customerDeliveryDestDialogDTOS.isEmpty()) ? new ResultBean(customerDeliveryDestDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK) :
                new ResultBean(customerDeliveryDestDialogDTOS, Constants.STATUS_NOT_FOUND, "Empty Result");
    }

    @Override
    public ResultBean searchCustomerDeliveryDestDialogByCodeOrName(String keyWord) {
        List<CustomerDeliveryDestDialogDTO> customerDeliveryDestDialogDTOS = customerDeliverDestRepository
                .findByDestCodeOrName(keyWord, keyWord);
//        if(!customerDeliveryDestDialogDTOS.isEmpty()){
//            return new ResultBean(customerDeliveryDestDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
        return (!customerDeliveryDestDialogDTOS.isEmpty()) ? new ResultBean(customerDeliveryDestDialogDTOS, Constants.STATUS_OK, Constants.MESSAGE_OK) :
                new ResultBean(customerDeliveryDestDialogDTOS, Constants.STATUS_NOT_FOUND, "Empty Result");
    }
}
