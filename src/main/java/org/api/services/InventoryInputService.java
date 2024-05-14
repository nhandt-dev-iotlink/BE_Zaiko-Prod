package org.api.services;

import org.api.dto.InventoryInputDto;
import org.api.dto.InventoryOutputDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventoryInputService {
    Page<InventoryInputDto> getAllPage(Pageable pageable) throws Exception;
}
