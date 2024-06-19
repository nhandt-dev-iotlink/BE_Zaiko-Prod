package org.api.repository.customer;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Query(value ="SELECT * FROM m_customer WHERE del_flg = '0' LIMIT 100 ", nativeQuery = true)
    List<CustomerEntity> findAllCustomers();

    @Query(
            value = "SELECT * FROM m_customer WHERE del_flg = '0' AND (customer_name LIKE %:keyWord% OR customer_code = :keyWord) LIMIT 100",
            nativeQuery = true)
    List<CustomerEntity> findCustomerKeyword(@Param("keyWord") String keyWord);

}
