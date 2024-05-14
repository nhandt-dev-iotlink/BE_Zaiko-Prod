package org.api.services.impl;

import org.api.dto.InventoryInputDto;
import org.api.dto.InventoryOutputDto;
import org.api.repository.inventoryInput.InventoryInputRepository;
import org.api.services.InventoryInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryInputServiceImpl implements InventoryInputService {
    @Autowired
    private InventoryInputRepository inventoryInputRepository;
    @Override
    public Page<InventoryInputDto> getAllPage(Pageable pageable) throws Exception {
        Page<InventoryInputDto> response = inventoryInputRepository.getAllPage(pageable);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }
}
