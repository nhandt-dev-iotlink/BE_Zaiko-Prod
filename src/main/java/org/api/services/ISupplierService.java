package org.api.services;


import org.api.bean.dto.SupplierDto;

import java.util.List;

public interface ISupplierService {
    List<SupplierDto> getAll(String keyword);
}
