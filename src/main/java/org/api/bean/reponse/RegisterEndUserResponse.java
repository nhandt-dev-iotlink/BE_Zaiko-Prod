package org.api.bean.reponse;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;

import org.api.bean.jpa.UserLoginEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] User Login Of Response.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 			001       1.0      2022/07/01     (TanDX)      Create new
 */

public class RegisterEndUserResponse implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("flagAdmin")
    private String flagAdmin;

    @JsonProperty("password")
    private String password;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("userIdx")
    private Long userIdx;

    @JsonProperty("counter")
    private Integer counter = 0;

    @JsonProperty("requireChangePass")
    private String requireChangePass;

    @JsonProperty("lastLoginTime")
    private String lastLoginTime;

    @JsonProperty("lastChangepassTime")
    private String lastChangepassTime;

    @JsonProperty("userIdFormat")
    private String userIdFormat;

 // User Name
    @Column(name = "user_name")
    @JsonProperty("userName")
    private String userName;

    // FirstName
    @Column(name = "first_name")
    @JsonProperty("firstName")
    private String firstName;

    // LastName
    @Column(name = "last_name")
    @JsonProperty("lastName")
    private String lastName;

    // Phone
    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    /**
     *
     * @param entity
     * @param userId
     */
    public RegisterEndUserResponse(UserLoginEntity entity, Integer userId) {
        super();
        //this.userId = entity.getUserId();
        this.password = entity.getPassword();
        this.mail = entity.getMail();
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the userIdFormat
     */
    public String getUserIdFormat() {
        return userIdFormat;
    }

    /**
     * @param userIdFormat
     */
    public void setUserIdFormat(String userIdFormat) {
        this.userIdFormat = userIdFormat;
    }

    /**
     * @return the flagAdmin
     */
    public String getFlagAdmin() {
        return flagAdmin;
    }

    /**
     * @param flagAdmin
     */
    public void setFlagAdmin(String flagAdmin) {
        this.flagAdmin = flagAdmin;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the userIdx
     */
    public Long getUserIdx() {
        return userIdx;
    }

    /**
     * @param userIdx
     */
    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    /**
     * @return the counter
     */
    public Integer getCounter() {
        return counter;
    }

    /**
     * @param counter
     */
    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    /**
     * @return the requireChangePass
     */
    public String getRequireChangePass() {
        return requireChangePass;
    }

    /**
     * @param requireChangePass
     */
    public void setRequireChangePass(String requireChangePass) {
        this.requireChangePass = requireChangePass;
    }

    /**
     * @return the lastLoginTime
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return the lastChangepassTime
     */
    public String getLastChangepassTime() {
        return lastChangepassTime;
    }

    /**
     * @param lastChangepassTime
     */
    public void setLastChangepassTime(String lastChangepassTime) {
        this.lastChangepassTime = lastChangepassTime;
    }

    /**
     * @return the userIdFormat
     */
    public String getuserIdFormat() {
        return userIdFormat;
    }

    /**
     * @param userIdFormat
     */
    public void setuserIdFormat(String userIdFormat) {
        this.userIdFormat = userIdFormat;
    }

}
