package org.api.repository.salePrice;


import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.SalePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalePriceRepository extends JpaRepository<SalePriceEntity,Integer> {

    @Query(value = "SELECT * FROM m_sale_price sp " +
            "WHERE sp.create_date = (" +
            "  SELECT MAX(sub_sp.create_date) " +
            "  FROM m_sale_price sub_sp " +
            "  WHERE sub_sp.product_id = :productId" +
            ")",
            nativeQuery = true)
    SalePriceEntity findLatestSalePriceByProductId(@Param("productId") Integer productId);
}
