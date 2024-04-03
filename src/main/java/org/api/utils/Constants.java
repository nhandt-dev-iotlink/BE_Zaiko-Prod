/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.utils;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * [OVERVIEW] Constants.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)       Create new
*/
public class Constants {

    // Status response
    public static final String STATUS_OK = "200";
    public static final String STATUS_201 = "201";
    public static final String STATUS_SYSTEM_ERROR = "500";
    public static final String STATUS_BAD_REQUEST = "400";
    public static final String STATUS_NOT_FOUND = "404";
    public static final String STATUS_MAINTAINMENT = "300";
    public static final String STATUS_PERMISSION = "301";
    public static final String STATUS_X_CYBOZU_AUTHORIZATION = "520";
    public static final String STATUS_DUPLICATE = "409";

    // Message response
    public static final String MESSAGE_OK = "処理に成功しました";
    public static final String MESSAGE_SYSTEM_ERROR = "サーバーでエラーが発生しました。管理者に問い合わせてください。";

    public static final String PROPERTIE_MESSAGE = "message";
    public static final String PROPERTIE_ITEM_NAME = "item_name";
    public static final String PROPERTIE_ITEM_MAIL = "mail_info";
    public static final String PROPERTIE_ITEM_CSV = "item_csv";
    public static final String PROPERTIE_APP = "application";
    public static final String MAIL_HOST = "mail.host";
    public static final String MAIL_PORT = "mail.port";
    public static final String MAIL_USERNAME = "mail.username";
    public static final String MAIL_PASSWORD = "mail.password";
    public static final String PROPERTIES_DATA = "data";
    public static final String RESULTS = "results";

    public static final String DEL_FLG_0 = "0";
    public static final String DEL_FLG_1 = "1";
    public static final String FREE_FLG_0 = "0";
    public static final String FREE_FLG_1 = "1";
    public static final String FREE_FLG_3 = "3";
    public static final String PDF = "pdf";
    // Message key
    public static final String ID_ERR00001 = "ERR00001";
    public static final String ID_BKE00003 = "BKE00003";
    public static final String ID_BKE00004 = "BKE00004";
    public static final String ID_BKE00005 = "BKE00005";
    public static final String ID_BKE00006 = "BKE00006";
    public static final String ID_BKE00007 = "BKE00007";
    public static final String ID_BKE00008 = "BKE00008";
    public static final String ID_BKE00009 = "BKE00009";
    public static final String ID_BKE00010 = "BKE00010";
    public static final String ID_BKE00011 = "BKE00011";
    public static final String ID_BKE00012 = "BKE00012";
    public static final String ID_BKE00013 = "BKE00013";
    public static final String ID_BKE00014 = "BKE00014";
    public static final String ID_BKE00015 = "BKE00015";
    public static final String ID_BKE00016 = "BKE00016";
    public static final String ID_BKE00017 = "BKE00017";
    public static final String ID_BKE00019 = "BKE00019";
    public static final String ID_BKE00020 = "BKE00020";
    public static final String ID_BKE00021 = "BKE00021";
    public static final String ID_BKE00028 = "BKE00028";
    public static final String ID_BKE00029 = "BKE00029";
    public static final String ID_BKE00030 = "BKE00030";
    public static final String ID_BKE00031 = "BKE00031";
    public static final String ID_BKE00032 = "BKE00032";
    public static final String ID_BKE00033 = "BKE00033";
    public static final String ID_BKE00034 = "BKE00034";
    public static final String ID_BKE00039 = "BKE00039";
    public static final String ID_BKE00040 = "BKE00040";
    public static final String ID_BKE00041 = "BKE00041";
    public static final String ID_BKE00058 = "BKE00058";
    public static final String ID_BKE00068 = "BKE00068";
    public static final String ID_BKE00069 = "BKE00069";
    public static final String ID_BKE00070 = "BKE00070";
    public static final String ID_BKE00071 = "BKE00071";
    public static final String ID_BKE00072 = "BKE00072";
    public static final String ID_BKE00073 = "BKE00073";
    public static final String ID_BKE00074 = "BKE00074";



