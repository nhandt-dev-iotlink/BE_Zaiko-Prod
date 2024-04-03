// © 2022 API. All right reserved.

package org.api.enumeration;

/**
 * [OVERVIEW] SortEnum.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/20      (TanDX)        	  Create new
*/

public enum SortEnum {
    /** SORT DESC */
    DESC("desc"),
    /** SORT ASC */
    ASC("asc");

	SortEnum(String text) {
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