package org.api.enumeration;
/**
 * [OVERVIEW] SortEnum.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/08/22      (TanDX)            Create new
*/

public enum CommonSettingEnum {
    /** TAX */
    TAX("001");

    CommonSettingEnum(String text) {
        this.text = text;
    }

    /**
     * @return text
     */
    public String getText() {
        return text;
    }

    private String text;
}
