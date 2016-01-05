package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.request.LoginReq;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public interface UserService {
    /**
     * 登录
     *
     * @param req
     */
    Result login(LoginReq req);
}
