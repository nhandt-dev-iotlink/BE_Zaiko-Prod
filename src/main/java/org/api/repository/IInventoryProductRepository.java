package org.api.repository;

import org.api.bean.dto.InventoryProductDto;
import org.api.bean.jpa.ProductInventoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInventoryProductRepository extends BaseRepository<ProductInventoryEntity, Integer>{
    @Query(value = "SELECT \n " +
            "    pin.inventory_id AS inventoryId,\n " +
            "    pin.product_owner_id AS customerId,\n " +
            "    cus.customer_code AS customerCode,\n " +
            "    cus.customer_name AS customerName,\n " +
            "    pin.location_id AS locationId,\n " +
            "    pin.datetime_mng AS datetimeMngTo,\n " +
            "    pin.number_mng AS numberMngTo,\n " +
            "    pin.inventory_product_type AS inventoryProductType,\n " +
            "    pro.product_code AS productCode,\n " +
            "    pin.repository_id AS repositoryId\n " +
            "FROM " +
            "    t_product_inventory pin " +
            "        JOIN\n " +
            "    m_product pro ON pin.product_id = pro.product_id\n " +
            "        JOIN\n " +
            "    m_customer cus ON pin.product_owner_id = cus.customer_id\n " +
            "WHERE\n " +
            "    pro.product_code = :productCode " +
            "        AND pin.repository_id = :repositoryId " +
            "ORDER BY pin.inventory_id;", nativeQuery = true)
    List<InventoryProductDto> getInventoryProduct(@Param("repositoryId") Integer repositoryId, @Param("productCode") String productCode);
}
