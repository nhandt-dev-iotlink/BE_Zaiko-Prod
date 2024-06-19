package org.api.repository;

import org.api.bean.dto.SalePriceDto;
import org.api.bean.jpa.SalePriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISalePriceRepository extends BaseRepository<SalePriceEntity,Integer>{
    @Query(value = "SELECT \n" +
            "    sale_price_id AS salePriceId,\n" +
            "    pack_cs_price AS packCsPrice,\n" +
            "    pack_bl_price AS packBlPrice,\n" +
            "    piece_price AS packPsPrice\n" +
            "FROM\n" +
            "    m_sale_price\n" +
            "WHERE\n" +
            "    product_id = :productId " +
            "        AND customer_id = :customerId ;", nativeQuery = true)
    SalePriceDto getSalePriceInfo(@Param("productId") Integer productId, @Param("customerId") Integer customerId);
}
