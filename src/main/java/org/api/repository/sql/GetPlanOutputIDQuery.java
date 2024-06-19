package org.api.repository.sql;

public class GetPlanOutputIDQuery {
    public static final String GET_PLAN_OUTPUT_ID_QUERY = "SELECT new org.api.bean.reponse.dto.PlanOutputDTO(" +
            "i.inventory_output_id, " +
            "i.order_date, " +
            "i.plan_output_date, " +
            "i.plan_working_date, " +
            "i.plan_deliver_date, " +
            "i.create_slip_type, " +
            "i.slip_no, " +
            "i.plan_supplier_slip_no, " +
            "i.plan_customer_delivery_destination_id, " +
            "i.output_status, " +
            "i.is_closed, " +
            "cd.departmentName, " +
            "i.plan_customer_id, " +
            "c.customerName, " +
            "i.slip_note, " +
            "i.plan_repository_id, " +
            "i.sale_category, " +
            "c.routeCode, " +
            "c.courseCode, " +
            "cd.faxNumber, " +
            "cd.postCode, " +
            "cd.address1, " +
            "cd.address2, " +
            "cd.address3, " +
            "cd.address4) " +
            "FROM " +
            "InventoryOutputEntity i " +
            "LEFT JOIN CustomerDeliveryDestEntity cd ON i.plan_customer_delivery_destination_id = cd.deliveryDestinationId AND cd.delFlg='0' " +
            "LEFT JOIN CustomerEntity c ON i.plan_customer_id = c.customerId  AND c.delFlg='0' " +
            "WHERE i.delFlg='0' AND i.inventory_output_id = :key ";
}
