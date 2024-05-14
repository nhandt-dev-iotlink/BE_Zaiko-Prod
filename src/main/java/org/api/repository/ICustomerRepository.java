package org.api.repository;

import org.api.bean.dto.CustomerDto;

import org.api.bean.jpa.CustomerEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends BaseRepository<CustomerEntity, Integer> {
    @Query(value = " SELECT \n " +
            "   customer_code as customerCode,\n " +
            "   customer_name as customerName \n " +
            "FROM m_customer " +
            "WHERE (customer_name like CONCAT('%', :keyword, '%')) " +
            "OR (customer_code like CONCAT('%', :keyword, '%')) " +
            "order by customerCode asc ", nativeQuery = true)
    List<CustomerDto> getAll( @Param("keyword") String keyword);
}
