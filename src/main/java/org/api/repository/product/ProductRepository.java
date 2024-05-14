package org.api.repository.product;


import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity ,Integer> {

    @Query(value = "SELECT * FROM m_product WHERE del_flg = '0' LIMIT 100 ",nativeQuery = true)
    List<ProductEntity> findAll();
    @Query(value = "SELECT * FROM m_product WHERE del_flg = '0' AND " +
            "(name1 LIKE CONCAT('%', :keyWord, '%') OR " +
            "name2 LIKE CONCAT('%', :keyWord, '%') OR " +
            "name3 LIKE CONCAT('%', :keyWord, '%') OR " +
            "name4 LIKE CONCAT('%', :keyWord, '%') OR " +
            "name5 LIKE CONCAT('%', :keyWord, '%') OR " +
            "product_code = :keyWord) LIMIT 100",
            nativeQuery = true)
    List<ProductEntity> findProductByKeyword(@Param("keyWord") String keyWord);

}
