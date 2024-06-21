package org.api.repository.sql;

public class GetPlanOutputIDQuery {
    public static final String GET_PLAN_OUTPUT_ID_QUERY = "SELECT new org.api.bean.reponse.dto.InventoryOutputPlanDTO(\n" +
            "    iou.inventory_output_id,\n" +
            "    iou.company_id,\n" +
            "    iou.deliver_destination_name,\n" +
            "    cd.postCode,\n" +
            "    cd.phoneNumber,\n" +
            "    cd.faxNumber,\n" +
            "    cd.address1,\n" +
            "    cd.address2,\n" +
            "    cd.address3,\n" +
            "    cd.address4,\n" +
            "    iou.route_code,\n" +
            "    iou.course_code,\n" +
            "    iou.order_date,\n" +
            "    iou.plan_output_date,\n" +
            "    iou.plan_working_date,\n" +
            "    iou.plan_deliver_date,\n" +
            "    iou.plan_supplier_slip_no,\n" +
            "    iou.create_slip_type,\n" +
            "    iou.slip_no,\n" +
            "    iou.slip_note,\n" +
            "    iou.plan_repository_id,\n" +
            "    iou.batch_status,\n" +
            "    iou.output_status,\n" +
            "    iou.is_closed,\n" +
            "    iou.checked,\n" +
            "    cd.destinationCode,\n" +
            "    cd.departmentName,\n" +
            "    c.customerCode,\n" +
            "    c.customerName\n" +
            ")\n" +
            "FROM\n" +
            "    InventoryOutputEntity iou\n" +
            "LEFT JOIN\n" +
            "    CustomerEntity c ON c.customerId = iou.plan_customer_id\n" +
            "LEFT JOIN\n" +
            "   CustomerDeliveryDestEntity cd ON cd.deliveryDestinationId = iou.plan_customer_delivery_destination_id\n" +
            "WHERE\n" +
            "    iou.delFlg = '0' AND\n" +
            "    c.delFlg = '0' AND\n" +
            "    cd.delFlg = '0' AND\n" +
            "    iou.inventory_output_id = :inventoryOutputId\n";
}
