package org.api.repository;

import org.api.bean.dto.InputListDto;
import org.api.bean.jpa.InventoryInputEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface IInventoryInputRepository extends BaseRepository<InventoryInputEntity, Integer>{

    @Query(value = "" +
            "select new org.api.bean.dto.InputListDto ( " +
            "i.inventoryInputId , " +
            "i.isClosed , " +
            "i.inputStatus , " +
            "i.slipNo, " +
            "i.inputPlanDate , " +
            "i.inputActualDate, " +
            "sdd.destinationCode, " +
            "sd.destinationCode, " +
            "sdd.departmentName, " +
            "sd.departmentName, " +
            "i.planSlipNote, " +
            "s.supplierCode, " +
            "s.supplierName, " +
            "c.customerCode, " +
            "c.customerName, " +
            "r.repositoryCode, " +
            "r.repositoryName, " +
            "rep.repositoryCode, " +
            "rep.repositoryName, " +
            "i.planSupplierSlipNo, " +
            "i.actualSupplierSlipNo, " +
            "i.sumPlanQuantity, " +
            "i.sumActualQuantity) " +
            "from InventoryInputEntity i " +
            "left join SupplierDeliveryDestEntity sd on i.actualSupplierDeliveryDestinationId= sd.deliveryDestinationId " +
            "left join SupplierDeliveryDestEntity sdd on i.planSupplierDeliveryDestinationId= sdd.deliveryDestinationId " +
            "left join SupplierEntity s on i.actualSupplierId = s.supplierId " +
            "left join CustomerEntity c on i.productOwnerId = c.customerId " +
            "left join RepositoryEntity rep on i.actualRepositoryId = rep.repositoryId " +
            "left join RepositoryEntity r on i.planRepositoryId = r.repositoryId " +
            "join InventoryActualInputDetailEntity aid on i.inventoryInputId = aid.inventoryInputId " +
            "join ProductEntity p ON aid.productId = p.productId " +
            " WHERE 1=1 " +
            " AND (:inputPlanDateFrom IS NULL OR i.inputPlanDate >= :inputPlanDateFrom) " +
            " AND (:inputPlanDateTo IS NULL OR i.inputPlanDate <= :inputPlanDateTo) " +
            " AND (:inputActualDateFrom IS NULL OR i.inputActualDate >= :inputActualDateFrom) " +
            " AND (:inputActualDateTo IS NULL OR i.inputActualDate <= :inputActualDateTo) " +
            " AND (:slipNoFrom IS NULL OR i.slipNo >= :slipNoFrom) " +
            " AND (:slipNoTo IS NULL OR i.slipNo <= :slipNoTo) " +
            " AND (:productOwnerIdFrom IS NULL OR i.productOwnerId >= :productOwnerIdFrom) " +
            " AND (:productOwnerIdTo IS NULL OR i.productOwnerId <= :productOwnerIdTo) " +
            " AND (:destinationIdFrom IS NULL OR sd.deliveryDestinationId >= :destinationIdFrom) " +
            " AND (:destinationIdTo IS NULL OR sd.deliveryDestinationId <= :destinationIdTo) " +
            " AND (:departmentName IS NULL OR sd.departmentName LIKE CONCAT('%', :departmentName, '%')) " +
            " AND (:supplierIdFrom IS NULL OR s.supplierId >= :supplierIdFrom) " +
            " AND (:supplierIdTo IS NULL OR s.supplierId <= :supplierIdTo) " +
            " AND (:supplierName IS NULL OR s.supplierName LIKE CONCAT('%', :supplierName, '%')) " +
            " AND (:customerIdFrom IS NULL OR c.customerId >= :customerIdFrom) " +
            " AND (:customerIdTo IS NULL OR c.customerId <= :customerIdTo) " +
            " AND (:customerName IS NULL OR c.customerName LIKE CONCAT('%', :customerName, '%')) " +
            " AND (:productIdFrom is null or p.productId >= :productIdFrom) " +
            " AND (:productIdTo is null or p.productId <= :productIdTo) " +
            " AND (:productName IS NULL OR p.productId IN " +
            " (SELECT p.productId FROM ProductEntity p WHERE " +
            " p.name1 LIKE CONCAT('%', :productName, '%') " +
            " OR p.name2 LIKE CONCAT('%', :productName, '%') " +
            " OR p.name3 LIKE CONCAT('%', :productName, '%') " +
            " OR p.name4 LIKE CONCAT('%', :productName, '%') " +
            " OR p.name5 LIKE CONCAT('%', :productName, '%') " +
            " )) " +
            " AND (:repositoryIdFrom IS NULL OR rep.repositoryId >= :repositoryIdFrom) " +
            " AND (:repositoryIdTo IS NULL OR rep.repositoryId <= :repositoryIdTo) " +

            " AND (:receiptType IS NULL OR " +
            " (:receiptType = '0' OR " +
            " (:receiptType = '1' AND i.inputPlanDate IS NOT NULL ) OR " +
            " (:receiptType = '2' AND i.inputActualDate IS NOT NULL ) " +
            " )) " +
            " AND (:receiptStatus IS NULL OR " +
            " (:receiptStatus = '0' OR " +
            " (:receiptStatus = '1' AND i.sumActualQuantity = 0) OR " +
            " (:receiptStatus = '2' AND i.sumActualQuantity < i.sumPlanQuantity AND i.sumActualQuantity > 0) OR " +
            " (:receiptStatus = '3' AND i.sumActualQuantity >= i.sumPlanQuantity ) " +
            " ))" +
            " AND " +
            " (( :isClosed IS NULL )" +
            " OR  " +
            " (:isClosed ='9') " +
            " OR (:isClosed = '0' AND i.isClosed = '0') " +
            " OR (:isClosed = '1' AND i.isClosed = '1'))" +
            "GROUP BY i.inventoryInputId" +
            " ORDER BY i.slipNo ASC " )
    Page<InputListDto> getSearchList(@RequestParam("inputPlanDateFrom") String inputPlanDateFrom,
                                     @RequestParam("inputPlanDateTo") String inputPlanDateTo,
                                     @RequestParam("inputPlanDateTo") String inputActualDateFrom,
                                     @RequestParam("inputPlanDateTo") String inputActualDateTo,
                                     @RequestParam("slipNoFrom") String slipNoFrom,
                                     @RequestParam("slipNoTo") String slipNoTo,
                                     @RequestParam("productOwnerIdFrom") String productOwnerIdFrom,
                                     @RequestParam("productOwnerIdTo") String productOwnerIdTo,
                                     @RequestParam("destinationIdFrom") Integer destinationIdFrom,
                                     @RequestParam("destinationIdTo") Integer destinationIdTo,
                                     @RequestParam("departmentName") String departmentName,
                                     @RequestParam("supplierIdFrom") Integer supplierIdFrom,
                                     @RequestParam("supplierIdTo") Integer supplierIdTo,
                                     @RequestParam("supplierName") String supplierName,
                                     @RequestParam("customerIdFrom") Integer customerIdFrom,
                                     @RequestParam("customerIdTo") Integer customerIdTo,
                                     @RequestParam("customerName") String customerName,
                                     @RequestParam("productIdFrom") Integer productIdFrom,
                                     @RequestParam("productIdTo") Integer productIdTo,
                                     @RequestParam("productName") String productName,
                                     @RequestParam("repositoryIdFrom") Integer repositoryIdFrom,
                                     @RequestParam("repositoryIdTo") Integer repositoryIdTo,
                                     @RequestParam("receiptType") String receiptType,
                                     @RequestParam("receiptStatus") String receiptStatus,
                                     @RequestParam("isClosed") String isClosed,
                                     Pageable pageable);
//    @Query(value = "select " +
//            "i.inventory_input_id as inventoryInputId, " +
//            "i.is_closed as isClosed, " +
//            "i.input_status as inputStatus, " +
//            "i.slip_no as slipNo, " +
//            "i.input_plan_date as inputPlanDate, " +
//            "i.input_actual_date as inputActualDate, " +
//            "sdd.destination_code as planDestinationCode, " +
//            "sd.destination_code as actualDestinationCode, " +
//            "sdd.department_name as planDepartmentName, " +
//            "sd.department_name as actualDepartmentName, " +
//            "i.plan_slip_note as planSlipNote, " +
//            "s.supplier_code as supplierCode, " +
//            "s.supplier_name as supplierName, " +
//            "c.customer_code as customerCode, " +
//            "c.customer_name as customerName, " +
//            "r.repository_code as planRepositoryCode, " +
//            "r.repository_name as planRepositoryName, " +
//            "rep.repository_code as actualRepositoryCode, " +
//            "rep.repository_name as actualRepositoryName, " +
//            "i.plan_supplier_slip_no as planSupplierSlipNo, " +
//            "i.actual_supplier_slip_no as actualSupplierSlipNo, " +
//            "i.sum_plan_quantity as sumPlanQuantity, " +
//            "i.sum_actual_quantity as sumActualQuantity " +
//            " from t_inventory_input i " +
//            "join m_supplier_delivery_dest sd on i.actual_supplier_delivery_destination_id= sd.delivery_destination_id " +
//            "join m_supplier_delivery_dest sdd on i.plan_supplier_delivery_destination_id= sdd.delivery_destination_id " +
//            "join m_supplier s on i.actual_supplier_id = s.supplier_id " +
//            "join m_customer c on i.product_owner_id = c.customer_id " +
//            "join m_repository rep on i.actual_repository_id = rep.repository_id " +
//            "join m_repository r on i.plan_repository_id = r.repository_id " +
//            "join t_inventory_actual_input_detail aid on i.inventory_input_id = aid.inventory_input_id " +
//            "join m_product p ON aid.product_id = p.product_id " +
//            " WHERE 1=1 " +
//            " AND (:inputPlanDateFrom IS NULL OR i.input_plan_date >= :inputPlanDateFrom) " +
//            " AND (:inputPlanDateTo IS NULL OR i.input_plan_date <= :inputPlanDateTo) " +
//            " AND (:inputActualDateFrom IS NULL OR i.input_actual_date >= :inputActualDateFrom) " +
//            " AND (:inputActualDateTo IS NULL OR i.input_actual_date <= :inputActualDateTo) " +
//            " AND (:slipNoFrom IS NULL OR i.slip_no >= :slipNoFrom) " +
//            " AND (:slipNoTo IS NULL OR i.slip_no <= :slipNoTo) " +
//            " AND (:actualSupplierSlipNo IS NULL OR i.actual_supplier_slip_no LIKE CONCAT('%', :actualSupplierSlipNo, '%')) " +
//            " AND (:destinationIdFrom IS NULL OR sd.delivery_destination_id >= :destinationIdFrom) " +
//            " AND (:destinationIdTo IS NULL OR sd.delivery_destination_id <= :destinationIdTo) " +
//            " AND (:departmentName IS NULL OR sd.department_name LIKE CONCAT('%', :departmentName, '%')) " +
//            " AND (:supplierIdFrom IS NULL OR s.supplier_id >= :supplierIdFrom) " +
//            " AND (:supplierIdTo IS NULL OR s.supplier_id <= :supplierIdTo) " +
//            " AND (:supplierName IS NULL OR s.supplier_name LIKE CONCAT('%', :supplierName, '%')) " +
//            " AND (:customerIdFrom IS NULL OR c.customer_id >= :customerIdFrom) " +
//            " AND (:customerIdTo IS NULL OR c.customer_id <= :customerIdTo) " +
//            " AND (:customerName IS NULL OR c.customer_name LIKE CONCAT('%', :customerName, '%')) " +
//            " AND (:productIdFrom is null or p.product_id >= :productIdFrom) " +
//            " AND (:productIdTo is null or p.product_id <= :productIdTo) " +
//            " AND (:productName IS NULL OR p.product_id IN " +
//            " (SELECT p.product_id FROM m_product p WHERE " +
//            " p.name1 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name2 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name3 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name4 LIKE CONCAT('%', :productName, '%') " +
//            " OR p.name5 LIKE CONCAT('%', :productName, '%') " +
//            " )) " +
//            " AND (:repositoryIdFrom IS NULL OR rep.repository_id >= :repositoryIdFrom) " +
//            " AND (:repositoryIdTo IS NULL OR rep.repository_id <= :repositoryIdTo) " +
//
//            " AND (:receiptType IS NULL OR " +
//            " (:receiptType = '0' OR " +
//            " (:receiptType = '1' AND i.input_plan_date IS NOT NULL ) OR " +
//            " (:receiptType = '2' AND i.input_actual_date IS NOT NULL ) " +
//            " )) " +
//            " AND (:receiptStatus IS NULL OR " +
//            " (:receiptStatus = '0' OR " +
//            " (:receiptStatus = '1' AND i.sum_actual_quantity = 0) OR " +
//            " (:receiptStatus = '2' AND i.sum_actual_quantity < i.sum_plan_quantity AND i.sum_actual_quantity > 0) OR " +
//            " (:receiptStatus = '3' AND i.sum_actual_quantity >= i.sum_plan_quantity ) " +
//            " ))" +
//            " AND " +
//            " (( :isClosed IS NULL )" +
//            " OR  " +
//            " (:isClosed ='9') " +
//            " OR (:isClosed = '0' AND i.is_closed = '0') " +
//            " OR (:isClosed = '1' AND i.is_closed = '1'))"
//                ,nativeQuery = true)
//    Page<InputListDto> getSearchList(@RequestParam("inputPlanDateFrom") String inputPlanDateFrom,
//                                     @RequestParam("inputPlanDateTo") String inputPlanDateTo,
//                                     @RequestParam("inputPlanDateTo") String inputActualDateFrom,
//                                     @RequestParam("inputPlanDateTo") String inputActualDateTo,
//                                     @RequestParam("slipNoFrom") String slipNoFrom,
//                                     @RequestParam("slipNoTo") String slipNoTo,
//                                     @RequestParam("actualSupplierSlipNo") String actualSupplierSlipNo,
//                                     @RequestParam("destinationIdFrom") Integer destinationIdFrom,
//                                     @RequestParam("destinationIdTo") Integer destinationIdTo,
//                                     @RequestParam("departmentName") String departmentName,
//                                     @RequestParam("supplierIdFrom") Integer supplierIdFrom,
//                                     @RequestParam("supplierIdTo") Integer supplierIdTo,
//                                     @RequestParam("supplierName") String supplierName,
//                                     @RequestParam("customerIdFrom") Integer customerIdFrom,
//                                     @RequestParam("customerIdTo") Integer customerIdTo,
//                                     @RequestParam("customerName") String customerName,
//                                     @RequestParam("productIdFrom") Integer productIdFrom,
//                                     @RequestParam("productIdTo") Integer productIdTo,
//                                     @RequestParam("productName") String productName,
//                                     @RequestParam("repositoryIdFrom") Integer repositoryIdFrom,
//                                     @RequestParam("repositoryIdTo") Integer repositoryIdTo,
//                                     @RequestParam("receiptType") String receiptType,
//                                     @RequestParam("receiptStatus") String receiptStatus,
//                                     @RequestParam("isClosed") String isClosed,
//                                     Pageable pageable);
}
