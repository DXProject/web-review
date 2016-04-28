package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.User;
import com.review.www.enums.UserTypeEnum;
import com.review.www.request.LoginReq;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public interface UserService {

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Result addUser(User user);

    /**
     * get by number and type
     * @param number
     * @param type
     * @return
     */
    User getByNumberAndType(String number, int type);

    /**
     * get by id
     * @param userId
     * @return
     */
    User getById(String userId);
}
