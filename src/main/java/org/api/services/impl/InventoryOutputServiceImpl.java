package org.api.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.catalina.mapper.Mapper;
import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.*;
import org.api.dto.*;
import org.api.mapper.InventoryOutputDetailMapper;
import org.api.mapper.InventoryPlanOutputDetailMapper;
import org.api.repository.inventoryOutput.InventoryOutputRepository;
import org.api.services.CustomerDeliveryDestService;
import org.api.services.CustomerService;
import org.api.services.InventoryOutputService;
import org.api.services.InventoryPlanOutputDetailService;
import org.api.utils.*;
import org.json.JSONObject;
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
@LogExecutionTime
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {ApiValidateException.class, Exception.class})
public class InventoryOutputServiceImpl implements InventoryOutputService {
    public static final String FILE_JSON_INFO_VALIDATE_CREATE = "createOutputPlanInfo.json";
    public static final String FILE_JSON_INFO_VALIDATE_UPDATE = "updateOutputPlanInfo.json";
    public static final String FILE_JSON_DETAIL_VALIDATE_CREATE = "createOutputPlanDetail.json";
    public static final String FILE_JSON_DETAIL_VALIDATE_UPDATE = "updateOutputPlanDetail.json";
    @Autowired
    private InventoryOutputRepository inventoryOutputRepo;
    @Autowired
    private InventoryPlanOutputDetailService planOutputDetailService;
    @Autowired
    private InventoryOutputDetailMapper outputPlanMapper;
    @Autowired
    private InventoryPlanOutputDetailMapper planOutputDetailMapper;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDeliveryDestService customerDeliveryDestService;

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

