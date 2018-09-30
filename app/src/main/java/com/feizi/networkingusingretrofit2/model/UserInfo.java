package com.feizi.networkingusingretrofit2.model;

/**
 * Created by Edalat on 2018/09/30.
 */

public class UserInfo {
    private String UserName;
    private String Email;

    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }
}
