package org.api.repository;

import org.api.bean.dto.OutputListDto;
import org.api.bean.dto.SearchOutputListDto;
import org.api.bean.jpa.InventoryOutputEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInventoryOutputRepository extends JpaRepository<InventoryOutputEntity, Integer> {
    @Query(value = " SELECT \n " +
            "    a.inventory_output_id as inventoryOutputId,\n " +
            "    a.is_closed as isClosed ,\n " +
            "    a.output_status as outputStatus,\n " +
            "    a.slip_no as slipNo,\n " +
            "    a.plan_output_date as planOutputDate,\n " +
            "    a.batch_status as batchStatus,\n " +
            "    a.order_date as orderDateFrom,\n " +
            "    a.order_date as orderDateTo,\n " +
            "    a.actual_output_date as actualOutputDate,\n " +
            "    a.plan_working_date as planWorkingDate,\n " +
            "    a.plan_deliver_date as planDeliverDate,\n " +
            "    a.actual_deliver_date as actualDeliverDate,\n " +
            "    b.destination_code as destinationCode,\n " +
            "    b.department_name as departmentName,\n " +
            "    d.customer_code as customerCode,\n " +
            "    d.customer_name as customerName,\n " +
            "    f.repository_code as repositoryCode,\n " +
            "    f.repository_name as repositoryName,\n " +
            "    a.plan_supplier_slip_no as planSupplierSlipNo,\n " +
            "    a.actual_supplier_slip_no as actualSupplierSlipNo,\n " +
            "    a.sum_plan_quantity as sumPlanQuantity,\n " +
            "    a.sum_actual_quantity as sumActualQuantity\n " +
            "FROM \n " +
            "    db_zaika.t_inventory_output a \n " +
            "        JOIN \n " +
            "    db_zaika.m_customer_delivery_dest b ON a.plan_customer_delivery_destination_id = b.delivery_destination_id\n " +
            "        JOIN \n " +
            "    db_zaika.m_customer_delivery_dest c ON a.actual_customer_delivery_destination_id = c.delivery_destination_id\n " +
            "        JOIN \n " +
            "    db_zaika.m_customer d ON a.plan_customer_id = d.customer_id\n " +
            "        JOIN\n " +
            "    db_zaika.m_customer e ON a.actual_customer_id = e.customer_id\n " +
            "        JOIN\n " +
            "    db_zaika.m_repository f ON a.plan_repository_id = f.repository_id\n " +
            "        JOIN\n " +
            "    db_zaika.m_repository g ON a.actual_repository_id = g.repository_id ", nativeQuery = true)
    List<OutputListDto> getAll();


    //version before changing using code instead of id
//    @Query(value = "" +
//            " SELECT new org.api.bean.dto.SearchOutputListDto( " +
//            " i.inventoryOutputId, " +
//            " i.isClosed, " +
//            " i.outputStatus, " +
//            " i.slipNo,  " +
//            " i.planOutputDate ," +
//            " i.orderDate," +
//            " i.batchStatus, " +
//            " i.actualOutputDate, " +
//            " i.planWorkingDate, " +
//            " i.planDeliverDate, " +
//            " i.actualDeliverDate, " +
//            " cd.destinationCode, " +
//            " sd.departmentName, " +
//            " c.customerCode, " +
//            " c.customerName, " +
//            " r.repositoryCode, " +
//            " r.repositoryName, " +
//            " i.planSupplierSlipNo, " +
//            " i.actualSupplierSlipNo, " +
//            " i.sumPlanQuantity, " +
//            " i.sumActualQuantity) " +
//            " FROM InventoryOutputEntity i " +
//            " LEFT JOIN InventoryActualOutputDetailEntity t ON i.inventoryOutputId = t.actual_detail_id " +
//            " left JOIN SupplierDeliveryDestEntity sd ON i.planCustomerDeliveryDestinationId = sd.deliveryDestinationId " +
//            " left JOIN CustomerDeliveryDestEntity cd ON i.actualCustomerDeliveryDestinationId = cd.deliveryDestinationId " +
//            " LEFT JOIN CustomerEntity c ON i.actualCustomerId = c.customerId " +
//            " LEFT JOIN RepositoryEntity r ON i.actualRepositoryId = r.repositoryId " +
//            " left JOIN SupplierEntity s ON t.supplier_id = s.supplierId " +
//            " left JOIN ProductEntity p ON t.product_id = p.productId " +
//            " WHERE 1=1 " +
//            " AND (:repositoryIdFrom IS NULL OR r.repositoryId >= :repositoryIdFrom) " +
//            " AND (:repositoryIdTo IS NULL OR r.repositoryId <= :repositoryIdTo) " +
//            " AND (:orderDateFrom IS NULL OR i.orderDate >= :orderDateFrom) " +
//            " AND (:orderDateTo IS NULL OR i.orderDate <= :orderDateTo) " +
//            " AND (:planOutputDateFrom IS NULL OR i.planOutputDate >= :planOutputDateFrom) " +
//            " AND (:planOutputDateTo IS NULL OR i.planOutputDate <= :planOutputDateTo) " +
//            " AND (:planWorkingDayFrom IS NULL OR i.planWorkingDate >= :planWorkingDayFrom) " +
//            " AND (:planWorkingDayTo IS NULL OR i.planWorkingDate <= :planWorkingDayTo) " +
//            " AND (:planDeliverDateFrom IS NULL OR i.planDeliverDate >= :planDeliverDateFrom)" +
//            " AND (:planDeliverDateTo IS NULL OR i.planDeliverDate <= :planDeliverDateTo) " +
//            " AND (:slipNoFrom IS NULL OR i.slipNo >= :slipNoFrom) " +
//            " AND (:slipNoTo IS NULL OR i.slipNo <= :slipNoTo) " +
//            " AND (:destinationIdFrom IS NULL OR cd.deliveryDestinationId >= :destinationIdFrom) " +
//            " AND (:destinationIdTo IS NULL OR cd.deliveryDestinationId <= :destinationIdTo) " +
//            " AND (:departmentName IS NULL OR cd.departmentName LIKE CONCAT('%', :departmentName, '%')) " +
//            " AND (:supplierIdFrom IS NULL OR s.supplierId >= :supplierIdFrom) " +
//            " AND (:supplierIdTo IS NULL OR s.supplierId <= :supplierIdTo) " +
//            " AND (:supplierName IS NULL OR s.supplierName LIKE CONCAT('%', :supplierName, '%')) " +
//            " AND (:customerIdFrom IS NULL OR c.customerId >= :customerIdFrom) " +
//            " AND (:customerIdTo IS NULL OR c.customerId <= :customerIdTo) " +
//            " AND (:customerName IS NULL OR c.customerName LIKE CONCAT('%', :customerName, '%')) " +
//            " AND ((:batchNo is null) or (t.batchNo LIKE CONCAT('%', :batchNo, '%')))" +
//            " AND (:ownerIdFrom IS NULL OR c.customerId >= :ownerIdFrom) " +
//            " AND (:ownerIdTo IS NULL OR c.customerId <= :ownerIdTo) " +
//            " AND (:ownerName IS NULL OR c.customerName LIKE CONCAT('%', :ownerName, '%')) " +
//            " AND (:productIdFrom is null or p.productId >= :productIdFrom) " +
//            " AND (:productIdTo is null or p.productId <= :productIdTo) " +
//            " AND (:productName IS NULL OR p.productId IN " +
//            " (SELECT p.productId FROM ProductEntity p WHERE " +
//            " p.name1 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name2 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name3 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name4 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name5 LIKE CONCAT('%', :productName, '%') " +
//            " )) " +
//            " AND (:deliveryType IS NULL OR " +
//            " (:deliveryType = '0' OR " +
//            " (:deliveryType = '1' AND i.planOutputDate IS NOT NULL ) OR " +
//            " (:deliveryType = '2' AND i.actualOutputDate IS NOT NULL ) " +
//            " )) " +
//            " AND (:deliveryStatus IS NULL OR " +
//            " (:deliveryStatus = '0' OR " +
//            " (:deliveryStatus = '1' AND i.sumActualQuantity = 0) OR " +
//            " (:deliveryStatus = '2' AND i.sumActualQuantity < i.sumPlanQuantity AND i.sumActualQuantity > 0) OR " +
//            " (:deliveryStatus = '3' AND i.sumActualQuantity >= i.sumPlanQuantity ) " +
//            " ))" +
//            " AND " +
//            " (( :isClosed IS NULL )" +
//            " OR  " +
//            " (:isClosed ='9') " +
//            " OR (:isClosed = '0' AND i.isClosed = '0') " +
//            " OR (:isClosed = '1' AND i.isClosed = '1')) ")
//    Page<SearchOutputListDto> getSearchList(
//            @Param("orderDateFrom") String orderDateFrom,
//            @Param("orderDateTo") String orderDateTo,
//            @Param("planOutputDateFrom") String planOutputDateFrom,
//            @Param("planOutputDateTo") String planOutputDateTo,
//            @Param("planWorkingDayFrom") String planWorkingDayFrom,
//            @Param("planWorkingDayTo") String planWorkingDayTo,
//            @Param("planDeliverDateFrom") String planDeliverDateFrom,
//            @Param("planDeliverDateTo") String planDeliverDateTo,
//            @Param("slipNoFrom") String slipNoFrom,
//            @Param("slipNoTo") String slipNoTo,
//            @Param("customerIdFrom") Integer customerIdFrom,
//            @Param("customerIdTo") Integer customerIdTo,
//            @Param("customerName") String customerName,
//            @Param("destinationIdFrom") Integer destinationIdFrom,
//            @Param("destinationIdTo") Integer destinationIdTo,
//            @Param("departmentName") String departmentName,
//            @Param("supplierIdFrom") Integer supplierIdFrom,
//            @Param("supplierIdTo") Integer supplierIdTo,
//            @Param("supplierName") String supplierName,
//            @Param("productIdFrom") Integer productIdFrom,
//            @Param("productIdTo") Integer productIdTo,
//            @Param("productName") String productName,
//            @Param("repositoryIdFrom") Integer repositoryIdFrom,
//            @Param("repositoryIdTo") Integer repositoryIdTo,
//            @Param("batchNo") String batchNo,
//            @Param("deliveryType") String deliveryType,
//            @Param("deliveryStatus") String deliveryStatus,
//            @Param("isClosed") String isClosed,
//            Pageable pageable,
//            @Param("ownerIdFrom") Integer ownerIdFrom,
//            @Param("ownerIdTo") Integer ownerIdTo,
//            @Param("ownerName") String ownerName
//    );


    // N chạy
//    @Query(value = "SELECT new org.api.bean.dto.SearchOutputListDto(  \n" +
//            "                a.inventoryOutputId, \n" +
//            "                a.isClosed,  \n" +
//            "                a.outputStatus,  \n" +
//            "                a.slipNo,  \n" +
//            "                a.planOutputDate,  \n" +
//            "                a.orderDate,  \n" +
//            "                a.batchStatus,  \n" +
//            "                a.actualOutputDate,  \n" +
//            "                a.planWorkingDate,  \n" +
//            "                a.planDeliverDate,  \n" +
//            "                a.actualDeliverDate,  \n" +
//            "                b.destinationCode,  \n" +
//            "                b.departmentName,  \n" +
//            "                d.customerCode,  \n" +
//            "                d.customerName,  \n" +
//            "                f.repositoryCode,  \n" +
//            "                f.repositoryName,  \n" +
//            "                a.planSupplierSlipNo,  \n" +
//            "                a.actualSupplierSlipNo,  \n" +
//            "                a.sumPlanQuantity,  \n" +
//            "                a.sumActualQuantity)   \n" +
//            "            FROM  \n" +
//            "                InventoryOutputEntity a   \n" +
//            "                    LEFT JOIN  \n" +
//            "                CustomerDeliveryDestEntity b ON a.planCustomerDeliveryDestinationId = b.deliveryDestinationId  \n" +
//            "                    LEFT JOIN  \n" +
//            "                CustomerDeliveryDestEntity c ON a.actualCustomerDeliveryDestinationId = c.deliveryDestinationId  \n" +
//            "                    LEFT JOIN  \n" +
//            "                CustomerEntity d ON a.planCustomerId = d.customerId  \n" +
//            "                    LEFT JOIN  \n" +
//            "                CustomerEntity e ON a.actualCustomerId = e.customerId  \n" +
//            "                    LEFT JOIN  \n" +
//            "                RepositoryEntity f ON a.planRepositoryId = f.repositoryId  \n" +
//            "                    LEFT JOIN  \n" +
//            "                RepositoryEntity g ON a.actualRepositoryId = g.repositoryId  \n" +
//            "            WHERE a.delFlg = '0'  \n" +
//            "            AND (:orderDateFrom IS NULL OR a.orderDate >= :orderDateFrom)  \n" +
//            "            AND (:orderDateTo IS NULL OR a.orderDate <= :orderDateTo)  \n" +
//            "            AND (:planOutputDateFrom IS NULL OR a.planOutputDate >= :planOutputDateFrom)  \n" +
//            "            AND (:planOutputDateTo IS NULL OR a.planOutputDate <= :planOutputDateTo)  \n" +
//            "            AND (:planWorkingDayFrom IS NULL OR a.planWorkingDate >= :planWorkingDayFrom)  \n" +
//            "            AND (:planWorkingDayTo IS NULL OR a.planWorkingDate <= :planWorkingDayTo)  \n" +
//            "            AND (:planDeliverDateFrom IS NULL OR a.planDeliverDate >= :planDeliverDateFrom)  \n" +
//            "            AND (:planDeliverDateTo IS NULL OR a.planDeliverDate <= :planDeliverDateTo)  \n" +
//            "            AND (:slipNoFrom IS NULL OR a.slipNo >= :slipNoFrom)  \n" +
//            "            AND (:slipNoTo IS NULL OR a.slipNo <= :slipNoTo)  \n" +
//            "            AND (:customerIdFrom IS NULL OR (a.planCustomerId >= :customerIdFrom OR a.actualCustomerId >= :customerIdFrom ))  \n" +
//            "            AND (:customerIdTo IS NULL OR (a.planCustomerId <= :customerIdTo OR a.actualCustomerId <= :customerIdTo ))  \n" +
//            "            AND (:customerName IS NULL OR (a.planCustomerId IN  \n" +
//            "            (SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', :customerName, '%'))  \n" +
//            "            OR a.actualCustomerId IN  \n" +
//            "            (SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', :customerName, '%'))))  \n" +
//            "            AND (:destinationIdFrom IS NULL OR (a.planCustomerDeliveryDestinationId >= :destinationIdFrom  \n" +
//            "            OR a.actualCustomerDeliveryDestinationId >= :deliveryCodeFrom )) \n" +
//            "            AND (:destinationIdTo IS NULL OR (a.planCustomerDeliveryDestinationId <= :destinationIdTo  \n" +
//            "            OR a.actualCustomerDeliveryDestinationId <= :destinationIdTo )) \n" +
//            "            AND (:departmentName IS NULL OR (a.planCustomerDeliveryDestinationId IN  \n" +
//            "            (SELECT a3.deliveryDestinationId FROM CustomerDeliveryDestEntity a3 WHERE a3.departmentName LIKE CONCAT('%', :departmentName, '%'))  \n" +
//            "            OR a.actualCustomerDeliveryDestinationId IN  \n" +
//            "            (SELECT a4.deliveryDestinationId FROM CustomerDeliveryDestEntity a4 WHERE a4.departmentName LIKE CONCAT('%', :departmentName, '%')))) \n" +
//            "            AND (:supplierIdFrom IS NULL OR (a.inventoryOutputId IN  \n" +
//            "            (SELECT a5.inventoryOutputId FROM InventoryOutputEntity a5  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventoryOutputId = a6.inventory_output_id  \n" +
//            "            WHERE a6.supplier_id >= :supplierIdFrom  \n" +
//            "            GROUP BY a5.inventoryOutputId)  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a7.inventoryOutputId FROM InventoryOutputEntity a7  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity a8 ON a7.inventoryOutputId = a8.inventory_output_id  \n" +
//            "            WHERE a8.supplier_id >= :supplierIdFrom  \n" +
//            "            GROUP BY a7.inventoryOutputId)))  \n" +
//            "            AND (:supplierIdTo IS NULL OR (a.inventoryOutputId IN  \n" +
//            "            (SELECT a5.inventoryOutputId FROM InventoryOutputEntity a5  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventoryOutputId = a6.inventory_output_id  \n" +
//            "            WHERE a6.supplier_id <= :supplierIdTo  \n" +
//            "            GROUP BY a5.inventoryOutputId)  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a7.inventoryOutputId FROM InventoryOutputEntity a7  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity a8 ON a7.inventoryOutputId = a8.inventory_output_id  \n" +
//            "            WHERE a8.supplier_id <= :supplierIdTo  \n" +
//            "            GROUP BY a7.inventoryOutputId)))  \n" +
//            "            AND (:supplierName IS NULL OR (a.inventoryOutputId IN  \n" +
//            "           (SELECT a5.inventoryOutputId FROM InventoryOutputEntity a5  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventoryOutputId = a6.inventory_output_id  \n" +
//            "            INNER JOIN SupplierEntity b ON a6.supplier_id = b.supplierId  \n" +
//            "            WHERE b.supplierName LIKE CONCAT('%', :supplierName, '%')  \n" +
//            "            GROUP BY a5.inventoryOutputId)  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a7.inventoryOutputId FROM InventoryOutputEntity a7  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity a8 ON a7.inventoryOutputId = a8.inventory_output_id  \n" +
//            "            INNER JOIN SupplierEntity b ON a8.supplier_id = b.supplierId  \n" +
//            "            WHERE b.supplierName LIKE CONCAT('%', :supplierName, '%')  \n" +
//            "            GROUP BY a7.inventoryOutputId)))   \n" +
//            "            AND (:ownerIdFrom IS NULL OR (a.planCustomerId >= :ownerIdFrom OR a.actualCustomerId >= :ownerIdFrom ))  \n" +
//            "            AND (:ownerIdTo IS NULL OR (a.planCustomerId <= :ownerIdTo OR a.actualCustomerId <= :ownerIdTo ))  \n" +
//            "            AND (:ownerName IS NULL OR (a.planCustomerId IN  \n" +
//            "            (SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', :ownerName, '%'))  \n" +
//            "            OR a.actualCustomerId IN  \n" +
//            "            (SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', :ownerName, '%'))))  \n" +
//            "            AND (:productIdFrom IS NULL OR (a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            WHERE b.product_id >= :productIdFrom  \n" +
//            "            GROUP BY a.inventoryOutputId)  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            WHERE b.product_id <= :productIdFrom  \n" +
//            "            GROUP BY a.inventoryOutputId)))  \n" +
//            "            AND (:productIdTo IS NULL OR (a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            WHERE b.product_id <= :productIdTo  \n" +
//            "            GROUP BY a.inventoryOutputId)  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            WHERE b.product_id >= :productIdTo  \n" +
//            "            GROUP BY a.inventoryOutputId)))  \n" +
//            "            AND (:productName IS NULL OR (a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            INNER JOIN ProductEntity c ON b.product_id = c.productId  \n" +
//            "            WHERE c.name1 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name2 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name3 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name4 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name5 LIKE CONCAT('%', :productName, '%') )  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            INNER JOIN ProductEntity c ON b.product_id = c.productId  \n" +
//            "            WHERE c.name1 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name2 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name3 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name4 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            OR c.name5 LIKE CONCAT('%', :productName, '%'))))  \n" +
//            "            AND (:repositoryIdFrom IS NULL OR (a.planRepositoryId >= :repositoryIdFrom OR a.actualRepositoryId >= :repositoryIdFrom))  \n" +
//            "            AND (:repositoryIdTo IS NULL OR (a.planRepositoryId <= :repositoryIdTo OR a.actualRepositoryId <= :repositoryIdTo))  \n" +
//            "            AND (:batchNo IS NULL OR (a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            WHERE b.batch_no LIKE CONCAT('%', :batchNo, '%') GROUP BY a.inventoryOutputId)  \n" +
//            "            OR a.inventoryOutputId IN  \n" +
//            "            (SELECT a.inventoryOutputId FROM InventoryOutputEntity a  \n" +
//            "            INNER JOIN InventoryActualOutputDetailEntity b ON a.inventoryOutputId = b.inventory_output_id  \n" +
//            "            WHERE b.batchNo LIKE CONCAT('%', :batchNo, '%') GROUP BY a.inventoryOutputId)))  \n" +
//            "            AND ((:deliveryType = 1 AND a.planOutputDate IS NOT NULL) OR (:deliveryType = 2 AND a.planOutputDate IS NULL) OR :deliveryType = 0)  \n" +
//            "            AND (:deliveryStatus = '' OR a.outputStatus = :deliveryStatus)  \n" +
//            "            AND (:isClosed = '' OR a.isClosed = :isClosed) ")
//    Page<SearchOutputListDto> getNewSearchList(
//            @Param("orderDateFrom") String orderDateFrom,
//            @Param("orderDateTo") String orderDateTo,
//            @Param("planOutputDateFrom") String planOutputDateFrom,
//            @Param("planOutputDateTo") String planOutputDateTo,
//            @Param("planWorkingDayFrom") String planWorkingDayFrom,
//            @Param("planWorkingDayTo") String planWorkingDayTo,
//            @Param("planDeliverDateFrom") String planDeliverDateFrom,
//            @Param("planDeliverDateTo") String planDeliverDateTo,
//            @Param("slipNoFrom") String slipNoFrom,
//            @Param("slipNoTo") String slipNoTo,
//            @Param("customerIdFrom") Integer customerIdFrom,
//            @Param("customerIdTo") Integer customerIdTo,
//            @Param("customerName") String customerName,
//            @Param("destinationIdFrom") Integer destinationIdFrom,
//            @Param("destinationIdTo") Integer destinationIdTo,
//            @Param("departmentName") String departmentName,
//            @Param("supplierIdFrom") Integer supplierIdFrom,
//            @Param("supplierIdTo") Integer supplierIdTo,
//            @Param("supplierName") String supplierName,
//            @Param("productIdFrom") Integer productIdFrom,
//            @Param("productIdTo") Integer productIdTo,
//            @Param("productName") String productName,
//            @Param("repositoryIdFrom") Integer repositoryIdFrom,
//            @Param("repositoryIdTo") Integer repositoryIdTo,
//            @Param("batchNo") String batchNo,
//            @Param("deliveryType") String deliveryType,
//            @Param("deliveryStatus") String deliveryStatus,
//            @Param("isClosed") String isClosed,
//            Pageable pageable,
//            @Param("ownerIdFrom") Integer ownerIdFrom,
//            @Param("ownerIdTo") Integer ownerIdTo,
//            @Param("ownerName") String ownerName
//
//    );

    //Ver dùng code

    @Query(value = "" +
            " SELECT new org.api.bean.dto.SearchOutputListDto( " +
            "i.inventoryOutputId,  " +
            "i.isClosed,  " +
            "i.outputStatus,  " +
            "i.slipNo,  " +
            "i.planOutputDate , " +
            "i.orderDate,  " +
            "i.batchStatus,  " +
            "i.actualOutputDate, " +
            "i.planWorkingDate,  " +
            "i.planDeliverDate,  " +
            "i.actualDeliverDate,  " +
            "cd.destinationCode,  " +
            "sd.departmentName,  " +
            "c.customerCode,  " +
            "c.customerName,  " +
            "r.repositoryCode,  " +
            "r.repositoryName,  " +
            "i.planSupplierSlipNo,  " +
            "i.actualSupplierSlipNo,  " +
            "i.sumPlanQuantity,  " +
            "i.sumActualQuantity  " +
            ")  " +
            "FROM InventoryOutputEntity i  " +
            "LEFT JOIN SupplierDeliveryDestEntity sd ON i.planCustomerDeliveryDestinationId = sd.deliveryDestinationId  " +
            "LEFT JOIN CustomerDeliveryDestEntity cd ON i.actualCustomerDeliveryDestinationId = cd.deliveryDestinationId " +
            "LEFT JOIN SupplierEntity s ON sd.supplierId = s.supplierId " +
            "LEFT JOIN InventoryActualOutputDetailEntity t ON i.inventoryOutputId = t.actualDetailId " +
            "LEFT JOIN CustomerEntity c ON i.planCustomerId = c.customerId " +
            "LEFT JOIN ProductEntity p ON t.productId = p.productId " +
            "LEFT JOIN RepositoryEntity r ON i.planRepositoryId = r.repositoryId " +
            "WHERE i.delFlg='0'  " +
            "AND (:repositoryCodeFrom IS NULL OR r.repositoryId >= :repositoryCodeFrom ) " +
            "AND (:repositoryCodeTo IS NULL OR r.repositoryId  <= :repositoryCodeTo ) " +
            "AND (:orderDateFrom IS NULL OR i.orderDate >= :orderDateFrom)  " +
            "AND (:orderDateTo IS NULL OR i.orderDate <= :orderDateTo)  " +
            "AND (:planOutputDateFrom IS NULL OR i.planOutputDate >= :planOutputDateFrom)  " +
            "AND (:planOutputDateTo IS NULL OR i.planOutputDate <= :planOutputDateTo)  " +
            "AND (:planWorkingDayFrom IS NULL OR i.planWorkingDate >= :planWorkingDayFrom)  " +
            "AND (:planWorkingDayTo IS NULL OR i.planWorkingDate <= :planWorkingDayTo)  " +
            "AND (:planDeliverDateFrom IS NULL OR i.planDeliverDate >= :planDeliverDateFrom)  " +
            "AND (:planDeliverDateTo IS NULL OR i.planDeliverDate <= :planDeliverDateTo)  " +
            "AND (:slipNoFrom IS NULL OR i.slipNo >= :slipNoFrom)  " +
            "AND (:slipNoTo IS NULL OR i.slipNo <= :slipNoTo)  " +
            "AND (:destinationCodeFrom IS NULL OR cd.destinationCode >= :destinationCodeFrom)  " +
            "AND (:destinationCodeTo IS NULL OR cd.destinationCode <= :destinationCodeTo)" +
            "AND (:departmentName IS NULL OR cd.departmentName LIKE CONCAT('%', :departmentName, '%'))  " +
            "AND (:supplierCodeFrom IS NULL OR s.supplierCode >= :supplierCodeFrom) " +
            "AND (:supplierCodeTo IS NULL OR s.supplierCode <= :supplierCodeTo) " +
            "AND (:supplierName IS NULL OR s.supplierName LIKE CONCAT('%', :supplierName, '%'))  " +
            "AND (:customerCodeFrom IS NULL OR c.customerCode >= :customerCodeFrom) " +
            "AND (:customerCodeTo IS NULL OR c.customerCode <=:customerCodeTo)" +
            "AND (c.customerName IS NULL OR c.customerName LIKE CONCAT('%', :customerName, '%'))  " +
            "AND (:ownerCodeFrom IS NULL OR c.customerCode >=:ownerCodeFrom) " +
            "AND (:ownerCodeTo IS NULL OR c.customerCode <=:ownerCodeTo)" +
            "AND (:ownerName IS NULL OR c.customerName LIKE CONCAT('%', :ownerName, '%'))  " +
            "AND (:batchNo IS NULL OR t.batchNo LIKE CONCAT('%', :batchNo, '%'))  " +
            "AND (:productCodeFrom IS NULL OR p.productCode >= :productCodeFrom)  " +
            "AND (:productCodeTo IS NULL OR p.productCode <= :productCodeTo)" +
            "AND (:productName IS NULL OR p.productId IN  " +
            "(SELECT p.productId FROM ProductEntity p WHERE  " +
            "p.name1 LIKE CONCAT('%', :productName, '%')  " +
            "                OR p.name2 LIKE CONCAT('%', :productName, '%')  " +
            "                OR p.name3 LIKE CONCAT('%', :productName, '%')  " +
            "                OR p.name4 LIKE CONCAT('%', :productName, '%')  " +
            "                OR p.name5 LIKE CONCAT('%', :productName, '%') )) " +
            "AND ( (:deliveryType = '0') " +
            "                OR (:deliveryType = '1' AND i.planOutputDate IS NOT NULL ) " +
            "                OR (:deliveryType = '2' AND i.actualOutputDate IS NOT NULL ))  " +


            "AND ( (:deliveryStatus = '0') " +
            "                OR (:deliveryStatus = '1' AND i.sumActualQuantity = 0)  " +
            "                OR (:deliveryStatus = '2' AND i.sumActualQuantity < i.sumPlanQuantity AND i.sumActualQuantity > 0) " +
            "                OR (:deliveryStatus = '3' AND i.sumActualQuantity >= i.sumPlanQuantity ))  "+
            "AND ((:isClosed = '9') OR (:isClosed = '0' AND i.isClosed = '0') OR (:isClosed = '1' AND i.isClosed = '1'))"
    )
    Page<SearchOutputListDto> getNewSearchList(
            @Param("orderDateFrom") String orderDateFrom,
            @Param("orderDateTo") String orderDateTo,
            @Param("planOutputDateFrom") String planOutputDateFrom,
            @Param("planOutputDateTo") String planOutputDateTo,
            @Param("planWorkingDayFrom") String planWorkingDayFrom,
            @Param("planWorkingDayTo") String planWorkingDayTo,
            @Param("planDeliverDateFrom") String planDeliverDateFrom,
            @Param("planDeliverDateTo") String planDeliverDateTo,
            @Param("slipNoFrom") String slipNoFrom,
            @Param("slipNoTo") String slipNoTo,
            @Param("customerCodeFrom") String customerCodeFrom,
            @Param("customerCodeTo") String customerCodeTo,
            @Param("customerName") String customerName,
            @Param("destinationCodeFrom") String destinationCodeFrom,
            @Param("destinationCodeTo") String destinationCodeTo,
            @Param("departmentName") String departmentName,
            @Param("supplierCodeFrom") String supplierCodeFrom,
            @Param("supplierCodeTo") String supplierCodeTo,
            @Param("supplierName") String supplierName,
            @Param("productCodeFrom") String productCodeFrom,
            @Param("productCodeTo") String productCodeTo,
            @Param("productName") String productName,
            @Param("repositoryCodeFrom") Integer repositoryCodeFrom,
            @Param("repositoryCodeTo") Integer repositoryCodeTo,
            @Param("batchNo") String batchNo,
            @Param("deliveryType") String deliveryType,
            @Param("deliveryStatus") String deliveryStatus,
            @Param("isClosed") String isClosed,
            @Param("ownerCodeFrom") String ownerCodeFrom,
            @Param("ownerCodeTo") String ownerCodeTo,
            @Param("ownerName") String ownerName,
            Pageable pageable
    );


// Duy chạy sai kết quả
//    @Query(value = "SELECT new org.api.bean.dto.SearchOutputListDto(" +
//            " a.inventoryOutputId, " +
//            " a.isClosed , " +
//            " a.outputStatus , " +
//            " a.slipNo , " +
//            " a.planOutputDate , " +
//            " a.orderDate , " +
//            " a.batchStatus , " +
//            " a.actualOutputDate, " +
//            " a.planWorkingDate ," +
//            " a.planDeliverDate , " +
//            " a.actualDeliverDate , " +
//            " b.destinationCode ," +
//            " b.departmentName ," +
//            " d.customerCode ," +
//            " d.customerName , " +
//            " f.repositoryCode ," +
//            " f.repositoryName , " +
//            " a.planSupplierSlipNo , " +
//            " a.actualSupplierSlipNo , " +
//            " a.sumPlanQuantity , " +
//            " a.sumActualQuantity )" +
//            " FROM  " +
//            " InventoryOutputEntity a  " +
//            " left JOIN " +
//            " InventoryPlanOutputDetailEntity h ON a.inventoryOutputId = h.inventory_output_id " +
//            " left JOIN " +
//            " InventoryActualOutputDetailEntity k ON a.inventoryOutputId = k.inventory_output_id" +
//            " left JOIN" +
//            " CustomerDeliveryDestEntity b ON a.planCustomerDeliveryDestinationId = b.deliveryDestinationId" +
//            " OR a.actualCustomerDeliveryDestinationId = b.deliveryDestinationId" +
//            " left JOIN " +
//            " CustomerEntity d ON a.planCustomerId = d.customerId " +
//            " OR a.actualCustomerId = d.customerId" +
//            " left JOIN " +
//            " RepositoryEntity f ON a.planRepositoryId = f.repositoryId " +
//            " OR a.actualRepositoryId = f.repositoryId " +
//            " left JOIN " +
//            " SupplierEntity l ON h.supplier_id = l.supplierId " +
//            " left JOIN " +
//            " ProductEntity m ON l.supplierId = m.supplierId" +
//            " WHERE 1=1 " +
//            " AND (:orderDateFrom is null or a.orderDate >= :orderDateFrom) " +
//            " AND (:orderDateTo is null or a.orderDate <= :orderDateTo) " +
//            " AND (:planOutputDateFrom is null or a.planOutputDate >= :planOutputDateFrom) " +
//            " AND (:planOutputDateTo is null or a.planOutputDate <= :planOutputDateTo) " +
//            " AND (:planWorkingDayFrom is null or a.planWorkingDate >= :planWorkingDayFrom) " +
//            " AND (:planWorkingDayTo is null or a.planWorkingDate <= :planWorkingDayTo) " +
//            " AND (:planDeliverDateFrom is null or a.planDeliverDate >= :planDeliverDateFrom) " +
//            " AND (:planDeliverDateTo is null or a.planDeliverDate <= :planDeliverDateTo) " +
//            " AND (:slipNoFrom is null or  a.slipNo >= :slipNoFrom) " +
//            " AND (:slipNoTo is null or a.slipNo <= :slipNoTo ) " +
//            " AND (:customerIdFrom is null or d.customerId >= :customerIdFrom) " +
//            " AND (:customerIdTo is null or d.customerId <= :customerIdTo) " +
//            " AND (:customerName is null or d.customerName LIKE CONCAT('%', :customerName, '%')) " +
//            " AND (:destinationIdFrom is null or b.deliveryDestinationId >= :destinationIdFrom) " +
//            " AND (:destinationIdTo is null or b.deliveryDestinationId <= :destinationIdTo) " +
//            " AND (:departmentName is null or b.departmentName LIKE CONCAT('%', :departmentName, '%')) " +
//            " AND (:repositoryIdFrom is null or f.repositoryId >= :repositoryIdFrom) " +
//            " AND (:repositoryIdTo is null or f.repositoryId <= :repositoryIdTo) " +
//            " AND (:supplierIdFrom is null or l.supplierId >= :supplierIdFrom) " +
//            " AND (:supplierIdTo is null or l.supplierId <= :supplierIdTo) " +
//            " AND (:supplierName is null or l.supplierName LIKE CONCAT('%', :supplierName, '%')) " +
//            " AND (:productIdFrom is null or m.productId >= :productIdFrom) " +
//            " AND (:productIdTo is null or m.productId <= :productIdTo) " +
//            " AND ((:productName is null) or (m.name1 LIKE CONCAT('%', :productName, '%')) " +
//            " OR (m.name2 LIKE CONCAT('%', :productName, '%')) " +
//            " OR (m.name3 LIKE CONCAT('%', :productName, '%')) " +
//            " OR (m.name4 LIKE CONCAT('%', :productName, '%'))" +
//            " OR (m.name5 LIKE CONCAT('%', :productName, '%')))" +
//            " AND ((:batchNo is null) or (h.batch_no LIKE CONCAT('%', :batchNo, '%')))" +
//            " AND (:deliveryType = '1' AND a.planOutputDate is not null)  OR (:deliveryType = '2' AND a.actualOutputDate IS NOT NULL ) OR (:deliveryType = '0') " +
//            " AND (:deliveryStatus = '0') OR (:deliveryStatus = '1' AND a.sumPlanQuantity >0 AND a.sumActualQuantity=0) OR (:deliveryStatus = '2' AND a.sumActualQuantity < a.sumPlanQuantity ) OR (:deliveryStatus = '3' AND a.sumActualQuantity >= a.sumPlanQuantity) " +
//            " AND (:isClosed ='' OR a.isClosed = :isClosed)" +
//            " group by a.inventoryOutputId " +
//            " ORDER BY a.slipNo ASC ")
//    Page<SearchOutputListDto> getNewSearchList(
//            @Param("orderDateFrom") String orderDateFrom,
//            @Param("orderDateTo") String orderDateTo,
//            @Param("planOutputDateFrom") String planOutputDateFrom,
//            @Param("planOutputDateTo") String planOutputDateTo,
//            @Param("planWorkingDayFrom") String planWorkingDayFrom,
//            @Param("planWorkingDayTo") String planWorkingDayTo,
//            @Param("planDeliverDateFrom") String planDeliverDateFrom,
//            @Param("planDeliverDateTo") String planDeliverDateTo,
//            @Param("slipNoFrom") String slipNoFrom,
//            @Param("slipNoTo") String slipNoTo,
//            @Param("customerIdFrom") Integer customerIdFrom,
//            @Param("customerIdTo") Integer customerIdTo,
//            @Param("customerName") String customerName,
//            @Param("destinationIdFrom") Integer destinationIdFrom,
//            @Param("destinationIdTo") Integer destinationIdTo,
//            @Param("departmentName") String departmentName,
//            @Param("supplierIdFrom") Integer supplierIdFrom,
//            @Param("supplierIdTo") Integer supplierIdTo,
//            @Param("supplierName") String supplierName,
//            @Param("productIdFrom") Integer productIdFrom,
//            @Param("productIdTo") Integer productIdTo,
//            @Param("productName") String productName,
//            @Param("repositoryIdFrom") Integer repositoryIdFrom,
//            @Param("repositoryIdTo") Integer repositoryIdTo,
//            @Param("batchNo") String batchNo,
//            @Param("deliveryType") String deliveryType,
//            @Param("deliveryStatus") String deliveryStatus,
//            @Param("isClosed") String isClosed,
//            Pageable pageable
//    );

//    //HaiHH
//    @Query(value = "SELECT new org.api.bean.dto.SearchOutputListDto(   \n" +
//            "                i.inventoryOutputId,  \n" +
//            "                i.isClosed,  \n" +
//            "                i.outputStatus,  \n" +
//            "                i.slipNo,  \n" +
//            "                i.planOutputDate , \n" +
//            "                i.orderDate,  \n" +
//            "                i.orderDate,  \n" +
//            "                i.batchStatus,  \n" +
//            "                i.actualOutputDate,  \n" +
//            "                i.planWorkingDate,  \n" +
//            "                i.planDeliverDate,  \n" +
//            "                i.actualDeliverDate,  \n" +
//            "                cd.destinatonCode,  \n" +
//            "                sd.departmentName,  \n" +
//            "                c.customerCode,  \n" +
//            "                c.customerName,  \n" +
//            "                r.repositoryCode,  \n" +
//            "                r.repositoryName,  \n" +
//            "                i.planSupplierSlipNo,  \n" +
//            "                i.actualSupplierSlipNo,  \n" +
//            "                i.sumPlanQuantity,  \n" +
//            "                i.sumActualQuantity  \n" +
//            "            )  \n" +
//            "            FROM InventoryOutputEntity i  \n" +
//            "            INNER JOIN SupplierDeliveryDestEntity sd ON i.planCustomerDeliveryDestinationId = sd.deliveryDestination_id  \n" +
//            "            INNER JOIN CustomerDeliveryDestEntity cd ON i.actualCustomerDeliveryDestinationId = cd.deliveryDestination_id  \n" +
//            "            LEFT JOIN CustomerEntity c ON i.actualCustomerId = c.customerId  \n" +
//            "            LEFT JOIN RepositoryEntity r ON i.actualRepositoryId = r.repositoryId  \n" +
//            "            LEFT JOIN InventoryActualOutputDetailEntity t ON i.inventoryOutputId = t.actual_detail_id  \n" +
//            "            left join  InventoryPlanOutputDetailEntity k ON i.inventoryOutputId = k.inventory_output_id " +
//            "            INNER JOIN SupplierEntity s ON t.supplier_id = s.supplierId  \n" +
//            "            INNER JOIN ProductEntity p ON t.product_id = p.productId  \n" +
//            "            WHERE 1=1  \n" +
//            "            AND (:repositoryIdFrom IS NULL OR r.repositoryId >= :repositoryIdFrom)  \n" +
//            "            AND (:repositoryIdTo IS NULL OR r.repositoryId >= :repositoryIdTo)  \n" +
//            "            AND (:orderDateFrom IS NULL OR i.orderDate >= :orderDateFrom)  \n" +
//            "            AND (:orderDateTo IS NULL OR i.orderDate <= :orderDateTo)  \n" +
//            "            AND (:planOutputDateFrom IS NULL OR i.planOutputDate >= :planOutputDateFrom)  \n" +
//            "            AND (:planOutputDateTo IS NULL OR i.planOutputDate <= :planOutputDateTo)  \n" +
//            "            AND (:planWorkingDayFrom IS NULL OR i.planWorkingDate >= :planWorkingDayFrom)  \n" +
//            "            AND (:planWorkingDayTo IS NULL OR i.planWorkingDate <= :planWorkingDayTo)  \n" +
//            "            AND (:planDeliverDateFrom IS NULL OR i.planDeliverDate >= :planDeliverDateFrom)  \n" +
//            "            AND (:planDeliverDateTo IS NULL OR i.planDeliverDate <= :planDeliverDateTo)  \n" +
//            "            AND (:slipNoFrom IS NULL OR i.slipNo >= :slipNoFrom)  \n" +
//            "            AND (:slipNoTo IS NULL OR i.slipNo <= :slipNoTo)  \n" +
//            "            AND (:destinationIdFrom IS NULL OR cd.deliveryDestination_id >= :destinationIdFrom)  \n" +
//            "            AND (:destinationIdTo IS NULL OR cd.deliveryDestination_id <= :destinationIdTo)  \n" +
//            "            AND (:departmentName IS NULL OR cd.departmentName LIKE CONCAT('%', :departmentName, '%'))  \n" +
//            "            AND (:supplierIdFrom IS NULL OR s.supplierId >= :supplierIdFrom)  \n" +
//            "            AND (:supplierIdTo IS NULL OR s.supplierId <= :supplierIdTo)  \n" +
//            "            AND (:supplierName IS NULL OR s.supplierName LIKE CONCAT('%', :supplierName, '%'))  \n" +
//            "            AND (:customerIdFrom IS NULL OR c.customerId >= :customerIdFrom)  \n" +
//            "            AND (:customerIdTo IS NULL OR c.customerId <= :customerIdTo)  \n" +
//            "            AND (:customerName IS NULL OR c.customerName LIKE CONCAT('%', :customerName, '%'))  \n" +
//            "            AND (:productIdFrom IS NULL OR p.productId >= :productIdFrom)  \n" +
//            "            AND (:productIdTo IS NULL OR p.productId <= :productIdTo)  \n" +
//            "            AND (:productName IS NULL OR p.productId IN  \n" +
//            "                (SELECT p.productId FROM ProductEntity p WHERE  \n" +
//            "                p.name1 LIKE CONCAT('%', :productName, '%')  \n" +
//            "                OR p.name2 LIKE CONCAT('%', :productName, '%')  \n" +
//            "                OR p.name3 LIKE CONCAT('%', :productName, '%')  \n" +
//            "                OR p.name4 LIKE CONCAT('%', :productName, '%')  \n" +
//            "                OR p.name5 LIKE CONCAT('%', :productName, '%')  \n" +
//            "            )) \n" +
//            "                  AND (:batchNo is null or k.batch_no LIKE CONCAT('%', :batchNo, '%'))" +
//            "            AND (:deliveryType IS NULL OR  \n" +
//            "                (:deliveryType = '0' OR  \n" +
//            "                (:deliveryType = '1' AND i.planOutputDate IS NOT NULL ) OR  \n" +
//            "                (:deliveryType = '2' AND i.actualOutputDate IS NOT NULL )  \n" +
//            "            ))  \n" +
//            "            AND (:deliveryStatus IS NULL OR  \n" +
//            "                (:deliveryStatus = '0' OR  \n" +
//            "                (:deliveryStatus = '1' AND i.sumPlanQuantity = 0) OR  \n" +
//            "                (:deliveryStatus = '2' AND i.sumActualQuantity < i.sumPlanQuantity AND i.sumActualQuantity > 0) OR  \n" +
//            "                (:deliveryStatus = '3' AND i.sumActualQuantity >= i.sumPlanQuantity )  \n" +
//            "            ))  \n" +
//            "            AND ( \n" +
//            "              :isClosed IS NULL  \n" +
//            "              OR ( \n" +
//            "                (:isClosed like '2')  \n" +
//            "                OR (:isClosed = '0' AND i.isClosed = '0')  \n" +
//            "                OR (:isClosed = '1' AND i.isClosed = '1')  \n" +
//            "              )  \n" +
//            "            )")
//    Page<SearchOutputListDto> getSearchList(
//            @Param("orderDateFrom") String orderDateFrom,
//            @Param("orderDateTo") String orderDateTo,
//            @Param("planOutputDateFrom") String planOutputDateFrom,
//            @Param("planOutputDateTo") String planOutputDateTo,
//            @Param("planWorkingDayFrom") String planWorkingDayFrom,
//            @Param("planWorkingDayTo") String planWorkingDayTo,
//            @Param("planDeliverDateFrom") String planDeliverDateFrom,
//            @Param("planDeliverDateTo") String planDeliverDateTo,
//            @Param("slipNoFrom") String slipNoFrom,
//            @Param("slipNoTo") String slipNoTo,
//            @Param("customerIdFrom") Integer customerIdFrom,
//            @Param("customerIdTo") Integer customerIdTo,
//            @Param("customerName") String customerName,
//            @Param("destinationIdFrom") Integer destinationIdFrom,
//            @Param("destinationIdTo") Integer destinationIdTo,
//            @Param("departmentName") String departmentName,
//            @Param("supplierIdFrom") Integer supplierIdFrom,
//            @Param("supplierIdTo") Integer supplierIdTo,
//            @Param("supplierName") String supplierName,
//            @Param("productIdFrom") Integer productIdFrom,
//            @Param("productIdTo") Integer productIdTo,
//            @Param("productName") String productName,
//            @Param("repositoryIdFrom") Integer repositoryIdFrom,
//            @Param("repositoryIdTo") Integer repositoryIdTo,
//            @Param("batchNo") String batchNo,
//            @Param("deliveryType") String deliveryType,
//            @Param("deliveryStatus") String deliveryStatus,
//            @Param("isClosed") String isClosed,
//            Pageable pageable
//    );


//    @Query(value = " SELECT   " +
//            "    a.inventory_output_id as inventoryOutputId,  " +
//            "    a.is_closed as isClosed ,  " +
//            "    a.output_status as outputStatus,  " +
//            "    a.slip_no as slipNo,  " +
//            "    a.plan_output_date as planOutputDate,  " +
//
//            "    a.order_date as orderDateFrom,  " +
//            "    a.order_date as orderDateTo,  " +
//            "    a.batch_status as batchStatus,  " +
//            "    a.actual_output_date as actualOutputDate,  " +
//            "    a.plan_working_date as planWorkingDate,  " +
//            "    a.plan_deliver_date as planDeliverDate,  " +
//            "    a.actual_deliver_date as actualDeliverDate,  " +
//            "    b.destination_code as destinationCode,  " +
//            "    b.department_name as departmentName,  " +
//            "    d.customer_code as customerCode,  " +
//            "    d.customer_name as customerName,  " +
//            "    f.repository_code as repositoryCode,  " +
//            "    f.repository_name as repositoryName,  " +
//            "    a.plan_supplier_slip_no as planSupplierSlipNo,  " +
//            "    a.actual_supplier_slip_no as actualSupplierSlipNo,  " +
//            "    a.sum_plan_quantity as sumPlanQuantity,  " +
//            "    a.sum_actual_quantity as sumActualQuantity  " +
//            "           FROM  " +
//            "             t_inventory_output a  " +
//            "                  left JOIN " +
//            "             t_inventory_plan_output_detail h ON a.inventory_output_id = h.inventory_output_id " +
//            "                    left JOIN " +
//            "               t_inventory_actual_output_detail k ON a.inventory_output_id = k.inventory_output_id " +
//            "                    left JOIN" +
//            "             m_customer_delivery_dest b ON a.plan_customer_delivery_destination_id = b.delivery_destination_id " +
//            "                   OR a.actual_customer_delivery_destination_id = b.delivery_destination_id " +
//            "                   left JOIN " +
//            "               m_customer d ON a.plan_customer_id = d.customer_id " +
//            "                    OR a.actual_customer_id = d.customer_id " +
//            "                   left JOIN " +
//            "                m_repository f ON a.plan_repository_id = f.repository_id " +
//            "                  OR a.actual_repository_id = f.repository_id " +
//            "                  left JOIN " +
//            "                m_supplier l ON h.supplier_id = l.supplier_id " +
//            "                  left JOIN " +
//            "                m_product m ON l.supplier_id = m.supplier_id " +
//            "            WHERE 1=1 " +
//            "               AND (:orderDateFrom is null or a.order_date >= :orderDateFrom) " +
//            "               AND (:orderDateTo is null or a.order_date <= :orderDateTo) " +
//            "                   AND (:planOutputDateFrom is null or a.plan_output_date >= :planOutputDateFrom) " +
//            "                   AND (:planOutputDateTo is null or a.plan_output_date <= :planOutputDateTo) " +
//            "                    AND (:planWorkingDayFrom is null or a.plan_working_date >= :planWorkingDayFrom) " +
//            "                    AND (:planWorkingDayTo is null or a.plan_working_date <= :planWorkingDayTo) " +
//            "                    AND (:planDeliverDateFrom is null or a.plan_deliver_date >= :planDeliverDateFrom) " +
//            "                    AND (:planDeliverDateTo is null or a.plan_deliver_date <= :planDeliverDateTo) " +
//            "                   AND (:slipNoFrom is null or  a.slip_no >= :slipNoFrom) " +
//            "                   AND (:slipNoTo is null or a.slip_no <= :slipNoTo ) " +
//            "                  AND (:customerIdFrom is null or d.customer_id >= :customerIdFrom) " +
//            "                  AND (:customerIdTo is null or d.customer_id <= :customerIdTo) " +
//            "                   AND (d.customer_name is null or d.customer_name LIKE CONCAT('%', :customerName, '%')) " +
//            "                   AND (:destinationIdFrom is null or b.delivery_destination_id >= :destinationIdFrom) " +
//            "                   AND (:destinationIdTo is null or b.delivery_destination_id <= :destinationIdTo) " +
//            "                   AND (b.department_name is null or b.department_name LIKE CONCAT('%', :departmentName, '%')) " +
//            "                  AND (:repositoryIdFrom is null or f.repository_id >= :repositoryIdFrom) " +
//            "                  AND (:repositoryIdTo is null or f.repository_id <= :repositoryIdTo) " +
//            "                   AND (:supplierIdFrom is null or l.supplier_id >= :supplierIdFrom) " +
//            "                   AND (:supplierIdTo is null or l.supplier_id <= :supplierIdTo) " +
//            "                   AND (l.supplier_name is null or l.supplier_name LIKE CONCAT('%', :supplierName, '%')) " +
//            "                AND (:productIdFrom is null or m.product_id >= :productIdFrom) " +
//            "                AND (:productIdTo is null or m.product_id <= :productIdTo) " +
//            "                  AND ((m.name1 is null or m.name1 LIKE CONCAT('%', :productName, '%')) " +
//            "                  OR (m.name2 is null or m.name2 LIKE CONCAT('%', :productName, '%')) " +
//            "                   OR (m.name3 is null or m.name3 LIKE CONCAT('%', :productName, '%')) " +
//            "                    OR (m.name4 is null or m.name4 LIKE CONCAT('%', :productName, '%'))" +
//            "                   OR (m.name5 is null or m.name5 LIKE CONCAT('%', :productName, '%'))) " +
//            "                  AND (h.batch_no is null or h.batch_no LIKE CONCAT('%', :batchNo, '%'))" +
//            "                    AND (:deliveryType = '0'or (:deliveryType = '1' and a.plan_output_date is not null)  or (:deliveryType = '2' and a.actual_output_date is not null)) " +
//            "                    AND (:deliveryStatus = '0' or (:deliveryStatus = '1' and a.sum_plan_quantity >0 and a.sum_actual_quantity=0) or (:deliveryStatus = '2' and a.sum_actual_quantity < a.sum_plan_quantity and a.sum_actual_quantity>0) or (:deliveryStatus = '3' and a.sum_actual_quantity >= a.sum_plan_quantity) ) " +
//            "                    AND (:isClosed = '0' or a.is_closed = :isClosed)" +
//            "           ORDER BY a.slip_no ASC ", nativeQuery = true)
//    Page<OutputListDto> getSearchList(
//            @Param("orderDateFrom") String orderDateFrom,
//            @Param("orderDateTo") String orderDateTo,
//            @Param("planOutputDateFrom") String planOutputDateFrom,
//            @Param("planOutputDateTo") String planOutputDateTo,
//            @Param("planWorkingDayFrom") String planWorkingDayFrom,
//            @Param("planWorkingDayTo") String planWorkingDayTo,
//            @Param("planDeliverDateFrom") String planDeliverDateFrom,
//            @Param("planDeliverDateTo") String planDeliverDateTo,
//            @Param("slipNoFrom") String slipNoFrom,
//            @Param("slipNoTo") String slipNoTo,
//            @Param("customerIdFrom") Integer customerIdFrom,
//            @Param("customerIdTo") Integer customerIdTo,
//            @Param("customerName") String customerName,
//            @Param("destinationIdFrom") Integer destinationIdFrom,
//            @Param("destinationIdTo") Integer destinationIdTo,
//            @Param("departmentName") String departmentName,
//            @Param("supplierIdFrom") Integer supplierIdFrom,
//            @Param("supplierIdTo") Integer supplierIdTo,
//            @Param("supplierName") String supplierName,
//            @Param("productIdFrom") Integer productIdFrom,
//            @Param("productIdTo") Integer productIdTo,
//            @Param("productName") String productName,
//            @Param("repositoryIdFrom") Integer repositoryIdFrom,
//            @Param("repositoryIdTo") Integer repositoryIdTo,
//            @Param("batchNo") String batchNo,
//            @Param("deliveryType") String deliveryType,
//            @Param("deliveryStatus") String deliveryStatus,
//            @Param("isClosed") String isClosed,
//            Pageable pageable
//    );

    //Version 3

//    @Query(value = "SELECT new org.api.bean.dto.SearchOutputListDto(" +
//            "             a.inventory_output_id , " +
//            "           a.is_closed , " +
//            "           a.output_status , " +
//            "            a.slip_no , " +
//            "            a.plan_output_date , " +
//            "            Min(a.order_date) , " +
//            "                Max(a.order_date), " +
//            "           a.batch_status , " +
//            "          a.actual_output_date, " +
//            "           a.plan_working_date ," +
//            "              a.plan_deliver_date , " +
//            "           a.actual_deliver_date , " +
//            "           b.destinatonCode ," +
//            "              b.departmentName ," +
//            "               d.customerCode ," +
//            "               d.customerName , " +
//            "              f.repository_code ," +
//            "              f.repository_name , " +
//            "              a.plan_supplier_slip_no , " +
//            "            a.actual_supplier_slip_no , " +
//            "              a.sum_plan_quantity , " +
//            "              a.sum_actual_quantity )" +
//            "           FROM  " +
//            "             InventoryOutputEntity a  " +
//            "                  left JOIN " +
//            "              InventoryPlanOutputDetailEntity h ON a.inventory_output_id = h.inventory_output_id " +
//            "                    left JOIN " +
//            "               InventoryActualOutputDetailEntity k ON a.inventory_output_id = k.inventory_output_id" +
//            "                    left JOIN" +
//            "             CustomerDeliveryDestEntity b ON a.plan_customer_delivery_destination_id = b.deliveryDestination_id" +
//            "                   OR a.actual_customer_delivery_destination_id = b.deliveryDestination_id" +
//            "                   left JOIN " +
//            "               CustomerEntity d ON a.plan_customer_id = d.customerId " +
//            "                    OR a.actual_customer_id = d.customerId" +
//            "                   left JOIN " +
//            "                RepositoryEntity f ON a.plan_repository_id = f.repository_id " +
//            "                  OR a.actual_repository_id = f.repository_id " +
//            "                  left JOIN " +
//            "                SupplierEntity l ON h.supplier_id = l.supplierId " +
//            "                  left JOIN " +
//            "                ProductEntity m ON l.supplierId = m.supplierId" +
//            "            WHERE 1=1 " +
//            "               AND (:orderDateFrom is null or a.order_date >= :orderDateFrom) " +
//            "               AND (:orderDateTo is null or a.order_date <= :orderDateTo) " +
//            "                   AND (:planOutputDateFrom is null or a.plan_output_date >= :planOutputDateFrom) " +
//            "                   AND (:planOutputDateTo is null or a.plan_output_date <= :planOutputDateTo) " +
//            "                    AND (:planWorkingDayFrom is null or a.plan_working_date >= :planWorkingDayFrom) " +
//            "                    AND (:planWorkingDayTo is null or a.plan_working_date <= :planWorkingDayTo) " +
//            "                    AND (:planDeliverDateFrom is null or a.plan_deliver_date >= :planDeliverDateFrom) " +
//            "                    AND (:planDeliverDateTo is null or a.plan_deliver_date <= :planDeliverDateTo) " +
//            "                   AND (:slipNoFrom is null or  a.slip_no >= :slipNoFrom) " +
//            "                   AND (:slipNoTo is null or a.slip_no <= :slipNoTo ) " +
//            "                  AND (:customerIdFrom is null or d.customerId >= :customerIdFrom) " +
//            "                  AND (:customerIdTo is null or d.customerId <= :customerIdTo) " +
//            "                   AND d.customerName is null or d.customerName LIKE CONCAT('%', :customerName, '%') " +
//            "                   AND (:destinationIdFrom is null or b.deliveryDestination_id >= :destinationIdFrom) " +
//            "                   AND (:destinationIdTo is null or b.deliveryDestination_id <= :destinationIdTo) " +
//            "                   AND b.departmentName is null or b.departmentName LIKE CONCAT('%', :departmentName, '%') " +
//            "                  AND (:repositoryIdFrom is null or f.repository_id >= :repositoryIdFrom) " +
//            "                  AND (:repositoryIdTo is null or f.repository_id <= :repositoryIdTo) " +
//            "                   AND (:supplierIdFrom is null or l.supplierId >= :supplierIdFrom) " +
//            "                   AND (:supplierIdTo is null or l.supplierId <= :supplierIdTo) " +
//            "                   AND l.supplierName is null or l.supplierName LIKE CONCAT('%', :supplierName, '%') " +
//            "                AND (:productIdFrom is null or m.productId >= :productIdFrom) " +
//            "                AND (:productIdTo is null or m.productId <= :productIdTo) " +
//            "                  AND (m.name1 is null or m.name1 LIKE CONCAT('%', :productName, '%') " +
//            "                  OR m.name2 is null or m.name2 LIKE CONCAT('%', :productName, '%') " +
//            "                   OR m.name3 is null or m.name3 LIKE CONCAT('%', :productName, '%') " +
//            "                    OR m.name4 is null or m.name4 LIKE CONCAT('%', :productName, '%')" +
//            "                   OR m.name5 is null or m.name5 LIKE CONCAT('%', :productName, '%')) " +
//            "                  AND h.batch_no is null or h.batch_no LIKE CONCAT('%', :batchNo, '%')" +
//            "                    AND ((:deliveryType = '1' and a.plan_output_date is not null)  or (:deliveryType = '2' and a.plan_output_date is null) or :deliveryType = '0') " +
//            "                    AND ((:deliveryStatus = '1' and a.sum_plan_quantity >0 and a.sum_actual_quantity=0) or (:deliveryStatus = '2' and a.sum_actual_quantity < a.sum_plan_quantity) or (:deliveryStatus = '3' and a.sum_actual_quantity >= a.sum_plan_quantity)  or :deliveryStatus = '0') " +
//            "                    AND (a.is_closed = :isClosed)" +
//            "           GROUP BY a.inventory_output_id  " +
//            "           ORDER BY a.slip_no ASC ")
//    Page<SearchOutputListDto> getSearchList(
//            @Param("orderDateFrom") String orderDateFrom,
//            @Param("orderDateTo") String orderDateTo,
//            @Param("planOutputDateFrom") String planOutputDateFrom,
//            @Param("planOutputDateTo") String planOutputDateTo,
//            @Param("planWorkingDayFrom") String planWorkingDayFrom,
//            @Param("planWorkingDayTo") String planWorkingDayTo,
//            @Param("planDeliverDateFrom") String planDeliverDateFrom,
//            @Param("planDeliverDateTo") String planDeliverDateTo,
//            @Param("slipNoFrom") String slipNoFrom,
//            @Param("slipNoTo") String slipNoTo,
//            @Param("customerIdFrom") Integer customerIdFrom,
//            @Param("customerIdTo") Integer customerIdTo,
//            @Param("customerName") String customerName,
//            @Param("destinationIdFrom") Integer destinationIdFrom,
//            @Param("destinationIdTo") Integer destinationIdTo,
//            @Param("departmentName") String departmentName,
//            @Param("supplierIdFrom") Integer supplierIdFrom,
//            @Param("supplierIdTo") Integer supplierIdTo,
//            @Param("supplierName") String supplierName,
//            @Param("productIdFrom") Integer productIdFrom,
//            @Param("productIdTo") Integer productIdTo,
//            @Param("productName") String productName,
//            @Param("repositoryIdFrom") Integer repositoryIdFrom,
//            @Param("repositoryIdTo") Integer repositoryIdTo,
//            @Param("batchNo") String batchNo,
//            @Param("deliveryType") String deliveryType,
//            @Param("deliveryStatus") String deliveryStatus,
//            @Param("isClosed") String isClosed,
//            Pageable pageable
//    );


//    SELECT " +
//            "             a.inventory_output_id AS inventoryOutputId, " +
//            "           a.is_closed AS isClosed, " +
//            "           a.output_status AS outputStatus, " +
//            "            a.slip_no AS slipNo, " +
//            "            a.plan_output_date AS planOutputDate, " +
//            "           a.batch_status AS batchStatus, " +
//            "            Min(a.order_date) AS orderDateFrom, " +
//            "                Max(a.order_date) AS orderDateTo, " +
//            "          a.actual_output_date AS actualOutputDate, " +
//            "           a.plan_working_date AS planWorkingDate, " +
//            "              a.plan_deliver_date AS planDeliverDate, " +
//            "           a.actual_deliver_date AS actualDeliverDate, " +
//            "           b.destination_code AS destinationCode," +
//            "              b.department_name AS departmentName," +
//            "               d.customer_code AS customerCode," +
//            "               d.customer_name AS customerName, " +
//            "              f.repository_code AS repositoryCode," +
//            "              f.repository_name AS repositoryName, " +
//            "              a.plan_supplier_slip_no AS planSupplierSlipNo, " +
//            "            a.actual_supplier_slip_no AS actualSupplierSlipNo, " +
//            "              a.sum_plan_quantity AS sumPlanQuantity, " +
//            "              a.sum_actual_quantity AS sumActualQuantity " +
//            "           FROM  " +
//            "             db_zaika.t_inventory_output a  " +
//            "                  left JOIN " +
//            "             db_zaika.m_customer_delivery_dest b ON a.plan_customer_delivery_destination_id = b.delivery_destination_id" +
//            "                   OR a.actual_customer_delivery_destination_id = b.delivery_destination_id" +
//            "                   left JOIN " +
//            "               db_zaika.m_customer d ON a.plan_customer_id = d.customer_id " +
//            "                    OR a.actual_customer_id = d.customer_id" +
//            "                   left JOIN " +
//            "                db_zaika.m_repository f ON a.plan_repository_id = f.repository_id " +
//            "                  OR a.actual_repository_id = f.repository_id " +
//            "                  left JOIN " +
//            "              db_zaika.t_inventory_plan_output_detail h ON a.inventory_output_id = h.inventory_output_id " +
//            "                    left JOIN " +
//            "               db_zaika.t_inventory_actual_output_detail k ON a.inventory_output_id = k.inventory_output_id" +
//            "                    left JOIN" +
//            "                db_zaika.m_supplier l ON h.supplier_id = l.supplier_id " +
//            "                  left JOIN " +
//            "                db_zaika.m_product m ON l.supplier_id = m.supplier_id" +
//            "            WHERE " +
//            "               a.order_date BETWEEN :orderDateFrom AND :orderDateTo " +
//            "                   AND a.plan_output_date BETWEEN :planOutputDateFrom AND :planOutputDateTo " +
//            "                    AND a.plan_working_date BETWEEN :planWorkingDayFrom AND :planWorkingDayTo " +
//            "                    AND a.plan_deliver_date BETWEEN :planDeliverDateFrom AND :planDeliverDateTo" +
//            "                   AND a.slip_no BETWEEN :slipNoFrom AND :slipNoTo " +
//            "                  AND d.customer_id BETWEEN :customerIdFrom AND :customerIdTo " +
//            "                   AND d.customer_name LIKE CONCAT('%', :customerName, '%') " +
//            "                   AND b.delivery_destination_id BETWEEN :destinationIdFrom AND :destinationIdTo " +
//            "                   AND b.department_name LIKE CONCAT('%', :departmentName, '%') " +
//            "                  AND f.repository_id BETWEEN :repositoryIdFrom AND :repositoryIdTo " +
//            "                   AND l.supplier_id BETWEEN :supplierIdFrom AND :supplierIdTo " +
//            "                   AND l.supplier_name LIKE CONCAT('%', :supplierName, '%') " +
//            "                AND m.product_id BETWEEN :productIdFrom AND :productIdTo " +
//            "                  AND (m.name1 LIKE CONCAT('%', :productName, '%') " +
//            "                  OR m.name2 LIKE CONCAT('%', :productName, '%') " +
//            "                   OR m.name3 LIKE CONCAT('%', :productName, '%') " +
//            "                    OR m.name4 LIKE CONCAT('%', :productName, '%')" +
//            "                   OR m.name5 LIKE CONCAT('%', :productName, '%')) " +
//            "                  AND h.batch_no LIKE CONCAT('%', :batchNo, '%')" +
//            "                    AND a.is_closed = :isClosed " +
//            "           GROUP BY a.inventory_output_id, a.slip_no  " +
//            "           ORDER BY a.slip_no ASC

}

