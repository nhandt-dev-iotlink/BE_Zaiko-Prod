package org.api.services.impl;


import org.api.bean.dto.SupplierDto;

import org.api.repository.ISupplierRepository;
import org.api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private ISupplierRepository supplierRepository;
    @Override
    public List<SupplierDto> getAll(String keyword) {
        return supplierRepository.getAll(keyword);
    }
}
