package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.User;
import com.review.www.request.LoginReq;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public interface UserService {

    /**
     * login
     *
     * @param req
     * @return
     */
    Result login(LoginReq req);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Result addUser(User user);
}
