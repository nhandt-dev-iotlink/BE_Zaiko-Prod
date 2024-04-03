/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import java.text.MessageFormat;
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
 * 001       1.0       2019/09/06      (TanDX)      Create new
*/
public class MessageUtils {

    private static ResourceBundle rsMessagesJp;

    private static ResourceBundle rsMessagesEn;

    /**
     * @author (TanDX)
     * @param key
     * @param locate
     * @param param
     * @return
     */
    public static String getMessage(String key, String locate, Object... param) {
        ResourceBundle rsMessages;
        // Load all message from message.properties

        if (Constants.LOCATE_JP.equals(locate) || DataUtil.isEmpty(locate)) {
            if (rsMessagesJp == null) {
                Locale.setDefault(new Locale("jp", "JP"));
                rsMessagesJp = ResourceBundle.getBundle(Constants.PROPERTIE_MESSAGE);
            }
            rsMessages = rsMessagesJp;
        } else {
            if (rsMessagesEn == null) {
                Locale.setDefault(new Locale("en", "US"));
                rsMessagesEn = ResourceBundle.getBundle(Constants.PROPERTIE_MESSAGE);
            }
            rsMessages = rsMessagesEn;
        }

        String message;
        try {
            // Get message from rsMessages
            message = rsMessages.getString(key);
            if (DataUtil.isEmpty(message)) {
                return key;
            }
            // Replace param
            if (param != null && param.length > 0) {
                message = MessageFormat.format(message, param);
            }
        } catch (MissingResourceException e) {
            message = key;
        }
        // return content
        return message;
    }

    /**
     * @author (TanDX)
     * @param key
     * @param param
     * @return
     */
    public static String getMessage(String key, Object... param) {
        return getMessage(key, null, param);
    }
}
