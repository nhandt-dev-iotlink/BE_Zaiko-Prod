package org.api.repository;

import org.api.bean.dto.CustomerAndDestDto;
import org.api.bean.dto.OutputDto;
import org.api.bean.dto.OutputPlanDetailDto;
import org.api.bean.dto.ProductSearchDto;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPlanOutputRepository extends BaseRepository<InventoryPlanOutputDetailEntity, Integer> {
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
            "    cdd.destination_code AS destinationCode,\n" +
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
            "WHERE " +
            "    io.inventory_output_id = :id AND io.del_flg = 0;", nativeQuery = true)
    OutputDto getOutputById(@Param("id") Integer id);

    @Query(value = "select distinct\n" +
            "ipod.batch_status as batchStatus ,\n" +
            "ipod.batch_no as batchNo,\n" +
            "ipod.plan_detail_id as planDetailId,\n" +
            "ipod.inventory_output_id as inventoryOutputId,\n" +
            "ipod.datetime_mng_to as datetimeMngTo,\n" +
            "ipod.datetime_mng_from as datetimeMngFrom,\n" +
            "ipod.number_mng_to as numberMngTo,\n" +
            "ipod.number_mng_from as numberMngFrom,\n" +
            "pro.product_id as productId,\n" +
            "pro.product_code as productCode,\n" +
            "pro.name1 as productName,\n" +
            "pro.standard_info as standardInfo,\n" +
            "cus.customer_code as customerCode,\n" +
            "cus.customer_name as customerName,\n" +
            "cus.department_name as departmentName,\n" +
            "ipod.repository_id as repositoryId,\n" +
            "rep.repository_code as repositoryCode,\n" +
            "rep.repository_name as repositoryName,\n" +
            "ipod.location_id as locationId,\n" +
            "ipod.inventory_product_type as inventoryProductType,\n" +
            "ipod.billing_pack_type as billingPackType,\n" +
            "ipod.cs_plan_quantity as csPlanQuantity,\n" +
            "ipod.bl_plan_quantity as blPlanQuantity,\n" +
            "ipod.ps_plan_quantity as psPlanQuantity,\n" +
            "ipod.total_plan_quantity as totalPlanQuantity,\n" +
            "ipod.plan_cs_price as planCsPrice,\n" +
            "ipod.plan_bl_price as planBlPrice,\n" +
            "ipod.plan_piece_price as planPiecePrice,\n" +
            "ipod.plan_amount_total as planAmountTotal\n" +
            "from t_inventory_plan_output_detail ipod \n" +
            "join m_product pro on ipod.product_id = pro.product_id\n" +
            "join m_customer cus on ipod.product_owner_id = cus.customer_id\n" +
            "join m_repository rep on ipod.repository_id = rep.repository_id\n" +
            "where ipod.inventory_output_id= :id AND ipod.del_flg = 0; \n" +
            ";", nativeQuery = true)
    List<OutputPlanDetailDto> getPlanOutputDetail(@Param("id") Integer id);

    @Query(value = "select inventory_output_id AS inventoryOutputId from t_inventory_output where slip_no = :code", nativeQuery = true)
    OutputDto findOutputBySlipNo(@Param("code") String code);

    @Query(value = "SELECT \n" +
            "    cus.lead_time as leadTime, " +
            "    cdd.destination_code AS destinationCode,\n" +
            "    cdd.department_name AS departmentName,\n" +
            "    cus.customer_code AS customerCode,\n" +
            "    cus.customer_name AS customerName,\n" +
            "    cus.route_code AS routeCode,\n" +
            "    cus.course_code AS courseCode,\n" +
            "    cdd.phone_number AS phoneNumber,\n" +
            "    cdd.fax_number AS faxNumber,\n" +
            "    cdd.post_code AS postCode,\n" +
            "    cdd.address1 AS address1,\n" +
            "    cdd.address2 AS address2,\n" +
            "    cdd.address3 AS address3,\n" +
            "    cdd.address4 AS address4\n" +
            "FROM\n" +
            "    m_customer_delivery_dest cdd " +
            "        JOIN\n" +
            "    m_customer cus ON cdd.customer_id = cus.customer_id\n" +
            "        JOIN\n" +
            "    m_route rou ON cus.route_code = rou.route_code\n" +
            "WHERE\n" +
            "    cdd.destination_code = :code AND cus.del_flg = 0;", nativeQuery = true)
    CustomerAndDestDto getCustomerInfo(@Param("code") String code);

    @Query(value = "SELECT DISTINCT\n" +
            "    pro.product_code AS productCode,\n" +
            "    pro.name1 AS productName,\n" +
            "    pro.standard_info AS standardInfo,\n" +
            "    pro.datetime_mng_type AS datetimeMngType,\n" +
            "    pro.lead_time AS leadTime, " +
            "    pro.is_datetime_mng AS isDatetimeMng,\n" +
            "    pro.is_number_mng AS isNumberMng,\n" +
            "    pro.is_pack_cs_output AS isPackCsOutput,\n" +
            "    pro.is_pack_bl_output AS isPackBlOutput,\n" +
            "    pro.is_piece_output AS isPieceOutput,\n" +
            "    pro.pack_cs_amount AS packCsAmount,\n" +
            "    pro.pack_bl_amount AS packBlAmount,\n" +
            "    spr.pack_cs_price AS packCsPrice,\n" +
            "    spr.pack_bl_price AS packBlPrice,\n" +
            "    spr.piece_price AS piecePrice\n" +
            "FROM\n" +
            "    m_product pro\n" +
            "        LEFT JOIN\n" +
            "    m_sale_price spr ON pro.product_id = spr.product_id\n" +
            "WHERE\n" +
            "    pro.product_code = :code\n" +
            "        AND pro.del_flg = 0\n" +
            "        AND spr.del_flg = 0" +
            "        AND spr.piece_price = (SELECT \n" +
            "            MAX(piece_price)\n" +
            "        FROM\n" +
            "            m_sale_price\n" +
            "        WHERE\n" +
            "            product_code = :code)\n" +
            "        AND spr.pack_cs_price = (SELECT \n" +
            "            MAX(pack_cs_price)\n" +
            "        FROM\n" +
            "            m_sale_price\n" +
            "        WHERE\n" +
            "            product_code = :code)\n" +
            "        AND spr.pack_bl_price = (SELECT \n" +
            "            MAX(pack_bl_price)\n" +
            "        FROM\n" +
            "            m_sale_price\n" +
            "        WHERE\n" +
            "            product_code = :code);", nativeQuery = true)
    ProductSearchDto getProductInfor(@Param("code") String code);

    @Query(value = "SELECT DISTINCT\n" +
            "    pro.product_code AS productCode,\n" +
            "    pro.name1 AS productName,\n" +
            "    pro.standard_info AS standardInfo,\n" +
            "    pro.datetime_mng_type AS datetimeMngType,\n" +
            "    pro.lead_time AS leadTime, " +
            "    pro.is_datetime_mng AS isDatetimeMng,\n" +
            "    pro.is_number_mng AS isNumberMng,\n" +
            "    pro.is_pack_cs_output AS isPackCsOutput,\n" +
            "    pro.is_pack_bl_output AS isPackBlOutput,\n" +
            "    pro.is_piece_output AS isPieceOutput,\n" +
            "    pro.pack_cs_amount AS packCsAmount,\n" +
            "    pro.pack_bl_amount AS packBlAmount\n" +
            "FROM\n" +
            "    m_product pro\n" +

            "WHERE\n" +
            "    pro.product_code = :code\n" +
            "        AND pro.del_flg = 0\n" +
            "           ", nativeQuery = true)
    ProductSearchDto getProductInfo(@Param("code") String code);


    @Query(value = "select * from t_inventory_plan_output_detail where inventory_output_id = :inventoryOutputId ", nativeQuery = true)
    List<InventoryPlanOutputDetailEntity> findByInventoryOutputId(@Param("inventoryOutputId") Integer inventoryOutputId);
}
