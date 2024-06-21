package org.api.services.impl;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.api.annotation.LogExecutionTime;
import org.api.bean.ResultBean;
import org.api.bean.jpa.*;
import org.api.bean.reponse.dto.*;
import org.api.repository.plan.InventoryPlanOutputDetailRepository;
import org.api.repository.plan.InventoryPlanOutputRepository;
import org.api.services.*;
import org.api.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class InventoryPlanOutputSericeImpl implements InventoryPlanOutputSerice {
    public static final String FILE_JSON_VALIDATE = "inventoryPlanOutput.json";

    public static final String ALIAS = "InventoryOutput";
    @Autowired
    InventoryPlanOutputRepository planOutputRepository;

    @Autowired
    InventoryPlanOutputDetailRepository planOutputDetailRepository;
    @Autowired
    InventoryOutputService outputService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDeliveryDestService destService;

    @Autowired
    ProductService productService;

    @Autowired
    SalePriceService salePriceService;

    @Override
    public ResultBean getPlanOutputWithKey(Integer inventoryOutputId) throws ApiValidateException {
        Optional<InventoryOutputPlanDTO>  planOptional= planOutputRepository.findPlanOutputWithKey(inventoryOutputId);
        if(planOptional.isPresent()) {
            return new ResultBean(planOptional.get(), Constants.STATUS_OK, Constants.MESSAGE_OK);
        }else {
            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.INVENTORY_OUTPUT_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00019, null, ItemNameUtils.getItemName(ConstantColumns.INVENTORY_OUTPUT_ID, ALIAS)));
        }
    }


    @Override
    public ResultBean updateInventoryOutputPlan(String json) throws Exception {
        // Chuyển đổi chuỗi JSON thành JsonObject
        JsonObject jsonObject = DataUtil.getJsonObject(json);

        JsonObject jsonObject1 = DataUtil.getJsonObject(String.valueOf(jsonObject.get("planForm")));
//        ValidateData.validate(FILE_JSON_VALIDATE, jsonObject1, false);
        if (DataUtil.isNull(jsonObject1, ConstantColumns.INVENTORY_OUTPUT_ID)) {
            throw new ApiValidateException(Constants.ID_BKE00004, ConstantColumns.INVENTORY_OUTPUT_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00004, new Object[] { ItemNameUtils.getItemName(ConstantColumns.INVENTORY_OUTPUT_ID, ALIAS) }));
        }
        // Trích xuất INVENTORY_OUTPUT_ID từ JSON
        Integer inventoryId = DataUtil.getJsonInteger(jsonObject1, ConstantColumns.INVENTORY_OUTPUT_ID);

        // Tìm đối tượng InventoryOutputEntity theo ID
        InventoryOutputEntity inventoryOutput = planOutputRepository.findInventoryOutputEntity(inventoryId);

