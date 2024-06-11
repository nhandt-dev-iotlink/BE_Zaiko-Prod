package org.api.repository.commonSetting;

import org.api.bean.jpa.CommonSettingEntity;
import org.api.dto.InventoryProductTypeDto;
import org.api.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonSettingRepository extends BaseRepository<CommonSettingEntity, Integer> {
    @Query(value = "SELECT new org.api.dto.InventoryProductTypeDto(code, value1, value2 ) FROM CommonSettingEntity WHERE delFlg = '0' AND code = 'INVENTORY_PRODUCT_TYPE' GROUP BY value1, value2")
    List<InventoryProductTypeDto> getAllInventoryProductType();
}
