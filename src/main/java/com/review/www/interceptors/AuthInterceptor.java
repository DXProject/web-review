package com.review.www.interceptors;

import com.review.www.constants.Constants;
import com.review.www.vo.SessionUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gexin on 15/3/22.
 * 登录权限拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SessionUser user = (SessionUser) httpServletRequest.getSession().getAttribute(Constants.SESSION_KEY_LOGIN_USER);
        if (null == user) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.htm");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
