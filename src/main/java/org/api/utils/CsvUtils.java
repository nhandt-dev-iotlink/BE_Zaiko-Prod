/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.opencsv.AbstractCSVWriter;

/**
 * [OVERVIEW] CSVWriteruser.
 *
 * @author:  (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)           Create new
*/
public class CsvUtils extends AbstractCSVWriter {
    protected final char separator;
    protected final char quotechar;
    protected final char escapechar;
    private static ResourceBundle rsItemCsvJp;
    private static ResourceBundle rsItemCsvEn;


    public CsvUtils(Writer writer, char separator, char quotechar, char escapechar, String lineEnd) {
        super(writer, lineEnd);
        this.escapechar = escapechar;
        this.quotechar = quotechar;
        this.separator = separator;
    }

    @Override
    protected void writeNext(String[] nextLine, boolean applyQuotesToAll, Appendable appendable) throws IOException {
        if (nextLine == null) {
            return;
        }
        if (applyQuotesToAll) {
            appendable.append(lineEnd);
        } else {
            applyQuotesToAll = true;
        }

        for (int i = 0; i < nextLine.length; i++) {

            if (i != 0) {
                appendable.append(separator);
            }

            String nextElement = nextLine[i];

            if (nextElement == null) {
                continue;
            }

            Boolean stringContainsSpecialCharacters = stringContainsSpecialCharacters(nextElement);

            appendQuoteCharacterIfNeeded(applyQuotesToAll, appendable, stringContainsSpecialCharacters);

            if (Boolean.TRUE.equals(stringContainsSpecialCharacters)) {
                processLine(nextElement, appendable);
            } else {
                appendable.append(nextElement);
            }

            appendQuoteCharacterIfNeeded(applyQuotesToAll, appendable, stringContainsSpecialCharacters);
        }

        writer.write(appendable.toString());
    }

    private void appendQuoteCharacterIfNeeded(boolean applyQuotesToAll, Appendable appendable, Boolean stringContainsSpecialCharacters) throws IOException {
        if ((applyQuotesToAll || stringContainsSpecialCharacters) && quotechar != NO_QUOTE_CHARACTER) {
            appendable.append(quotechar);
        }
    }

    protected boolean stringContainsSpecialCharacters(String line) {
        return line.indexOf(quotechar) != -1 || line.indexOf(escapechar) != -1 || line.indexOf(separator) != -1 || line.contains(DEFAULT_LINE_END)
                || line.contains("\r");
    }

    protected void processLine(String nextElement, Appendable appendable) throws IOException {
        for (int j = 0; j < nextElement.length(); j++) {
            char nextChar = nextElement.charAt(j);
            processCharacter(appendable, nextChar);
        }
    }

    protected void processCharacter(Appendable appendable, char nextChar) throws IOException {
        if (escapechar != NO_ESCAPE_CHARACTER && checkCharactersToEscape(nextChar)) {
            appendable.append(escapechar);
        }
        appendable.append(nextChar);
    }

    protected boolean checkCharactersToEscape(char nextChar) {
        return quotechar == NO_QUOTE_CHARACTER ? (nextChar == quotechar || nextChar == escapechar || nextChar == separator || nextChar == '\n')
                : (nextChar == quotechar || nextChar == escapechar);
    }
    
    /**
     * @author (TanDX)
     * @param key
     * @param param
     * @return
     */
    public static String getItemCsv(String key, Object... param) {
        return getItemCsv(key, null, param);
    }

    /**
     * @author (TanDX)
     * @param key
     * @param locate
     * @param param
     * @return
     */
    public static String getItemCsv(String key, String locate, Object... param) {

        ResourceBundle rsItemCsv;
        // Load all message from message.properties
        if (Constants.LOCATE_JP.equals(locate) || DataUtil.isEmpty(locate)) {
            if (rsItemCsvJp == null) {
                Locale.setDefault(new Locale("jp", "JP"));
                rsItemCsvJp = ResourceBundle.getBundle(Constants.PROPERTIE_ITEM_CSV);
            }
            rsItemCsv = rsItemCsvJp;
        } else {
            if (rsItemCsvEn == null) {
                Locale.setDefault(new Locale("en", "US"));
                rsItemCsvEn = ResourceBundle.getBundle(Constants.PROPERTIE_ITEM_CSV);
            }
            rsItemCsv = rsItemCsvEn;
        }

        String message;
        try {
            // Get message from rsMessages
            message = rsItemCsv.getString(key);

            if (DataUtil.isEmpty(message)) {
                message = key;
            }
            if (param != null && param.length > 0) {
                message = MessageFormat.format(message, param);
            }
        } catch (MissingResourceException e) {
            message = key;
        }
        // return content
        return message;
    }
}
