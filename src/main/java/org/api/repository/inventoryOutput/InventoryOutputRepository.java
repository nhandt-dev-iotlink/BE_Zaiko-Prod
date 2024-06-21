package org.api.repository.inventoryOutput;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.InventoryOutputDto;
import org.api.dto.InventoryOutputDetailDto;
import org.api.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface InventoryOutputRepository extends BaseRepository<InventoryOutputEntity, Integer> {
    @Query(value = "SELECT new org.api.dto.InventoryOutputDto( " +
            "    a.inventoryOutputId," +
            "    a.isClosed, " +
            "    a.outputStatus, " +
            "    a.slipNo, " +
            "    a.planOutputDate, " +
            "    a.batchStatus, " +
            "    a.orderDate, " +
            "    a.actualOutputDate, " +
            "    a.planWorkingDate, " +
            "    a.planDeliverDate, " +
            "    a.actualDeliverDate, " +
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
            "    a.planSupplierSlipNo, " +
            "    a.actualSupplierSlipNo, " +
            "    a.sumPlanQuantity, " +
            "    a.sumActualQuantity)  " +
            "FROM " +
            "    InventoryOutputEntity a  " +
            "        LEFT JOIN " +
            "    CustomerDeliveryDestEntity b ON a.planCustomerDeliveryDestinationId = b.deliveryDestinationId AND b.delFlg = '0' " +
            "        LEFT JOIN " +
            "    CustomerDeliveryDestEntity c ON a.actualCustomerDeliveryDestinationId = c.deliveryDestinationId AND c.delFlg = '0' " +
            "        LEFT JOIN " +
            "    CustomerEntity d ON a.planCustomerId = d.customerId AND d.delFlg = '0' " +
            "        LEFT JOIN " +
            "    CustomerEntity e ON a.actualCustomerId = e.customerId AND e.delFlg = '0' " +
            "        LEFT JOIN " +
            "    RepositoryEntity f ON a.planRepositoryId = f.repositoryId AND f.delFlg = '0' " +
            "        LEFT JOIN " +
            "    RepositoryEntity g ON a.actualRepositoryId = g.repositoryId AND g.delFlg = '0' " +
            "WHERE a.delFlg = '0' " +
            "AND (:orderDateFrom IS NULL OR a.orderDate >= :orderDateFrom) " +
            "AND (:orderDateTo IS NULL OR a.orderDate <= :orderDateTo) " +
            "AND (:planOutputDateFrom IS NULL OR a.planOutputDate >= :planOutputDateFrom) " +
            "AND (:planOutputDateTo IS NULL OR a.planOutputDate <= :planOutputDateTo) " +
            "AND (:planWorkingDateFrom IS NULL OR a.planWorkingDate >= :planWorkingDateFrom) " +
            "AND (:planWorkingDateTo IS NULL OR a.planWorkingDate <= :planWorkingDateTo) " +
            "AND (:planDeliveryDateFrom IS NULL OR a.planDeliverDate >= :planDeliveryDateFrom) " +
            "AND (:planDeliveryDateTo IS NULL OR a.planDeliverDate <= :planDeliveryDateTo) " +
            "AND (:slipNoFrom IS NULL OR a.slipNo >= :slipNoFrom) " +
            "AND (:slipNoTo IS NULL OR a.slipNo <= :slipNoTo) " +
            "AND (:customerCodeFrom IS NULL OR (a.planCustomerId >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeFrom,'%')) OR a.actualCustomerId >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeFrom,'%')))) " +
            "AND (:customerCodeTo IS NULL OR (a.planCustomerId <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeTo,'%')) OR a.actualCustomerId <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:customerCodeTo,'%')))) " +
            "AND (:customerName IS NULL " +
            "OR (a.planCustomerId IN " +
            "(SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', :customerName, '%')) " +
            "OR a.actualCustomerId IN " +
            "(SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', :customerName, '%')))) " +
            "AND (:deliveryCodeFrom IS NULL OR (a.planCustomerDeliveryDestinationId >= (select min(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeFrom,'%')) " +
            "OR a.actualCustomerDeliveryDestinationId >= (select min(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeFrom,'%'))))" +
            "AND (:deliveryCodeTo IS NULL OR (a.planCustomerDeliveryDestinationId <= (select max(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeTo,'%')) " +
            "OR a.actualCustomerDeliveryDestinationId <= (select max(a.deliveryDestinationId) from CustomerDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeTo,'%'))))" +
            "AND (:deliveryName IS NULL OR (a.planCustomerDeliveryDestinationId IN " +
            "(SELECT a3.deliveryDestinationId FROM CustomerDeliveryDestEntity a3 WHERE a3.departmentName LIKE CONCAT('%', :deliveryName, '%')) " +
            "OR a.actualCustomerDeliveryDestinationId IN " +
            "(SELECT a4.deliveryDestinationId FROM CustomerDeliveryDestEntity a4 WHERE a4.departmentName LIKE CONCAT('%', :deliveryName, '%')))) " +


            "AND (:supplierCodeFrom IS NULL OR " +
            "(a.inventoryOutputId IN " +
            "(SELECT a5.inventoryOutputId FROM InventoryOutputEntity a5 " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventoryOutputId = a6.inventoryOutputId " +
            "WHERE a6.supplierId >= (select min(a.supplierId) from SupplierEntity a where a.supplierCode like concat('%', :supplierCodeFrom,'%')) " +
            "GROUP BY a5.inventoryOutputId) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a7.inventoryOutputId FROM InventoryOutputEntity a7 " +
            "RIGHT JOIN InventoryActualOutputDetailEntity a8 ON a7.inventoryOutputId = a8.inventoryOutputId " +
            "WHERE a8.inventoryOutputId >= (select min(a.supplierId) from SupplierEntity a where a.supplierCode like concat('%', :supplierCodeFrom,'%')) " +
            "GROUP BY a7.inventoryOutputId))) " +


            "AND (:supplierCodeTo IS NULL OR (a.inventoryOutputId IN " +
            "(SELECT a5.inventoryOutputId FROM InventoryOutputEntity a5 " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventoryOutputId = a6.inventoryOutputId " +
            "WHERE a6.supplierId <= (select max(a.supplierId) from SupplierEntity a where a.supplierCode like concat('%', :supplierCodeTo,'%')) " +
            "GROUP BY a5.inventoryOutputId) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a7.inventoryOutputId FROM InventoryOutputEntity a7 " +
            "RIGHT JOIN InventoryActualOutputDetailEntity a8 ON a7.inventoryOutputId = a8.inventoryOutputId " +
            "WHERE a8.supplierId <= (select max(a.supplierId) from SupplierEntity a where a.supplierCode like concat('%', :supplierCodeTo,'%')) " +
            "GROUP BY a7.inventoryOutputId))) " +


            "AND (:supplierName IS NULL OR " +
            "(a.inventoryOutputId IN " +
            "(SELECT a5.inventoryOutputId FROM InventoryOutputEntity a5 " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventoryOutputId = a6.inventoryOutputId " +
            "INNER JOIN SupplierEntity b ON a6.supplierId = b.supplierId " +
            "WHERE b.supplierName LIKE CONCAT('%', :supplierName, '%') " +
            "GROUP BY a5.inventoryOutputId) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a7.inventoryOutputId FROM InventoryOutputEntity a7 " +
            "RIGHT JOIN InventoryActualOutputDetailEntity a8 ON a7.inventoryOutputId = a8.inventoryOutputId " +
            "INNER JOIN SupplierEntity b ON a8.supplierId = b.supplierId " +
            "WHERE b.supplierName LIKE CONCAT('%', :supplierName, '%') " +
            "GROUP BY a7.inventoryOutputId))) " +
            "AND (:ownerCodeFrom IS NULL OR (a.planCustomerId >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeFrom,'%')) OR a.actualCustomerId >= (select min(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeFrom,'%')) )) " +
            "AND (:ownerCodeTo IS NULL OR (a.planCustomerId <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeTo,'%'))  OR a.actualCustomerId <= (select max(a.customerId) from CustomerEntity a where  a.customerCode like concat('%',:ownerCodeTo,'%')))) " +
            "AND (:ownerName IS NULL OR (a.planCustomerId IN " +
            "(SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', :ownerName, '%')) " +
            "OR a.actualCustomerId IN " +
            "(SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', :ownerName, '%')))) " +
            "AND (:productCodeFrom IS NULL OR (a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "WHERE b.productId >= (select min(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeFrom,'%')) " +
            "GROUP BY a.inventoryOutputId) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "WHERE b.productId >= (select min(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeFrom,'%')) " +
            "GROUP BY a.inventoryOutputId))) " +
            "AND (:productCodeTo IS NULL OR (a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "WHERE b.productId <= (select max(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeTo,'%')) " +
            "GROUP BY a.inventoryOutputId) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "WHERE b.productId <= (select max(a.productId) from ProductEntity a where a.productCode like concat('%',:productCodeTo,'%')) " +
            "GROUP BY a.inventoryOutputId))) " +
            "AND (:productName IS NULL OR (a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "INNER JOIN ProductEntity c ON b.productId = c.productId " +
            "WHERE c.name1 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name2 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name3 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name4 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name5 LIKE CONCAT('%', :productName, '%') ) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "INNER JOIN ProductEntity c ON b.productId = c.productId " +
            "WHERE c.name1 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name2 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name3 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name4 LIKE CONCAT('%', :productName, '%') " +
            "OR c.name5 LIKE CONCAT('%', :productName, '%')))) " +
            "AND (:repoFrom IS NULL OR (a.planRepositoryId >= :repoFrom OR a.actualRepositoryId >= :repoFrom)) " +
            "AND (:repoTo IS NULL OR (a.planRepositoryId <= :repoTo OR a.actualRepositoryId <= :repoTo)) " +
            "AND (:batchNo IS NULL OR (a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "WHERE b.batchNo LIKE CONCAT('%', :batchNo, '%') GROUP BY a.inventoryOutputId) " +
            "OR a.inventoryOutputId IN " +
            "(SELECT a.inventoryOutputId FROM InventoryOutputEntity a " +
            "RIGHT JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventoryOutputId " +
            "WHERE b.batchNo LIKE CONCAT('%', :batchNo, '%') GROUP BY a.inventoryOutputId))) " +
            "AND ((:deliveryType = 1 AND a.planOutputDate IS NOT NULL) OR (:deliveryType = 2 AND a.planOutputDate IS NULL) OR :deliveryType = 0) " +
            "AND (:deliveryStatus = '' OR a.outputStatus = :deliveryStatus) " +
            "AND (:isClose = '' OR a.isClosed = :isClose) " +
            "ORDER BY a.slipNo ASC ")
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
                                        @Param("isClose") String isClose
    );


    @Query(value = "SELECT new org.api.dto.InventoryOutputPlanDto(" +
                "io.inventoryOutputId, io.isClosed, io.outputStatus, " +
                "io.orderDate, io.planOutputDate, io.planWorkingDate, io.planDeliverDate, io.createSlipType, io.slipNo, " +
                "io.planSupplierSlipNo, io.planCustomerDeliveryDestinationId, io.planCustomerId, io.planRepositoryId, io.checked, " +
                "cdd.destinationCode, cdd.departmentName, cdd.phoneNumber, cdd.faxNumber, cdd.postCode, cdd.address1, " +
                "cdd.address2, cdd.address3, cdd.address4, c.customerCode, c.customerName, r.routeCode, r.routeName," +
                "co.courseCode, co.courseName, rp.repositoryCode, rp.repositoryName, io.slipNote) " +
            "FROM InventoryOutputEntity io " +
            "LEFT JOIN CustomerDeliveryDestEntity cdd ON io.planCustomerDeliveryDestinationId = cdd.deliveryDestinationId AND cdd.delFlg = '0' " +
            "LEFT JOIN CustomerEntity c ON io.planCustomerId = c.customerId AND c.delFlg = '0' " +
            "LEFT JOIN RouteEntity r ON (io.routeCode = r.routeCode OR c.routeCode = r.routeCode) AND r.delFlg = '0' " +
            "LEFT JOIN CourseEntity co ON r.routeCode = co.routeCode AND (io.courseCode = co.courseCode OR c.courseCode = co.courseCode) AND co.delFlg = '0' " +
            "LEFT JOIN RepositoryEntity rp ON io.planRepositoryId = rp.repositoryId AND rp.delFlg = '0'" +
            "WHERE io.delFlg = '0' AND io.inventoryOutputId = :id AND io.planOutputDate IS NOT NULL ")
    Optional<InventoryOutputDetailDto> getInfoOutputPlanById(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM t_inventory_output ioe WHERE ioe.del_flg = '0' AND ioe.slip_no = :slipNo")
    Optional<InventoryOutputEntity> findBySlipNo(@Param("slipNo") String slipNo);

    @Query(nativeQuery = true, value = "select * from t_inventory_output where slip_no like CONCAT(:slipNo, '%') AND del_flg = '0' order by slip_no desc limit 1")
    InventoryOutputEntity getSlipNo(@Param("slipNo") String slipNo);
    @Query(nativeQuery = true, value = "SELECT * FROM t_inventory_output WHERE inventory_output_id = :id AND del_flg = '0' LIMIT 1")
    InventoryOutputEntity getOneById(@Param("id") Integer id);
}
