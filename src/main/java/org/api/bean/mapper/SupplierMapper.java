package org.api.bean.mapper;

import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.SupplierEntity;
import org.api.bean.reponse.dto.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class SupplierMapper implements Function<SupplierEntity, SupplierDTO> {

    @Override
    public SupplierDTO apply(SupplierEntity supplier) {
        return SupplierDTO.builder()
                .supplierId(supplier.getSupplierId())
                .supplierCode(supplier.getSupplierCode())
                .supplierName(supplier.getSupplierName())
                .build();
    }
}
