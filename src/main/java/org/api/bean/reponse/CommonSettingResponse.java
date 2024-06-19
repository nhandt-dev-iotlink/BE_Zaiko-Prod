/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.bean.reponse;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] CommonSettingResponse.
 *
  * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)     	  Create new
*/
public class CommonSettingResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // Common ID
    @JsonProperty("commonId")
    private Integer commonId;

    // Code
    @JsonProperty("code")
    private String code;

    // Value 01
    @JsonProperty("value01")
    private String value01;

    // Value 02
    @JsonProperty("value02")
    private String value02;

    // Value 03
    @JsonProperty("value03")
    private String value03;

    // Value 04
    @JsonProperty("value04")
    private String value04;

    // Value 05
    @JsonProperty("value05")
    private String value05;

    public CommonSettingResponse() {
    }

    public CommonSettingResponse(Integer commonId, String code, String value01, String value02, String value03, String value04, String value05) {
        super();
        this.commonId = commonId;
        this.code = code;
        this.value01 = value01;
        this.value02 = value02;
        this.value03 = value03;
        this.value04 = value04;
        this.value05 = value05;
    }

    public Integer getCommonId() {
        return commonId;
    }

    public void setCommonId(Integer commonId) {
        this.commonId = commonId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue01() {
        return value01;
    }

    public void setValue01(String value01) {
        this.value01 = value01;
    }

    public String getValue02() {
        return value02;
    }

    public void setValue02(String value02) {
        this.value02 = value02;
    }

    public String getValue03() {
        return value03;
    }

    public void setValue03(String value03) {
        this.value03 = value03;
    }

    public String getValue04() {
        return value04;
    }

    public void setValue04(String value04) {
        this.value04 = value04;
    }

    public String getValue05() {
        return value05;
    }

    public void setValue05(String value05) {
        this.value05 = value05;
    }
}
