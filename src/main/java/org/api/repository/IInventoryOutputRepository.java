package org.api.repository;

import org.api.bean.dto.CustomerDestAddress;
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
            "                OR (:deliveryStatus = '3' AND i.sumActualQuantity >= i.sumPlanQuantity ))  " +
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


    @Query(value = "SELECT \n" +
            "    MAX(slip_no)\n" +
            "FROM\n" +
            "    t_inventory_output\n" +
            "WHERE\n" +
            "    slip_no LIKE CONCAT(:formattedDate, '%') AND del_flg = 0;"
            ,nativeQuery = true)
    String generateSlipNo(@Param("formattedDate") String formattedDate);
    @Query(value = "SELECT " +
            "    cdd.post_code AS postCode, " +
            "    cdd.address1 AS address1, " +
            "    cdd.address2 AS address2, " +
            "    cdd.address3 AS address3, " +
            "    cdd.address4 AS address4 " +
            "FROM\n" +
            "    m_customer_delivery_dest cdd " +
            "WHERE\n" +
            "    cdd.post_code = :postCode AND cdd.del_flg = 0;", nativeQuery = true)
    CustomerDestAddress getCustomerDestAddress(@Param("postCode") String postCode);


    //version using id
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


}

