package org.api.repository.inventoryInput;

import org.api.bean.jpa.InventoryInputEntity;
import org.api.dto.InventoryInputDto;
import org.api.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryInputRepository extends BaseRepository<InventoryInputEntity, Integer> {
    @Query(value = "SELECT new org.api.dto.InventoryInputDto( " +
            "a.inventoryInputId, a.isClosed, a.inputStatus, a.slipNo, a.inputPlanDate, a.inputActualDate, " +
            "b.destinatonCode, b.departmentName, c.destinatonCode, c.departmentName," +
            "a.planSlipNote, d.supplierCode, d.supplierName, e.supplierCode, e.supplierName, " +
            "f.customerCode, f.customerName, f.customerCode, f.customerName, " +
            "g.repositoryCode, g.repositoryName, h.repositoryCode, h.repositoryName, " +
            "a.planSupplierSlipNo, a.actualSupplierSlipNo, a.sumPlanQuantity, a.sumActualQuantity) " +
            "FROM InventoryInputEntity a " +
            "LEFT JOIN SupplierDeliveryDestEntity b ON a.planSupplierDeliveryDestinationId = b.deliveryDestinationId " +
            "LEFT JOIN SupplierDeliveryDestEntity c ON a.actualSupplierDeliveryDestinationId = c.deliveryDestinationId " +
            "LEFT JOIN SupplierEntity d ON a.planSupplierId = d.supplierId " +
            "LEFT JOIN SupplierEntity e ON a.actualSupplierId = e.supplierId " +
            "LEFT JOIN CustomerEntity f ON a.productOwnerId = f.customerId " +
            "LEFT JOIN RepositoryEntity g ON a.planRepositoryId = g.repositoryId " +
            "LEFT JOIN RepositoryEntity h ON a.actualRepositoryId = h.repositoryId " +
            "WHERE a.delFlg = '0' " +
            //
//            "AND (:inputPlanDateFrom IS NULL OR a.inputPlanDate >= :inputPlanDateFrom) " +
//            "AND (:inputPlanDateTo IS NULL OR a.inputPlanDate <= :inputPlanDateTo) " +
//            "AND (:inputActualDateFrom IS NULL OR a.inputActualDate >= :inputActualDateFrom) " +
//            "AND (:inputActualDateTo IS NULL OR a.inputActualDate <= :inputActualDateTo) " +
//            "AND (:slipNoFrom IS NULL OR a.slip_no >= :slipNoFrom) " +
//            "AND (:slipNoTo IS NULL OR a.slip_no <= :slipNoTo) " +
            //customerDocumentNumber

            //deliveryCode - Name
//            "AND (:deliveryCodeFrom IS NULL OR (a.planSupplierDeliveryDestinationId >= (select min(a.deliveryDestinationId) from SupplierDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeFrom,'%')) " +
//            "OR a.actualSupplierDeliveryDestinationId >= (select min(a.deliveryDestinationId) from SupplierDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeFrom,'%'))))" +
//            "AND (:deliveryCodeTo IS NULL OR (a.planSupplierDeliveryDestinationId <= (select max(a.deliveryDestinationId) from SupplierDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeTo,'%')) " +
//            "OR a.actualSupplierDeliveryDestinationId <= (select max(a.deliveryDestinationId) from SupplierDeliveryDestEntity a where  a.destinationCode like concat('%',:deliveryCodeTo,'%'))))" +
//            "AND (:deliveryName IS NULL OR (a.planSupplierDeliveryDestinationId IN " +
//            "(SELECT a3.deliveryDestinationId FROM SupplierDeliveryDestEntity a3 WHERE a3.departmentName LIKE CONCAT('%', :deliveryName, '%')) " +
//            "OR a.actualSupplierDeliveryDestinationId IN " +
//            "(SELECT a4.deliveryDestinationId FROM SupplierDeliveryDestEntity a4 WHERE a4.departmentName LIKE CONCAT('%', :deliveryName, '%')))) " +
            //supplierCode - Name
            "" +

            //Order by
            "ORDER BY a.slipNo ")
    Page<InventoryInputDto> getAllPage(Pageable pageable);
}