    public static final String DATE_PATTEN = "yyyy/MM/dd";
    public static final String DATE_PATTEN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_PATTEN_WITHOUT_SEPARATE = "yyyyMMdd";
    public static final String DATE_TIME_PATTEN = "yyyy/MM/dd HH:mm";
    public static final String DATE_PATTEN_YYYYMM = "yyyy/MM";

    public static final String PASSWORD_PATTEN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(\\S+){8,255}$";
    public static final String ACTION_MANUAL = "1";
    public static final String ACTION_AUTOMATIC = "0";

    public static final String FILE_PATH = "file_path";

    public static final Integer PDF_DS = 1;
    public static final Integer PREFIX_LENGTH = 4;
    public static final Integer PREFIX_LENGTH_6 = 6;
    public static final String ROUND_TYPE_0 = "0";
    public static final String ROUND_TYPE_1 = "1";

    // BATCH
    public static final String BATCH_STATUS_0 = "0";
    public static final String BATCH_STATUS_1 = "1";
    public static final String BATCH_STATUS_2 = "2";
    public static final String BATCH_STATUS_3 = "3";
    public static final String TIME_MILISECOND_PATTEN = "HH:mm:ss.SSS";

    public static final String ID_BKI00001 = "BKI00001";
    public static final String ID_BKI00002 = "BKI00002";
    public static final String ID_BKI00003 = "BKI00003";
    public static final String ID_BKI00004 = "BKI00004";

    public static final String OPTIMIZE_IDX = "OPTIMIZE_IDX";
    public static final String OPTIMIZE_CAR_IDX = "OPTIMIZE_CAR_IDX";
    public static final String OPTIMIZE_CAR_IMAGE_IDX = "OPTIMIZE_CAR_IMAGE_IDX";
    public static final String OPTIMIZE_ORDER_IDX = "OPTIMIZE_ORDER_IDX";
    public static final String OPTIMIZE_INVOICE_IDX = "OPTIMIZE_INVOICE_IDX";
    public static final String INSERT_INVOICE_TYPE_ORDER_CAR = "InsertInvoiceTypeOrderCar";
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "ConstraintViolationException";
    public static final String ROLE_SYSTEM = "SYSTEM";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    public static final String ROLE_END_USER = "PACKAGE_END_USER";
    public static final String ROLE_R = "R";
    public static final String FLG_IS_ADMIN = "1";
    public static final String FLG_IS_NOT_ADMIN = "0";
    public static final String FLG_PACKAGE_TRANSPORT = "2";
    public static final String FLG_ZERO = "0";
    public static final String FLG_ONE = "1";
    public static final String FLG_TWO = "2";
    public static final String FLG_THREE = "3";
    public static final String FLG_FOUR = "4";
    public static final String DELIMITER_COMMA = ",";
    public static final String DATA_JP = "データ";

    public static final String LOCATE_EN = "locate_en";
    public static final String LOCATE_JP = "locate_jp";

    public static final String FREE_SPACE_FULL_SIZE = "\u3000";

    // Mail infor
    public static final String ENCODEDING_UFT8 = "utf-8";
    public static final String MAIL_CONTENT_TYPE = "text/html; charset=UTF-8";
    public static final String KEY_MAIL_FROM = "mail_from";
    public static final String KEY_MAIL_CREATE_USER_SUBJECT = "mail_create_user_subject";
    public static final String KEY_MAIL_CREATE_USER_BODY = "mail_create_user_body";
    public static final String KEY_MAIL_USER_TO = "mail_user_to";
    public static final String KEY_MAIL_USER_WELLCOME = "mail_user_wellcome";
    public static final String KEY_MAIL_USER_FROM = "mail_user_from";
    public static final String KEY_MAIL_USER_THANKS_START = "mail_user_thanks_start";
    public static final String KEY_MAIL_USER_CONTENT = "mail_user_content";
    public static final String KEY_MAIL_USER_ID_TITLE = "mail_user_id_title";
    public static final String KEY_MAIL_PASSWORD_TITLE = "mail_password_title";
    public static final String KEY_MAIL_URL_LOGIN = "mail_url_login";
    public static final String KEY_MAIL_URL = "mail_url";
    public static final String KEY_MAIL_USER_THANKS_END = "mail_user_thanks_end";
    public static final String KEY_DELEGATE = "DELEGATE";
    public static final String KEY_DELEGATE_TEL = "DELEGATE_TEL";
    public static final String KEY_DELEGATE_MAIL = "DELEGATE_EMAIL";
    public static final String KEY_MAIL_CREATE_END_USER_BODY = "mail_create_end_user_body";
    public static final String KEY_MAIL_CREATE_END_USER_SUBJECT = "mail_create_end_user_subject";
    public static final String KEY_MAIL_FOOTER = "mail_footer";

