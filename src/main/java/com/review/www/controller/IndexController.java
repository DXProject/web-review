package com.review.www.controller;

import com.jopool.jweb.utils.StringUtils;
import com.review.www.constants.Constants;
import com.review.www.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gexin on 16/3/27.
 */
@Controller
@RequestMapping("/")
public class IndexController extends WebBaseController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private UserService userService;

    /**
     * login
     *
     * @return
     */
    @RequestMapping("login.htm")
    public ModelAndView login(RedirectAttributesModelMap model) {
        return getSessionUserMV("login", model);
    }

    @RequestMapping("doLogin.htm")
    public String doLogin(HttpServletRequest request, String phoneOrNumber, String password, RedirectAttributesModelMap model) {
        log.debug("name:{},password:{}", phoneOrNumber, password);
        if (StringUtils.isEmpty(phoneOrNumber) || StringUtils.isEmpty(password)) {
            addErrorAction(model, "请输入手机号或密码");
            return "redirect:login.htm";
        }
//        Passport passport = passportService.getByPhoneAndType(phoneOrNumber, PassportType.TRAVEL_AGENCY);
//        if (null == passport || passport.getIsDeleted()) {
//            passport = passportService.getByPhoneAndType(phoneOrNumber, PassportType.ADMIN);
//            if (null == passport || passport.getIsDeleted()) {
//                passport = passportService.getByPhoneAndType(phoneOrNumber, PassportType.MONITOR);
//            }
//            if (null == passport) {
//                addErrorAction(model, "手机号或密码错误");
//                return "redirect:login.htm";
//            }
//        }
//        if (!StringUtils.isEmpty(passport.getPassword()) && !PasswordHash.validatePassword(password, passport.getPassword())) {
//            addErrorAction(model, "手机号或密码错误");
//            return "redirect:login.htm";
//        } else {
//            String userId = passportService.getUserId(passport);
//            if (StringUtils.isEmpty(userId)) {
//                addErrorAction(model, "手机号或密码错误");
//                return "redirect:login.htm";
//            }
//            SessionUser user = new SessionUser();
//            user.setPassportId(passport.getId());
//            user.setType(passport.getType());
//            user.setName(passport.getName());
//            user.setUserId(userId);
//            request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_USER, user);
//        }
        return "redirect:index.htm";
    }

    /**
     * 退出登陆
     *
     * @param request
     * @return
     */
    @RequestMapping("logout.htm")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.SESSION_KEY_LOGIN_USER);
        return "redirect:login.htm";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index.htm")
    public ModelAndView index() {
        return getSessionUserMV("index");
    }

    /**
     * 顶部
     *
     * @return
     */
    @RequestMapping("top.htm")
    public ModelAndView top() {
        return getSessionUserMV("/top");
    }

    /**
     * 左侧
     *
     * @return
     */
    @RequestMapping("left.htm")
    public ModelAndView left() {
        return getSessionUserMV("/left");
    }

}
