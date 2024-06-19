/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * [OVERVIEW] Response information.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01     (TanDX)       	Create new
*/
public class ResultBean implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The meta. */
    private MetaClass meta;

    /** . */
    private Object data;

    /**  infor. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object dataInfor;

    /** . */
    // Errors result
    private List<ErrorBean> errors = new ArrayList<ErrorBean>();

    /**
     * Instantiates a new result bean.
     * @author (TanDX) 
     * @param data 
     * @param code 
     * @param message 
     */
    public ResultBean(Object data, String code, String message) {
        this.meta = new ResultBean.MetaClass(code, message);
        this.data = data;

    }
    
    /**
     * Instantiates a new result bean.
     *
     * @author (TanDX)
     * @param data 
     * @param code 
     * @param filed 
     * @param message 
     */
    public ResultBean(Object data, String code, String field ,String message) {
        this.meta = new ResultBean.MetaClass(code, field, message);
        this.data = data;

    }

    /**
     * Instantiates a new result bean.
     *
     * @param code 
     * @param message 
     */
    public ResultBean(String code, String message) {
        this.meta = new ResultBean.MetaClass(code, message);
    }

    /**
     * Instantiates a new result bean.
     *
     * @param code 
     * @param message 
     * @param errors 
     */
    public ResultBean(String code, String message, List<ErrorBean> errors) {
        this.meta = new ResultBean.MetaClass(code, message);
        this.errors = errors;
    }

    /**
     * Instantiates a new result bean.
     *
     * @param code 
     * @param field 
     * @param message 
     */
    public ResultBean(String code, String field, String message) {
        this.meta = new ResultBean.MetaClass(code, field, message);
    }

    /**
     * Gets the meta.
     *
     * @return the meta
     */
    public MetaClass getMeta() {
        return meta;
    }

    /**
     * Sets the meta.
     *
     * @param meta 
     */
    public void setMeta(MetaClass meta) {
        this.meta = meta;
    }

    /**
     * Gets .
     *
     * @return 
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets .
     *
     * @param data 
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Gets .
     *
     * @return 
     */
    public List<ErrorBean> getErrors() {
        return errors;
    }

    /**
     * Sets .
     *
     * @param errors 
     */
    public void setErrors(List<ErrorBean> errors) {
        this.errors = errors;
    }

    /**
     * Adds .
     *
     * @param error 
     */
    public void addError(ErrorBean error) {
        this.errors.add(error);
    }

    /**
     * Gets  infor.
     *
     * @return  infor
     */
    public Object getDataInfor() {
        return dataInfor;
    }

    /**
     * Sets  infor.
     *
     * @param dataInfor  infor
     */
    public void setDataInfor(Object dataInfor) {
        this.dataInfor = dataInfor;
    }

    /**
     * The Class MetaClass.
     */
    public class MetaClass implements Serializable {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** . */
        private String code;

        /** . */
        private String field;

        /** . */
        private String message;

        /**
         * Instantiates a new meta class.
         *
         * @param code 
         * @param message 
         */
        public MetaClass(String code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * Instantiates a new meta class.
         *
         * @param code 
         * @param field 
         * @param message 
         */
        public MetaClass(String code, String field, String message) {
            this.code = code;
            this.message = message;
            this.field = field;
        }

        /**
         * Gets .
         *
         * @return 
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets .
         *
         * @param code 
         */
        public void setCode(String code) {
            this.code = code;
        }

        /**
         * Gets .
         *
         * @return 
         */
        public String getMessage() {
            return message;
        }

        /**
         * Sets .
         *
         * @param message 
         */
        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * Gets .
         *
         * @return 
         */
        public String getField() {
            return field;
        }

        /**
         * Sets .
         *
         * @param field 
         */
        public void setField(String field) {
            this.field = field;
        }
    }
}
