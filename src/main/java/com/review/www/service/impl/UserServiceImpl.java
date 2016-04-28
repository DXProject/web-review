package com.review.www.service.impl;

import com.jopool.jweb.cache.Cache;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.spring.SelfBeanAware;
import com.jopool.jweb.utils.PasswordHash;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.constants.CodeMessage;
import com.review.www.constants.Constants;
import com.review.www.dao.UserMapper;
import com.review.www.entity.User;
import com.review.www.enums.ModeEnum;
import com.review.www.enums.UserTypeEnum;
import com.review.www.helper.ApplicationConfigHelper;
import com.review.www.request.LoginReq;
import com.review.www.response.LoginResp;
import com.review.www.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService, SelfBeanAware<UserService> {
    private UserService selfService;
    @Resource
    private UserMapper  userMapper;
    @Resource
    private Cache       cacheBean;

    @Override
    public Result addUser(User user) {
        user.setId(UUIDUtils.createId());
        user.setPassword(PasswordHash.createHash(user.getPassword(), UUIDUtils.createId()));
        userMapper.insert(user);
        return new Result(Code.SUCCESS);
    }

    @Override
    public User getByNumberAndType(String number, int type) {
        return userMapper.selectByNumberAndType(number,type);
    }

    @Override
    public User getById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Result changePassword(String number, String password, Byte type) {
        User userExist = selfService.getByNumberAndType(number, type);
        if (null == userExist) {
            return new Result(Code.ERROR, CodeMessage.PASSPORT_NOT_EXIST);
        }
        userExist.setPassword(PasswordHash.createHash(password, UUIDUtils.createId()));
        userMapper.updateByPrimaryKeySelective(userExist);
        return new Result(Code.SUCCESS);
    }

    @Override
    public void setSelfBean(UserService object) {
        this.selfService = object;
    }
}
