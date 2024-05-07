package org.api.repository;

import org.api.bean.dto.ProductDto;
import org.api.bean.jpa.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends BaseRepository<ProductEntity, Integer> {
    @Query(value = " SELECT \n " +
            "   product_id as productId,\n " +
            "   name1 as productName \n " +
            "FROM m_product " +
            "WHERE (name1 like CONCAT('%', :keyword, '%')) " +
            "OR (name2 like CONCAT('%', :keyword, '%')) " +
            "OR (name3 like CONCAT('%', :keyword, '%')) " +
            "OR (name4 like CONCAT('%', :keyword, '%')) " +
            "OR (name5 like CONCAT('%', :keyword, '%')) " +
            "order by productId asc  LIMIT 5000  ", nativeQuery = true)
    List<ProductDto> getAll(@Param("keyword") String keyword);
}
