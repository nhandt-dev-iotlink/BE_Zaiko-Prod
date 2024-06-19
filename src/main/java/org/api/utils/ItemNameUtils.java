/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * [OVERVIEW] Get message from file properties.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0      2022/07/01     (TanDX)       Create new
*/
public class ItemNameUtils {

    private static final String COMMON_COLUMNS = "common_columns";

    private static String commonColumns;

    private static ResourceBundle rsItemNameJp;

    private static ResourceBundle rsItemNameEn;

    /*
     * Get resource and set bundle locate default
     */
    public static String getItemName(String key, String alias) {
        return getItemName(key, null, alias);
    }

    /**
     * @author (TanDX)
     * @param key
     * @param locate
     * @param alias
     * @return
     */
    public static String getItemName(String key, String locate, String alias) {
        ResourceBundle rsItemName;
        // Load all message from message.properties
        if (Constants.LOCATE_JP.equals(locate) || DataUtil.isEmpty(locate)) {
            if (rsItemNameJp == null) {
                Locale.setDefault(new Locale("jp", "JP"));
                rsItemNameJp = ResourceBundle.getBundle(Constants.PROPERTIE_ITEM_NAME);
                commonColumns = rsItemNameJp.getString(COMMON_COLUMNS);
            }
            rsItemName = rsItemNameJp;
        } else {
            if (rsItemNameEn == null) {
                Locale.setDefault(new Locale("en", "US"));
                rsItemNameEn = ResourceBundle.getBundle(Constants.PROPERTIE_ITEM_NAME);
                commonColumns = rsItemNameEn.getString(COMMON_COLUMNS);
            }
            rsItemName = rsItemNameEn;
        }

        String message;
        try {
            // Get message from rsMessages
            if (DataUtil.isEmpty(alias) && commonColumns.contains(key + ";")) {
                message = rsItemName.getString(key);
            } else {
                message = rsItemName.getString(alias + "." + key);
            }
            if (DataUtil.isEmpty(message)) {
                message = key;
            }
        } catch (MissingResourceException e) {
            message = key;
        }
        // return content
        return message;
    }
}
