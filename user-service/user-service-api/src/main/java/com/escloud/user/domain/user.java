package com.escloud.user.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018-7-24.
 */
public class user implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8197887386591992327L;

    private Integer id;

    private String userName;

    private String password;

    private String email;

    public user() {
    }

    public user(Integer Id, String UserName,String Email) {
        id=Id;
        userName = UserName;
        email =Email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

}