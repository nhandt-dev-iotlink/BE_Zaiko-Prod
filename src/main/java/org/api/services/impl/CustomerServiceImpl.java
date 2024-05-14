package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.dto.customer.response.CustomerDialogDTO;
import org.api.repository.customer.CustomerRepository;
import org.api.services.CustomerService;
import org.api.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public ResultBean getCustomersForDialog() {
        List<CustomerDialogDTO> customerDialogDTOList = customerRepository.findAllCustomer();
//        if(!customerDialogDTOList.isEmpty()){
//            return new ResultBean(customerDialogDTOList, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
        return (!customerDialogDTOList.isEmpty()) ? new ResultBean(customerDialogDTOList, Constants.STATUS_OK, Constants.MESSAGE_OK) :
                new ResultBean(customerDialogDTOList, Constants.STATUS_NOT_FOUND, "Not Found");
    }

    @Override
    public ResultBean getSearchCustomersForDialog(String keyWord) {
        List<CustomerDialogDTO> customerDialogDTOList = customerRepository.findByCustomerCodeOrCustomerName(keyWord, keyWord);
//        if(!customerDialogDTOList.isEmpty()){
//            return new ResultBean(customerDialogDTOList, Constants.STATUS_OK, Constants.MESSAGE_OK);
//        }
        return (!customerDialogDTOList.isEmpty()) ? new ResultBean(customerDialogDTOList, Constants.STATUS_OK, Constants.MESSAGE_OK) :
                new ResultBean(customerDialogDTOList, Constants.STATUS_NOT_FOUND, "Not Found");
    }
}
