package org.api.repository;

import org.api.bean.dto.ProductDto;
import org.api.bean.jpa.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends BaseRepository<ProductEntity, Integer> {
    @Query(value = " SELECT \n " +
            "product_code as productCode,\n " +
            "name1 as productName \n " +
            "FROM m_product " +
            "WHERE (name1 like CONCAT('%', :keyword, '%'))" +
            "AND del_flg = 0 " +
            "order by productCode asc  LIMIT 500  ", nativeQuery = true)
    List<ProductDto> getAll(@Param("keyword") String keyword);
    @Query(value = " SELECT " +
            "product_id as productId, " +
            "product_code as productCode, " +
            "name1 as productName " +
            "FROM m_product " +
            " WHERE product_code = :productCode " +
            " AND del_flg = 0 " , nativeQuery = true)
    ProductDto findByCode(@Param("productCode") String productCode);
}
