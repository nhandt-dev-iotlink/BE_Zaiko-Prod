package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_customer")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity extends CommonEntity{
    // Customer ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private Integer customerId;

    // CompanyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    //Customer Code
    @Column(name = "customer_code")
    @JsonProperty("customerCode")
    private String customerCode;

    //Customer Name
    @Column(name = "customer_name")
    @JsonProperty("customerName")
    private String customerName;

    //Deparment Name
    @Column(name = "department_name")
    @JsonProperty("departmentName")
    private String departmentName;

    //Pic Name
    @Column(name = "pic_name")
    @JsonProperty("picName")
    private Integer picName;

    //Phone Number
    @Column(name = "phone_number")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    //Fax Number
    @Column(name = "fax_number")
    @JsonProperty("faxNumber")
    private String faxNumber;

    //Post Code
    @Column(name = "post_code", nullable = false)
    @JsonProperty("postCode")
    private String postCode;

    //Address 1
    @Column(name = "address1", nullable = false)
    @JsonProperty("address1")
    private String address1;

    //Address 2
    @Column(name = "address2")
    @JsonProperty("address2")
    private String address2;

    //Address 3
    @Column(name = "address3")
    @JsonProperty("address3")
    private String address3;

    //Address 4
    @Column(name = "address4")
    @JsonProperty("address4")
    private String address4;

    //Bank Name
    @Column(name = "bank_name")
    @JsonProperty("bankName")
    private String bankName;

    //Bank Branch Name
    @Column(name = "bank_branch_name")
    @JsonProperty("bankBranchName")
    private String bankBranchName;

    //Bank Acc Number
    @Column(name = "bank_acc_number")
    @JsonProperty("bankAccNumber")
    private String bankAccNumber;

    //Bank Acc Holder
    @Column(name = "bank_acc_holder")
    @JsonProperty("bankAccHolder")
    private String bankAccHolder;

    //Lead Time
    @Column(name = "lead_time")
    @JsonProperty("leadTime")
    private Integer leadTime;

    //Route Code
    @Column(name = "route_code")
    @JsonProperty("routeCode")
    private String routeCode;

    //Course Code
    @Column(name = "course_code")
    @JsonProperty("courseCode")
    private String courseCode;

    //Output Priority Rank
    @Column(name = "output_priority_rank")
    @JsonProperty("outputPriorityRank")
    private Integer outputPriorityRank = 1;

    // FreeItem1
    @Column(name = "free_item1")
    @JsonProperty("freeItem1")
    private String freeItem1;

    // FreeItem2
    @Column(name = "free_item2")
    @JsonProperty("freeItem2")
    private String freeItem2;

    // FreeItem3
    @Column(name = "free_item3")
    @JsonProperty("freeItem3")
    private String freeItem3;

    //Notes
    @Column(name = "notes")
    @JsonProperty("notes")
    private String notes;
    //

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getPicName() {
        return picName;
    }

    public void setPicName(Integer picName) {
        this.picName = picName;
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankAccNumber() {
        return bankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        this.bankAccNumber = bankAccNumber;
    }

    public String getBankAccHolder() {
        return bankAccHolder;
    }

    public void setBankAccHolder(String bankAccHolder) {
        this.bankAccHolder = bankAccHolder;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
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

    public Integer getOutputPriorityRank() {
        return outputPriorityRank;
    }

    public void setOutputPriorityRank(Integer outputPriorityRank) {
        this.outputPriorityRank = outputPriorityRank;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
