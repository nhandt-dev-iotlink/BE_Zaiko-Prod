package org.api.repository.supplier;
import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer> {
    @Query(value = "SELECT * FROM m_supplier WHERE del_flg = '0' LIMIT 100 ",nativeQuery = true)
    List<SupplierEntity> findAllSuppliers();

    @Query("SELECT s FROM SupplierEntity s WHERE s.delFlg = '0' AND (s.supplierName LIKE %:keyWord% OR s.supplierCode = :keyWord)")
    List<SupplierEntity> findSuppliersByKeyword(@Param("keyWord") String keyWord);
}
