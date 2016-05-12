package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.User;
import com.review.www.enums.UserTypeEnum;
import com.review.www.request.LoginReq;
import com.review.www.response.UserResp;

import java.util.List;

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

    /**
     * change password
     * @param number
     * @param newPwd
     * @param type
     */
    Result changePassword(String number, String newPwd, Byte type);
    /**
     * getByType
     */
    List<UserResp> getByType(int type);
    /**
     * addUserManage
     */
    int addUserManage(int type ,User user);

    int editUserManage(int type ,User user);

    int delUserManage(int type ,String id);

    UserResp getByTypeAndId(int type,String id);

    List<UserResp> getByNumberOrName(int type,String keyword);
}
