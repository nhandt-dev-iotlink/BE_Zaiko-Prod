package org.api.repository.customerDeliveryDest;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.dto.CustomerDeliveryDestDto;
import org.api.dto.CustomerDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDeliveryDestRepository extends BaseRepository<CustomerDeliveryDestEntity, Integer> {
    @Query(value = "SELECT new org.api.dto.CustomerDeliveryDestDto(a.deliveryDestinationId, a.destinationCode, " +
            "a.departmentName, a.phoneNumber, a.faxNumber, a.postCode, a.routeCode, a.courseCode, a.address1, " +
            "a.address2, a.address3, a.address4) FROM CustomerDeliveryDestEntity a WHERE a.delFlg = '0' AND (:deliveryName = '' OR a.destinationCode LIKE CONCAT('%', :deliveryName, '%') OR a.departmentName LIKE CONCAT('%', :deliveryName, '%')) ORDER BY a.destinationCode")
    List<CustomerDeliveryDestDto> getAll(@Param("deliveryName") String deliveryName);

    @Query(value = "SELECT new org.api.dto.CustomerDeliveryDestDto(a.deliveryDestinationId, a.destinationCode, " +
            "a.departmentName, a.phoneNumber, a.faxNumber, a.postCode, a.routeCode, a.courseCode, a.address1, " +
            "a.address2, a.address3, a.address4) FROM CustomerDeliveryDestEntity a WHERE a.delFlg = '0' AND a.destinationCode = :code")
    CustomerDeliveryDestDto findDtoByCode(@Param("code") String code);

    @Query(nativeQuery = true, value = "SELECT * FROM m_customer_delivery_dest WHERE destination_code = :code AND del_flg = '0'")
    CustomerDeliveryDestEntity findEntityByDestinationCode(@Param("code") String code);
}

