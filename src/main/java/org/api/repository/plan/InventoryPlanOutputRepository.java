package org.api.repository.plan;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.reponse.dto.InventoryOutputPlanDTO;
import org.api.bean.reponse.dto.PlanOutputDTO;
import org.api.repository.sql.GetPlanOutputIDQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface InventoryPlanOutputRepository extends JpaRepository<InventoryOutputEntity,Integer> {
    @Query(value = GetPlanOutputIDQuery.GET_PLAN_OUTPUT_ID_QUERY)
    Optional<InventoryOutputPlanDTO> findPlanOutputWithKey(@Param("inventoryOutputId") Integer inventoryOutputId);

    @Query(value = "SELECT * FROM t_inventory_output where del_flg='0' and inventory_output_id = :inventoryOutputId",nativeQuery = true)
    public InventoryOutputEntity findInventoryOutputEntity(@Param("inventoryOutputId") Integer inventoryOutputId);

}
