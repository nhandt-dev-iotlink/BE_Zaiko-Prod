package org.api.repository.customer;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.CustomerEntity;
import org.api.dto.CustomerDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Integer> {
    @Query("SELECT new org.api.dto.CustomerDto(a.customerId, a.customerCode, a.customerName) FROM CustomerEntity a WHERE a.delFlg = '0' AND (:customerName = '' OR a.customerName LIKE CONCAT('%', :customerName, '%') OR a.customerCode LIKE CONCAT('%', :customerName, '%')) ORDER BY a.customerCode")
    List<CustomerDto> getAll(@Param("customerName") String customerName);
}