    public static final String PREFIX_INVOICE = "I";
    public static final String UNDERSCORE = "_";
    public static final String DOT = ".";
    public static final String ASTERICK = "*";
    public static final String CSV = "csv";
    public static final String HEADER_CUSOTOMER_CSV = "header_csv_user_info";
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final String SIX = "6";
    public static final Integer ZERO_IN = 0;
    public static final Integer ONE_IN = 1;
    public static final Integer FOUR_IN = 4;
    public static final Integer FIVE_IN = 5;
    public static final String KEY_MAIL_INVOICE_SUBJECT = "mail_invoice_subject";
    public static final String KEY_MAIL_INVOICE_REFUND_SUBJECT = "mail_invoice_refund_subject";
    public static final String KEY_MAIL_INVOICE_BODY = "mail_invoice_body";
    public static final String KEY_MAIL_INVOICE_REFUND_BODY = "mail_invoice_refund_body";
    public static final String FLG_ACCOUNT_LOCK = "1";
    public static final String FLG_ACTION = "1";
    public static final String DEFAULT_TIME_RESULT = "00:00";
    /** The Constant PATH_FILE_TEMPLATE_PDF. */
    public static final String PATH_FILE_TEMPLATE_PDF = "path_file_template_pdf";
    public static final String AUCTION_RESULT_1 = "1";
    public static final String TRANSPORT_STATUS_1 = "1";
    public static final String EXPORT_STATUS_1 = "1";
    public static final String EXPORT_STATUS_2 = "2";
    public static final String EXPORT_STATUS_0 = "0";
    public static final String TYPE_AUCTION_CAR = "01";
    public static final String FILE_PDF = ".pdf";

    public static final String JG_MEMBER = "正会員 JG";
    public static final String JP_MEMBER = "正会員 JP";
    public static final String JA_MEMBER = "準会員 JA";
    public static final String JF_MEMBER = "準会員 JF";

    public static final String KEY_MAIL_ORDER_SUCCESS_SUBJECT = "mail_order_success_subject";
    public static final String KEY_MAIL_ORDER_SUCCESS_BODY = "mail_order_success_body";
    public static final String KEY_MAIL_DATA_CHANGE_SUBJECT = "mail_car_change_subject";
    public static final String KEY_MAIL_DATA_CHANGE_BODY = "mail_car_change_body";
    public static final String KEY_MAIL_DELETE_ORDER_SUCCESS_BODY = "mail_delete_order_success_body";
    public static final String KEY_MAIL_DELETE_ORDER_SUCCESS_SUBJECT = "mail_delete_order_success_subject";

    public static final String GET_ORDER_LIST = "get_order_list";
    public static final String GET_ORDER_HISTORY = "get_order_history";
    public static final String GET_ORDER_SUCCESS = "get_order_success";
    public static final String GET_ORDER_SALES = "get_order_sales";

    public static final Integer USER_ID_SYSTEM = 1;
    public static final int TIME_NEXT_SUCCESS = 10;
    public static final String NUMBER_CUT_FLG = "NumberCutFlg";
    public static final String EXPORT_INSPECTION = "ExportInspection";
    public static final String NODA_REQUEST_FLG = "NodaRequestFlg";

    // 0: Not request, 1: Requested
    public static final String PACKAGE_TRAN_STATUS = "1";

    public static final String PATH_TOKEN = "/oauth/token";
    // Access token name
    public static final String SESSION = "SESSION";

    public static final List<String> PUBLIC_API = Lists.newArrayList("/api/information", "/api/testSendMail", "/api/order", "/api/common/dialog-common");

    public static final String LINK_CLOUD_PLATFORM = "https://www.googleapis.com/auth/cloud-platform";

}
