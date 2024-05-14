package org.api.repository.sql;

public class InventoryOutputQuery {
    public static final String FIND_ALL = "SELECT new org.api.dto.InventoryOutputDto( " +
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
            "    b.destinatonCode, " +
            "    b.departmentName, " +
            "    c.destinatonCode, " +
            "    c.departmentName, " +
            "    d.customerCode, " +
            "    d.customerName, " +
            "    e.customerCode, " +
            "    e.customerName, " +
            "    f.repository_code, " +
            "    f.repository_name, " +
            "    g.repository_code , " +
            "    g.repository_name, " +
            "    a.plan_supplier_slip_no, " +
            "    a.actual_supplier_slip_no, " +
            "    a.sum_plan_quantity, " +
            "    a.sum_actual_quantity)  " +
            "FROM " +
            "    InventoryOutputEntity a  " +
            "        LEFT JOIN " +
            "    CustomerDeliveryDestEntity b ON a.plan_customer_delivery_destination_id = b.deliveryDestination_id " +
            "        LEFT JOIN " +
            "    CustomerDeliveryDestEntity c ON a.actual_customer_delivery_destination_id = c.deliveryDestination_id " +
            "        LEFT JOIN " +
            "    CustomerEntity d ON a.plan_customer_id = d.customerId " +
            "        LEFT JOIN " +
            "    CustomerEntity e ON a.actual_customer_id = e.customerId " +
            "        LEFT JOIN " +
            "    RepositoryEntity f ON a.plan_repository_id = f.repository_id " +
            "        LEFT JOIN " +
            "    RepositoryEntity g ON a.actual_repository_id = g.repository_id " +
            "WHERE a.delFlg = '0' ";
    public static final String ORDER_BY = " ORDER BY a.slip_no ASC ";
    public static final String ORDER_DATE_F = " AND a.order_date >= '2023/08/01' ";
    public static final String ORDER_DATE_T = " AND a.order_date <= :orderDateTo ";
    public static final String PLAN_OUTPUT_DATE_F = " AND a.plan_output_date >= '2023/08/01' ";
    public static final String PLAN_OUTPUT_DATE_T = " AND a.plan_output_date <= '2024/08/01' ";
    public static final String PLAN_WORKING_DATE = " AND a.plan_working_date BETWEEN '2023/08/01' AND  '2024/08/02' ";
    public static final String PLAN_WORKING_DATE_F = " AND a.plan_working_date >= '2023/08/01' ";
    public static final String PLAN_WORKING_DATE_T = " AND a.plan_working_date <= '2024/08/02' ";
    public static final String PLAN_DELIVERY_DATE = " AND a.plan_deliver_date BETWEEN '2023/08/01' AND  '2024/08/02' ";
    public static final String PLAN_DELIVERY_DATE_F = " AND a.plan_deliver_date >= '2023/08/01' ";
    public static final String PLAN_DELIVERY_DATE_T = " AND a.plan_deliver_date <=  '2024/08/02' ";
    public static final String SLIP_NO = " AND a.slip_no BETWEEN '1' AND '9999999999' ";
    public static final String SLIP_NO_F = " AND a.slip_no >= '1' ";
    public static final String SLIP_NO_T = " AND a.slip_no <= '9999999999' ";
    public static final String CUSTOMER_CODE = " AND (a.plan_customer_id BETWEEN 1 AND 999999999 OR a.actual_customer_id BETWEEN 1 AND 999999999) ";
    public static final String CUSTOMER_CODE_F = " AND (a.plan_customer_id >= 1 OR a.actual_customer_id >= 1 ) ";
    public static final String CUSTOMER_CODE_T = " AND (a.plan_customer_id <= 999999999 OR a.actual_customer_id <= 999999999) ";
    public static final String CUSTOMER_NAME = " AND (a.plan_customer_id IN (SELECT a1.customerId FROM CustomerEntity a1 WHERE a1.customerName LIKE CONCAT('%', '', '%')) OR a.actual_customer_id IN (SELECT a2.customerId FROM CustomerEntity a2 WHERE a2.customerName LIKE CONCAT('%', '', '%'))) ";
    public static final String DELIVERY_DESTINATION_CODE = " AND (a.plan_customer_delivery_destination_id BETWEEN 1 AND 99999999999999 " +
            "OR a.actual_customer_delivery_destination_id BETWEEN 1 AND 99999999999999) ";
    public static final String DELIVERY_DESTINATION_CODE_F = " AND (a.plan_customer_delivery_destination_id >= 1 OR a.actual_customer_delivery_destination_id >= 1 ) ";
    public static final String DELIVERY_DESTINATION_CODE_T = " AND (a.plan_customer_delivery_destination_id <= 99999999999999 " +
            "OR a.actual_customer_delivery_destination_id <= 99999999999999) ";
    public static final String DELIVERY_DESTINATION_NAME = " AND (a.plan_customer_delivery_destination_id IN (SELECT a3.deliveryDestination_id FROM CustomerDeliveryDestEntity a3 WHERE a3.departmentName LIKE CONCAT('%', '', '%') ) OR a.actual_customer_delivery_destination_id IN (SELECT a4.deliveryDestination_id FROM CustomerDeliveryDestEntity a4 WHERE a4.departmentName LIKE CONCAT('%', '', '%') )) ";
    public static final String SUPPLIER_CODE = "AND (a.inventory_output_id IN " +
            "(SELECT a5.inventory_output_id FROM InventoryOutputEntity a5 " +
            "INNER JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventory_output_id = a6.inventory_output_id " +
            "WHERE a6.supplier_id BETWEEN 1 AND 9999999999 " +
            "GROUP BY a5.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a7.inventory_output_id FROM InventoryOutputEntity a7 " +
            "INNER JOIN InventoryActualOutputDetailEntity a8 ON a7.inventory_output_id = a8.inventory_output_id " +
            "WHERE a8.supplier_id BETWEEN 1 AND 9999999999 " +
            "GROUP BY a7.inventory_output_id)) ";
    public static final String SUPPLIER_CODE_F = "AND (a.inventory_output_id IN " +
            "(SELECT a5.inventory_output_id FROM InventoryOutputEntity a5 " +
            "INNER JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventory_output_id = a6.inventory_output_id " +
            "WHERE a6.supplier_id >= 1  " +
            "GROUP BY a5.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a7.inventory_output_id FROM InventoryOutputEntity a7 " +
            "INNER JOIN InventoryActualOutputDetailEntity a8 ON a7.inventory_output_id = a8.inventory_output_id " +
            "WHERE a8.supplier_id >= 1  " +
            "GROUP BY a7.inventory_output_id)) ";
    public static final String SUPPLIER_CODE_T = "AND (a.inventory_output_id IN " +
            "(SELECT a5.inventory_output_id FROM InventoryOutputEntity a5 " +
            "INNER JOIN InventoryPlanOutputDetailEntity a6 ON a5.inventory_output_id = a6.inventory_output_id " +
            "WHERE a6.supplier_id <= 9999999999 " +
            "GROUP BY a5.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a7.inventory_output_id FROM InventoryOutputEntity a7 " +
            "INNER JOIN InventoryActualOutputDetailEntity a8 ON a7.inventory_output_id = a8.inventory_output_id " +
            "WHERE a8.supplier_id <= 9999999999 " +
            "GROUP BY a7.inventory_output_id)) ";
    public static final String SUPPLIER_NAME = "AND (a.inventory_output_id IN " +
            "(SELECT a9.inventory_output_id FROM InventoryOutputEntity a9 " +
            "INNER JOIN InventoryPlanOutputDetailEntity a0 ON a9.inventory_output_id = a0.inventory_output_id " +
            "INNER JOIN SupplierEntity b ON a0.supplier_id = b.supplierId " +
            "WHERE b.supplierName LIKE CONCAT('%', '', '%') " +
            "GROUP BY a9.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a9.inventory_output_id FROM InventoryOutputEntity a9 " +
            "INNER JOIN InventoryActualOutputDetailEntity a0 ON a9.inventory_output_id = a0.inventory_output_id " +
            "INNER JOIN SupplierEntity b ON a0.supplier_id = b.supplierId " +
            "WHERE b.supplierName LIKE CONCAT('%', '', '%') " +
            "GROUP BY a9.inventory_output_id) ) ";
    public static final String PRODUCT_ID = "AND (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id BETWEEN 1 AND 999999999 " +
            "GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id BETWEEN 1 AND 999999999 " +
            "GROUP BY a.inventory_output_id)) ";
    public static final String PRODUCT_ID_F = "AND (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id >= 1" +
            "GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id >= 1 " +
            "GROUP BY a.inventory_output_id)) ";
    public static final String PRODUCT_ID_T = "AND (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id <= 999999999 " +
            "GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.product_id <= 999999999 " +
            "GROUP BY a.inventory_output_id)) ";
    public static final String PRODUCT_NAME = "AND (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "INNER JOIN ProductEntity c ON b.product_id = c.productId " +
            "WHERE c.name1 LIKE CONCAT('%', '', '%') " +
            "OR c.name2 LIKE CONCAT('%', '', '%') " +
            "OR c.name3 LIKE CONCAT('%', '', '%') " +
            "OR c.name4 LIKE CONCAT('%', '', '%') " +
            "OR c.name5 LIKE CONCAT('%', '', '%') ) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "INNER JOIN ProductEntity c ON b.product_id = c.productId " +
            "WHERE c.name1 LIKE CONCAT('%', '', '%') " +
            "OR c.name2 LIKE CONCAT('%', '', '%') " +
            "OR c.name3 LIKE CONCAT('%', '', '%') " +
            "OR c.name4 LIKE CONCAT('%', '', '%') " +
            "OR c.name5 LIKE CONCAT('%', '', '%') )) ";
    public static final String REPOSITORY = " AND (a.plan_repository_id BETWEEN 1 AND 9999999999 " +
            "OR a.actual_repository_id BETWEEN 1 AND 9999999999) ";
    public static final String REPOSITORY_F = " AND (a.plan_repository_id >= 1 " +
            "OR a.actual_repository_id >= 1 ) ";
    public static final String REPOSITORY_T = " AND (a.plan_repository_id <= 9999999999 " +
            "OR a.actual_repository_id <= 9999999999) ";
    public static final String BATCH_NO = "AND (a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryPlanOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.batch_no LIKE CONCAT('%', '', '%') GROUP BY a.inventory_output_id) " +
            "OR a.inventory_output_id IN " +
            "(SELECT a.inventory_output_id FROM InventoryOutputEntity a " +
            "INNER JOIN InventoryActualOutputDetailEntity b ON a.inventory_output_id = b.inventory_output_id " +
            "WHERE b.batch_no LIKE CONCAT('%', '', '%') GROUP BY a.inventory_output_id)) ";
    public static final String DELIVERY_TYPE = " AND a.plan_output_date IS NOT NULL  ";
    public static final String DELIVERY_TYPE_PLAN = " AND a.plan_output_date IS NOT NULL  ";
    public static final String DELIVERY_TYPE_ACTUAL = " AND a.plan_output_date IS NULL  ";
    public static final String DELIVERY_STATUS = " AND a.output_status = :deliveryStatus ";
    public static final String DELIVERY_STATUS_NOTYET = " AND a.output_status = '0' ";
    public static final String DELIVERY_STATUS_REMAINING = " AND a.output_status = '1' ";
    public static final String DELIVERY_STATUS_DONE = " AND a.output_status = '2' ";
    public static final String IS_CLOSED = " AND a.is_closed = :isClose ";
    public static final String UNCLOSE = " AND a.is_closed = '0' ";
    public static final String CLOSED = " AND a.is_closed = '1' ";
}
