package com.review.www.controller;

import com.jopool.jweb.utils.PasswordHash;
import com.jopool.jweb.utils.StringUtils;
import com.review.www.constants.Constants;
import com.review.www.entity.User;
import com.review.www.enums.UserType;
import com.review.www.enums.UserTypeEnum;
import com.review.www.service.UserService;
import com.review.www.vo.SessionUser;
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
    public String doLogin(HttpServletRequest request, String number, String password, RedirectAttributesModelMap model) {
        log.debug("name:{},password:{}", number, password);
        if (StringUtils.isEmpty(number) || StringUtils.isEmpty(password)) {
            addErrorAction(model, "请输入教工号或密码");
            return "redirect:login.htm";
        }
        User user = userService.getByNumberAndType(number, UserType.APPLICANT);
        if (null == user) {
            user = userService.getByNumberAndType(number, UserType.ADMIN);
            if (null == user) {
                user = userService.getByNumberAndType(number, UserType.SECONDARY_COLLEGE);
            }
            if (null == user) {
                addErrorAction(model, "教工号或密码错误");
                return "redirect:login.htm";
            }
        }
        if (!StringUtils.isEmpty(user.getPassword()) && !PasswordHash.validatePassword(password, user.getPassword())) {
            addErrorAction(model, "教工号或密码错误");
            return "redirect:login.htm";
        } else {
            String userId = user.getId();
            if (StringUtils.isEmpty(userId)) {
                addErrorAction(model, "教工号或密码错误");
                return "redirect:login.htm";
            }
            SessionUser userSession = new SessionUser();
            userSession.setType(user.getType());
            userSession.setName(user.getName());
            userSession.setUserId(userId);
            request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_USER, userSession);
        }
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
