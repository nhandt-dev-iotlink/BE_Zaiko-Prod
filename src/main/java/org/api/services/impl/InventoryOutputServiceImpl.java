package org.api.services.impl;

import io.lettuce.core.dynamic.annotation.Param;
import org.api.annotation.LogExecutionTime;
import org.api.bean.reponse.dto.InventoryOutputListDTO;
import org.api.repository.inventory.InventoryOutputListRepository;
import org.api.services.InventoryOutputService;
import org.api.utils.ApiValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class InventoryOutputServiceImpl implements InventoryOutputService {
    @Autowired
    private InventoryOutputListRepository outputListRepository;

    private static final Logger log = LoggerFactory.getLogger(InventoryOutputServiceImpl.class);


    // Method để kiểm tra và chuyển đổi tham số ngày tháng
    private LocalDate convertToDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        try {
            // Định dạng chuẩn của ngày tháng
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Định dạng ngày tháng không hợp lệ: " + dateStr);
        }
    }




    @Override
    public Page<InventoryOutputListDTO> findInventoryOutputWithFilters(Pageable pageable,Integer page,Integer size, Integer repositoryIdFrom,Integer repositoryIdTo, String orderDateFrom, String orderDateTo, String planOutputDateFrom, String planOutputDateTo, String planWorkingDateFrom, String planWorkingDateTo, String planDeliverDateFrom, String planDeliverDateTo, String slipNoFrom, String slipNoTo, String productCodeFrom, String productCodeTo, String batchNo, String productName, String destinationCodeFrom, String destinationCodeTo, String departmentName, String supplierCodeFrom, String supplierCodeTo, String supplierName, String customerCodeFrom, String customerCodeTo, String customerName, String DeliveryType, String DeliveryStatus, String isClosed) throws Exception {
        Page<InventoryOutputListDTO> response = outputListRepository.findInventoryOutputWithFilters( pageable,
                 repositoryIdFrom, repositoryIdTo,orderDateFrom,  orderDateTo, planOutputDateFrom, planOutputDateTo, planWorkingDateFrom, planWorkingDateTo, planDeliverDateFrom,  planDeliverDateTo, slipNoFrom,  slipNoTo, productCodeFrom , productCodeTo, batchNo,
                productName,destinationCodeFrom,destinationCodeTo,departmentName, supplierCodeFrom, supplierCodeTo, supplierName, customerCodeFrom,customerCodeTo,customerName, DeliveryType,DeliveryStatus,isClosed);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }


}
