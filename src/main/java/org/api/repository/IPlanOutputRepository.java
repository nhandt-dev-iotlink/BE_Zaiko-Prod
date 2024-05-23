package org.api.repository;

import org.api.bean.dto.OutputDto;
import org.api.bean.jpa.InventoryOutputEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPlanOutputRepository extends BaseRepository<InventoryOutputEntity, Integer>{
    @Query(value = "SELECT \n" +
            "    io.inventory_output_id AS inventoryOutputId,\n" +
            "    io.output_status AS outputStatus,\n" +
            "    io.is_closed AS isClosed,\n" +
            "    io.sum_plan_quantity AS sumPlanQuantity,\n" +
            "    io.sum_actual_quantity AS sumActualQuantity,\n" +
            "    io.order_date AS orderDate,\n" +
            "    io.plan_output_date AS planOutputDate,\n" +
            "    io.plan_working_date AS planWorkingDate,\n" +
            "    io.plan_deliver_date AS planDeliverDate,\n" +
            "    cdd.lead_time as leadTime, " +
            "    io.create_slip_type AS createSlipType,\n" +
            "    io.slip_no AS slipNo,\n" +
            "    io.plan_supplier_slip_no AS planSupplierSlipNo,\n" +
            "    io.plan_customer_delivery_destination_id AS destinationCode,\n" +
            "    cdd.department_name AS departmentName,\n" +
            "    cus.customer_code AS customerCode,\n" +
            "    cus.customer_name AS customerName,\n" +
            "    io.slip_note AS slipNote,\n" +
            "    rep.repository_id AS repositoryId,\n" +
            "    rep.repository_code AS repositoryCode,\n" +
            "    rep.repository_name AS repositoryName,\n" +
            "    cus.route_code AS routeCode,\n" +
            "    rou.route_name AS routeName,\n" +
            "    cus.course_code AS courseCode,\n" +
            "    cdd.phone_number AS phoneNumber,\n" +
            "    cdd.fax_number AS faxNumber,\n" +
            "    cdd.post_code AS postCode,\n" +
            "    cdd.address1 AS address1,\n" +
            "    cdd.address2 AS address2,\n" +
            "    cdd.address3 AS address3,\n" +
            "    cdd.address4 AS address4\n" +
            "FROM\n" +
            "    t_inventory_output io\n" +
            "        JOIN\n" +
            "    m_customer_delivery_dest cdd ON io.plan_customer_delivery_destination_id = cdd.delivery_destination_id\n" +
            "        JOIN\n" +
            "    m_customer cus ON io.plan_customer_id = cus.customer_id\n" +
            "        JOIN\n" +
            "    m_repository rep ON io.plan_repository_id = rep.repository_id\n" +
            "        JOIN\n" +
            "    m_route rou ON cus.route_code = rou.route_code\n" +
            "WHERE\n" +
            "    io.inventory_output_id = :id",nativeQuery = true)
    OutputDto getOutputById(@Param("id") Integer id);


}
