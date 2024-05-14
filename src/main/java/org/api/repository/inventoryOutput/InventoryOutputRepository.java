package org.api.repository.inventoryOutput;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.InventoryOutputDto;
import org.api.repository.BaseRepository;
import org.api.repository.sql.InventoryOutputQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface InventoryOutputRepository extends BaseRepository<InventoryOutputEntity, Integer> {

    @Query(value = "SELECT new org.api.dto.InventoryOutputDto( " +
            "    a.inventory_output_id," +
            "    a.is_closed, " +
            "    a.output_status, " +
            "    a.slip_no, " +
            "    a.plan_output_date, " +
            "    a.batch_status, " +
            "    a.order_date, " +
            "    a.actual_output_date, " +
            "    a.plan_working_date, " +
            "    a.plan_deliver_date, " +
            "    a.actual_deliver_date, " +
            "    b.destinationCode, " +
            "    b.departmentName, " +
            "    c.destinationCode, " +
            "    c.departmentName, " +
            "    d.customerCode, " +
            "    d.customerName, " +
            "    e.customerCode, " +
            "    e.customerName, " +
            "    f.repositoryCode, " +
            "    f.repositoryName, " +
            "    g.repositoryCode , " +
            "    g.repositoryName, " +
            "    a.plan_supplier_slip_no, " +
            "    a.actual_supplier_slip_no, " +
            "    a.sum_plan_quantity, " +
            "    a.sum_actual_quantity)  " +
            "FROM " +
            "    InventoryOutputEntity a  " +
            "        LEFT JOIN " +
            "    CustomerDeliveryDestEntity b ON a.plan_customer_delivery_destination_id = b.deliveryDestinationId AND b.delFlg = '0' " +
            "        LEFT JOIN " +
            "    CustomerDeliveryDestEntity c ON a.actual_customer_delivery_destination_id = c.deliveryDestinationId AND c.delFlg = '0' " +
            "        LEFT JOIN " +
            "    CustomerEntity d ON a.plan_customer_id = d.customerId AND d.delFlg = '0' " +
            "        LEFT JOIN " +
            "    CustomerEntity e ON a.actual_customer_id = e.customerId AND e.delFlg = '0' " +
            "        LEFT JOIN " +
            "    RepositoryEntity f ON a.plan_repository_id = f.repositoryId AND f.delFlg = '0' " +
            "        LEFT JOIN " +
            "    RepositoryEntity g ON a.actual_repository_id = g.repositoryId AND g.delFlg = '0' " +
            "WHERE a.delFlg = '0' " +
            "AND (:orderDateFrom IS NULL OR a.order_date >= :orderDateFrom) " +
            "AND (:orderDateTo IS NULL OR a.order_date <= :orderDateTo) " +
            "AND (:planOutputDateFrom IS NULL OR a.plan_output_date >= :planOutputDateFrom) " +
            "AND (:planOutputDateTo IS NULL OR a.plan_output_date <= :planOutputDateTo) " +
            "AND (:planWorkingDateFrom IS NULL OR a.plan_working_date >= :planWorkingDateFrom) " +
            "AND (:planWorkingDateTo IS NULL OR a.plan_working_date <= :planWorkingDateTo) " +
            "AND (:planDeliveryDateFrom IS NULL OR a.plan_deliver_date >= :planDeliveryDateFrom) " +
            "AND (:planDeliveryDateTo IS NULL OR a.plan_deliver_date <= :planDeliveryDateTo) " +
            "AND (:slipNoFrom IS NULL OR a.slip_no >= :slipNoFrom) " +
            "AND (:slipNoTo IS NULL OR a.slip_no <= :slipNoTo) " +
            "AND (:customerCodeFrom IS NULL OR (a.plan_customer_id >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeFrom,'%')) OR a.actual_customer_id >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeFrom,'%')))) " +
            "AND (:customerCodeTo IS NULL OR (a.plan_customer_id <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeTo,'%')) OR a.actual_customer_id <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeTo,'%')))) " +
            "AND (:customerName IS NULL OR (a.plan_customer_id IN " +
            "(SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', :customerName, '%')) " +
            "OR a.actual_customer_id IN " +
            "(SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', :customerName, '%')))) " +
            "AND (:deliveryCodeFrom IS NULL OR (a.plan_customer_delivery_destination_id >= (select min(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeFrom,'%')) " +
            "OR a.actual_customer_delivery_destination_id >= (select min(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeFrom,'%'))))" +
            "AND (:deliveryCodeTo IS NULL OR (a.plan_customer_delivery_destination_id <= (select max(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeTo,'%')) " +
            "OR a.actual_customer_delivery_destination_id <= (select max(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeTo,'%'))))" +
            "AND (:deliveryName IS NULL OR (a.plan_customer_delivery_destination_id IN " +
            "(SELECT a3.deliveryDestinationId FROM CustomerDeliveryDestEntity a3 WHERE a3.departmentName LIKE CONCAT('%', :deliveryName, '%')) " +
            "OR a.actual_customer_delivery_destination_id IN " +
            "(SELECT a4.deliveryDestinationId FROM CustomerDeliveryDestEntity a4 WHERE a4.departmentName LIKE CONCAT('%', :deliveryName, '%')))) " +
            "AND (:supplierCodeFrom IS NULL OR " +
            "(a.inventory_output_id IN " +
            "(SELECT a5.inventory_output_id FROM InventoryOutputEntity a5 " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventory_output_id = a6.inventory_output_id " +
            "WHERE a6.supplier_id >= (select min(a.supplierId) from SupplierEntity a where  a.supplierCode like concat('%', :supplierCodeFrom,'%')) " +
            "GROUP BY a5.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a7.inventory_output_id FROM InventoryOutputEntity a7 " +
            "RIGHT JOIN InventoryActualOutputDetailEntity a8 ON a7.inventory_output_id = a8.inventory_output_id " +
            "WHERE a8.supplier_id >= (select min(a.supplierId) from SupplierEntity a where  a.supplierCode like concat('%', :supplierCodeFrom,'%')) " +
            "GROUP BY a7.inventory_output_id))) " +
            "AND (:supplierCodeTo IS NULL OR (a.inventory_output_id IN " +
            "(SELECT a5.inventory_output_id FROM InventoryOutputEntity a5 " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventory_output_id = a6.inventory_output_id " +
            "WHERE a6.supplier_id <= (select max(a.supplierId) from SupplierEntity a where a.supplierCode like concat('%', :supplierCodeTo,'%')) " +
            "GROUP BY a5.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a7.inventory_output_id FROM InventoryOutputEntity a7 " +
            "RIGHT JOIN InventoryActualOutputDetailEntity a8 ON a7.inventory_output_id = a8.inventory_output_id " +
            "WHERE a8.supplier_id <= (select max(a.supplierId) from SupplierEntity a where a.supplierCode like concat('%', :supplierCodeTo,'%')) " +
            "GROUP BY a7.inventory_output_id))) " +
            "AND (:supplierName IS NULL OR " +
            "(a.inventory_output_id IN " +
            "(SELECT a5.inventory_output_id FROM InventoryOutputEntity a5 " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventory_output_id = a6.inventory_output_id " +
            "INNER JOIN SupplierEntity b ON a6.supplier_id = b.supplierId " +
            "WHERE b.supplierName LIKE CONCAT('%', :supplierName, '%') " +
            "GROUP BY a5.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a7.inventory_output_id FROM InventoryOutputEntity a7 " +
            "RIGHT JOIN InventoryActualOutputDetailEntity a8 ON a7.inventory_output_id = a8.inventory_output_id " +
            "INNER JOIN SupplierEntity b ON a8.supplier_id = b.supplierId " +
            "WHERE b.supplierName LIKE CONCAT('%', :supplierName, '%') " +
            "GROUP BY a7.inventory_output_id))) "  +
            "AND (:ownerCodeFrom IS NULL OR (a.plan_customer_id >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeFrom,'%')) OR a.actual_customer_id >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeFrom,'%')) )) " +
            "AND (:ownerCodeTo IS NULL OR (a.plan_customer_id <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeTo,'%'))  OR a.actual_customer_id <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeTo,'%')))) " +
            "AND (:ownerName IS NULL OR (a.plan_customer_id IN " +
            "(SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', :ownerName, '%')) " +
            "OR a.actual_customer_id IN " +
            "(SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', :ownerName, '%')))) " +
            "AND (:productCodeFrom IS NULL OR (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id >= (select min(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeFrom,'%')) " +
            "GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id >= (select min(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeFrom,'%')) " +
            "GROUP BY a.inventory_output_id))) " +
            "AND (:productCodeTo IS NULL OR (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id <= (select max(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeTo,'%')) " +
            "GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id <= (select max(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeTo,'%')) " +
            "GROUP BY a.inventory_output_id))) " +
            "AND (:productName IS NULL OR (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "INNER JOIN ProductEntity c ON b.product_id = c.productId " +
            "WHERE c.name1 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name2 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name3 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name4 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name5 LIKE CONCAT('%', :productName, '%') ) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "INNER JOIN ProductEntity c ON b.product_id = c.productId " +
            "WHERE c.name1 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name2 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name3 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name4 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name5 LIKE CONCAT('%', :productName, '%')))) " +
            "AND (:repoFrom IS NULL OR (a.plan_repository_id >= :repoFrom OR a.actual_repository_id >= :repoFrom)) " +
            "AND (:repoTo IS NULL OR (a.plan_repository_id <= :repoTo OR a.actual_repository_id <= :repoTo)) " +
            "AND (:batchNo IS NULL OR (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.batch_no LIKE CONCAT('%', :batchNo, '%') GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.batch_no LIKE CONCAT('%', :batchNo, '%') GROUP BY a.inventory_output_id))) " +
            "AND ((:deliveryType = 1 AND a.plan_output_date IS NOT NULL) OR (:deliveryType = 2 AND a.plan_output_date IS NULL) OR :deliveryType = 0) " +
            "AND (:deliveryStatus = '' OR a.output_status = :deliveryStatus) " +
            "AND (:isClose = '' OR a.is_closed = :isClose) " +
            InventoryOutputQuery.ORDER_BY)
    Page<InventoryOutputDto> getAllPage(Pageable pageable,
                                        @Param("orderDateFrom") String orderDateFrom,
                                        @Param("orderDateTo") String orderDateTo,
                                        @Param("planOutputDateFrom") String planOutputDateFrom,
                                        @Param("planOutputDateTo") String planOutputDateTo,
                                        @Param("planWorkingDateFrom") String planWorkingDateFrom,
                                        @Param("planWorkingDateTo") String planWorkingDateTo,
                                        @Param("planDeliveryDateFrom") String planDeliveryDateFrom,
                                        @Param("planDeliveryDateTo") String planDeliveryDateTo,
                                        @Param("slipNoFrom") String slipNoFrom,
                                        @Param("slipNoTo") String slipNoTo,
                                        @Param("customerCodeFrom") String customerCodeFrom,
                                        @Param("customerCodeTo") String customerCodeTo,
                                        @Param("customerName") String customerName,
                                        @Param("deliveryCodeFrom") String deliveryCodeFrom,
                                        @Param("deliveryCodeTo") String deliveryCodeTo,
                                        @Param("deliveryName") String deliveryName,
                                        @Param("supplierCodeFrom") String supplierCodeFrom,
                                        @Param("supplierCodeTo") String supplierCodeTo,
                                        @Param("supplierName") String supplierName,
                                        @Param("ownerCodeFrom") String ownerCodeFrom,
                                        @Param("ownerCodeTo") String ownerCodeTo,
                                        @Param("ownerName") String ownerName,
                                        @Param("productCodeFrom") String productCodeFrom,
                                        @Param("productCodeTo") String productCodeTo,
                                        @Param("productName") String productName,
                                        @Param("repoFrom") Integer repoFrom,
                                        @Param("repoTo") Integer repoTo,
                                        @Param("batchNo") String batchNo,
                                        @Param("deliveryType") Integer deliveryType,
                                        @Param("deliveryStatus") String deliveryStatus,
                                        @Param("isClose") String isClose);
}
