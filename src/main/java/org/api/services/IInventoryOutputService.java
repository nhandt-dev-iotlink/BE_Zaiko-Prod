package org.api.services;


import org.api.bean.dto.OutputListDto;
import org.api.bean.dto.SearchOutputListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInventoryOutputService {

    List<OutputListDto> getAll();

    // Ver dùng id
//    Page<SearchOutputListDto> getListOutputWithPagination(String orderDateFrom, String orderDateTo, String planOutputDateFrom, String planOutputDateTo,
//                                                          String planWorkingDayFrom, String planWorkingDayTo, String planDeliverDateFrom, String planDeliverDateTo,
//                                                          String slipNoFrom, String slipNoTo, Integer customerIdFrom, Integer customerIdTo, String customerName,
//                                                          Integer destinationIdFrom, Integer destinationIdTo, String departmentName, Integer supplierIdFrom,
//                                                          Integer supplierIdTo, String supplierName, Integer productIdFrom, Integer productIdTo, String productName,
//                                                          Integer repositoryIdFrom, Integer repositoryIdTo, String batchNo, String deliveryType, String deliveryStatus,
//                                                          String isClosed, Pageable pageable, Integer ownerIdFrom, Integer ownerIdTo, String ownerName);

    // Ver dùng code
    Page<SearchOutputListDto> getListOutputWithPagination(String orderDateFrom,
                                                          String orderDateTo,
                                                          String planOutputDateFrom,
                                                          String planOutputDateTo,
                                                          String planWorkingDayFrom,
                                                          String planWorkingDayTo,
                                                          String planDeliverDateFrom,
                                                          String planDeliverDateTo,
                                                          String slipNoFrom,
                                                          String slipNoTo,
                                                          String customerCodeFrom,
                                                          String customerCodeTo,
                                                          String customerName,
                                                          String destinationCodeFrom,
                                                          String destinationCodeTo,
                                                          String departmentName,
                                                          String supplierCodeFrom,
                                                          String supplierCodeTo,
                                                          String supplierName,
                                                          String productCodeFrom,
                                                          String productCodeTo,
                                                          String productName,
                                                          Integer repositoryCodeFrom,
                                                          Integer repositoryCodeTo,
                                                          String batchNo,
                                                          String deliveryType,
                                                          String deliveryStatus,
                                                          String isClosed,
                                                          String ownerCodeFrom,
                                                          String ownerCodeTo,
                                                          String ownerName,
                                                          Pageable pageable);


}
