package org.api.services.impl;



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
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@LogExecutionTime
@Service
@Transactional(rollbackFor = { ApiValidateException.class, Exception.class })
public class InventoryPlanOutputSericeImpl implements InventoryPlanOutputSerice {

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
    public PlanOutputDTO getPlanOutputWithKey(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        PlanOutputDTO planOutputDTO = planOutputRepository.findPlanOutputWithKey(key);
        if (planOutputDTO == null) {
            throw new EntityNotFoundException("Plan output not found for key: " + key);
        }
        return planOutputDTO;
    }

    @Override
    public ResultBean createInventoryOutputPlan(PlanFormDTO form) throws ApiValidateException ,Exception {
        if (form == null) {
            return new ResultBean(Constants.STATUS_BAD_REQUEST, MessageUtils.getMessage("入力データがnullです"));
        }
        if (form.getPlanForm() == null) {
            return new ResultBean(Constants.STATUS_BAD_REQUEST, MessageUtils.getMessage("計画フォームデータがnullです"));
        }
        if (form.getTableForm() == null || form.getTableForm().isEmpty()) {
            return new ResultBean(Constants.STATUS_BAD_REQUEST, MessageUtils.getMessage("テーブルフォームデータがnullまたは空です"));
        }
        try {
            InventoryOutputEntity outputEntity = new InventoryOutputEntity();
            BeanUtils.copyProperties(form.getPlanForm(), outputEntity);
            setDateFields(outputEntity, form);
            outputEntity.setSum_plan_quantity(sumPlanQuantity(form.getTableForm()));
            if (outputEntity.getChecked().equals('1')) {
                createCustomerAndCustomerDeliveryDest(form.getPlanForm());
            } else {
                String customerCode = String.format("%06d", outputEntity.getPlan_customer_id());
                CustomerDTO customer = customerService.getCustomerByCode(customerCode);
                outputEntity.setPlan_customer_id(customer.getCustomerId());
                CustomerDeliveryDestDTO deliveryDestDTO = destService.getCustomerDeliveryDestByCode(customerCode);

                outputEntity.setPlan_customer_delivery_destination_id(deliveryDestDTO.getDeliveryDestinationId());
                outputEntity.setDeliver_destination_name(deliverDestinationName(customer, deliveryDestDTO));
            }
            outputEntity.setCompany_id(0001);
            Date date = new Date();
            outputEntity.setCreateDate(date);
            outputEntity.setSlip_no(outputService.getNextAutomaticSlipNo());
            outputEntity.setIs_closed(Constants.FREE_FLG_0);
            outputEntity.setBatch_status("9");
            InventoryOutputEntity outputSave = planOutputRepository.save(outputEntity);
            for (InventoryPlanOutputDetailDTO detailDTO : form.getTableForm()) {
                createPlanOutputDetail(detailDTO, outputSave.getInventory_output_id());
            }
            return new ResultBean(form, Constants.STATUS_201, "在庫出荷計画が正常に作成されました。");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultBean(form, Constants.STATUS_SYSTEM_ERROR, "在庫出荷計画の作成中にエラーが発生しました");
        }
    }
    private void createCustomerAndCustomerDeliveryDest(InventoryOutputDTO outputEntity) {
        Date date = new Date();
        try {
            CustomerEntity customer = new CustomerEntity();
            customer.setPhoneNumber(outputEntity.getPhone_number());
            customer.setCustomerName(outputEntity.getCustomerName());
            customer.setPostCode(outputEntity.getPost_code());
            customer.setAddress1(outputEntity.getAddress1());
            customer.setCompanyId(Constants.DEFAULT_COMPANY_ID);
            customer.setCustomerCode(String.valueOf(outputEntity.getPlan_customer_id()));
            customer.setOutputPriorityRank(Constants.ONE_IN);
            customer.setDelFlg(Constants.DEL_FLG_0);
            customer.setCreateDate(date);
            customerService.createCustomer(customer);

            CustomerDeliveryDestEntity deliveryDest = new CustomerDeliveryDestEntity();
            deliveryDest.setCompanyId(Constants.DEFAULT_COMPANY_ID);
            deliveryDest.setDelFlg(Constants.DEL_FLG_0);
            deliveryDest.setDestinationCode(String.valueOf(outputEntity.getPlan_customer_delivery_destination_id()));
            deliveryDest.setDepartmentName(outputEntity.getDepartmentName());
            deliveryDest.setIsCuststomer(Constants.FLG_ZERO);
            deliveryDest.setAddress1(outputEntity.getAddress1());
            deliveryDest.setPhoneNumber(outputEntity.getPhone_number());
            deliveryDest.setPostCode(outputEntity.getPost_code());
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
    public ResultBean removeInventoryOutputPlan(Integer inventoryId, List < Integer > inventoryDetailIds) throws ApiValidateException, Exception {
        try {
            InventoryOutputEntity outputEntity = planOutputRepository.findInventoryOutputEntity(inventoryId);
            if (outputEntity != null) {
                outputEntity.setDelFlg("1");
                planOutputRepository.save(outputEntity);
            } else {
                throw new ApiValidateException(Constants.STATUS_BAD_REQUEST, "inventoryId", "IDでInventoryOutputEntityのレコードが見つかりませんでした：" + inventoryId);
            }
            for (Integer detailId : inventoryDetailIds) {
                InventoryPlanOutputDetailEntity planOutputDetailEntity = planOutputDetailRepository.findPlanOutputDetailEntity(detailId);
                if (planOutputDetailEntity != null) {
                    planOutputDetailEntity.setDelFlg("1");
                    planOutputDetailRepository.save(planOutputDetailEntity);
                } else {
                    throw new ApiValidateException(Constants.STATUS_BAD_REQUEST, "inventoryDetailId", "IDでInventoryPlanOutputDetailEntityのレコードが見つかりませんでした：" + detailId);
                }
            }
            return new ResultBean(Constants.STATUS_201, "InventoryOutputEntityとInventoryPlanOutputDetailEntityのレコードを削除しました");
        } catch (Exception e) {
            throw new Exception("データの削除中にエラーが発生しました：" + e.getMessage());
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
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
            outputEntity.setOrder_date(convertDateFormat(form.getPlanForm().getOrder_date(), inputFormat, outputFormat));
            outputEntity.setPlan_output_date(convertDateFormat(form.getPlanForm().getPlan_output_date(), inputFormat, outputFormat));
            outputEntity.setPlan_working_date(convertDateFormat(form.getPlanForm().getPlan_working_date(), inputFormat, outputFormat));
            outputEntity.setPlan_deliver_date(convertDateFormat(form.getPlanForm().getPlan_deliver_date(), inputFormat, outputFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private String convertDateFormat(String dateStr, SimpleDateFormat inputFormat, SimpleDateFormat outputFormat) throws ParseException {
        Date date = inputFormat.parse(dateStr);
        return outputFormat.format(date);
    }


}