    public static void validateCreateAndUpdate(String json, String validInfo, String validDetail) throws Exception {
        JsonObject planFormDtoObject = DataUtil.getJsonObject(json);
        JsonObject infoFormObject = DataUtil.getJsonObjectWithMember(planFormDtoObject, "infoForm");
        ValidateData.validate(validInfo, infoFormObject, false);
        JsonArray jsonArray = planFormDtoObject.get("detailForm").getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObjectDetail = jsonElement.getAsJsonObject();
            ValidateData.validate(validDetail, jsonObjectDetail, false);
        }
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
    public ResultBean getInfoOutputDetailPlanById(Integer id) throws Exception {
        Optional<InventoryOutputDetailDto> inventoryOutputPlanDto = inventoryOutputRepo.getInfoOutputDetailPlanById(id);
        if (inventoryOutputPlanDto.isEmpty()) {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            return new ResultBean(inventoryOutputPlanDto, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
    }

    @Override
    public ResultBean getInfoOutputDetailActualById(Integer id) throws Exception {
        Optional<InventoryOutputEntity> entity = inventoryOutputRepo.getInfoOutputDetailActualById(id);
        if (entity.isEmpty()) {
            return new ResultBean(new ArrayList<>(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        } else {
            InventoryOutputDetailDto dto = outputPlanMapper.toDto(entity.get());
            return new ResultBean(dto, Constants.STATUS_OK, Constants.MESSAGE_OK);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean saveOutputPlan(PlanFormDto planFormDto) throws Exception {
        InventoryOutputDetailDto outputPlanDto = planFormDto.getInfoForm();
        List<InventoryPlanOutputDetailDto> listDetail = planFormDto.getDetailForm();
        InventoryOutputEntity outputEntityToSave = new InventoryOutputEntity();
        if (outputPlanDto.getInventoryOutputId() != null) {
            outputEntityToSave = inventoryOutputRepo.getOneById(outputPlanDto.getInventoryOutputId());
            outputPlanMapper.update(outputEntityToSave, outputPlanDto);
        } else {
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

//       Start Set SumPlanQuantity
        Integer sumPlanQuantity = 0;
        for (InventoryPlanOutputDetailDto dto : listDetail) {
            sumPlanQuantity += dto.getTotalPlanQuantity();
        }
        outputEntityToSave.setSumPlanQuantity(sumPlanQuantity);
//       End Set SumPlanQuantity

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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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

    /**
     * The Constant ALIAS.
     */
    public static final String ALIAS = "User";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean create(String json) throws Exception {
        validateCreateAndUpdate(json, FILE_JSON_INFO_VALIDATE_CREATE, FILE_JSON_DETAIL_VALIDATE_CREATE);
        PlanFormDto planFormDto = new PlanFormDto();
        convertJsonToDto(json, planFormDto);

        InventoryOutputDetailDto outputPlanDto = planFormDto.getInfoForm();
        List<InventoryPlanOutputDetailDto> listDetail = planFormDto.getDetailForm();
        InventoryOutputEntity outputEntityToSave = new InventoryOutputEntity();
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
        outputEntityToSave.setPlanDeliverDate(outputPlanDto.getPlanDeliveryDate());
        setCustomerAndCustomerDest(outputEntityToSave, outputPlanDto);
        setTotalPlanQuantity(outputEntityToSave, listDetail);

        InventoryOutputEntity outputEntityReturn = new InventoryOutputEntity();
        outputEntityReturn = inventoryOutputRepo.save(outputEntityToSave);
        PlanFormDto newPlanFormDto = new PlanFormDto();
        newPlanFormDto = saveDetail(outputEntityReturn, listDetail);
//        List<InventoryPlanOutputDetailDto> dtoDetailList = new ArrayList<>();
//
//        if (outputEntityReturn.getInventoryOutputId() != null) {
//            newPlanFormDto.setInfoForm(outputPlanMapper.toDto(outputEntityReturn));
//            for (InventoryPlanOutputDetailDto dto : listDetail) {
//                ResultBean resultBeanDetail = planOutputDetailService.savePlanOutputDetail(dto, outputEntityReturn);
//                if (resultBeanDetail.getData() != null) {
//                    InventoryPlanOutputDetailEntity detailEntity = (InventoryPlanOutputDetailEntity) resultBeanDetail.getData();
//                    dtoDetailList.add(planOutputDetailMapper.toDto(detailEntity));
//                } else {
//                    return new ResultBean(dto, Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
//                }
//            }
//            newPlanFormDto.setDetailForm(dtoDetailList);
//        } else {
//            return new ResultBean(outputEntityToSave, Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
//        }
        return new ResultBean(newPlanFormDto, Constants.STATUS_201, Constants.MESSAGE_OK);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultBean update(String json) throws Exception {
        validateCreateAndUpdate(json, FILE_JSON_INFO_VALIDATE_UPDATE, FILE_JSON_DETAIL_VALIDATE_UPDATE);
        PlanFormDto planFormDto = new PlanFormDto();
        convertJsonToDto(json, planFormDto);

        InventoryOutputDetailDto outputPlanDto = planFormDto.getInfoForm();
        List<InventoryPlanOutputDetailDto> listDetail = planFormDto.getDetailForm();

        InventoryOutputEntity outputEntityToSave = new InventoryOutputEntity();
        outputEntityToSave = inventoryOutputRepo.getOneById(outputPlanDto.getInventoryOutputId());
        outputPlanMapper.update(outputEntityToSave, outputPlanDto);
        outputEntityToSave.setPlanDeliverDate(outputPlanDto.getPlanDeliveryDate());
        setCustomerAndCustomerDest(outputEntityToSave, outputPlanDto);
        setTotalPlanQuantity(outputEntityToSave, listDetail);

        InventoryOutputEntity outputEntityReturn = new InventoryOutputEntity();
        outputEntityReturn = inventoryOutputRepo.save(outputEntityToSave);
        PlanFormDto newPlanFormDto = new PlanFormDto();
        newPlanFormDto = saveDetail(outputEntityReturn, listDetail);

        return new ResultBean(newPlanFormDto, Constants.STATUS_OK, Constants.MESSAGE_OK);
    }

    private void convertJsonToDto(String json, PlanFormDto dto) throws ApiValidateException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonObject planFormDtoObject = DataUtil.getJsonObject(json);
        JsonObject infoFormObject = DataUtil.getJsonObjectWithMember(planFormDtoObject, "infoForm");
        InventoryOutputDetailDto info = objectMapper.readValue(infoFormObject.toString(), InventoryOutputDetailDto.class);
        JsonArray jsonArray = planFormDtoObject.get("detailForm").getAsJsonArray();
        List<InventoryPlanOutputDetailDto> list = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObjectDetail = jsonElement.getAsJsonObject();
            InventoryPlanOutputDetailDto detail = objectMapper.readValue(jsonObjectDetail.toString(), InventoryPlanOutputDetailDto.class);
            list.add(detail);
        }
        dto.setInfoForm(info);
        dto.setDetailForm(list);
    }

    private void setCustomerAndCustomerDest(InventoryOutputEntity outputEntityToSave, InventoryOutputDetailDto outputPlanDto) throws Exception {
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
                    throw new ApiValidateException(Constants.ID_BKE00004,
                            MessageUtils.getMessage(Constants.ID_BKE00004, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
                }
            } else {
                throw new ApiValidateException(Constants.ID_BKE00004,
                        MessageUtils.getMessage(Constants.ID_BKE00004, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
            }
        } else {
            customerEntity = customerService.findOneCustomerByCode(outputPlanDto.getCustomerCode());
            customerDeliveryDestEntity = customerDeliveryDestService.findOneByCode(outputPlanDto.getDestinationCode());
        }
        outputEntityToSave.setPlanCustomerId(customerEntity.getCustomerId());
        outputEntityToSave.setDeliverDestinationName(outputPlanDto.getCustomerName().concat(outputPlanDto.getDepartmentName()));
        outputEntityToSave.setPlanCustomerDeliveryDestinationId(customerDeliveryDestEntity.getDeliveryDestinationId());
    }

    private void setTotalPlanQuantity(InventoryOutputEntity outputEntityToSave, List<InventoryPlanOutputDetailDto> listDetail) throws Exception {
        Integer sumPlanQuantity = 0;
        for (InventoryPlanOutputDetailDto dto : listDetail) {
            sumPlanQuantity += dto.getTotalPlanQuantity();
        }
        outputEntityToSave.setSumPlanQuantity(sumPlanQuantity);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PlanFormDto saveDetail(InventoryOutputEntity outputEntityReturn, List<InventoryPlanOutputDetailDto> listDetail) throws Exception {
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
                    throw new ApiValidateException(Constants.ID_BKE00004,
                            MessageUtils.getMessage(Constants.ID_BKE00004, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
                }
            }
            newPlanFormDto.setDetailForm(dtoDetailList);
        } else {
            throw new ApiValidateException(Constants.ID_BKE00004,
                    MessageUtils.getMessage(Constants.ID_BKE00004, ItemNameUtils.getItemName(ConstantColumns.USER_ID, ALIAS)));
        }
        return newPlanFormDto;
    }
}
