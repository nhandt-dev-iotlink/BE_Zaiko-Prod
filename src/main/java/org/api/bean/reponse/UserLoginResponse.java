/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.bean.reponse;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] User Login Of Response.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)      	Create new
*/

public class UserLoginResponse extends CommonResponse implements Serializable {

	/**
    *
    */
   private static final long serialVersionUID = 1L;

   @JsonProperty("userId")
   private Integer userId;

   // User Name
   @JsonProperty("userName")
   private String userName;

   // CompanyId
   @JsonProperty("companyId")
   private Integer companyId;

   // Role
   @JsonProperty("role")
   private String role;

   // Mail
   @JsonProperty("mail")
   private String mail;

   // Birthday
   @JsonProperty("birthDay")
   private String birthDay;

   // Gender
   @JsonProperty("gender")
   private String gender;

   // Phone
   @JsonProperty("phone")
   private String phone;

   // Address
   @JsonProperty("address")
   private String address;

   // FreeItem1
   @JsonProperty("freeItem1")
   private String freeItem1;

   // FreeItem2
   @JsonProperty("freeItem2")
   private String freeItem2;

   // FreeItem3
   @JsonProperty("freeItem3")
   private String freeItem3;

// FreeItem3
   @JsonProperty("updateDate")
   private Date updateDate;

   @JsonIgnore
   private List<UserRoleResponse> roles;

   public UserLoginResponse() {}
   public UserLoginResponse(String phone) {
       this.phone = phone;
   }

   public UserLoginResponse(Integer userId, String userName, Integer companyId, String mail, String birthDay, String gender, String phone, String address, String freeItem1,
   	String freeItem2, String freeItem3) {
       this.userId = userId;
       this.userName = userName;
       this.companyId = companyId;
       this.mail = mail;
       this.birthDay = birthDay;
       this.gender = gender;
       this.phone = phone;
       this.address = address;
       this.freeItem1 = freeItem1;
       this.freeItem2 = freeItem2;
       this.freeItem3 = freeItem3;
       this.role = role;
   }

   public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

   public String getMail() {
       return mail;
   }

   public void setMail(String mail) {
       this.mail = mail;
   }

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	public List<UserRoleResponse> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRoleResponse> roles) {
		this.roles = roles;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}