/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.api.bean.reponse.UserRoleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mifmif.common.regex.Generex;
import com.opencsv.CSVWriter;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * [OVERVIEW] Data util.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0      2022/07/01      (TanDX)    	  Create new
*/
public class DataUtil {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

    /** The Constant fullSymbols. */
    private static final String fullSymbols = "　！“”＃＄％＆’（）＊＋，－．／：；＜＝＞？＠［￥］￡￠≒≠±∝∞" + "＾＿‘｛｜｝～゛、。※「」○◎●×△▽▲▼∵∴÷↑↓←→￣⇔⇒" + "【】『』〃…♂♀０-９ａ-ｚＡ-Ｚα-σΑ-Σ〒☆★";

    /** The Constant harfSymbols. */
    private static final String harfSymbols = " !\\\"#$%&\'()*+,\\-./:;<=>?@\\[\\\\\\]\\^_`{|}~ﾞ";

    /** The Constant YYYYMMDDHHMMSS_FORMAT_STR. */
    private static final String YYYYMMDDHHMMSS_FORMAT_STR = "yyyy/MM/dd HH:mm";

    /** The Constant YYYYMMDD_FORMAT. */
    private static final SimpleDateFormat YYYYMMDD_FORMAT = new SimpleDateFormat("yyyyMMdd");

    /** The Constant YYYY_MM_DD_FORMAT_EN. */
    private static final SimpleDateFormat YYYY_MM_DD_FORMAT_EN = new SimpleDateFormat("yyyy-MM-dd");

    /** The Constant YYYYMMDDHHMMSS_FORMAT. */
    private static final SimpleDateFormat YYYYMMDDHHMMSS_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /** The Constant YYYYMMDDHHMMSS_FORMAT. */
    private static final SimpleDateFormat YYYYMMDDHHMMSSSSS_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /** The Constant YYYY$MM$DD_FORMAT. */
    private static final SimpleDateFormat YYYY$MM$DD_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    /** The Constant TOKEN_PREFIX. */
    public static final String TOKEN_PREFIX = "Bearer";

    /** The Constant PATH_FILE_TEMPLATE_PDF. */
    public static final String PATH_FILE_TEMPLATE_PDF = "path_file_template_pdf";

    /** The Constant PATH_FILE_EXPORT_PDF. */
    public static final String PATH_FILE_EXPORT_PDF = "path_file_export_pdf";

    /** The Constant PATH_FILE_DATA. */
    public static final String PATH_FILE_DATA = "path_file_data";

    /** The env. */
    @Autowired
    private static Environment env;

