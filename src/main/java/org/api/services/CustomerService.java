package org.api.services;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.reponse.dto.CustomerDTO;
import org.api.bean.reponse.dto.SupplierDTO;
import org.api.utils.ApiValidateException;
import org.springframework.stereotype.Indexed;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getAllActiveCustomers();

    public List<CustomerDTO> findCustomerByKeyword(String param);

    public CustomerDTO getCustomerByCode(String customerCode);

    public CustomerDTO getCustomerById(Integer id);

    public ResultBean createCustomer(CustomerEntity customer) throws ApiValidateException, Exception;

}