//        // Kiểm tra xem đối tượng InventoryOutputEntity có tồn tại không
        if (inventoryOutput == null) {
            throw new ApiValidateException(Constants.ID_BKE00019, ConstantColumns.INVENTORY_OUTPUT_ID,
                    MessageUtils.getMessage(Constants.ID_BKE00019, new Object[] { ItemNameUtils.getItemName(ConstantColumns.INVENTORY_OUTPUT_ID, ALIAS) }));
        }

        // Chuyển đổi JSON thành đối tượng PlanFormDTO
        PlanFormDTO updateOutputPlan = convertJsonToEntity(json);

        // Cập nhật các thuộc tính từ PlanFormDTO sang InventoryOutputEntity
        BeanUtils.copyProperties(updateOutputPlan.getPlanForm(), inventoryOutput);
        //  cập nhật vào database
        planOutputRepository.save(inventoryOutput);

        // Xử lý và lưu các chi tiết
        if (updateOutputPlan.getTableForm() != null) {
            for (InventoryPlanOutputDetailDTO detailDTO : updateOutputPlan.getTableForm()) {
                InventoryPlanOutputDetailEntity updateInventoryOutputDetail = new InventoryPlanOutputDetailEntity();
                BeanUtils.copyProperties(detailDTO, updateInventoryOutputDetail);
                // Lưu chi tiết cập nhật vào database
                planOutputDetailRepository.save(updateInventoryOutputDetail);
            }
        }
        return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
    }


    @Override
    public ResultBean createInventoryOutputPlan(PlanFormDTO createFormPlan) throws ApiValidateException ,Exception {
        try {


            InventoryOutputEntity outputEntity = new InventoryOutputEntity();
            BeanUtils.copyProperties(createFormPlan.getPlanForm(), outputEntity);
            setDateFields(outputEntity, createFormPlan);
            outputEntity.setSum_plan_quantity(sumPlanQuantity(createFormPlan.getTableForm()));
            if (outputEntity.getChecked().equals('1')) {
                createCustomerAndCustomerDeliveryDest(createFormPlan.getPlanForm());
            } else {
                String customerCode = String.format("%06d", outputEntity.getPlan_customer_id());
                CustomerDTO customer = customerService.getCustomerByCode(customerCode);
                outputEntity.setPlan_customer_id(customer.getCustomerId());
                CustomerDeliveryDestDTO deliveryDestDTO = destService.getCustomerDeliveryDestByCode(customerCode);

                outputEntity.setPlan_customer_delivery_destination_id(deliveryDestDTO.getDeliveryDestinationId());
                outputEntity.setDeliver_destination_name(deliverDestinationName(customer, deliveryDestDTO));
            }
            outputEntity.setCompany_id(Constants.DEFAULT_COMPANY_ID);
            Date date = new Date();
            outputEntity.setCreateDate(date);
            outputEntity.setSlip_no(outputService.getNextAutomaticSlipNo());
            outputEntity.setIs_closed(Constants.FREE_FLG_0);
            outputEntity.setBatch_status(Constants.BATCH_STATUS_9);
            InventoryOutputEntity outputSave = planOutputRepository.save(outputEntity);
            for (InventoryPlanOutputDetailDTO detailDTO : createFormPlan.getTableForm()) {
                createPlanOutputDetail(detailDTO, outputSave.getInventory_output_id());
            }
            return new ResultBean(Constants.STATUS_201, Constants.MESSAGE_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBean(Constants.STATUS_SYSTEM_ERROR, Constants.MESSAGE_SYSTEM_ERROR);
        }
    }



    private void createCustomerAndCustomerDeliveryDest(InventoryOutputPlanDTO outputEntity) {
        Date date = new Date();
        try {
            CustomerEntity customer = new CustomerEntity();
            customer.setPhoneNumber(outputEntity.getPhoneNumber());
            customer.setCustomerName(outputEntity.getCustomerName());
            customer.setPostCode(outputEntity.getPostCode());
            customer.setAddress1(outputEntity.getAddress1());
            customer.setCompanyId(Constants.DEFAULT_COMPANY_ID);
            customer.setCustomerCode(String.valueOf(outputEntity.getCustomerCode()));
            customer.setOutputPriorityRank(Constants.ONE_IN);
            customer.setDelFlg(Constants.DEL_FLG_0);
            customer.setCreateDate(date);
            customerService.createCustomer(customer);

            CustomerDeliveryDestEntity deliveryDest = new CustomerDeliveryDestEntity();
            deliveryDest.setCompanyId(Constants.DEFAULT_COMPANY_ID);
            deliveryDest.setDelFlg(Constants.DEL_FLG_0);
            deliveryDest.setDestinationCode(String.valueOf(outputEntity.getDestinationCode()));
            deliveryDest.setDepartmentName(outputEntity.getDepartmentName());
            deliveryDest.setIsCuststomer(Constants.FLG_ZERO);
            deliveryDest.setAddress1(outputEntity.getAddress1());
            deliveryDest.setPhoneNumber(outputEntity.getPhoneNumber());
            deliveryDest.setPostCode(outputEntity.getPostCode());
            deliveryDest.setOutputPriorityRank(Constants.ONE_IN);
            destService.createCustomerDeliveryDest(deliveryDest);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void createPlanOutputDetail(InventoryPlanOutputDetailDTO detail, Integer InventoryOutputId) {
        Date date = new Date();
        try {
            InventoryPlanOutputDetailEntity planOutputDetailEntity = new InventoryPlanOutputDetailEntity();
            BeanUtils.copyProperties(detail, planOutputDetailEntity);
            ProductDTO product = productService.getProductByCode(String.valueOf(detail.getProduct_id()));
            SalePriceDTO price = salePriceService.getLatestSalePriceByProductId(product.getProductId());
            planOutputDetailEntity.setPlan_cs_price(price.getPack_cs_price());
            planOutputDetailEntity.setPlan_bl_price(price.getPack_bl_price());
            planOutputDetailEntity.setPlan_piece_price(price.getPiece_price());
            planOutputDetailEntity.setTax(Constants.TAX);
            planOutputDetailEntity.setAmount_total(calculateAmountTotal(detail, product, price));
            planOutputDetailEntity.setBatch_status(Constants.BATCH_STATUS_0);
            planOutputDetailEntity.setIs_batch_inprogress(Constants.ZERO_IN);
            planOutputDetailEntity.setInventory_output_id(InventoryOutputId);
            planOutputDetailEntity.setCreateDate(date);
            planOutputDetailEntity.setCompany_id(Constants.ONE_IN);
            planOutputDetailRepository.save(planOutputDetailEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private Double calculateAmountTotal(InventoryPlanOutputDetailDTO detail, ProductDTO productDTO, SalePriceDTO price) {
        Double packCsPrice = price.getPack_cs_price();
        Double packBlPrice = price.getPack_bl_price();
        Double piecePrice = price.getPiece_price();
        Integer planCsQuantity = detail.getCs_plan_quantity();
        Integer planBlQuantity = detail.getBl_plan_quantity();
        Integer planPsQuantity = detail.getPs_plan_quantity();
        Integer totalPlanQuantity = detail.getTotal_plan_quantity();
        Double amountTotal = 0.00;
        String billingPackageType = detail.getBilling_pack_type();
        if (billingPackageType.equals("3")) {
            amountTotal = (totalPlanQuantity / planCsQuantity) * packCsPrice;
        } else if (billingPackageType.equals("2")) {
            amountTotal = (totalPlanQuantity / planBlQuantity) * packBlPrice;
        } else {
            amountTotal = planPsQuantity * piecePrice;
        }
        return amountTotal;
    };
    private Integer sumPlanQuantity(List<InventoryPlanOutputDetailDTO> detailDTOList) {
        int totalPlanAmount = 0;
        for (InventoryPlanOutputDetailDTO detailDTO : detailDTOList) {
            if (detailDTO.getPlan_amount_total() != null) {
                totalPlanAmount += detailDTO.getPlan_amount_total();
            }
        }
        return totalPlanAmount;
    }

    private String deliverDestinationName(CustomerDTO customerDTO, CustomerDeliveryDestDTO deliveryDestDTO) {
        String customerName = customerDTO != null ? customerDTO.getCustomerName() : "";
        String departmentName = deliveryDestDTO != null ? deliveryDestDTO.getDepartmentName() : "";
        return customerName + departmentName;
    }


    @Override
    public ResultBean removeInventoryOutputPlan(Integer inventoryId) throws ApiValidateException, Exception {

            InventoryOutputEntity outputEntity = planOutputRepository.findInventoryOutputEntity(inventoryId);

            if (outputEntity != null) {
                outputEntity.setDelFlg("1");
                planOutputRepository.save(outputEntity);

                List<InventoryPlanOutputDetailEntity> inventoryDetails = planOutputDetailRepository.finPlanOutputDetailEntities(inventoryId);
//               List<Integer> id =inventoryDetails.stream().mapMultiToInt( ei -> ei.getPlan_detail_id()).collect(Collections.toList)
                for (InventoryPlanOutputDetailEntity detail : inventoryDetails) {
                    detail.setDelFlg("1");
                    planOutputDetailRepository.save(detail);
                }

                return new ResultBean(Constants.STATUS_OK, Constants.MESSAGE_OK);
            } else {
                throw new ApiValidateException(Constants.STATUS_BAD_REQUEST, Constants.MESSAGE_BAD_REQUEST);
            }


    }

    @Override
    public ResultBean getOutputDetailById(Integer id) throws ApiValidateException  {

            List<InventoryPlanOutputDetailEntity> outputEntity = planOutputDetailRepository.finPlanOutputDetailEntities(id);
            if (outputEntity != null && !outputEntity.isEmpty()) {
                ResultBean resultBean = new ResultBean(outputEntity , Constants.STATUS_201,Constants.MESSAGE_OK);
                return resultBean;

            }else {
                throw new ApiValidateException(Constants.STATUS_BAD_REQUEST,Constants.MESSAGE_SYSTEM_ERROR);
            }

    }




    private void setDateFields(InventoryOutputEntity outputEntity, PlanFormDTO form) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat(Constants.DATE_PATTEN_YYYY_MM_DD);
            SimpleDateFormat outputFormat = new SimpleDateFormat(Constants.DATE_PATTEN);
            outputEntity.setOrder_date(convertDateFormat(form.getPlanForm().getOrderDate(), inputFormat, outputFormat));
            outputEntity.setPlan_output_date(convertDateFormat(form.getPlanForm().getPlanOutputDate(), inputFormat, outputFormat));
            outputEntity.setPlan_working_date(convertDateFormat(form.getPlanForm().getPlanWorkingDate(), inputFormat, outputFormat));
            outputEntity.setPlan_deliver_date(convertDateFormat(form.getPlanForm().getPlanDeliverDate(), inputFormat, outputFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private String convertDateFormat(String dateStr, SimpleDateFormat inputFormat, SimpleDateFormat outputFormat) throws ParseException {
        Date date = inputFormat.parse(dateStr);
        return outputFormat.format(date);
    }

    public PlanFormDTO convertJsonToEntity(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, PlanFormDTO.class);
    }


}