    /**
     * Check emailValid.
     *
     * @param email
     * @return true false
     */
    public static boolean isEmailValid(String email) {
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /**
     * Check number phone 10 digit or 11 digit.
     *
     * @param number
     * @return true false
     */
    public static boolean checkNumberPhone(String number) {
        if (isEmpty(number)) {
            return true;
        }

        Pattern pattern = Pattern.compile("^[0-9.-]{0,11}$");
        return pattern.matcher(number).matches();
    }

    /**
     * Check code price.
     *
     * @param code
     * @return true, if successful
     */
    public static boolean checkCodePrice(String code) {
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }

    /**
     * Check data 0/1.
     *
     * @param data
     * @return true false
     */
    public static boolean isBoolean(String data) {
        if (data.equals("0") || data.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check zip code 7 digit.
     *
     * @param number
     * @return true false
     */
    public static boolean checkZipCode(String number) {
        Pattern pattern = Pattern.compile("^[0-9.-]$");
        Matcher matcher = pattern.matcher(number);
        return number.length() <= 8 && matcher.matches();
    }

    /**
     * Return integer from string value.
     *
     * @param value
     * @return the integer
     */
    public static Integer parseIntWithNull(String value) {
        if (isEmpty(value)) {
            return null;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * Return float from string value.
     *
     * @param value
     * @return the float
     */
    public static Float parseFloatWithNull(String value) {
        if (isEmpty(value)) {
            return null;
        } else {
            return Float.parseFloat(value);
        }
    }

    /**
     * Return type JSON of String.
     *
     * @param value
     * @return ing
     */
    public static String convertToStringJson(String value) {
        if (isEmpty(value)) {
            return null;
        } else {
            return value;
        }
    }

    /**
     * Check if string is integer.
     *
     * @param str
     * @return true, if is true integer
     */
    public static boolean isTrueInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Check if string is follow pattern.
     *
     * @param value
     * @param patternStr
     * @return true, false
     */
    public static boolean checkBlankOrPattern(String value, String patternStr) {
        if (isEmpty(value)) {
            return true;
        }

        final Pattern pattern = Pattern.compile(patternStr);
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is empty.
     *
     * @param value
     * @return true, false
     */
    public static boolean isEmpty(String value) {
        if (null == value || 0 == value.length()) {
            return true;
        }

        return false;
    }

    /**
     * Check is empty.
     *
     * @param value
     * @return true, false
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(List value) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * Check is integer.
     *
     * @param value
     * @return true(integer), false(not integer)
     */
    public static boolean isInteger(String value) {
        final Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is integer.
     *
     * @param value
     * @return true(integer), false(not integer)
     */
    public static boolean isIntegerWithNegative(String value) {
        final Pattern pattern = Pattern.compile("(-?)\\d+(\\.\\d+)?");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check time with format HHMMSS.
     *
     * @param value
     * @return true, false
     */
    public static boolean isTimeHHMMSS(String value) {
        Pattern pattern = Pattern.compile("^\\d\\d[0-5]\\d[0-5]\\d$");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is a character of ASCII(not included symbols).
     *
     * @param value
     * @return true, false
     */
    public static boolean isASCII(String value) {
        Pattern pattern = Pattern.compile("^[\\p{Alnum}\\p{Space}]+$");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is a character of ASCII(included symbols).
     *
     * @param value
     * @return true, false
     */
    public static boolean isASCIISymbols(String value) {
        Pattern pattern = Pattern.compile("^[\\p{Alnum}" + harfSymbols + " ]+$");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is a character kana(excluded symbols).
     *
     * @param value
     * @return true, false
     */
    public static boolean isKana(String value) {
        // Pattern pattern = Pattern.compile("^[\\p{InHalfwidthandFullwidthForms}]+$");
        Pattern pattern = Pattern.compile("^(([0-9 ]+)|([０-９ ]+)|([゠-ヿ ]+)|([ｦ-ﾟ ]+))*$");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is a character fullsize.
     *
     * @param value
     * @return true, false
     */
    public static boolean isFullWidthKatakana(String value) {
        Pattern pattern = Pattern.compile("([ァ-ン]+$)");
        return pattern.matcher(value).matches();
    }

    /**
     * check is katakana fullsize and number halfsize.
     *
     * @param value
     * @return true, if is kata full and number
     */
    public static boolean isKataFullAndNumber(String value) {
        Pattern pattern = Pattern.compile("([ア-ン0-9]+$)");
        return pattern.matcher(value).matches();
    }

    /**
     * Check is a character kana(included symbols).
     *
     * @param value
     * @return true, false
     */
    public static boolean isKanaSymbols(String value) {
        Pattern pattern = Pattern.compile("^[\\p{InHalfwidthandFullwidthForms}&&[^" + fullSymbols + "]]+$");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Check is a character fullsize.
     *
     * @param str
     * @return true, false
     */
    public static boolean isZenkaku(String str) {

        boolean ret = true;
        if (str.length() < 0 || str.length() > Integer.MAX_VALUE) {
            return false;
        }

        // 一文字ずつチェックする
        for (int n = 0; n < str.length(); n++) {
            String s = str.substring(n, n + 1);
            try {
                byte[] b = s.getBytes("MS932");
                // 1バイト文字
                if (b.length == 1) {
                    // 改行コード
                    if (!(b[0] == 0x0D || b[0] == 0x0A)) {
                        ret = false;
                        continue;
                    }
                    continue;
                }

                // ２バイト文字
                if (b.length == 2) {

                    char val = (char) ((char) (b[0] & 0xFF) << 8 | (char) (b[1] & 0xFF));

                    if ( // 非漢字 0x8140～0x849E
                    !(val >= 0x8140 && val <= 0x849E) &&
                    // １３区文字 0x8740～0x879E
                            !(val >= 0x8740 && val <= 0x879E) &&
                            // 第一水準 0x889F～0x989E
                            !(val >= 0x889F && val <= 0x989E) &&
                            // 第二水準 0x989F～0xEFFC
                            !(val >= 0x989F && val <= 0xEFFC)) {
                        ret = false;
                    }
                } else {
                    ret = false;
                }
            } catch (Exception e) {
                ret = false;
            }
        }

        return ret;
    }

    /**
     * Get Json Object.
     *
     * @param strJson  json
     * @return JsonObject
     * @throws ApiValidateException
     */
    public static JsonObject getJsonObject(String strJson) throws ApiValidateException {
        JsonObject json = null;
        try {
            if (null != strJson && 0 != strJson.length()) {
                json = new Gson().fromJson(strJson, JsonObject.class);
            }
            if (json != null && hasMember(json, "data")) {
                json = json.getAsJsonObject("data");
            }
        } catch (Exception ex) {
            json = null;
        }

        if (null == json) {
            //  format is incorrect.
            throw new ApiValidateException(null, null, "JSONフォーマットが正しくありません。");
        }
        return json;
    }

    /**
     * Gets  array.
     * @author (TanDX)
     * @param strJson
     * @return  array
     * @throws ApiValidateException
     */
    public static JsonArray getJsonArray(String strJson) throws ApiValidateException {
        JsonArray json = null;
        try {
            if (null != strJson && 0 != strJson.length()) {
                json = new Gson().fromJson(strJson, JsonArray.class);
            }
        } catch (Exception ex) {
            json = null;
        }
        if (null == json) {
            throw new ApiValidateException(null, null, "JSONフォーマットが正しくありません。");
        }
        return json;
    }

    /**
     * Get Json Object.
     *
     * @param json
     * @param memberName
     * @return JsonObject
     */
    public static JsonObject getJsonObjectWithMember(JsonObject json, String memberName) {
        try {
            if (json != null && hasMember(json, memberName)) {
                json = json.getAsJsonObject(memberName);
                return json;
            }
        } catch (Exception e) {
            //
        }
        return null;
    }

    /**
     * Get Json Object.
     *
     * @param json
     * @param memberName
     * @return JsonObject
     */
    public static JsonArray getJsonArrayWithMember(JsonObject json, String memberName) {
        JsonArray jsons;
        try {
            if (json != null && hasMember(json, memberName)) {
                jsons = json.getAsJsonArray(memberName);
                return jsons;
            }
        } catch (Exception e) {
            //
        }
        return null;
    }

    /**
     * Get Json Object.
     *
     * @param json
     * @param memberName
     * @return JsonObject
     * @throws ApiValidateException
     */
    public static JsonElement getJsonJsonElement(JsonObject json, String memberName) throws ApiValidateException {
        JsonElement jsons;
        try {
            if (json != null && hasMember(json, memberName)) {
                jsons = json.get(memberName);
                return jsons;
            }
        } catch (Exception e) {
            //  format is incorrect.
            throw new ApiValidateException(null, null, "JSONフォーマットが正しくありません。");
        }
        return null;
    }

    /**
     * Get Json Object.
     *
     * @param json
     * @param memberName
     * @return JsonObject
     * @throws ApiValidateException
     */
    public static String getJsonJsonElementToString(JsonObject json, String memberName) throws ApiValidateException {
        try {
            JsonElement jsons = getJsonJsonElement(json, memberName);
            if (jsons != null) {
                return jsons.toString();
            }
        } catch (Exception e) {
            //  format is incorrect.
            throw new ApiValidateException(null, null, "JSONフォーマットが正しくありません。");
        }
        return null;
    }

    /**
     * Check member is exist.
     *
     * @param json
     * @param memberName
     * @return true, false
     */
    public static boolean has(JsonObject json, String memberName) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return false;
        }
        return true;
    }

    /**
     * Check member is exist.
     *
     * @param json
     * @param memberName
     * @return true, false
     */
    public static boolean hasMember(JsonObject json, String memberName) {
        return json.has(memberName);
    }

    /**
     * Get data from JSON, return String.
     *
     * @param json
     * @param memberName
     * @return String
     */
    public static String getJsonString(JsonObject json, String memberName) {
        return getJsonString(json, memberName, null);
    }

    /**
     * Get data from JSON, return String.
     *
     * @param jsonElement
     * @param memberName
     * @return String
     */
    public static String getJsonString(JsonElement jsonElement, String memberName) {
        JsonObject json = jsonElement.getAsJsonObject();
        return getJsonString(json, memberName, null);
    }

    /**
     * Get data from JSON, return String.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return String
     */
    public static String getJsonString(JsonObject json, String memberName, String defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        return json.get(memberName).getAsString().trim();
    }

    /**
     * Get data to JSON, return Integer.
     *
     * @param json
     * @param memberName
     * @return Integer
     */
    public static Integer getJsonInteger(JsonObject json, String memberName) {
        return getJsonInteger(json, memberName, null);
    }

    /**
     * Get data to JSON, return Integer.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return Integer
     */
    public static Integer getJsonInteger(JsonObject json, String memberName, Integer defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        try {
            return json.get(memberName).getAsInt();
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Get data to JSON, return Long.
     *
     * @param json
     * @param memberName
     * @return Long
     */
    public static Long getJsonLong(JsonObject json, String memberName) {
        return getJsonLong(json, memberName, null);
    }

    /**
     * Get data to JSON, return Long.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return Long
     */
    public static Long getJsonLong(JsonObject json, String memberName, Long defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        try {
            return json.get(memberName).getAsLong();
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Get data to JSON, return Boolean.
     *
     * @param json
     * @param memberName
     * @return Boolean
     */
    public static Boolean getJsonBoolean(JsonObject json, String memberName) {
        return getJsonBoolean(json, memberName, null);
    }

    /**
     * Get data to JSON, return Boolean.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return Boolean
     */
    public static Boolean getJsonBoolean(JsonObject json, String memberName, Boolean defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        try {
            return json.get(memberName).getAsBoolean();
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Get map data from JSON String.
     *
     * @param json
     * @return Map<String, Object>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> createJsonMap(String json) {
        return new Gson().fromJson(json, Map.class);
    }

    /**
     * Get map data of member from JSON String.
     *
     * @param json
     * @param memberName
     * @return Map<String, Object>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getJsonMap(Map<String, Object> json, String memberName) {
        return (Map<String, Object>) json.get(memberName);
    }

    /**
     * Get data from map JSON, return String.
     *
     * @param json
     * @param memberName
     * @return String
     */
    public static String getJsonString(Map<String, Object> json, String memberName) {
        return getJsonString(json, memberName, null);
    }

    /**
     * Get data from map JSON, return String.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return String
     */
    public static String getJsonString(Map<String, Object> json, String memberName, String defaultValue) {
        Object value = json.get(memberName);
        if (value == null) {
            return defaultValue;
        } else if (value instanceof String) {
            return (String) value;
        } else if (value instanceof Number) {
            // Number型ならintの文字列として返す
            Number num = (Number) json.get(memberName);
            return String.valueOf(num.intValue());
        } else {
            return value.toString();
        }
    }

    /**
     * Get data from map JSON, return Integer.
     *
     * @param json
     * @param memberName
     * @return Integer
     */
    public static Integer getJsonInteger(Map<String, Object> json, String memberName) {
        return getJsonInteger(json, memberName, null);
    }

    /**
     * Get data from map JSON, return Integer.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return Integer
     */
    public static Integer getJsonInteger(Map<String, Object> json, String memberName, Integer defaultValue) {
        Object value = json.get(memberName);
        if (value == null) {
            return defaultValue;
        } else if (value instanceof String) {
            String str = (String) value;
            if (str.length() == 0) {
                return defaultValue;
            } else {
                return Integer.valueOf(str);
            }
        } else {
            Number num = (Number) json.get(memberName);
            if (num instanceof Integer) {
                return (Integer) num;
            } else {
                return num.intValue();
            }
        }
    }

    /**
     * Convert Date to String.
     *
     * @param date
     * @return String
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return null;
        }

        try {
            return YYYYMMDD_FORMAT.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Name file.
     * @author (TanDX)
     * @param date
     * @return ing
     */
    public static String nameFile(Date date) {
        if (date == null) {
            return null;
        }

        try {
            return YYYYMMDDHHMMSSSSS_FORMAT.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert Date to String.
     *
     * @param date
     * @return String
     */
    public static String dateToStringYYYYMMDDHHMMSS(Date date) {
        if (date == null) {
            return null;
        }

        try {
            return YYYYMMDDHHMMSS_FORMAT.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert Date to String.
     *
     * @param date
     * @param patttern
     * @return String
     */
    public static String dateToString(Date date, String patttern) {
        if (date == null) {
            return null;
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat(patttern);
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert Date to String.
     *
     * @return String
     */
    public static String getLocalDateTime() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS_FORMAT_STR);
            return LocalDateTime.now().format(formatter);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Convert Date to String.
     *
     * @return String
     */
    public static String getDateTime() {
        try {
            LocalDateTime localTime = LocalDateTime.now();
            int year = localTime.getYear();
            String month = "" + localTime.getMonthValue();
            String day = "" + localTime.getDayOfMonth();
            String hours = "" + localTime.getHour();
            String minute = "" + localTime.getMinute();
            String seconds = "" + localTime.getSecond();
            if (localTime.getMonthValue() < 10) {
                month = "0" + localTime.getMonthValue();
            }
            if (localTime.getDayOfMonth() < 10) {
                day = "0" + localTime.getDayOfMonth();
            }
            if (localTime.getHour() < 10) {
                hours = "0" + localTime.getHour();
            }
            if (localTime.getMinute() < 10) {
                minute = "0" + localTime.getMinute();
            }
            if (localTime.getSecond() < 10) {
                seconds = "0" + localTime.getSecond();
            }
            return year + "" + month + "" + day + "" + hours + "" + minute + "" + seconds;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Convert Date to String.
     *
     * @param date
     * @return String
     */
    public static String dateToStringYYYY$MM$DD(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return YYYY$MM$DD_FORMAT.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * convert string to date.
     *
     * @param dateString  string
     * @return
     */
    public static Date convertStringToDate(String dateString) {
        Date date = null;
        try {
            date = YYYYMMDD_FORMAT.parse(dateString);
        } catch (Exception ex) {
            return null;
        }
        return date;
    }

    /**
     * convert string to date.
     *
     * @param dateString
     * @param patten
     * @return
     */
    public static Date convertStringToDate(String dateString, String patten) {
        SimpleDateFormat originalFormat = new SimpleDateFormat(patten);
        Date date = null;
        try {
            date = originalFormat.parse(dateString);
        } catch (Exception ex) {
            return null;
        }
        return date;
    }

    /**
     * check input value.
     *
     * @param value
     * @return true, if successful
     */
    public static boolean checkValue(String value) {
        final Pattern pattern = Pattern.compile("^[1-9]");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Get data to JSON, return Double.
     *
     * @param json
     * @param memberName
     * @return Integer
     */
    public static Double getJsonDouble(JsonObject json, String memberName) {
        return getJsonDouble(json, memberName, null);
    }

    /**
     * Get data to JSON, return Double.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return Integer
     */
    public static Double getJsonDouble(JsonObject json, String memberName, Double defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        try {
            return json.get(memberName).getAsDouble();
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Checks if is zero one.
     *
     * @param value
     * @return true, if is zero one
     */
    public static boolean isZeroOne(String value) {
        final Pattern pattern = Pattern.compile("^[0-1]");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Checks if is zero to three.
     *
     * @param value
     * @return true, if is zero to three
     */
    public static boolean isZeroToThree(String value) {
        final Pattern pattern = Pattern.compile("^[0-3]");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Checks if is zero to two.
     *
     * @param value
     * @return true, if is zero to two
     */
    public static boolean isZeroToTwo(String value) {
        final Pattern pattern = Pattern.compile("^[0-2]");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Convert string to timestamp.
     *
     * @param strTimestamp
     * @return the timestamp
     */
    public static Timestamp convertStringToTimestamp(String strTimestamp) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(strTimestamp);
            Timestamp timeStampDate = new Timestamp(date.getTime());
            return timeStampDate;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Checks if is phone number.
     *
     * @param tel
     * @return true, if is phone number
     */
    public static boolean isPhoneNumber(String tel) {
        Pattern pattern = Pattern.compile("^[0-9]{1,13}$");
        return pattern.matcher(tel).matches();
    }

    /**
     * Checks if is phone number start zero.
     *
     * @param tel
     * @return true, if is phone number start zero
     */
    public static boolean isPhoneNumberStartZero(String tel) {
        Pattern pattern = Pattern.compile("^0\\d*$");
        return pattern.matcher(tel).matches();
    }

    /**
     * deleteListFileInfolder.
     *
     * @param source
     * @return boolean
     */
    public static boolean deleteListFileInfolder(File source) {
        if (source.exists()) {
            File[] listFile = source.listFiles();
            if (listFile.length != 0) {
                for (File f : listFile) {
                    if (f.isFile()) {
                        f.delete();
                    }
                }
            }
            source.delete();
            return true;
        }
        return false;
    }

    /**
     * Trim all size.
     *
     * @param string ing
     * @return ing
     */
    public static String trimAllSize(String string) {
        String trim;
        trim = string.replaceFirst("(　| )+$", "");
        return trim.replaceFirst("^(　| )+", "");
    }

    /**
     * Trim all space character in begin and end of ing, if input string is
     * null then return null.
     *
     * @author (TanDX)
     * @param string ing
     * @return ing
     */
    public static String trimAllSizeWithNull(String string) {
        if (string != null) {
            String trim;
            trim = string.replaceFirst("(　| )+$", "");
            return trim.replaceFirst("^(　| )+", "");
        } else {
            return null;
        }
    }

    /**
     * Check numbers.
     *
     * @param value
     * @return true(integer), false(not integer)
     */
    public static boolean isNumeric(String value) {
        final Pattern pattern = Pattern.compile("[+-]?\\d*(\\.\\d+)?");
        try {
            return pattern.matcher(value).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * Convert object to json string.
     *
     * @param data
     * @return String
     */
    public static String convertObjectToJsonString(Object data) {

        Gson gson = new Gson();
        return gson.toJson(data);
    }

    /**
     * Convert object to json string with NULL.
     *
     * @param data
     * @return ing
     */
    public static String convertObjectToJsonStringWithNull(Object data) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        return gson.toJson(data);
    }

    /**
     * Change path.
     *
     * @param path
     * @return ing
     */
    /*
     * パスを更新する
     */
    public static String changePath(String path) {
        if (path.startsWith("\"")) {
            path = path.substring(1);
        }

        if (path.endsWith("\"")) {
            path = path.substring(0, path.length() - 1);
        }

        if (!path.endsWith("/")) {
            path += "/";
        }
        return path;
    }

    /**
     * セッションのタイムアウトをチェックする.
     *
     * @param date1  1
     * @param date2  2
     * @return true, if is expired
     */
    public static boolean isExpired(Date date1, Date date2) {
        return date1 != null && date2 != null && date1.before(date2);
    }

    /**
     * Get token id from token or refresh token.
     *
     * @param value
     * @return token id
     */
    public static String extractTokenKey(String value) {
        if (value == null) {
            return null;
        }
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
        }

        try {
            byte[] bytes = digest.digest(value.getBytes("UTF-8"));
            return String.format("%032x", new BigInteger(1, bytes));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
        }
    }

    /**
     * Gets  big decimal.
     *
     * @param json
     * @param memberName
     * @return  big decimal
     * @throws ApiValidateException
     */
    public static BigDecimal getJsonBigDecimal(JsonObject json, String memberName) throws ApiValidateException {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return null;
        }
        try {
            return json.get(memberName).getAsBigDecimal();
        } catch (Exception e) {
            throw new ApiValidateException("", "BigDecimal format no correct!");
        }
    }

    /**
     * Gets  date.
     *
     * @param json
     * @param memberName
     * @return  date
     * @throws ApiValidateException
     */
    public static Date getJsonDate(JsonObject json, String memberName) throws ApiValidateException {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return null;
        }
        try {
            return YYYY$MM$DD_FORMAT.parse(json.get(memberName).getAsString());
        } catch (Exception e) {
            throw new ApiValidateException("", "Date format no correct!");
        }
    }

    /**
     * Gen password.
     *
     * @return ing
     */
    public static String genPassword() {
        try {
            Generex generex = new Generex("([0-9a-zA-Z]{8})");
            return generex.random();
        } catch (Error e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Check min length.
     *
     * @param value
     * @param minlength
     * @return true, if successful
     */
    public static boolean checkMinLength(String value, int minlength) {
        if (DataUtil.isEmpty(value) || value.length() < minlength) {
            return false;
        }
        return true;
    }

    /**
     * Check max length.
     *
     * @param value
     * @param maxlength
     * @return true, if successful
     */
    public static boolean checkMaxLength(String value, int maxlength) {
        if (DataUtil.isEmpty(value) || value.length() > maxlength) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is number.
     *
     * @param value
     * @return true, if is number
     */
    public static boolean isNumber(String value) {
        if (DataUtil.isEmpty(value)) {
            return true;
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * Check pattern.
     *
     * @param value
     * @param sPattern
     * @return true, if successful
     */
    public static boolean checkPattern(String value, String sPattern) {
        if (DataUtil.isEmpty(value)) {
            return true;
        }
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * Checks if is null.
     *
     * @param json
     * @param memberName
     * @return true, if is null
     */
    public static boolean isNull(JsonObject json, String memberName) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if is date.
     *
     * @param value
     * @param sPattern
     * @return true, if is date
     */
    public static boolean isDate(String value, String sPattern) {
        if (isEmpty(value)) {
            return true;
        }
        SimpleDateFormat format = new SimpleDateFormat(sPattern);
        format.setLenient(false);
        try {
            format.parse(value);
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is positive number.
     *
     * @param value
     * @return true, if is positive number
     */
    public static boolean isPositiveNumber(Integer value) {
        if (value != null && value > 0) {
            return true;
        }
        return false;
    }

    /**
     * Gets the access token.
     *
     * @param httpServletRequest
     * @return the access token
     */
    public static String getAccessToken(HttpServletRequest httpServletRequest) {
        return getAccessToken(httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION));
    }

    /**
     * Get access token
     * @author: (TanDX)
     * @return
     */
//    public static String getAccessToken() {
//        return ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getTokenValue();
//    }

    /**
     * Gets the access token.
     *
     * @param header
     * @return the access token
     */
    public static String getAccessToken(String header) {
        if (isEmpty(header)) {
            return null;
        }
        final int space = header.indexOf(' ');
        if (space <= 0) {
            return null;
        }
        final String method = header.substring(0, space);
        if (!TOKEN_PREFIX.equalsIgnoreCase(method)) {
            return null;
        }
        return header.substring(space + 1);
    }

    /**
     * Gets the media type for file name.
     *
     * @param servletContext the servlet context
     * @param fileName the file name
     * @return the media type for file name
     */
    public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
        String mineType = servletContext.getMimeType(fileName);
        try {
            return MediaType.parseMediaType(mineType);
        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    /**
     * Creates the direct tory if not exist.
     *
     * @param path
     */
    public static void createDirectToryIfNotExist(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * Creates the file CSV.
     *
     * @param response
     * @param fileName
     * @param csvHeader
     * @param csvData
     * @throws Exception
     */
    public static void createFileCSV(HttpServletResponse response, String fileName, String[] csvHeader, List<String[]> csvData) throws Exception {
        response.setContentType("text/csv;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(0xEF);
        outputStream.write(0xBB);
        outputStream.write(0xBF);
        CsvUtils csvWriter = new CsvUtils(new OutputStreamWriter(outputStream, "UTF-8"), CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);
        csvWriter.writeNext(csvHeader, false);
        csvWriter.writeAll(csvData);
        csvWriter.close();
    }

    /**
     * Creates the file PDF download.
     *
     * @param httpResponse
     * @param fileExport
     * @param fileName
     * @param parameters
     * @param data
     * @param mergeCell
     * @return ing
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static String createFilePDFDownload(HttpServletResponse httpResponse, String fileExport, String fileName, Map<String, Object> parameters, List data,
            Boolean... mergeCell) throws Exception {
        String sourceFileName = env.getProperty(PATH_FILE_TEMPLATE_PDF).concat(fileExport.concat(".jrxml"));
        String descFileExport = System.getProperty("java.io.tmpdir").endsWith(System.getProperty("file.separator"))
                ? System.getProperty("java.io.tmpdir").concat(fileName)
                : System.getProperty("java.io.tmpdir").concat(System.getProperty("file.separator")).concat(fileName);
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(data);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
            JasperPrint jprint = null;
            if (mergeCell.length > 0) {
                jprint = JasperFillManager.fillReport(jasperReport, parameters, itemsJRBean);
            } else {
                parameters.put("ItemDataBean", itemsJRBean);
                jprint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource(Constants.PDF_DS));
            }
            JasperExportManager.exportReportToPdfFile(jprint, descFileExport);
            return descFileExport;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Get Curent Date Time.
     *
     * @return the curent date time
     */
    public static Date getCurentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return DataUtil.convertStringToDate(formatter.format(date), "yyyy/MM/dd HH:mm:ss");
    }

    /**
     * Get currency by unit value
     * 0 - ¥, 1 - $, 2 - €.
     *
     * @param unitValue
     * @return the currency
     */
    public static String getCurrency(String unitValue) {
        if ("0".contentEquals(unitValue)) {
            return "¥";
        } else if ("1".contentEquals(unitValue)) {
            return "$";
        } else {
            return "€";
        }
    }

    /**
     * Format zip code.
     *
     * @param value
     * @return ing
     */
    public static String formatZipCode(String value) {
        if (isEmpty(value)) {
            return "";
        }
        return (value.substring(0, 3) + '-' + value.substring(3));
    }

    /**
     * Format phone number.
     *
     * @param value
     * @return string
     */
    public static String formatPhoneNumber(String value) {
        if (isEmpty(value)) {
            return "";
        }
        return value.length() == 10 //
                ? (value.substring(0, 3) + '-' + value.substring(3, 6) + '-' + value.substring(6)) //
                : (value.substring(0, 3) + '-' + value.substring(3, 7) + '-' + value.substring(7));
    }

    /**
     * Format currency.
     *
     * @param bigDecimal
     * @return String
     */
    public static String formatCurrency(BigDecimal bigDecimal) {
        return String.format("%,.0f", bigDecimal.floatValue());
    }

    /**
     * Format currency no rounding.
     *
     * @param bigDecimal
     * @return ing
     */
    public static String formatCurrencyNoRounding(BigDecimal bigDecimal) {
        return new DecimalFormat("###,###,###.##").format(bigDecimal.doubleValue());
    }

    /**
     * Format currency point.
     *
     * @param current
     * @return String
     */
    public static String formatCurrencyPoint(Integer current) {
        return "\u00A5".concat(current.toString());
    }

    /**
     * Format currency point.
     *
     * @param current
     * @return String
     */
    public static String formatCurrencyPoint(Long current) {
        return "\u00A5".concat(current.toString());
    }

    /**
     * Rounding currency.
     *
     * @param bigDecimal
     * @return the big decimal
     */
    public static BigDecimal roundingCurrency(BigDecimal bigDecimal) {
        return bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Format currency.
     *
     * @param value
     * @return String
     */
    public static String formatCurrency(String value) {
        return value.replaceAll("((\\d(?:\\.?\\d)?))(?=(\\d{3})+(?:\\.?\\d+)?+$)", "$1,");
    }

    /**
     * Decode URL.
     *
     * @param url
     * @return String
     */
    public static String decodeURL(String url) {
        if (isEmpty(url)) {
            return url;
        }
        try {
            if (DataUtil.isEmpty(url)) {
                return null;
            }
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }

    /**
     * Format leading zero.
     *
     * @param value
     * @return String
     */
    public static String formatLeadingZero(String value) {
        if (DataUtil.isEmpty(value)) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        return decimalFormat.format(BigDecimal.valueOf(Double.valueOf(value)));
    }

    /**
     * Set value string builder to empty.
     *
     * @param args
     */
    public static void resetValue(StringBuilder... args) {
        for (StringBuilder arg : args) {
            arg.setLength(0);
        }
    }

    /**
     * Gets the end of .
     *
     * @param date
     * @return the end of
     */
    public static Date getEndOfTheDate(Date date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.add(Calendar.HOUR_OF_DAY, 23);
            cal.add(Calendar.MINUTE, 59);
            cal.add(Calendar.SECOND, 59);
        } catch (Exception ex) {
            return null;
        }
        Date dateT = cal.getTime();
        return dateT;
    }

    /**
     * Format id.
     *
     * @param prefix
     * @param id
     * @return String
     */
    public static String formatId(String prefix, Integer id) {
        String format = "%0" + Constants.PREFIX_LENGTH + "d";
        String date = dateToString(new Date());
        String idFormat = prefix + date + String.format(format, id);

        return idFormat;
    }

    /**
     * Format id.
     *
     * @param id
     * @return String
     */
    public static String formatId(Integer id) {
        String format = "%0" + Constants.PREFIX_LENGTH_6 + "d";
        return String.format(format, id);
    }

    /**
     * Format big decimal.
     *
     * @param param
     * @param roundType
     * @return String
     */
    public static String formatBigDecimal(BigDecimal param, String roundType) {
        BigDecimal round = new BigDecimal(0);
        if (Constants.ROUND_TYPE_0.equals(roundType)) {
            round = param.setScale(0, RoundingMode.UP);
        } else if (Constants.ROUND_TYPE_1.equals(roundType)) {
            round = param.setScale(0, RoundingMode.DOWN);
        } else {
            round = param.setScale(0, RoundingMode.HALF_UP);
        }
        return String.valueOf(new DecimalFormat("#,###").format(round));
    }

    /**
     * Format big decimal.
     *
     * @param param
     * @param roundType
     * @param pattern
     * @return String
     */
    public static String formatBigDecimal(BigDecimal param, String roundType, String pattern) {
        if (Objects.isNull(pattern)) {
            pattern = "#,###";
        }
        BigDecimal round = new BigDecimal(0);
        if (Constants.ROUND_TYPE_0.equals(roundType)) {
            round = param.setScale(0, RoundingMode.UP);
        } else if (Constants.ROUND_TYPE_1.equals(roundType)) {
            round = param.setScale(0, RoundingMode.DOWN);
        } else {
            round = param.setScale(0, RoundingMode.HALF_UP);
        }
        return String.valueOf(new DecimalFormat(pattern).format(round));
    }

    /**
     * Round big decimal.
     *
     * @param param
     * @param roundType
     * @return the big decimal
     */
    public static BigDecimal roundBigDecimal(BigDecimal param, String roundType) {
        BigDecimal round = new BigDecimal(0);
        if (Constants.ROUND_TYPE_0.equals(roundType)) {
            round = param.setScale(0, RoundingMode.UP);
        } else if (Constants.ROUND_TYPE_1.equals(roundType)) {
            round = param.setScale(0, RoundingMode.DOWN);
        } else {
            round = param.setScale(0, RoundingMode.HALF_UP);
        }
        return round;
    }

    /**
     * Round big decimal.
     *
     * @param param
     * @param roundType
     * @return the big decimal
     */
    public static BigDecimal roundBigDecimal(String param, String roundType) {
        BigDecimal value = new BigDecimal(param);
        BigDecimal round = new BigDecimal(0);
        if (Constants.ROUND_TYPE_0.equals(roundType)) {
            round = value.setScale(0, RoundingMode.UP);
        } else if (Constants.ROUND_TYPE_1.equals(roundType)) {
            round = value.setScale(0, RoundingMode.DOWN);
        } else {
            round = value.setScale(0, RoundingMode.HALF_UP);
        }
        return round;
    }

    /**
     * Checks for role system.
     *
     * @param roles
     * @return true, if successful
     * @author: (TanDX)
     */
    public static boolean hasRoleSystem(List<UserRoleResponse> roles) {
        for (UserRoleResponse role : roles) {
            if (role.getRole().equals(Constants.ROLE_SYSTEM)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for role param.
     *
     * @param roles
     * @param param
     * @return true, if successful
     * @author: (TanDX)
     */
    public static boolean hasRoleParam(List<UserRoleResponse> roles, String param) {
        for (UserRoleResponse role : roles) {
            if (role.getRole().equals(param)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Replace enter.
     *
     * @param string
     * @return ing
     */
    public static String replaceEnter(String string) {
        if (isEmpty(string)) {
            return "";
        }
        return string.replaceAll("(\r\n|\n)", "\\\\n");
    }

    /**
     * Date to string YYY Y M M D D EN.
     *
     * @param date
     * @return ing
     */
    public static String dateToStringYYYY_MM_DD_EN(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return YYYY_MM_DD_FORMAT_EN.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * createFilePDF.
     *
     * @author (TanDX)
     * @param filePath
     * @param fileExport
     * @param parameters
     * @param data
     * @param mergeCell
     * @return the byte[]
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static byte[] createFilePDF(String filePath, String fileExport, Map<String, Object> parameters, List data, Boolean... mergeCell) throws Exception {
        String sourceFileName = filePath.concat(fileExport.concat(".jrxml"));
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(data);
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
            JasperPrint jprint = null;
            if (mergeCell.length > 0) {
                jprint = JasperFillManager.fillReport(jasperReport, parameters, itemsJRBean);
            } else {
                parameters.put("ItemDataBean", itemsJRBean);
                jprint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource(Constants.PDF_DS));
            }
            ;
            return JasperExportManager.exportReportToPdf(jprint);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Gets the param by url.
     * @author (TanDX)
     * @param urlImage
     * @return the param by url
     * @throws Exception
     */
    public static Map<String, Object> getParamByUrl(String urlImage) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            URL url = new URL(urlImage);
            String q = url.getQuery();
            String[] arr = q.split("&");
            for (String string : arr) {
                String[] arrEle = string.split("=");
                if (arrEle.length > 1) {
                    result.put(arrEle[0], arrEle[1]);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * *
     * formatId.
     *
     * @author (TanDX)
     * @param prefix
     * @param id
     * @return string
     */
    public static String formatIdIvoice(String prefix, Integer id) {
        String format = "%0" + Constants.PREFIX_LENGTH_6 + "d";
        return prefix + String.format(format, id);
    }

    /**
     * Gets the company id by token.
     * @param updateJson
     * @param updateDate
     * @return the company id by token
     * @author: (TanDX)
     */
    public static boolean checkDateUpdate(Long updateJson, Long updateDate) {
        return updateJson.equals(updateDate);
    }

    /**
     * Get data from JSON, return String.
     *
     * @param json
     * @param memberName
     * @return String
     */
    public static BigDecimal getJsonDecimal(JsonObject json, String memberName) {
        return getJsonDecimal(json, memberName, null);
    }

    /**
     * Get data from JSON, return String.
     *
     * @param json
     * @param memberName
     * @param defaultValue
     * @return String
     */
    public static BigDecimal getJsonDecimal(JsonObject json, String memberName, BigDecimal defaultValue) {
        if (!json.has(memberName) || json.get(memberName).isJsonNull()) {
            return defaultValue;
        }
        return json.get(memberName).getAsBigDecimal();
    }

    /**
     * CheckDecimal
     *
     * @param value
     * @param pattern
     * @param defaultValue
     * @return boolean
     */
    public static boolean checkDecimal(String value, String pattern) {
        if (DataUtil.isEmpty(value)) {
            return true;
        }
        return value.matches(pattern);
    }

    /**
     * Checks is list roles contains role system.
     *
     * @param roles
     * @return true, false
     * @author: (TanDX)
     */
    public static boolean isListRolesContainsRoleSystem(List<UserRoleResponse> roles) {
        for (UserRoleResponse role : roles) {
            if (Constants.ROLE_SYSTEM.equals(role.getRole())) {
                return true;
            }
        }
        return false;
    }
}
