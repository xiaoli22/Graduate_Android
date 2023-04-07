package com.example.graduate_android.bean;

import static com.example.graduate_android.utils.DateTimeUtils.getCurrentDateTime;

import java.util.Date;

public class UserModel {
    private String email;
    private String password;
    private Date date; // 添加日期属性

    public UserModel(String email, String password, Date date) { // 修改构造方法
        this.email = email;
        this.password = password;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
