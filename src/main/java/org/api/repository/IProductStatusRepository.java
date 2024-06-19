package org.api.repository;

import org.api.bean.dto.InputProductStatusDto;
import org.api.bean.dto.RepositoryDto;
import org.api.bean.jpa.ProductInventoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductStatusRepository extends BaseRepository<ProductInventoryEntity, Integer>{
    @Query(value = "select distinct value1, value2 from m_common_setting where code='INVENTORY_PRODUCT_TYPE' " +
            "and description='在庫状態'" +
            "and del_flg = 0" , nativeQuery = true)
    List<InputProductStatusDto> getAll();
}
