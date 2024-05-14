package org.api.repository.inventory_output;

import org.api.bean.jpa.InventoryOutputEntity;
import org.api.dto.inventory_output.reponse.search.InventoryOutputListDTO;
import org.api.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryOutputRepository extends BaseRepository<InventoryOutputEntity, Integer> {

    @Query(value = "SELECT new org.api.dto.inventory_output.reponse.search.InventoryOutputListDTO( a.inventoryOutputId, " +
            "a.isClosed, a.outputStatus, a.slipNo, a.planOutputDate, a.batchStatus, a.orderDate, a.planOutputDate, " +
            "a.actualOutputDate, a.planWorkingDate, a.actualOutputDate, a.planDeliverDate, a.actualDeliverDate, " +
            "b.destinationCode, b.departmentName, c.destinationCode, c.departmentName, d.customerCode, d.customerName, " +
            "e.customerCode, e.customerName, f.repository_code, f.repository_name, g.repository_code, g.repository_name, " +
            "a.planSupplierSlipNo, a.actualSupplierSlipNo, a.sumPlanQuantity, a.sumActualQuantity) " +
            "FROM InventoryOutputEntity a " +
            "INNER JOIN CustomerDeliveryDestEntity b ON a.planCustomerDeliveryDestinationId = b.deliveryDestinationId " +
            "INNER JOIN  SupplierDeliveryDestEntity c ON a.actualCustomerDeliveryDestinationId = c.deliveryDestination_id " +
            "INNER JOIN CustomerEntity d ON a.planCustomerId = d.customerId " +
            "INNER JOIN CustomerEntity e ON a.actualCustomerId = e.customerId " +
            "INNER JOIN RepositoryEntity f ON a.planRepositoryId = f.repository_id " +
            "INNER JOIN RepositoryEntity g ON a.actualRepositoryId = g.repository_id ")
    Page<InventoryOutputListDTO> findAllInventoryOutputInfor(Pageable pageable);

//    ====================================================================================
@Query("SELECT new org.api.dto.inventory_output.reponse.search.InventoryOutputListDTO(a.inventoryOutputId, " +
        "a.isClosed, a.outputStatus, a.slipNo, a.planOutputDate, a.batchStatus, a.orderDate, a.planOutputDate, " +
        "a.actualOutputDate, a.planWorkingDate, a.actualOutputDate, a.planDeliverDate, a.actualDeliverDate, " +
        "b.destinationCode, b.departmentName, c.destinationCode, c.departmentName, d.customerCode, d.customerName, " +
        "e.customerCode, e.customerName, f.repository_code, f.repository_name, g.repository_code, g.repository_name, " +
        "a.planSupplierSlipNo, a.actualSupplierSlipNo, a.sumPlanQuantity, a.sumActualQuantity) " +
        "FROM InventoryOutputEntity a " +
        "LEFT JOIN CustomerDeliveryDestEntity b ON a.planCustomerDeliveryDestinationId = b.deliveryDestinationId " +
        "LEFT JOIN  SupplierDeliveryDestEntity c ON a.actualCustomerDeliveryDestinationId = c.deliveryDestination_id " +
        "LEFT JOIN CustomerEntity d ON a.planCustomerId = d.customerId " +
        "LEFT JOIN CustomerEntity e ON a.actualCustomerId = e.customerId " +
        "LEFT JOIN RepositoryEntity f ON a.planRepositoryId = f.repository_id " +
        "LEFT JOIN RepositoryEntity g ON a.actualRepositoryId = g.repository_id"
        + " Where a.delFlg = '0' "+
        "AND (:fromOrderDate IS NULL OR a.orderDate >= :fromOrderDate) " +
                "AND (:toOrderDate IS NULL OR a.orderDate <= :toOrderDate) "+
        "AND (:fromPlanOutputDate IS NULL OR a.planOutputDate >= :fromPlanOutputDate) " +
                "AND (:toPlanOutputDate IS NULL OR a.planOutputDate <= :toPlanOutputDate ) "+
        "AND (:fromPlanWorkingDate IS NULL OR a.planWorkingDate >= :fromPlanWorkingDate) " +
                "AND (:toPlanWorkingDate IS NULL OR a.planWorkingDate <= :toPlanWorkingDate)"+
        "AND (:fromPlanDeliverDate IS NULL OR a.planDeliverDate >= :fromPlanDeliverDate) " +
                "AND (:toPlanDeliverDate IS NULL OR a.planDeliverDate <= :toPlanDeliverDate)"+
        "AND (:fromSlipNo IS NULL OR a.slipNo >= :fromSlipNo) " +
        "AND (:toSlipNo IS NULL OR a.slipNo <= :toSlipNo) "+
        "AND (:fromCustomerCode IS NULL OR (a.planCustomerId >= " +
                                                        "(SELECT sd1.customerId FROM CustomerEntity sd1 " +
                                                            "WHERE sd1.customerCode = :fromCustomerCode) " +
                            "OR a.actualCustomerId >= " +
                                                        "(SELECT sd2.customerId FROM CustomerEntity sd2 " +
                                                            "WHERE sd2.customerCode = :fromCustomerCode))) " +
        "AND (:toCustomerCode IS NULL OR (a.planCustomerId <= " +
                                                        "(SELECT sd1.customerId FROM CustomerEntity sd1 " +
                                                            "WHERE sd1.customerCode = :toCustomerCode) " +
                            "OR a.actualCustomerId <= " +
                                                        "(SELECT sd2.customerId FROM CustomerEntity sd2 " +
                                                            "WHERE sd2.customerCode = :toCustomerCode)))"+
        "AND (:customerName IS NULL OR (a.planCustomerId IN " +
                                                        "(SELECT sd1.customerId FROM CustomerEntity sd1 " +
                                                        "WHERE sd1.customerName LIKE CONCAT('%', :customerName, '%')) "+
                                            "OR a.actualCustomerId IN " +
                                                        "(SELECT sd3.customerId FROM CustomerEntity sd3 " +
                                                        "WHERE sd3.customerName LIKE CONCAT('%', :customerName, '%'))))"+
        "AND (:fromDeliverDestCode IS NULL OR (a.planCustomerDeliveryDestinationId >= " +
                                                                    "(SELECT cd1.deliveryDestinationId " +
                                                                        "FROM CustomerDeliveryDestEntity cd1 " +
                                                                        "WHERE cd1.destinationCode = :fromDeliverDestCode) " +
                                            "OR a.actualCustomerDeliveryDestinationId >= " +
                                                                    "(SELECT cd2.deliveryDestinationId " +
                                                                        "FROM CustomerDeliveryDestEntity cd2 " +
                                                                        "WHERE cd2.destinationCode = :fromDeliverDestCode ))) " +
        "AND (:toDeliverDestCode IS NUll OR (a.planCustomerDeliveryDestinationId <= " +
                                                                    "(SELECT cd1.deliveryDestinationId " +
                                                                        "FROM CustomerDeliveryDestEntity cd1 " +
                                                                        "WHERE cd1.destinationCode = :toDeliverDestCode) " +
                                            "OR a.actualCustomerDeliveryDestinationId <= " +
                                                                    "(SELECT cd2.deliveryDestinationId " +
                                                                        "FROM CustomerDeliveryDestEntity cd2 " +
                                                                        "WHERE cd2.destinationCode = :toDeliverDestCode))) "+
        "AND (:deliveryDestName IS NULL OR (a.planCustomerDeliveryDestinationId IN " +
                                                                        "(SELECT cd1.deliveryDestinationId " +
                                                                        "FROM CustomerDeliveryDestEntity cd1 " +
                                                                        "WHERE cd1.departmentName " +
                                                                        "LIKE CONCAT('%', :deliveryDestName, '%')) " +
                                            "OR a.actualCustomerDeliveryDestinationId IN " +
                                                                        "(SELECT cd3.deliveryDestinationId " +
                                                                        "FROM CustomerDeliveryDestEntity cd3 " +
                                                                        "WHERE cd3.departmentName " +
                                                                        "LIKE CONCAT('%', :deliveryDestName, '%')))) "+
        "AND (:fromSupplierCode IS NULL OR (a.inventoryOutputId >= " +
                                                                "(SELECT MIN(actual_output_detail.inventoryOutputId) " +
                                                                "FROM SupplierEntity supplier " +
                                                                "JOIN InventoryActualOutputDetailEntity actual_output_detail " +
                                                                        "ON supplier.supplierId = actual_output_detail.supplierId " +
                                                                "WHERE supplier.supplierId IN " +
                                                                            "(SELECT s.supplierId FROM SupplierEntity s " +
                                                                                "WHERE s.supplierCode = :fromSupplierCode) ) " +
                                            "OR a.inventoryOutputId >= " +
                                                                "(SELECT MIN(plan_output_detail.inventoryOutputId) " +
                                                                "FROM SupplierEntity supplier " +
                                                                "JOIN InventoryPlanOutputDetailEntity plan_output_detail " +
                                                                        "ON supplier.supplierId = plan_output_detail.supplierId " +
                                                                "WHERE supplier.supplierId IN " +
                                                                            "(SELECT s.supplierId FROM SupplierEntity s " +
                                                                                "WHERE s.supplierCode = :fromSupplierCode) ))) "+
        "AND (:toSupplierCode IS NULL OR (a.inventoryOutputId <= " +
                                                                "(SELECT MAX(actual_output_detail1.inventoryOutputId) " +
                                                                "FROM SupplierEntity supplier " +
                                                                "JOIN InventoryActualOutputDetailEntity actual_output_detail1 " +
                                                                        "ON supplier.supplierId = actual_output_detail1.supplierId " +
                                                                "WHERE supplier.supplierId IN " +
                                                                            "(SELECT s.supplierId FROM SupplierEntity s " +
                                                                                "WHERE s.supplierCode = :toSupplierCode) ) " +
                                            "OR a.inventoryOutputId <= " +
                                                                "(SELECT MAX(plan_output_detail1.inventoryOutputId) " +
                                                                "FROM SupplierEntity supplier " +
                                                                "JOIN InventoryPlanOutputDetailEntity plan_output_detail1 " +
                                                                        "ON supplier.supplierId = plan_output_detail1.supplierId " +
                                                                "WHERE supplier.supplierId IN " +
                                                                            "(SELECT s.supplierId FROM SupplierEntity s " +
                                                                                "WHERE s.supplierCode = :toSupplierCode) " +
        "))) "+
        "AND (:supplierName IS NULL OR (a.inventoryOutputId IN " +
                                                                "(SELECT actual_output_detail2.inventoryOutputId " +
                                                                "FROM SupplierEntity supllier_a " +
                                                                "JOIN InventoryActualOutputDetailEntity actual_output_detail2 " +
                                                                        "ON supllier_a.supplierId = actual_output_detail2.supplierId " +
                                                                "WHERE supllier_a.supplierId IN " +
                                                                            "(SELECT sb1.supplierId FROM SupplierEntity sb1 " +
                                                                                "WHERE sb1.supplierName " +
                                                                                "LIKE CONCAT('%', :supplierName, '%')) " +
                                                                "GROUP BY actual_output_detail2.inventoryOutputId) " +
                                        "OR a.inventoryOutputId IN " +
                                                                "(SELECT plan_output_detail2.inventoryOutputId " +
                                                                "FROM SupplierEntity supllier_b " +
                                                                "JOIN InventoryPlanOutputDetailEntity plan_output_detail2 " +
                                                                        "ON supllier_b.supplierId = plan_output_detail2.supplierId " +
                                                                "WHERE supllier_b.supplierId IN " +
                                                                            "(SELECT sb3.supplierId FROM SupplierEntity sb3 " +
                                                                                "WHERE sb3.supplierName " +
                                                                                "LIKE CONCAT('%', :supplierName, '%')) " +
                                                                "GROUP BY plan_output_detail2.inventoryOutputId))) "+
        "AND (:fromProductCode IS NULL OR (a.inventoryOutputId >= " +
                                                                "(SELECT MIN(actual_output_detail.inventoryOutputId) " +
                                                                "FROM ProductEntity product " +
                                                                "JOIN InventoryActualOutputDetailEntity actual_output_detail " +
                                                                        "ON product.productId = actual_output_detail.productId " +
                                                                "WHERE product.productId IN " +
                                                                            "(SELECT p.productId FROM ProductEntity p " +
                                                                                "WHERE p.productCode = :fromProductCode)) " +
                                        "OR a.inventoryOutputId >= " +
                                                                "(SELECT MIN(plan_output_detail.inventoryOutputId) " +
                                                                "FROM ProductEntity product " +
                                                                "JOIN InventoryPlanOutputDetailEntity plan_output_detail " +
                                                                        "ON product.productId = plan_output_detail.productId " +
                                                                "WHERE product.productId IN " +
                                                                            "(SELECT p.productId FROM ProductEntity p " +
                                                                                "WHERE p.productCode = :fromProductCode) ))) " +
        "AND (:toProductCode IS NULL OR (a.inventoryOutputId <= "+
                                                                "(SELECT MAX(actual_output_detail.inventoryOutputId) " +
                                                                "FROM ProductEntity product " +
                                                                "JOIN InventoryActualOutputDetailEntity actual_output_detail " +
                                                                        "ON product.productId = actual_output_detail.productId " +
                                                                "WHERE product.productId IN " +
                                                                            "(SELECT p.productId FROM ProductEntity p " +
                                                                                "WHERE p.productCode = :toProductCode)) " +
                                        "OR a.inventoryOutputId <= " +
                                                                "(SELECT MAX(plan_output_detail.inventoryOutputId) " +
                                                                "FROM ProductEntity product " +
                                                                "JOIN InventoryPlanOutputDetailEntity plan_output_detail " +
                                                                        "ON product.productId = plan_output_detail.productId " +
                                                                "WHERE product.productId IN " +
                                                                            "(SELECT p.productId FROM ProductEntity p " +
                                                                                "WHERE p.productCode = :toProductCode) ))) "+
        "AND (:productName IS NULL OR (a.inventoryOutputId IN " +
                                                                "(SELECT actual_output_detail.inventoryOutputId " +
                                                                "FROM ProductEntity product " +
                                                                "JOIN InventoryActualOutputDetailEntity actual_output_detail " +
                                                                "ON product.productId = actual_output_detail.productId " +
                                                                "WHERE product.productId IN " +
                                                                            "(SELECT p.productId FROM ProductEntity p " +
                                                                                "WHERE p.name1 LIKE CONCAT('%', :productName, '%') " +
                                                                                    "OR p.name2 LIKE CONCAT('%', :productName, '%') " +
                                                                                    "OR p.name3 LIKE CONCAT('%', :productName, '%') " +
                                                                                    "OR p.name4 LIKE CONCAT('%', :productName, '%') " +
                                                                                    "OR p.name5 LIKE CONCAT('%', :productName, '%'))" +
                                                                "GROUP BY actual_output_detail.inventoryOutputId) " +
                                        "OR a.inventoryOutputId IN " +
                                                                "(SELECT plan_output_detail.inventoryOutputId " +
                                                                "FROM ProductEntity product " +
                                                                "JOIN InventoryPlanOutputDetailEntity plan_output_detail " +
                                                                "ON product.productId = plan_output_detail.productId " +
                                                                "WHERE product.productId IN " +
                                                                            "(SELECT p.productId FROM ProductEntity p " +
                                                                                "WHERE p.name1 LIKE CONCAT('%', :productName, '%') " +
                                                                                "OR p.name2 LIKE CONCAT('%', :productName, '%') " +
                                                                                "OR p.name3 LIKE CONCAT('%', :productName, '%') " +
                                                                                "OR p.name4 LIKE CONCAT('%', :productName, '%') " +
                                                                                "OR p.name5 LIKE CONCAT('%', :productName, '%')) " +
                                                                "GROUP BY plan_output_detail.inventoryOutputId))) "+
        "AND (:fromRepositoryId IS NULL OR (a.planRepositoryId >= :fromRepositoryId " +
                                                "OR a.actualRepositoryId >= :fromRepositoryId)) " +
        "AND (:toRepositoryId IS NULL OR (a.planRepositoryId <= :toRepositoryId " +
                                                "OR a.actualRepositoryId <= :toRepositoryId)) "+
        "AND (:batchNo IS NULL OR (a.inventoryOutputId IN " +
                                                                "(SELECT actual_output_detail.inventoryOutputId " +
                                                                "FROM InventoryActualOutputDetailEntity actual_output_detail " +
                                                                "WHERE actual_output_detail.batchNo " +
                                                                "LIKE CONCAT('%', :batchNo, '%') " +
                                                                "GROUP BY actual_output_detail.inventoryOutputId) " +
                                        "OR a.inventoryOutputId IN " +
                                                                "(SELECT plan_output_detail.inventoryOutputId " +
                                                                "FROM InventoryPlanOutputDetailEntity plan_output_detail " +
                                                                "WHERE plan_output_detail.batchNo " +
                                                                "LIKE CONCAT('%', :batchNo, '%') " +
                                                                "GROUP BY plan_output_detail.inventoryOutputId))) "+
        "AND ((:deliveryType = 2 AND a.planOutputDate IS NOT NULL) OR (:deliveryType = 3 AND a.planOutputDate IS NULL) OR :deliveryType = 1 ) "+
        "AND ((:deliveryStatus = '2' AND a.sumActualQuantity = 0) " +
        "OR (:deliveryStatus = '3' AND a.sumActualQuantity <  a.sumPlanQuantity AND a.sumActualQuantity > 0) " +
        "OR (:deliveryStatus = '4' AND a.sumActualQuantity >= a.sumPlanQuantity) OR :deliveryStatus = 1) "+
        "AND (:isClosed = '' OR a.isClosed = :isClosed) " +
        "ORDER BY a.slipNo ASC"
)
Page<InventoryOutputListDTO> findInventoryOutputInfoByCondition(
        @Param("fromOrderDate") String fromOrderDate,
        @Param("toOrderDate") String toOrderDate,
        @Param("fromPlanOutputDate") String fromPlanOutputDate,
        @Param("toPlanOutputDate") String toPlanOutputDate,
        @Param("fromPlanWorkingDate") String fromPlanWorkingDate,
        @Param("toPlanWorkingDate") String toPlanWorkingDate,
        @Param("fromPlanDeliverDate") String fromPlanDeliverDate,
        @Param("toPlanDeliverDate") String toPlanDeliverDate,
        @Param("fromSlipNo") String fromSlipNo,
        @Param("toSlipNo") String toSlipNo,
        @Param("fromCustomerCode") String fromCustomerCode,
        @Param("toCustomerCode") String toCustomerCode,
        @Param("customerName") String customerName,
        @Param("fromDeliverDestCode") String fromDeliverDestCode,
        @Param("toDeliverDestCode") String toDeliverDestCode,
        @Param("deliveryDestName") String deliveryDestName,
        @Param("fromSupplierCode") String fromSupplierCode,
        @Param("toSupplierCode") String toSupplierCode,
        @Param("supplierName") String supplierName,
        @Param("fromProductCode") String fromProductCode,
        @Param("toProductCode") String toProductCode,
        @Param("productName") String productName,
        @Param("fromRepositoryId") Integer fromRepositoryId,
        @Param("toRepositoryId") Integer toRepositoryId,
        @Param("batchNo") String batchNo,
        @Param("deliveryType") Integer deliveryType,
        @Param("deliveryStatus") String deliveryStatus,
        @Param("isClosed") String isClosed,
        Pageable pageable);
}
