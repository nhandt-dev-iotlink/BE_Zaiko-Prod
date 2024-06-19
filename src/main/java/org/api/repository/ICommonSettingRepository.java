package org.api.repository;

import org.api.bean.dto.CommonSettingDto;
import org.api.bean.dto.LocationDto;
import org.api.bean.jpa.CommonSettingEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ICommonSettingRepository extends BaseRepository<CommonSettingEntity, Integer> {
    @Query(value = "SELECT DISTINCT\n" +
            "    value1, value2\n" +
            "FROM\n" +
            "    m_common_setting\n" +
            "WHERE\n" +
            "    code = 'INVENTORY_PRODUCT_TYPE'\n" +
            "        AND description = '在庫状態'\n" +
            "        AND del_flg = 0\n" +
            "ORDER BY value1 ASC;", nativeQuery = true)
    List<CommonSettingDto> getAll();
}
