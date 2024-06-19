package org.api.repository.customerDeliveryDest;


import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDeliveryDestRepository  extends JpaRepository<CustomerDeliveryDestEntity , Integer> {


    @Query(value = "SELECT * FROM m_customer_delivery_dest  WHERE del_flg = '0' LIMIT 100 ",nativeQuery = true)
    List<CustomerDeliveryDestEntity> findAll();


    @Query(value = "SELECT cd FROM CustomerDeliveryDestEntity cd WHERE cd.delFlg='0' AND( cd.departmentName LIKE %:keyWord% OR cd.destinationCode = :keyWord)")
    List<CustomerDeliveryDestEntity> findCustomerDeliveryDestByKeyword(@Param("keyWord") String keyWord);
}
