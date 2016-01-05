package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.User;
import com.review.www.request.LoginReq;
import com.review.www.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
@RestController
@RequestMapping("/user")
public class UserController extends WebBaseController {
    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param req
     * @return
     */
    @RequestMapping("doLogin.htm")
    private Result login(LoginReq req){
        validateParam(req.getNumber(), req.getPassword());
        return userService.login(req);
    }

    /**
     * register
     */
    @RequestMapping("doAddUser.htm")
    private Result doAddUser(User user){
        validateParam(user.getNumber());
        return userService.addUser(user);
    }
}
