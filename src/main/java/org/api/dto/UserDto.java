package org.api.dto;

import java.io.Serializable;

public class UserDto  {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDto(String userName) {
        this.userName = userName;
    }
}
