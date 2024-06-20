package org.api.repository.plan;


import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryPlanOutputDetailRepository extends JpaRepository<InventoryPlanOutputDetailEntity,Integer> {

    @Query(value = "SELECT * FROM t_inventory_plan_output_detail where del_flg='1' and plan_detail_id = :planDetailId",nativeQuery = true)
    InventoryPlanOutputDetailEntity findPlanOutputDetailEntity(@Param("planDetailId") Integer planDetailId);

    @Query(value = "SELECT * FROM t_inventory_plan_output_detail where inventory_output_id = :inventoryOutputId and del_flg= '0' ",nativeQuery = true)
    List<InventoryPlanOutputDetailEntity> finPlanOutputDetailEntities(@Param("inventoryOutputId") Integer inventoryOutputId);


}
