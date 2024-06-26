package org.api.repository.inventoryPlanOutputDetail;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.dto.InventoryPlanOutputDetailDto;
import org.api.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryPlanOutputDetailRepository extends BaseRepository<InventoryPlanOutputDetailEntity, Integer> {

    @Query(value = "SELECT new org.api.dto.InventoryPlanOutputDetailDto(ipode.companyId, ipode.planDetailId, ipode.inventoryOutputId, ipode.batchStatus, ipode.batchNo, " +
            "ipode.productId, pe.datetimeMngType, ipode.datetimeMngFrom, ipode.datetimeMngTo, pe.isNumberMng, ipode.numberMngFrom, ipode.numberMngTo, " +
            "ipode.productOwnerId, ipode.repositoryId, ipode.locationId, ipode.inventoryProductType, ipode.billingPackType, " +
            "ipode.csPlanQuantity, ipode.blPlanQuantity, ipode.psPlanQuantity, pe.packCsAmount, pe.packBlAmount, " +
            "ipode.totalPlanQuantity, 0, ipode.planCsPrice, ipode.planBlPrice, ipode.planPiecePrice, ipode.amountTotal, " +
            "pe.productCode, pe.name1, pe.standardInfo, ce.customerCode, ce.customerName, ce.departmentName, ioe.saleCategory, ipode.delFlg) " +
            "FROM InventoryPlanOutputDetailEntity ipode " +
            "LEFT JOIN ProductEntity pe ON ipode.productId = pe.productId AND pe.delFlg = '0' " +
            "LEFT JOIN CustomerEntity ce ON ipode.productOwnerId = ce.customerId AND ce.delFlg = '0' " +
            "LEFT JOIN InventoryOutputEntity ioe ON ipode.inventoryOutputId = ioe.inventoryOutputId AND ioe.delFlg = '0' " +
            "WHERE ipode.delFlg = '0' AND ipode.inventoryOutputId = :inventoryOutputId " +
            "ORDER BY ipode.planDetailId ")
    Page<InventoryPlanOutputDetailDto> getAllInventoryPlanOutputDetailByInventoryOutputId(Pageable pageable,
                                                                                          @Param("inventoryOutputId") Integer inventoryOutputId);

    @Query(nativeQuery = true, value = "SELECT * FROM t_inventory_plan_output_detail WHERE inventory_output_id = :id")
    List<InventoryPlanOutputDetailEntity> getAllByOutputId(@Param("id") Integer id);
}
