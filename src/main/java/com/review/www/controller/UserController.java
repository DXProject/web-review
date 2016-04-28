package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.User;
import com.review.www.request.LoginReq;
import com.review.www.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
     * register
     */
    @RequestMapping("doAddUser.htm")
    private Result doAddUser(User user){
        validateParam(user.getNumber());
        return userService.addUser(user);
    }

    /**
     * 我的账户信息
     *
     * @return
     */
    @RequestMapping("myAccountInfo.htm")
    public ModelAndView myAccountInfo() {
        ModelAndView mv = getSessionUserMV("user/myAccountInfo");
        User user = userService.getById(getSessionUser().getUserId());
        mv.addObject("user", user);
        return mv;
    }
}
