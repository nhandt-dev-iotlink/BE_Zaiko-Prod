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
        if (outputPlanDto.getOrderDate() != null) {
            outputPlanDto.setOrderDate(formatDate(outputPlanDto.getOrderDate()));
        }
        if (outputPlanDto.getPlanDeliveryDate() != null) {
            outputPlanDto.setPlanDeliveryDate(formatDate(outputPlanDto.getPlanDeliveryDate()));
        }
        if (outputPlanDto.getPlanOutputDate() != null) {
            outputPlanDto.setPlanOutputDate(formatDate(outputPlanDto.getPlanOutputDate()));
        }
        if (outputPlanDto.getPlanWorkingDate() != null) {
            outputPlanDto.setPlanWorkingDate(formatDate(outputPlanDto.getPlanWorkingDate()));
        }
        List<InventoryPlanOutputDetailDto> listDetail = planFormDto.getDetailForm();
        InventoryOutputEntity outputEntityToSave = new InventoryOutputEntity();
//        InventoryOutputEntity outputEntityToSave = null;
        if (outputPlanDto.getInventoryOutputId() != null || outputPlanDto.getSlipNo() != null) {
            outputEntityToSave = inventoryOutputRepo.getOneById(outputPlanDto.getInventoryOutputId());
            outputPlanMapper.update(outputEntityToSave, outputPlanDto);
//            outputEntityToSave.setUpdateDate(null);
//            outputEntityReturn = inventoryOutputRepo.save(outputEntityToSave);
//            return new ResultBean(outputEntityReturn, Constants.STATUS_201, Constants.MESSAGE_OK);
        }else {
            outputEntityToSave = outputPlanMapper.toEntity(outputPlanDto);
            outputEntityToSave.setCompanyId(Constants.ONE_IN);
            outputEntityToSave.setBatchStatus(Constants.BATCH_STATUS_9);
            outputEntityToSave.setOutputStatus(Constants.FLG_ZERO);
            outputEntityToSave.setIsClosed(Constants.FLG_ZERO);
            outputEntityToSave.setSaleCategory(Constants.FLG_ZERO);
            outputEntityToSave.setDelFlg(Constants.DEL_FLG_0);
            int slipNo = 0;
            if (outputEntityToSave.getCreateSlipType().equals("0")) {
                InventoryOutputEntity getSlipNoBefore = inventoryOutputRepo.getSlipNo(createSlipNo(0).substring(0, 6));
                if (getSlipNoBefore != null) {
                    String slipNoBefore = getSlipNoBefore.getSlipNo();
                    slipNo = Integer.parseInt(slipNoBefore.substring(slipNoBefore.length() - 4));
                }
                outputEntityToSave.setSlipNo(createSlipNo(slipNo + 1));
            }
        }
        outputEntityToSave.setPlanDeliverDate(outputPlanDto.getPlanDeliveryDate());


        CustomerEntity customerEntity = new CustomerEntity();
        CustomerDeliveryDestEntity customerDeliveryDestEntity = new CustomerDeliveryDestEntity();
        if (outputEntityToSave.getChecked().equals("1")) {
            outputEntityToSave.setNewDestinationName(outputPlanDto.getDepartmentName());
            CustomerDto customerDtoToSave = new CustomerDto(null, outputPlanDto.getCustomerCode(),
                    outputPlanDto.getCustomerName(), outputPlanDto.getDepartmentName(), null, 0,
                    outputEntityToSave.getCompanyId(), outputPlanDto.getPhoneNumber(), outputPlanDto.getFaxNumber(), outputPlanDto.getPostCode(),
                    outputPlanDto.getAddress1(), outputPlanDto.getAddress2(), outputPlanDto.getAddress3(), outputPlanDto.getAddress4(),
                    outputPlanDto.getRouteCode(), outputPlanDto.getCourseCode());
            ResultBean resultBeanCustomer = customerService.saveCustomer(customerDtoToSave);
            if (resultBeanCustomer.getData() != null) {
                customerEntity = (CustomerEntity) resultBeanCustomer.getData();
                CustomerDeliveryDestDto customerDeliveryDestDtoToSave = new CustomerDeliveryDestDto(null,
                        outputPlanDto.getDestinationCode(), outputPlanDto.getDepartmentName(),
                        outputPlanDto.getPhoneNumber(), outputPlanDto.getFaxNumber(), outputPlanDto.getPostCode(),
                        outputPlanDto.getRouteCode(), outputPlanDto.getCourseCode(), outputPlanDto.getAddress1(),
                        outputPlanDto.getAddress2(), outputPlanDto.getAddress3(), outputPlanDto.getAddress4(),
                        outputEntityToSave.getCompanyId(), customerEntity.getCustomerId(), "0", 0);
                ResultBean resultBeanCustomerDest = customerDeliveryDestService.saveEntity(customerDeliveryDestDtoToSave);
                if (resultBeanCustomerDest.getData() != null) {
                    customerDeliveryDestEntity = (CustomerDeliveryDestEntity) resultBeanCustomerDest.getData();
                } else {
                    return new ResultBean(customerDeliveryDestDtoToSave, Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
                }
            } else {
                return new ResultBean(customerDtoToSave, Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
            }
        } else {
            customerEntity = customerService.findOneCustomerByCode(outputPlanDto.getCustomerCode());
            customerDeliveryDestEntity = customerDeliveryDestService.findOneByCode(outputPlanDto.getDestinationCode());
        }
        outputEntityToSave.setPlanCustomerId(customerEntity.getCustomerId());
        outputEntityToSave.setDeliverDestinationName(outputPlanDto.getCustomerName().concat(outputPlanDto.getDepartmentName()));
        outputEntityToSave.setPlanCustomerDeliveryDestinationId(customerDeliveryDestEntity.getDeliveryDestinationId());
        Integer sumPlanQuantity = 0;
        for (InventoryPlanOutputDetailDto dto : listDetail) {
            sumPlanQuantity += dto.getTotalPlanQuantity();
        }
        outputEntityToSave.setSumPlanQuantity(sumPlanQuantity);

        InventoryOutputEntity outputEntityReturn = new InventoryOutputEntity();
        outputEntityReturn = inventoryOutputRepo.save(outputEntityToSave);
        PlanFormDto newPlanFormDto = new PlanFormDto();
        List<InventoryPlanOutputDetailDto> dtoDetailList = new ArrayList<>();

        if (outputEntityReturn.getInventoryOutputId() != null) {
            newPlanFormDto.setInfoForm(outputPlanMapper.toDto(outputEntityReturn));
            for (InventoryPlanOutputDetailDto dto : listDetail) {
                ResultBean resultBeanDetail = planOutputDetailService.savePlanOutputDetail(dto, outputEntityReturn);
                if (resultBeanDetail.getData() != null) {
                    InventoryPlanOutputDetailEntity detailEntity = (InventoryPlanOutputDetailEntity) resultBeanDetail.getData();
                    dtoDetailList.add(planOutputDetailMapper.toDto(detailEntity));
                } else {
                    return new ResultBean(dto, Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
                }
            }
            newPlanFormDto.setDetailForm(dtoDetailList);
        } else {
            return new ResultBean(outputEntityToSave, Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
        }
        return new ResultBean(newPlanFormDto, Constants.STATUS_201, Constants.MESSAGE_OK);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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
        Optional<InventoryOutputEntity> outputEntityToSave = inventoryOutputRepo.findBySlipNo(slipNo);
        if (outputEntityToSave.isPresent()) {
            return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
        return new ResultBean(Constants.STATUS_NOT_FOUND, Constants.MESSAGE_OK);
    }
}
