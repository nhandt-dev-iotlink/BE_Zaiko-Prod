package org.api.bean.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * [OVERVIEW] : Common Entity
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)       Create new
*/
@Data
@MappedSuperclass
public abstract class CommonEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Delete flag
    @Column(name = "del_flg")
    @JsonProperty("delFlg")
    @JsonIgnore
    private String delFlg = "0";

    // Creation date
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false)
    @JsonProperty("createDate")
    @JsonIgnore
    private Date createDate;

    // Creator ID
    @Column(name = "create_by", updatable = false)
    @JsonProperty("createBy")
    @JsonIgnore
    private Integer createBy;

    // Update date
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonProperty("updateDate")
    @JsonIgnore
    private Date updateDate;

    // Updater ID
    @Column(name = "update_by")
    @JsonProperty("updateBy")
    @JsonIgnore
    private Integer updateBy;
}
