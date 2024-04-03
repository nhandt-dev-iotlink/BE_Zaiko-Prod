/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.bean.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] CommonResponse.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)     	 Create new
*/
public class CommonResponse {

    @JsonProperty("delFlg")
    private String delFlg = "0";

    @JsonProperty("createBy")
    private String createBy;

    public String getDelFlg() {
        return delFlg;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
