package org.api.repository;

import org.api.bean.dto.CustomerDto;
import org.api.bean.dto.SupplierDto;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.SupplierEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISupplierRepository extends BaseRepository<SupplierEntity, Integer> {
    @Query(value = " SELECT \n " +
            "   supplier_code as supplierCode,\n " +
            "   supplier_name as supplierName \n " +
            "FROM m_supplier " +
            "WHERE (supplier_name like CONCAT('%', :keyword, '%')) " +
            "OR (supplier_code like CONCAT('%', :keyword, '%')) " +
            "order by supplierCode asc ", nativeQuery = true)
    List<SupplierDto> getAll(@Param("keyword") String keyword);
}
