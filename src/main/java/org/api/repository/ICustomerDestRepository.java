package org.api.repository;

import org.api.bean.dto.CustomerDestDto;
import org.api.bean.dto.CustomerDto;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ICustomerDestRepository extends BaseRepository<CustomerDeliveryDestEntity, Integer> {
    @Query(value = " SELECT \n " +
            "  destination_code  as destinationCode,\n " +
            "  department_name as departmentName \n " +
            "FROM m_customer_delivery_dest " +
            "WHERE (department_name like CONCAT('%', :keyword, '%')) " +
            "OR (destination_code like CONCAT('%', :keyword, '%')) " +
            "order by destinationCode asc ", nativeQuery = true)
    List<CustomerDestDto> getAll(@Param("keyword") String keyword);
}
