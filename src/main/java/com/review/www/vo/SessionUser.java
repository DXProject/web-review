package com.review.www.vo;

import com.jopool.jweb.entity.BaseSessionUser;

/**
 * Created by zhangtianfeng on 15/12/24.
 */
public class SessionUser {
    private String userId;
    private int    type;
    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
