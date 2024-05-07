package org.api.repository;

import org.api.bean.dto.CustomerDestDto;
import org.api.bean.dto.CustomerDto;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ICustomerDestRepository extends BaseRepository<CustomerDeliveryDestEntity, Integer> {
    @Query(value = " SELECT \n " +
            "  delivery_destination_id  as deliveryDestinationId,\n " +
            "  department_name as departmentName \n " +
            "FROM m_customer_delivery_dest " +
            "WHERE (department_name like CONCAT('%', :keyword, '%')) " +
            "OR (destination_code like CONCAT('%', :keyword, '%')) " +
            "order by deliveryDestinationId asc ", nativeQuery = true)
    List<CustomerDestDto> getAll(@Param("keyword") String keyword);
}
