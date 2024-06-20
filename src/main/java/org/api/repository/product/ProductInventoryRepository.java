package org.api.repository.product;


import io.lettuce.core.dynamic.annotation.Param;

import org.api.bean.jpa.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventoryEntity, Integer> {
    @Query(value = "SELECT * FROM t_product_inventory p WHERE p.del_flg = '0' " +
            "AND (:keyWord IS NULL OR :keyWord = '' OR p.customer_code LIKE %:keyWord% OR p.product_code = :keyWord) " +
            "LIMIT 100", nativeQuery = true)
    List<ProductInventoryEntity> findProductInventoryKeyword(@Param("keyWord") String keyWord);

    @Query("SELECT p FROM ProductInventoryEntity p WHERE p.delFlg = '0' AND p.inventory_id =:productInventoryId")
    ProductInventoryEntity getProductInventoryById(@Param("productInventoryId") Integer productInventoryId);

}
