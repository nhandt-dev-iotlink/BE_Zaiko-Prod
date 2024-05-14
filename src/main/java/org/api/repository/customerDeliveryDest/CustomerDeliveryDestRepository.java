package org.api.repository.customerDeliveryDest;

import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.dto.customerDeliveryDest.response.CustomerDeliveryDestDialogDTO;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDeliveryDestRepository extends BaseRepository<CustomerDeliveryDestEntity, Integer> {

    @Query("SELECT new org.api.dto.customerDeliveryDest.response" +
            ".CustomerDeliveryDestDialogDTO(cd.deliveryDestinationId, cd.destinationCode, cd.departmentName) " +
            "FROM CustomerDeliveryDestEntity cd WHERE cd.delFlg='0'")
    List<CustomerDeliveryDestDialogDTO> findAllCustomerDeliveryDest();

    @Query("SELECT new org.api.dto.customerDeliveryDest" +
            ".response.CustomerDeliveryDestDialogDTO(cd.deliveryDestinationId, cd.destinationCode, cd.departmentName) " +
            "FROM CustomerDeliveryDestEntity cd WHERE cd.delFlg='0' " +
            "AND (cd.destinationCode LIKE CONCAT('%', :code, '%') OR cd.departmentName LIKE CONCAT('%', :name, '%'))")
    List<CustomerDeliveryDestDialogDTO> findByDestCodeOrName(@Param("code") String code, @Param("name") String name);
}
