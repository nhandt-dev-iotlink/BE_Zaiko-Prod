package org.api.repository.sql;

public class UserLoginQuery {
    public static final String FIND_USER =
            " SELECT u.* "
          + " FROM t_user_login u "
          + " WHERE u.address LIKE CONCAT('%', :keyWord, '%') ";
}
