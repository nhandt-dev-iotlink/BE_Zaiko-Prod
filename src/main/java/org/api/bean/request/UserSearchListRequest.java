/////////////////////////////////////////////////////////////////////////////
//
// © 2022 API. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.bean.request;

import org.apache.commons.collections.MapUtils;
import org.api.bean.jpa.UserLoginEntity;
import org.api.bean.reponse.search.user.UserPageResponse;
import org.api.enumeration.SortEnum;
import org.springframework.data.domain.Pageable;

import com.google.api.client.util.Strings;

/**
 * [OVERVIEW] UserSearchListRequest.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01     (TanDX)     Create new
*/
public class UserSearchListRequest extends PageRequest {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String KEY_WORD = "keyWord";
    public static final String COMPANY_ID = "companyId";
    public static final String DEL_FLG = "delFlg";

    private String sort;
    private Integer companyId;
    private String column;
    private Integer userSystem;

    private String tuKhoa;

    private Pageable pageable;

    public String getTuKhoa() {
        return tuKhoa;
    }

    public void setTuKhoa(String tuKhoa) {
        this.tuKhoa = tuKhoa;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    private String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Integer getUserSystem() {
        return userSystem;
    }

    public void setUserSystem(Integer userSystem) {
        this.userSystem = userSystem;
    }

    @Override
    protected void appendCondition(StringBuilder sql) {
        if (!MapUtils.isEmpty(this.searchFields)) {
            StringBuilder sqlWhere = new StringBuilder();
            this.searchFields.forEach((k, v) -> {
                switch (k) {
                case KEY_WORD:
                    sqlWhere.append(String.format(" AND ule.userName LIKE :%s", k));
                    break;
                case COMPANY_ID:
                    sqlWhere.append(String.format(" AND ule.companyId = :%s ", k));
                    break;
                default:
                    if (v instanceof String) {
                        String value = (String) v;
                        if (value.startsWith("%") || value.endsWith("%")) {
                            sqlWhere.append(String.format(" AND ule.%s LIKE :%s ", k, k));
                        } else {
                            sqlWhere.append(String.format(" AND ule.%s = :%s ", k, k));
                        }
                    }
                }
            });
            if (sqlWhere.length() > 0) {
                sql.append(" WHERE 1=1 ").append(sqlWhere);
            }
        }
    }

    @Override
    public StringBuilder getQuery() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT new org.api.bean.reponse.UserLoginResponse(");
        sql.append("ule.id,");
        sql.append("ule.userName,");
        sql.append("ule.companyId,");
        sql.append("ule.mail,");
        sql.append("ule.birthDay,");
        sql.append("ule.gender,");
        sql.append("ule.phone,");
        sql.append("ule.address,");
        sql.append("ule.freeItem1,");
        sql.append("ule.freeItem2,");
        sql.append("ule.freeItem3)");
        sql.append(" FROM ");
        sql.append("    UserLoginEntity ule ");
        appendCondition(sql);
        if (!Strings.isNullOrEmpty(getSort())) {
        	if (getSort().equals(SortEnum.DESC.getText())) {
            	sql.append("    ORDER BY  ule."+column+" DESC ");
            } else if (getSort().equals(SortEnum.ASC.getText())) {
            	sql.append("    ORDER BY  ule."+column+" ASC ");
            }
        } else {
        	sql.append("    ORDER BY  ule.id DESC ");
        }

        return sql;
    }

    @Override
    public StringBuilder getCount() {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(ule)");
        sql.append(" FROM ");
        sql.append("    UserLoginEntity ule ");
        appendCondition(sql);
        return sql;
    }

    @Override
    public Class<UserLoginEntity> getEntityClass() {
        return UserLoginEntity.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<UserPageResponse> getResponseClass() {
        return UserPageResponse.class;
    }
}
