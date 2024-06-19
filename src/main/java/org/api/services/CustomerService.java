package org.api.services;

import org.api.bean.reponse.dto.CustomerDTO;
import org.api.bean.reponse.dto.SupplierDTO;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getAllActiveCustomers();

    public List<CustomerDTO> findCustomerByKeyword(String param);

}
