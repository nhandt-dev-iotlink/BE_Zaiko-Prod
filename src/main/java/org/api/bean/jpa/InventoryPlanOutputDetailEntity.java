package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory_plan_output_detail")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryPlanOutputDetailEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_detail_id")
    @JsonProperty("planDetail_id")
    private Integer planDetailId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //inventoryOutput_id
    @Column(name = "inventory_output_id",nullable = false)
    @JsonProperty("inventoryOutput_id")
    private Integer inventoryOutputId;

    //productInventory_id
    @Column(name = "product_inventory_id")
    @JsonProperty("productInventory_id")
    private Integer productInventoryId;

    //productId
    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Integer productId;

    //repositoryId
    @Column(name = "repository_id", nullable = false)
    @JsonProperty("repositoryId")
    private Integer repositoryId;

    //locationId
    @Column(name = "location_id")
    @JsonProperty("locationId")
    private Integer locationId;

    //datetime_mng_from
    @Column(name = "datetime_mng_from")
    @JsonProperty("datetime_mng_from")
    private String datetimeMngFrom;

    //datetime_mng_to
    @Column(name = "datetime_mng_to")
    @JsonProperty("datetime_mng_to")
    private String datetimeMngTo;

    //number_mng_from
    @Column(name = "number_mng_from")
    @JsonProperty("number_mng_from")
    private String numberMngFrom;

    //number_mng_to
    @Column(name = "number_mng_to")
    @JsonProperty("number_mng_to")
    private String numberMngTo;

    //productOwner_id
    @Column(name = "product_owner_id")
    @JsonProperty("productOwner_id")
    private Integer productOwnerId;

    //supplierId
    @Column(name = "supplier_id")
    @JsonProperty("supplierId")
    private Integer supplierId;

    //cs_plan_quantity
    @Column(name = "cs_plan_quantity")
    @JsonProperty("cs_plan_quantity")
    private Integer csPlanQuantity;

    //bl_plan_quantity
    @Column(name = "bl_plan_quantity")
    @JsonProperty("bl_plan_quantity")
    private Integer blPlanQuantity;



    //ps_plan_quantity
    @Column(name = "ps_plan_quantity")
    @JsonProperty("ps_plan_quantity")
    private Integer psPlanQuantity;

    //total_plan_quantity
    @Column(name = "total_plan_quantity")
    @JsonProperty("total_plan_quantity")
    private Integer totalPlanQuantity;

    //inventoryProductType
    @Column(name = "inventory_product_type")
    @JsonProperty("inventoryProductType")
    private String inventoryProductType;

    //detailNote
    @Column(name = "detail_note")
    @JsonProperty("detailNote")
    private String detailNote;

    //plan_cs_price
    @Column(name = "plan_cs_price",precision = 7,scale = 2)
    @JsonProperty("plan_cs_price")
    private Double planCsPrice;

    //plan_bl_price
    @Column(name = "plan_bl_price",precision = 7,scale = 2)
    @JsonProperty("plan_bl_price")
    private Double planBlPrice;

    //planPiecePrice
    @Column(name = "plan_piece_price",precision = 7,scale = 2)
    @JsonProperty("planPiecePrice")
    private Double planPiecePrice;

    //planAmountTotal
    @Column(name = "plan_amount_total",precision = 19,scale = 2)
    @JsonProperty("planAmountTotal")
    private Double planAmountTotal;

    //tax
    @Column(name = "tax",precision = 2,scale = 2)
    @JsonProperty("tax")
    private Double tax;

    //isBatchInprogress
    @Column(name = "is_batch_inprogress")
    @JsonProperty("isBatchInprogress")
    private Integer isBatchInprogress;

    //batchStatus
    @Column(name = "batch_status",nullable = false)
    @JsonProperty("batchStatus")
    private String batchStatus;

    //batchNo
    @Column(name = "batch_no")
    @JsonProperty("batchNo")
    private String batchNo;

    //billingPackType
    @Column(name = "billing_pack_type",nullable = false)
    @JsonProperty("billingPackType")
    private String billingPackType;

    //amountTotal
    @Column(name = "amount_total",precision = 7,scale = 2)
    @JsonProperty("amountTotal")
    private Double amountTotal;

    //free_item1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    //free_item2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    //free_item3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;

    public Integer getPlanDetailId() {
        return planDetailId;
    }

    public void setPlanDetailId(Integer planDetailId) {
        this.planDetailId = planDetailId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getInventoryOutputId() {
        return inventoryOutputId;
    }

    public void setInventoryOutputId(Integer inventoryOutputId) {
        this.inventoryOutputId = inventoryOutputId;
    }

    public Integer getProductInventoryId() {
        return productInventoryId;
    }

    public void setProductInventoryId(Integer productInventoryId) {
        this.productInventoryId = productInventoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDatetimeMngFrom() {
        return datetimeMngFrom;
    }

    public void setDatetimeMngFrom(String datetimeMngFrom) {
        this.datetimeMngFrom = datetimeMngFrom;
    }

    public String getDatetimeMngTo() {
        return datetimeMngTo;
    }

    public void setDatetimeMngTo(String datetimeMngTo) {
        this.datetimeMngTo = datetimeMngTo;
    }

    public String getNumberMngFrom() {
        return numberMngFrom;
    }

    public void setNumberMngFrom(String numberMngFrom) {
        this.numberMngFrom = numberMngFrom;
    }

    public String getNumberMngTo() {
        return numberMngTo;
    }

    public void setNumberMngTo(String numberMngTo) {
        this.numberMngTo = numberMngTo;
    }

    public Integer getProductOwnerId() {
        return productOwnerId;
    }

    public void setProductOwnerId(Integer productOwnerId) {
        this.productOwnerId = productOwnerId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getCsPlanQuantity() {
        return csPlanQuantity;
    }

    public void setCsPlanQuantity(Integer csPlanQuantity) {
        this.csPlanQuantity = csPlanQuantity;
    }

    public Integer getBlPlanQuantity() {
        return blPlanQuantity;
    }

    public void setBlPlanQuantity(Integer blPlanQuantity) {
        this.blPlanQuantity = blPlanQuantity;
    }

    public Integer getPsPlanQuantity() {
        return psPlanQuantity;
    }

    public void setPsPlanQuantity(Integer psPlanQuantity) {
        this.psPlanQuantity = psPlanQuantity;
    }

    public Integer getTotalPlanQuantity() {
        return totalPlanQuantity;
    }

    public void setTotalPlanQuantity(Integer totalPlanQuantity) {
        this.totalPlanQuantity = totalPlanQuantity;
    }

    public String getInventoryProductType() {
        return inventoryProductType;
    }

    public void setInventoryProductType(String inventoryProductType) {
        this.inventoryProductType = inventoryProductType;
    }

    public String getDetailNote() {
        return detailNote;
    }

    public void setDetailNote(String detailNote) {
        this.detailNote = detailNote;
    }

    public Double getPlanCsPrice() {
        return planCsPrice;
    }

    public void setPlanCsPrice(Double planCsPrice) {
        this.planCsPrice = planCsPrice;
    }

    public Double getPlanBlPrice() {
        return planBlPrice;
    }

    public void setPlanBlPrice(Double planBlPrice) {
        this.planBlPrice = planBlPrice;
    }

    public Double getPlanPiecePrice() {
        return planPiecePrice;
    }

    public void setPlanPiecePrice(Double planPiecePrice) {
        this.planPiecePrice = planPiecePrice;
    }

    public Double getPlanAmountTotal() {
        return planAmountTotal;
    }

    public void setPlanAmountTotal(Double planAmountTotal) {
        this.planAmountTotal = planAmountTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Integer getIsBatchInprogress() {
        return isBatchInprogress;
    }

    public void setIsBatchInprogress(Integer isBatchInprogress) {
        this.isBatchInprogress = isBatchInprogress;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBillingPackType() {
        return billingPackType;
    }

    public void setBillingPackType(String billingPackType) {
        this.billingPackType = billingPackType;
    }

    public Double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Double amountTotal) {
        this.amountTotal = amountTotal;
    }

    public String getFreeItem1() {
        return freeItem1;
    }

    public void setFreeItem1(String freeItem1) {
        this.freeItem1 = freeItem1;
    }

    public String getFreeItem2() {
        return freeItem2;
    }

    public void setFreeItem2(String freeItem2) {
        this.freeItem2 = freeItem2;
    }

    public String getFreeItem3() {
        return freeItem3;
    }

    public void setFreeItem3(String freeItem3) {
        this.freeItem3 = freeItem3;
    }
}
