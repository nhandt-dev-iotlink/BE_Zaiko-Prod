package org.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.api.dto.InventoryOutputDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface InventoryOutputMapper {
    @Query(nativeQuery = true, value = "SELECT \n" +
            "    a.inventory_output_id,\n" +
            "    a.is_closed,\n" +
            "    a.output_status,\n" +
            "    a.slip_no,\n" +
            "    a.plan_output_date,\n" +
            "    a.batch_status,\n" +
            "    a.order_date,\n" +
            "    a.actual_output_date,\n" +
            "    a.plan_working_date,\n" +
            "    a.plan_deliver_date,\n" +
            "    a.actual_deliver_date,\n" +
            "    b.destination_code,\n" +
            "    b.department_name,\n" +
            "    c.destination_code,\n" +
            "    c.department_name,\n" +
            "    d.customer_code,\n" +
            "    d.customer_name,\n" +
            "    e.customer_code,\n" +
            "    e.customer_name,\n" +
            "    f.repository_code,\n" +
            "    f.repository_name,\n" +
            "    g.repository_code,\n" +
            "    g.repository_name,\n" +
            "    a.plan_supplier_slip_no,\n" +
            "    a.actual_supplier_slip_no,\n" +
            "    a.sum_plan_quantity,\n" +
            "    a.sum_actual_quantity\n" +
            "FROM\n" +
            "    t_inventory_output a \n" +
            "        RIGHT JOIN\n" +
            "    m_customer_delivery_dest b ON a.plan_customer_delivery_destination_id = b.delivery_destination_id\n" +
            "        RIGHT JOIN\n" +
            "    m_customer_delivery_dest c ON a.actual_customer_delivery_destination_id = c.delivery_destination_id\n" +
            "        RIGHT JOIN\n" +
            "    m_customer d ON a.plan_customer_id = d.customer_id\n" +
            "        RIGHT JOIN\n" +
            "    m_customer e ON a.actual_customer_id = e.customer_id\n" +
            "        RIGHT JOIN\n" +
            "    m_repository f ON a.plan_repository_id = f.repository_id\n" +
            "        RIGHT JOIN\n" +
            "    m_repository g ON a.actual_repository_id = g.repository_id ORDER BY a.slip_no ASC\n" +
            "LIMIT 50\n")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "price", column = "price")
//    })
    List<InventoryOutputDto> getAll();
}
