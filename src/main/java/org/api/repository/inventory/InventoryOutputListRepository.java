package org.api.repository.inventory;



import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.api.bean.request.InventorySearchCriteria;
import org.api.repository.sql.InventoryOutputQuery;
import org.api.services.impl.InventoryOutputServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static org.api.bean.request.InventorySearchCriteria.*;


@Repository
public interface InventoryOutputListRepository extends JpaRepository <InventoryOutputEntity, Integer> {



    @Query(value = "SELECT max(t.slip_no) \n" +
            "FROM t_inventory_output t \n" +
            "WHERE t.slip_no LIKE CONCAT(:datePattern, '%') \n" +
            "ORDER BY t.slip_no DESC", nativeQuery = true)
    String findLastSlipNoByDate(@Param("datePattern") String datePattern);

    @Query(value = InventoryOutputQuery.CHECK_SLIP_NO)
    boolean existsBySlipNo(@Param("slipNo") String slipNo);

    @Query(value = InventoryOutputQuery.FIND_WITH_FILTERS)
    public Page<InventoryOutputListDTO> findInventoryOutputWithFilters(Pageable pageable,
                                                                       @Param("repositoryIdFrom") Integer repositoryIdFrom,@Param("repositoryIdTo") Integer repositoryIdTo,
                                                                       @Param("orderDateFrom") String orderDateFrom, @Param("orderDateTo") String orderDateTo,
                                                                       @Param("planOutputDateFrom") String planOutputDateFrom, @Param("planOutputDateTo") String planOutputDateTo,
                                                                       @Param("planWorkingDateFrom") String planWorkingDateFrom, @Param("planWorkingDateTo") String planWorkingDateTo,
                                                                       @Param("planDeliverDateFrom") String planDeliverDateFrom, @Param("planDeliverDateTo") String planDeliverDateTo,
                                                                       @Param("slipNoFrom") String slipNoFrom, @Param("slipNoTo") String slipNoTo,
                                                                       @Param("productCodeFrom ") String productCodeFrom , @Param("productCodeTo ") String productCodeTo,@Param("batchNo") String batchNo, @Param("productName") String productName,
                                                                       @Param("destinationCodeFrom") String destinationCodeFrom, @Param("destinationCodeTo") String destinationCodeTo, @Param("departmentName") String departmentName,
                                                                       @Param("supplierCodeFrom") String supplierCodeFrom, @Param("supplierCodeTo") String supplierCodeTo, @Param("supplierName") String supplierName,
                                                                       @Param("customerCodeFrom") String customerCodeFrom, @Param("customerCodeTo") String customerCodeTo, @Param("customerName") String customerName,
                                                                       @Param("DeliveryType") String DeliveryType, @Param("DeliveryStatus") String DeliveryStatus, @Param("isClosed") String isClosed);
}