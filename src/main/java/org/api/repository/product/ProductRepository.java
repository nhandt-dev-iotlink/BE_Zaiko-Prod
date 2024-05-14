package org.api.repository.product;

import org.api.bean.jpa.ProductEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Integer> {

    @Query(value = "SELECT * FROM m_product WHERE del_flg = '0' ORDER BY product_id LIMIT 300", nativeQuery = true)
    List<ProductEntity> findAllProductForDialog();

    @Query(value = "SELECT * " +
            "FROM m_product " +
            "WHERE del_flg = '0' AND (product_code LIKE CONCAT('%', :code, '%') OR " +
            "(name1 LIKE CONCAT('%', :name, '%') OR name2 LIKE CONCAT('%', :name, '%') OR " +
            "name3 LIKE CONCAT('%', :name, '%') OR name4 LIKE CONCAT('%', :name, '%') OR name5 LIKE CONCAT('%', :name, '%'))) LIMIT 300",
            nativeQuery = true)
    List<ProductEntity> findProductForDialogByCodeOrName(@Param("code") String code, @Param("name") String name);
}
