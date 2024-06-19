package org.api.bean.mapper;
import org.api.bean.jpa.SupplierEntity;
import org.api.bean.reponse.dto.SupplierDTO;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierDTO supplierToSupplierDto(SupplierEntity supplier);
    SupplierEntity supplierDtoToSupplier(SupplierDTO supplierDto);
}
