package org.api.repository.productInventory;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.ProductInventoryEntity;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInventoryRepository extends BaseRepository<ProductInventoryEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM zaiko_v3.t_product_inventory where product_code = :productCode " +
            "And repository_id = :repositoryId AND del_flg = '0' AND CONCAT(product_owner_id, customer_code, supplier_code, location_code) like CONCAT('%', :keyWord, '%')")
    List<ProductInventoryEntity> getAllByProductAndRepository(@Param("keyWord") String keyWord,
                                                              @Param("productCode") String productCode,
                                                              @Param("repositoryId") Integer repositoryId);
}
