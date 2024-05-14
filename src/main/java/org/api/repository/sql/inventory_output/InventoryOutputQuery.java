package org.api.repository.sql.inventory_output;

public class InventoryOutputQuery {
    public static final String SELECT_JOIN_CONDITION =
            "SELECT new org.api.dto.inventory_output.reponse.search.InventoryOutputListDTO(a.inventory_output_id, " +
                    "a.is_closed, a.output_status, a.slip_no, a.plan_output_date, a.batch_status, a.order_date, a.plan_output_date, " +
                    "a.actual_output_date, a.plan_working_date, a.actual_output_date, a.plan_deliver_date, a.actual_deliver_date, " +
                    "b.destinationCode, b.departmentName, c.destinationCode, c.departmentName, d.customerCode, d.customerName, " +
                    "e.customerCode, e.customerName, f.repository_code, f.repository_name, g.repository_code, g.repository_name, " +
                    "a.plan_supplier_slip_no, a.actual_supplier_slip_no, a.sum_plan_quantity, a.sum_actual_quantity) " +
                    "FROM InventoryOutputEntity a " +
                    "INNER JOIN CustomerDeliveryDestEntity b ON a.plan_customer_delivery_destination_id = b.deliveryDestination_id " +
                    "INNER JOIN  SupplierDeliveryDestEntity c ON a.actual_customer_delivery_destination_id = c.deliveryDestination_id " +
                    "INNER JOIN CustomerEntity d ON a.plan_customer_id = d.customerId " +
                    "INNER JOIN CustomerEntity e ON a.actual_customer_id = e.customerId " +
                    "INNER JOIN RepositoryEntity f ON a.plan_repository_id = f.repository_id " +
                    "INNER JOIN RepositoryEntity g ON a.actual_repository_id = g.repository_id"
                    + " Where a.delFlg = '0' ";
}
