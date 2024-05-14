package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * [OVERVIEW] T Info Of User Login Entity.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/0       (TanDX)           Create new
*/
@Entity
@Table(name = "m_user")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class UserLoginEntity extends CommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // User ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonProperty("userId")
    private Integer id;

    // User Name
    @Column(name = "user_name")
    @JsonProperty("userName")
    private String userName;

    // CompanyId
    @Column(name = "company_id")
    @JsonProperty("companyId")
    private Integer companyId;

    // Role
    @Column(name = "role")
    @JsonProperty("role")
    private Integer role;

    // Password
    @Column(name = "password")
    @JsonProperty("password")
    private String password;

    // Mail
    @Column(name = "mail")
    @JsonProperty("mail")
    private String mail;

    // Birthday
    @Column(name = "birthDay")
    @JsonProperty("birthDay")
    private String birthDay;

    // Gender
    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    // Phone
    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    // Address
    @Column(name = "address")
    @JsonProperty("address")
    private String address;

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
}