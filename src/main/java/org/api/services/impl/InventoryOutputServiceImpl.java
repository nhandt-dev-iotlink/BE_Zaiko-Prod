package org.api.services.impl;

import org.api.bean.ResultBean;
import org.api.bean.jpa.CustomerDeliveryDestEntity;
import org.api.bean.jpa.CustomerEntity;
import org.api.bean.jpa.InventoryOutputEntity;
import org.api.bean.jpa.InventoryPlanOutputDetailEntity;
import org.api.dto.*;
import org.api.mapper.InventoryOutputPlanMapper;
import org.api.mapper.InventoryPlanOutputDetailMapper;
import org.api.repository.customer.CustomerRepository;
import org.api.repository.customerDeliveryDest.CustomerDeliveryDestRepository;
import org.api.repository.inventoryOutput.InventoryOutputRepository;
import org.api.services.CustomerDeliveryDestService;
import org.api.services.CustomerService;
import org.api.services.InventoryOutputService;
import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryOutputServiceImpl implements InventoryOutputService {
    @Autowired
    private InventoryOutputRepository inventoryOutputRepo;
    @Autowired
    private InventoryPlanOutputDetailServiceImpl planOutputDetailService;
    @Autowired
    private InventoryOutputPlanMapper outputPlanMapper;
    @Autowired
    private InventoryPlanOutputDetailMapper planOutputDetailMapper;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDeliveryDestService customerDeliveryDestService;



//    public static void removeNullProperties(Object object) throws Exception {
//        java.lang.reflect.Field[] fields = object.getClass().getDeclaredFields();
//        for (java.lang.reflect.Field field : fields) {
//            field.setAccessible(true);
//            Object value = field.get(object);
//            if (value == null) {
//                field.set(object, null);
//            }
//        }
//    }

    public static String createSlipNo(Integer no) throws Exception {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear() % 100;
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        int sequenceNumber = no; // Số thứ tự
        return String.format("%02d%02d%02d%04d", year, month, day, sequenceNumber);
    }

    public static String formatDate(String date) throws Exception {
        return date.replaceAll("-", "/");
    }


    @Override
    public Page<InventoryOutputDto> getAllPage(Pageable pageable, String orderDateFrom, String orderDateTo,
                                               String planOutputDateFrom, String planOutputDateTo, String planWorkingDateFrom,
                                               String planWorkingDateTo, String planDeliveryDateFrom, String planDeliveryDateTo,
                                               String slipNoFrom, String slipNoTo, String customerCodeFrom,
                                               String customerCodeTo, String customerName, String deliveryCodeFrom,
                                               String deliveryCodeTo, String deliveryName, String supplierCodeFrom,
                                               String supplierCodeTo, String supplierName, String ownerCodeFrom,
                                               String ownerCodeTo, String ownerName, String productCodeFrom,
                                               String productCodeTo, String productName, Integer repoFrom, Integer repoTo,
                                               String batchNo, Integer deliveryType,
                                               String deliveryStatus, String isClose) throws Exception {
        Page<InventoryOutputDto> response = inventoryOutputRepo.getAllPage(pageable, orderDateFrom, orderDateTo,
                planOutputDateFrom, planOutputDateTo, planWorkingDateFrom, planWorkingDateTo, planDeliveryDateFrom,
                planDeliveryDateTo, slipNoFrom, slipNoTo, customerCodeFrom, customerCodeTo, customerName,
                deliveryCodeFrom, deliveryCodeTo, deliveryName, supplierCodeFrom, supplierCodeTo, supplierName, ownerCodeFrom,
                ownerCodeTo, ownerName, productCodeFrom, productCodeTo, productName, repoFrom, repoTo, batchNo,
                deliveryType, deliveryStatus, isClose);
        return new PageImpl<>(response.getContent(), response.getPageable(), response.getTotalElements());
    }

    @Override
    public ResultBean getInfoOutputPlanById(Integer id) throws Exception {
        Optional<InventoryOutputPlanDto> inventoryOutputPlanDto = inventoryOutputRepo.getInfoOutputPlanById(id);
        if (inventoryOutputPlanDto.isEmpty()) {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            return new ResultBean(inventoryOutputPlanDto, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean saveOutputPlan(PlanFormDto planFormDto) throws Exception {
        InventoryOutputPlanDto outputPlanDto = planFormDto.getInfoForm();
        List<InventoryPlanOutputDetailDto> listDetail = planFormDto.getDetailForm();
        InventoryOutputEntity entity = new InventoryOutputEntity();
        entity = outputPlanMapper.toEntity(outputPlanDto);
        entity.setCompanyId(Constants.ONE_IN);
        entity.setOrderDate(formatDate(entity.getOrderDate()));
        entity.setPlanDeliverDate(formatDate(outputPlanDto.getPlanDeliveryDate()));
        entity.setPlanOutputDate(formatDate(entity.getPlanOutputDate()));
        entity.setPlanWorkingDate(formatDate(entity.getPlanWorkingDate()));
        entity.setBatchStatus(Constants.BATCH_STATUS_9);
        entity.setOutputStatus(Constants.FLG_ZERO);
        entity.setIsClosed(Constants.FLG_ZERO);
        entity.setSaleCategory(Constants.FLG_ZERO);
        entity.setDelFlg(Constants.DEL_FLG_0);
        int slipNo = 0;
        if (entity.getCreateSlipType().equals("0")) {
            InventoryOutputEntity getSlipNoBefore = inventoryOutputRepo.getSlipNoBefore(createSlipNo(0).substring(0, 6));

            if (getSlipNoBefore != null) {
                String slipNoBefore = getSlipNoBefore.getSlipNo();
                slipNo = Integer.parseInt(slipNoBefore.substring(slipNoBefore.length() - 4));
            }
            entity.setSlipNo(createSlipNo(slipNo + 1));
        }

        CustomerEntity customerEntity = new CustomerEntity();
        CustomerDeliveryDestEntity customerDeliveryDestEntity = new CustomerDeliveryDestEntity();
//        CustomerDeliveryDestDto customerDeliveryDestDto = new CustomerDeliveryDestDto();

        if (entity.getChecked().equals("1")) {
            entity.setNewDestinationName(outputPlanDto.getDepartmentName());
            CustomerDto customerDtoToSave = new CustomerDto(null, outputPlanDto.getCustomerCode(), outputPlanDto.getCustomerName(), null, entity.getCompanyId(), outputPlanDto.getPhoneNumber(), outputPlanDto.getPostCode(), outputPlanDto.getAddress1());
            ResultBean resultBeanCustomer = customerService.saveCustomer(customerDtoToSave);
        } else {
            customerEntity = customerService.findOneCustomerByCode(outputPlanDto.getCustomerCode());
            customerDeliveryDestEntity = customerDeliveryDestService.findOneByCode(outputPlanDto.getDestinationCode());
//            customerDeliveryDestDto = customerDeliveryDestRepository.findByCode(outputPlanDto.getDestinationCode());
        }
        entity.setPlanCustomerId(customerEntity.getCustomerId());
        entity.setDeliverDestinationName(outputPlanDto.getCustomerName().concat(outputPlanDto.getDepartmentName()));
        entity.setPlanCustomerDeliveryDestinationId(customerDeliveryDestEntity.getDeliveryDestinationId());
        Integer sumPlanQuantity = 0;
        for (InventoryPlanOutputDetailDto dto : listDetail) {
            sumPlanQuantity += dto.getTotalPlanQuantity();
        }
        entity.setSumPlanQuantity(sumPlanQuantity);
        inventoryOutputRepo.save(entity);
        Optional<InventoryOutputEntity> optional = inventoryOutputRepo.findBySlipNo(createSlipNo(slipNo + 1));
//        Optional<InventoryOutputEntity> optional = inventoryOutputRepo.findBySlipNo("2406070002");
        InventoryOutputEntity outputEntity = optional.get();

        List<InventoryPlanOutputDetailDto> dtoDetailList = new ArrayList<>();
        for (InventoryPlanOutputDetailDto dto : listDetail) {
            ResultBean resultBean = planOutputDetailService.savePlanOutputDetail(dto, outputEntity);
            InventoryPlanOutputDetailEntity detailEntity = (InventoryPlanOutputDetailEntity) resultBean.getData();
            dtoDetailList.add(planOutputDetailMapper.toDto(detailEntity));
        }
        PlanFormDto newPlanFormDto = new PlanFormDto(outputPlanMapper.toDto(entity), dtoDetailList);

        return new ResultBean(newPlanFormDto, Constants.STATUS_201, Constants.MESSAGE_OK);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultBean deleteOutputPlanById(Integer id) throws Exception {
        Optional<InventoryOutputEntity> inventoryOutputEntity = inventoryOutputRepo.findById(id);
        if (inventoryOutputEntity.isPresent()) {
            ResultBean resultBean = planOutputDetailService.deletePlanOutputDetailByOutputId(id);
            if (resultBean.getMeta().getCode().equals("1")) {
                inventoryOutputEntity.get().setDelFlg("1");
                inventoryOutputRepo.save(inventoryOutputEntity.get());
                return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
            }
        }
        return new ResultBean(Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
    }

    @Override
    public ResultBean checkSlipNo(String slipNo) throws Exception {
        Optional<InventoryOutputEntity> entity = inventoryOutputRepo.findBySlipNo(slipNo);
        if (entity.isPresent()) {
            return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(Constants.STATUS_NOT_FOUND, Constants.MESSAGE_OK);
    }
}
