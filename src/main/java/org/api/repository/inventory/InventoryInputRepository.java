//package org.api.repository.inventory;
//import org.api.bean.jpa.InventoryInputEntity;
//import org.api.bean.reponse.dto.InventoryInputListDTO;
//import org.api.repository.sql.InventoryInputQuery;
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface InventoryInputRepository extends JpaRepository<InventoryInputEntity,Integer> {
//
//    @Query(value = InventoryInputQuery.FIND_WITH_FILTERS)
//    public Page<InventoryInputListDTO> findInventoryOutputWithFilters();
//}
