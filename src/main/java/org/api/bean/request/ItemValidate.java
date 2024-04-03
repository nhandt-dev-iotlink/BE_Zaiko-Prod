/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.bean.request;

import java.util.List;

/**
 * [OVERVIEW] Item validate.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)      Create new
*/
public class ItemValidate {

    private String alias;

    private List<ValidateInfo> checks;

    public String getAlias() {
        return alias;
    }

    public List<ValidateInfo> getChecks() {
        return checks;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setChecks(List<ValidateInfo> checks) {
        this.checks = checks;
    }

}