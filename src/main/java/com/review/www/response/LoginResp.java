package com.review.www.response;

import java.io.Serializable;

/**
 * Created by zhangtf on 16/1/5.
 */
public class LoginResp implements Serializable {
    private String token;
    private String userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
