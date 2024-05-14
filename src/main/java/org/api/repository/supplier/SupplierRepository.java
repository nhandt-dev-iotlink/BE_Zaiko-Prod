package org.api.repository.supplier;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.SupplierEntity;
import org.api.dto.SupplierDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends BaseRepository<SupplierEntity, Integer> {
    @Query(value = "SELECT new org.api.dto.SupplierDto(a.supplierId, a.supplierCode, a.supplierName) FROM SupplierEntity a WHERE a.delFlg = '0' AND (:param = '' OR a.supplierCode LIKE CONCAT('%',:param,'%') OR a.supplierName LIKE CONCAT('%',:param,'%')) GROUP BY a.supplierId ORDER BY a.supplierCode")
    List<SupplierDto> getAll(@Param("param") String param);
    @Query(nativeQuery = true, value = "SELECT * FROM m_supplier a WHERE a.del_flg = '0' AND a.supplier_code LIKE CONCAT('%',:param,'%') order by a.supplier_id limit 1")
    SupplierEntity findByCode(@Param("param") String param);
}
