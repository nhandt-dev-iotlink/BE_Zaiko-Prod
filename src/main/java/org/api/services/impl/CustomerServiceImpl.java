package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.UserLoginEntity;
import org.api.dto.CustomerDto;
import org.api.repository.customer.CustomerRepository;
import org.api.services.CustomerService;
import org.api.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    /** The Constant ALIAS. */
    public static final String ALIAS = "Customer";
    @Override
    public ResultBean getAll(String customerName) throws ApiValidateException {
        List<CustomerDto> customerDtoList =  customerRepository.getAll(customerName);

        if (!customerDtoList.isEmpty()) {
            return new ResultBean(customerDtoList, Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
//            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.CUSTOMER_ID,
//                    MessageUtils.getMessage(Constants.ID_BKE00019, null, ItemNameUtils.getItemName(ConstantColumns.CUSTOMER_ID, ALIAS)));
        }
    }
}
