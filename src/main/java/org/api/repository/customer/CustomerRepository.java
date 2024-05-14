package org.api.repository.customer;

import org.api.bean.jpa.CustomerEntity;
import org.api.dto.customer.response.CustomerDialogDTO;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Integer> {

    @Query("SELECT new org.api.dto.customer.response.CustomerDialogDTO(c.customerId, c.customerCode, c.customerName) " +
            "FROM CustomerEntity c " +
            "WHERE c.delFlg = '0'")
    List<CustomerDialogDTO> findAllCustomer();

    @Query("SELECT new org.api.dto.customer.response.CustomerDialogDTO(c.customerId, c.customerCode, c.customerName) " +
            "FROM CustomerEntity c " +
            "WHERE c.delFlg = '0' AND (c.customerCode LIKE CONCAT('%', :code, '%') OR c.customerName LIKE CONCAT('%', :name, '%')) ")
    List<CustomerDialogDTO> findByCustomerCodeOrCustomerName(@Param("code") String code, @Param("name") String name);
}
