package org.api.repository.customer;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.CustomerEntity;
import org.api.dto.CustomerDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Integer> {
    @Query("SELECT new org.api.dto.CustomerDto(a.customerId, a.customerCode, a.customerName, a.departmentName, a.picName, " +
            "a.leadTime, a.companyId, a.phoneNumber, a.faxNumber, a.postCode, a.address1, a.address2, a.address3, a.address4, a.routeCode, a.courseCode) " +
            "FROM CustomerEntity a WHERE a.delFlg = '0' AND (:customerName = '' OR a.customerName LIKE CONCAT('%', :customerName, '%') " +
            "OR a.customerCode LIKE CONCAT('%', :customerName, '%')) ORDER BY a.customerCode")
    List<CustomerDto> getAll(@Param("customerName") String customerName);
    @Query("select new org.api.dto.CustomerDto(a.customerId, a.customerCode, a.customerName, a.departmentName, a.picName, a.leadTime, a.companyId, " +
            "a.phoneNumber, a.faxNumber, a.postCode, a.address1, a.address2, a.address3, a.address4, a.routeCode, a.courseCode) FROM CustomerEntity a WHERE a.delFlg = '0' AND a.customerCode like :code")
    CustomerDto getAllByCode(@Param("code") String code);
    @Query(nativeQuery = true, value = "SELECT * FROM m_customer c WHERE c.customer_code = :code AND c.del_flg = '0'")
    CustomerEntity findCustomerByCode(@Param("code") String code);
}
