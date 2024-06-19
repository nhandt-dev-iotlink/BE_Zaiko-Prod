package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "t_inventory_output")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class InventoryOutputEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_output_id")
    @JsonProperty("inventoryOutputId")
    private Integer inventoryOutputId;

    //companyId
    @Column(name = "company_id", nullable = false)
    @JsonProperty("companyId")
    private Integer companyId;

    //planCustomerDeliveryDestination_id
    @Column(name = "plan_customer_delivery_destination_id")
    @JsonProperty("planCustomerDeliveryDestinationId")
    private Integer planCustomerDeliveryDestinationId;

    //actualCustomerDeliveryDestination_id
    @Column(name = "actual_customer_delivery_destination_id")
    @JsonProperty("actualCustomerDeliveryDestinationId")
    private Integer actualCustomerDeliveryDestinationId;

    //deliverDestinationName
    @Column(name = "deliver_destination_name")
    @JsonProperty("deliverDestinationName")
    private String deliverDestinationName;

    //postCode
    @Column(name = "post_code")
    @JsonProperty("postCode")
    private String postCode;

    //phoneNumber
    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    //faxNumber
    @Column(name = "fax_number")
    @JsonProperty("faxNumber")
    private String faxNumber;

    //address1
    @Column(name = "address1")
    @JsonProperty("address1")
    private String address1;

    //address2
    @Column(name = "address2")
    @JsonProperty("address2")
    private String address2;

    //address3
    @Column(name = "address3")
    @JsonProperty("address3")
    private String address3;

    //address4
    @Column(name = "address4")
    @JsonProperty("address4")
    private String address4;

    //routeCode
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String routeCode;

    //courseCode
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String courseCode;

    //planCustomer_id
    @Column(name = "plan_customer_id")
    @JsonProperty("planCustomerId")
    private Integer planCustomerId;

    //actualCustomer_id
    @Column(name = "actual_customer_id")
    @JsonProperty("actualCustomerId")
    private Integer actualCustomerId;

    //orderDate
    @Column(name = "order_date")
    @JsonProperty("orderDate")
    private String orderDate;

    //planOutputDate
    @Column(name = "plan_output_date")
    @JsonProperty("planOutputDate")
    private String planOutputDate;

    //planWorkingDate
    @Column(name = "plan_working_date")
    @JsonProperty("planWorkingDate")
    private String planWorkingDate;

    //planDeliverDate
    @Column(name = "plan_deliver_date")
    @JsonProperty("planDeliverDate")
    private String planDeliverDate;

    //actualOutputDate
    @Column(name = "actual_output_date")
    @JsonProperty("actualOutputDate")
    private String actualOutputDate;

    //actualDeliverDate
    @Column(name = "actual_deliver_date")
    @JsonProperty("actualDeliverDate")
    private String actualDeliverDate;

    //planSupplierSlipNo
    @Column(name = "plan_supplier_slip_no")
    @JsonProperty("planSupplierSlipNo")
    private String planSupplierSlipNo;

    //actualSupplierSlipNo
    @Column(name = "actual_supplier_slip_no")
    @JsonProperty("actualSupplierSlipNo")
    private String actualSupplierSlipNo;

    //create_slip_type
    @Column(name = "create_slip_type",nullable = false)
    @JsonProperty("createSlipType")
    private String createSlipType;

    //slipNo
    @Column(name = "slip_no",nullable = false)
    @JsonProperty("slipNo")
    private String slipNo;

    //slipNote
    @Column(name = "slip_note")
    @JsonProperty("slipNote")
    private String slipNote;

    //planRepository_id
    @Column(name = "plan_repository_id")
    @JsonProperty("planRepositoryId")
    private Integer planRepositoryId;

    //actualRepository_id
    @Column(name = "actual_repository_id")
    @JsonProperty("actualRepositoryId")
    private Integer actualRepositoryId;

    //batchStatus
    @Column(name = "batch_status")
    @JsonProperty("batchStatus")
    private String batchStatus;

    //outputStatus
    @Column(name = "output_status")
    @JsonProperty("outputStatus")
    private String outputStatus;

    //isClosed
    @Column(name = "is_closed",
            columnDefinition = "varchar(50) default '未クローズ'")
    @JsonProperty("isClosed")
    private String isClosed;

    //sumPlanQuantity
    @Column(name = "sum_plan_quantity")
    @JsonProperty("sumPlanQuantity")
    private Integer sumPlanQuantity;

    //sumActualQuantity
    @Column(name = "sum_actual_quantity")
    @JsonProperty("sumActualQuantity")
    private Integer sumActualQuantity;

    //newDestinationName
    @Column(name = "new_destination_name")
    @JsonProperty("newDestinationName")
    private String newDestinationName;

    //checked
    @Column(name = "checked")
    @JsonProperty("checked")
    private Boolean checked;

    //saleCategory
    @Column(name = "sale_category",
            columnDefinition = "varchar(50) default '掛売上'")
    @JsonProperty("saleCategory")
    private String saleCategory;

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

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Integer getInventoryOutputId() {
        return inventoryOutputId;
    }

    public void setInventoryOutputId(Integer inventoryOutputId) {
        this.inventoryOutputId = inventoryOutputId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getPlanCustomerDeliveryDestinationId() {
        return planCustomerDeliveryDestinationId;
    }

    public void setPlanCustomerDeliveryDestinationId(Integer planCustomerDeliveryDestinationId) {
        this.planCustomerDeliveryDestinationId = planCustomerDeliveryDestinationId;
    }

    public Integer getActualCustomerDeliveryDestinationId() {
        return actualCustomerDeliveryDestinationId;
    }

    public void setActualCustomerDeliveryDestinationId(Integer actualCustomerDeliveryDestinationId) {
        this.actualCustomerDeliveryDestinationId = actualCustomerDeliveryDestinationId;
    }

    public String getDeliverDestinationName() {
        return deliverDestinationName;
    }

    public void setDeliverDestinationName(String deliverDestinationName) {
        this.deliverDestinationName = deliverDestinationName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getPlanCustomerId() {
        return planCustomerId;
    }

    public void setPlanCustomerId(Integer planCustomerId) {
        this.planCustomerId = planCustomerId;
    }

    public Integer getActualCustomerId() {
        return actualCustomerId;
    }

    public void setActualCustomerId(Integer actualCustomerId) {
        this.actualCustomerId = actualCustomerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPlanOutputDate() {
        return planOutputDate;
    }

    public void setPlanOutputDate(String planOutputDate) {
        this.planOutputDate = planOutputDate;
    }

    public String getPlanWorkingDate() {
        return planWorkingDate;
    }

    public void setPlanWorkingDate(String planWorkingDate) {
        this.planWorkingDate = planWorkingDate;
    }

    public String getPlanDeliverDate() {
        return planDeliverDate;
    }

    public void setPlanDeliverDate(String planDeliverDate) {
        this.planDeliverDate = planDeliverDate;
    }

    public String getActualOutputDate() {
        return actualOutputDate;
    }

    public void setActualOutputDate(String actualOutputDate) {
        this.actualOutputDate = actualOutputDate;
    }

    public String getActualDeliverDate() {
        return actualDeliverDate;
    }

    public void setActualDeliverDate(String actualDeliverDate) {
        this.actualDeliverDate = actualDeliverDate;
    }

    public String getPlanSupplierSlipNo() {
        return planSupplierSlipNo;
    }

    public void setPlanSupplierSlipNo(String planSupplierSlipNo) {
        this.planSupplierSlipNo = planSupplierSlipNo;
    }

    public String getActualSupplierSlipNo() {
        return actualSupplierSlipNo;
    }

    public void setActualSupplierSlipNo(String actualSupplierSlipNo) {
        this.actualSupplierSlipNo = actualSupplierSlipNo;
    }

    public String getCreateSlipType() {
        return createSlipType;
    }

    public void setCreateSlipType(String createSlipType) {
        this.createSlipType = createSlipType;
    }

    public String getSlipNo() {
        return slipNo;
    }

    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    public String getSlipNote() {
        return slipNote;
    }

    public void setSlipNote(String slipNote) {
        this.slipNote = slipNote;
    }

    public Integer getPlanRepositoryId() {
        return planRepositoryId;
    }

    public void setPlanRepositoryId(Integer planRepositoryId) {
        this.planRepositoryId = planRepositoryId;
    }

    public Integer getActualRepositoryId() {
        return actualRepositoryId;
    }

    public void setActualRepositoryId(Integer actualRepositoryId) {
        this.actualRepositoryId = actualRepositoryId;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getOutputStatus() {
        return outputStatus;
    }

    public void setOutputStatus(String outputStatus) {
        this.outputStatus = outputStatus;
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public Integer getSumPlanQuantity() {
        return sumPlanQuantity;
    }

    public void setSumPlanQuantity(Integer sumPlanQuantity) {
        this.sumPlanQuantity = sumPlanQuantity;
    }

    public Integer getSumActualQuantity() {
        return sumActualQuantity;
    }

    public void setSumActualQuantity(Integer sumActualQuantity) {
        this.sumActualQuantity = sumActualQuantity;
    }

    public String getNewDestinationName() {
        return newDestinationName;
    }

    public void setNewDestinationName(String newDestinationName) {
        this.newDestinationName = newDestinationName;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getSaleCategory() {
        return saleCategory;
    }

    public void setSaleCategory(String saleCategory) {
        this.saleCategory = saleCategory;
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
