package org.api.repository.sql;

import org.api.services.impl.InventoryOutputServiceImpl;

public class InventoryOutputQuery {


    public  static final String CHECK_SLIP_NO="SELECT COUNT(io) > 0 FROM InventoryOutputEntity io WHERE io.slip_no = :slipNo";


    public static final String FIND_WITH_FILTERS = " SELECT new org.api.bean.reponse.dto.InventoryOutputListDTO(  " +
            "    i.inventory_output_id, " +
            "    i.is_closed, " +
            "    i.output_status, " +
            "    i.slip_no, " +
            "    s.supplierCode, " +
            "    i.plan_output_date ," +
            "    i.batch_status, " +
            "    i.order_date, " +
            "    i.actual_output_date, " +
            "    i.plan_working_date, " +
            "    i.plan_deliver_date, " +
            "    i.actual_deliver_date, " +
            "    cd.destinationCode, " +
            "    cd.deliveryDestinationId, " +
            "    sd.departmentName, " +
            "    c.customerCode, " +
            "    c.customerName, " +
            "    r.repositoryCode, " +
            "    r.repositoryName, " +
            "    i.plan_supplier_slip_no, " +
            "    i.actual_supplier_slip_no, " +
            "    i.sum_plan_quantity, " +
            "    i.sum_actual_quantity " +
            ") " +
            "FROM InventoryOutputEntity i " +
            "LEFT JOIN SupplierDeliveryDestEntity sd ON i.plan_customer_delivery_destination_id = sd.deliveryDestinationId " +
            "LEFT JOIN CustomerDeliveryDestEntity cd ON i.actual_customer_delivery_destination_id = cd.deliveryDestinationId " +
            "LEFT JOIN SupplierEntity s ON sd.supplierId = s.supplierId " +
            "LEFT JOIN InventoryActualOutputDetailEntity t ON i.inventory_output_id = t.actual_detail_id " +
            "LEFT JOIN CustomerEntity c ON i.plan_customer_id = c.customerId " +
            "LEFT JOIN ProductEntity p ON t.product_id = p.productId " +
            "LEFT JOIN RepositoryEntity r ON i.plan_repository_id = r.repository_id "+
            "WHERE i.delFlg='0' " +
            "AND (:repositoryIdFrom IS NULL OR r.repository_id >= :repositoryIdFrom) " +
            "AND (:repositoryIdTo IS NULL OR r.repository_id <= :repositoryIdTo) " +
            "AND (:orderDateFrom IS NULL OR i.order_date >= :orderDateFrom) " +
            "AND (:orderDateTo IS NULL OR i.order_date <= :orderDateTo) " +
            "AND (:planOutputDateFrom IS NULL OR i.plan_output_date >= :planOutputDateFrom) " +
            "AND (:planOutputDateTo IS NULL OR i.plan_output_date <= :planOutputDateTo) " +
            "AND (:planWorkingDateTo IS NULL OR i.plan_working_date >= :planWorkingDateFrom) " +
            "AND (:planWorkingDateTo IS NULL OR i.plan_working_date <= :planWorkingDateTo) " +
            "AND (:planDeliverDateFrom IS NULL OR i.plan_deliver_date >= :planDeliverDateFrom) " +
            "AND (:planDeliverDateTo IS NULL OR i.plan_deliver_date <= :planDeliverDateTo) " +
            "AND (:slipNoFrom IS NULL OR i.slip_no >= :slipNoFrom) " +
            "AND (:slipNoTo IS NULL OR i.slip_no <= :slipNoTo) " +
            " AND (:destinationCodeFrom IS NULL OR cd.deliveryDestinationId IN (SELECT deliveryDestinationId FROM CustomerDeliveryDestEntity WHERE destinationCode >= :destinationCodeFrom)) " +
            " AND (:destinationCodeTo IS NULL OR cd.deliveryDestinationId IN (SELECT deliveryDestinationId FROM CustomerDeliveryDestEntity WHERE destinationCode <= :destinationCodeTo)) " +
            " AND (:departmentName IS NULL OR cd.departmentName LIKE CONCAT('%', :departmentName, '%')) " +
            " AND (:supplierCodeFrom IS NULL OR s.supplierId IN (SELECT supplierId FROM SupplierEntity WHERE supplierCode >= :supplierCodeFrom))" +
            " AND (:supplierCodeTo IS NULL OR s.supplierId IN (SELECT supplierId FROM SupplierEntity WHERE supplierCode <= :supplierCodeTo))" +
            " AND (:supplierName IS NULL OR s.supplierName LIKE CONCAT('%', :supplierName, '%')) " +
            " AND (:customerCodeFrom IS NULL OR c.customerId IN (SELECT customerId FROM CustomerEntity  WHERE customerCode >=:customerCodeFrom))" +
            " AND (:customerCodeTo IS NULL OR c.customerId IN (SELECT customerId FROM CustomerEntity  WHERE customerCode <=:customerCodeTo))"+
            " AND (:customerName IS NULL OR c.customerName LIKE CONCAT('%', :customerName, '%')) " +
            " AND (:batchNo IS NULL OR t.batch_no LIKE CONCAT('%', :batchNo, '%')) " +
            " AND (:productCodeFrom IS NULL OR p.productId IN (SELECT productId FROM ProductEntity WHERE productCode >= :productCodeFrom)) " +
            " AND (:productCodeTo IS NULL OR p.productId IN (SELECT productId FROM ProductEntity WHERE productCode <= :productCodeTo))"+
            " AND (:productName IS NULL OR p.productId IN " +
            "    (SELECT p.productId FROM ProductEntity p WHERE " +
            "    p.name1 LIKE CONCAT('%', :productName, '%') " +
            "    OR p.name2 LIKE CONCAT('%', :productName, '%') " +
            "    OR p.name3 LIKE CONCAT('%', :productName, '%') " +
            "    OR p.name4 LIKE CONCAT('%', :productName, '%') " +
            "    OR p.name5 LIKE CONCAT('%', :productName, '%') " +
            ")) "+
            "AND (:DeliveryType IS NULL OR " +
            "    (:DeliveryType = '0' OR " +
            "    (:DeliveryType = '1' AND i.plan_output_date IS NOT NULL AND i.actual_output_date IS NULL) OR " +
            "    (:DeliveryType = '2' AND i.actual_output_date IS NOT NULL AND i.plan_output_date IS NULL) " +
            ")) " +
            "AND (:DeliveryStatus IS NULL OR " +
            "    (:DeliveryStatus = '0' OR " +
            "    (:DeliveryStatus = '1' AND i.sum_actual_quantity = 0) OR " +
            "    (:DeliveryStatus = '2' AND i.sum_actual_quantity < i.sum_plan_quantity AND i.sum_actual_quantity > 0) OR " +
            "    (:DeliveryStatus = '3' AND i.sum_actual_quantity >= i.sum_plan_quantity ) " +
            ")) " +
            "AND (" +
            "  :isClosed IS NULL " +
            "  OR (" +
            "    (:isClosed like '2') " +
            "    OR (:isClosed = '0' AND i.is_closed = '0') " +
            "    OR (:isClosed = '1' AND i.is_closed = '1') " +
            "  ) " +
            ")";



}
