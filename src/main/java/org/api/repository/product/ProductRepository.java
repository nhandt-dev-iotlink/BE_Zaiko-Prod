package org.api.repository.product;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.ProductEntity;
import org.api.dto.ProductDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Integer> {
    //        @Query(value = "SELECT new org.api.dto.ProductDto(a.productId, a.productCode, a.name1) FROM ProductEntity a WHERE a.delFlg = '0' AND (:param = '' OR a.productCode LIKE CONCAT('%',:param,'%') OR a.name1  LIKE CONCAT('%',:param,'%')) ORDER BY a.productCode")
//    List<ProductDto> getAll(@Param("param") String param);
    @Query(nativeQuery = true, value = "SELECT * FROM m_product AS a WHERE a.del_flg = '0' AND (a.product_code LIKE CONCAT('%',:param,'%') OR a.name1  LIKE CONCAT('%',:param,'%') OR a.name2  LIKE CONCAT('%',:param,'%') OR a.name3  LIKE CONCAT('%',:param,'%') OR a.name4  LIKE CONCAT('%',:param,'%') OR a.name5  LIKE CONCAT('%',:param,'%')) ORDER BY a.product_code LIMIT 1000")
    List<ProductEntity> getAll(@Param("param") String param);

    @Query(nativeQuery = true, value = "SELECT * FROM m_product AS p WHERE p.del_flg = '0' AND p.product_id = :id ORDER BY p.product_id LIMIT 1")
    ProductEntity findOneById(@Param("id") Integer id);
    @Query(nativeQuery = true, value = "SELECT * FROM m_product AS p WHERE p.del_flg = '0' AND p.product_code = :id ORDER BY p.product_id LIMIT 1")
    ProductEntity findOneByCode(@Param("id") String id);
}
