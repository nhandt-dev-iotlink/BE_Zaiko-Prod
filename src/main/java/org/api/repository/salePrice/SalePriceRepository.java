package org.api.repository.salePrice;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.SalePriceEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePriceRepository extends BaseRepository<SalePriceEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM zaiko_v3.m_sale_price where del_flg = 0 AND product_id = :id AND datetime_mng_to > now() ORDER BY datetime_mng_from desc limit 1")
    SalePriceEntity findOneByProductId(@Param("id") Integer id);
}
