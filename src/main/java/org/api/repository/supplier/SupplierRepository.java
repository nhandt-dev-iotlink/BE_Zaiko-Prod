package org.api.repository.supplier;

import org.api.bean.jpa.SupplierEntity;
import org.api.dto.supplier.response.SupplierDialogDTO;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends BaseRepository<SupplierEntity, Integer> {

    @Query("SELECT new org.api.dto.supplier.response.SupplierDialogDTO(s.supplierId, s.supplierCode, s.supplierName) " +
            "FROM SupplierEntity s WHERE s.delFlg = '0'")
    List<SupplierDialogDTO> findAllSupplier();

    @Query("SELECT new org.api.dto.supplier.response.SupplierDialogDTO(s.supplierId, s.supplierCode, s.supplierName) " +
            "FROM SupplierEntity s " +
            "WHERE s.delFlg = '0' AND (s.supplierCode LIKE CONCAT('%', :code, '%') OR s.supplierName LIKE CONCAT('%', :name, '%'))")
    List<SupplierDialogDTO> findSupplierByCodeOrName(@Param("code") String code, @Param("name") String name);
}
