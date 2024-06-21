package org.api.repository.sql;

public class InventoryInputQuery {

    public static final String FIND_WITH_FILTERS="SELECT new org.api.bean.reponse.dto.InventoryInputListDTO( " +
            " i.inventory_input_id, " +
            " i.input_plan_date, " +
            " i.input_actual_date, " +
            " sd.destinatonCode, " +
            " sd.departmentName, " +
            " s.supplierCode, " +
            " s.supplierName, " +
            " c.customerCode, " +
            " c.customerName, " +
            " r.repositoryCode, " +
            " r.repositoryName, " +
            " i.plan_slip_note " +
            " i.plan_supplier_slip_no, " +
            " i.actual_supplier_slip_no, " +
            " i.sum_plan_quantity, " +
            " i.sum_actual_quantity " +
            " ) "+
            " FROM InventoryInputEntity i "+
            " LEFT JOIN SupplierDeliveryDestEntity sd ON i.plan_supplier_delivery_destination_id = sd.deliveryDestinationId " +
            " LEFT JOIN SupplierEntity s ON i.actual_supplier_id = s.supplierId  " +
            " LEFT JOIN CustomerEntity c ON i.product_owner_id = c.customerId  " +
            " LEFT JOIN ProductEntity p ON " +
            " LEFT JOIN RepositoryEntity r ON i.plan_repository_id=r.repository_id " +
            " WHERE i.delFlg='0' " +
            " AND (:inputPlanDateFrom IS NULL i.input_plan_date >= :inputPlanDateFrom) " +
            " AND (:inputPlanDateTo IS NULL i.input_plan_date <= :inputPlanDateTo) " +
            " AND (:inputActualDateFrom IS NULL i.input_actual_date >= :inputActualDateFrom) " +
            " AND (:inputActualDateTo IS NULL i.input_actual_date <= :inputActualDateTo) " +
            " AND (:slipNoFrom IS NULL i.slip_no >= :slipNoFrom) " +
            " AND (:slipNoTo IS NULL i.slip_no <= :slipNoTo) " +
            " AND (:destinationCodeFrom IS NULL OR sd.deliveryDestinationId IN (SELECT deliveryDestinationId FROM SupplierDeliveryDestEntity WHERE destinationCode >= :destinationCodeFrom)) " +
            " AND (:destinationCodeTo IS NULL OR sd.deliveryDestinationId IN (SELECT deliveryDestinationId FROM SupplierDeliveryDestEntity WHERE destinationCode <= :destinationCodeTo)) " +
            " AND (:departmentName IS NULL OR sd.departmentName LIKE CONCAT('%', :departmentName , '%') " +
            " AND (:supplierCodeFrom IS NULL OR s.supplierId IN (SELECT supplierId FROM SupplierEntity WHERE supplierCode >= :supplierCodeFrom))" +
            " AND (:supplierCodeTo IS NULL OR s.supplierId IN (SELECT supplierId FROM SupplierEntity WHERE supplierCode <= :supplierCodeTo))" +
            " AND (:supplierName IS NULL OR s.supplierName LIKE CONCAT('%', :supplierName ,'%' )" +
            " AND (:customerCodeFrom IS NULL OR c.customerId IN (SELECT customerId FROM CustomerEntity WHERE customerCode >= :customerCodeFrom))" +
            " AND (:customerCodeTo IS NULL OR c.customerId IN (SELECT customerId FROM CustomerEntity WHERE customerCode <= :customerCodeTo))" +
            " AND (:customerName IS NULL OR c.customerName LIKE CONCAT('%' ,:customerName ,'%')) " +
            " AND (:productCodeFrom IS NULL OR p.)" ;


}
