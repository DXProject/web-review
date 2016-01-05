package com.review.www.request;

/**
 * Created by zhangtf on 16/1/5.
 */
public class LoginReq {
    private String number;//教工号
    private String password;//密码
    private int    type;//类型

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
