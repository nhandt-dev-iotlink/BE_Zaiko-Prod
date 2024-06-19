package org.api.services;


import org.api.bean.jpa.SupplierEntity;
import org.api.bean.reponse.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    public List<SupplierDTO> getAllSupplier();

    public List<SupplierDTO> findSuppliersByKeyword(String param);
}
