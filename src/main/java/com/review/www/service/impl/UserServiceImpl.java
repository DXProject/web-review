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
    public Result login(LoginReq req) {
        User user = userMapper.selectByNumber(req.getNumber());
        if (null == user || user.getType() != req.getType() || !PasswordHash.validatePassword(req.getPassword(), user.getPassword())) {
            return new Result(Code.ERROR, CodeMessage.ACCOUNT_PWD_ERROR);
        }
        String userId = user.getId();
        //生成并保存token
        String token = UUIDUtils.createId();
        if (ModeEnum.DEVELOP == ApplicationConfigHelper.getMode() || ModeEnum.SNAPSHOT == ApplicationConfigHelper.getMode() || ModeEnum.RELEASE == ApplicationConfigHelper.getMode()) {
            token = userId;
        }
        cacheBean.put(Constants.CACHE_KEY_USER_TOKEN + userId, token);
        LoginResp resp = new LoginResp();
        resp.setUserId(user.getId());
        resp.setToken(token);
        return new Result(Code.SUCCESS, resp);
    }

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
    public String getUserId(User user) {
        //根据不同类型获取userId
        String userId = null;
        if (UserTypeEnum.ADMIN.getValue() == user.getType()) {
            userId = user.getId();
        } else if (UserTypeEnum.APPLICANT.getValue()  == user.getType()) {
            userId = user.getId();
        } else if (UserTypeEnum.SECONDARY_COLLEGE.getValue()  == user.getType()) {
            userId = user.getId();
        }
        return userId;
    }

    @Override
    public void setSelfBean(UserService object) {
        this.selfService = object;
    }
}
