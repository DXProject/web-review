package com.review.www.controller;

import com.alibaba.fastjson.JSONArray;
import com.review.www.constants.Constants;
import com.review.www.exception.REVException;
import com.review.www.helper.PaginationHelper;
import com.review.www.vo.SessionUser;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.mybatis.page.PaginationUtils;
import com.jopool.jweb.utils.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gexin on 15/3/20.
 * 基础Controller
 */
public class WebBaseController {

    /**
     * 获取当前登录用户MV
     *
     * @param viewName
     * @return
     */
    protected ModelAndView getSessionUserMV(String viewName) {
        return getSessionUserMV(viewName, null);
    }

    protected ModelAndView getSessionUserMV(String viewName, RedirectAttributesModelMap model) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("user", getSessionUser());
        if (model != null) {
            modelAndView.addAllObjects(model);
        }
        return modelAndView;
    }

    protected ModelAndView getMV(String viewName) {
        return getMV(viewName, null, null);
    }

    protected ModelAndView getMV(String viewName, String key, Object value) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        if (!StringUtils.isEmpty(key) && null != value) {
            modelAndView.addObject(key, value);
        }
        return modelAndView;
    }

    /**
     * 分页MV
     *
     * @param viewName
     * @param list
     * @param page     @return
     */
    protected ModelAndView  getPageMv(String viewName, Object list, Pagination page) {
        ModelAndView modelAndView = getSessionUserMV(viewName);
        if (page != null) {
            modelAndView.addObject("list", list);
            modelAndView.addObject("page", PaginationHelper.pagination(PaginationUtils.getUrlFromRequest(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()), page));
        }
        return modelAndView;
    }

    /**
     * 返回错误信息
     *
     * @param model
     * @param message
     */
    protected void addErrorAction(RedirectAttributesModelMap model, String message) {
        model.addFlashAttribute("result", new Result(Code.ERROR, message));
    }

    protected void addErrorAction(ModelAndView model, String message) {
        model.addObject("result", new Result(Code.ERROR, message));
    }


    /**
     * 返回正确信息
     *
     * @param model
     * @param message
     */
    protected void addMessageAction(RedirectAttributesModelMap model, String message) {
        model.addFlashAttribute("result", new Result(Code.SUCCESS, message));
    }

    protected void addMessageAction(ModelAndView model, String message) {
        model.addObject("result", new Result(Code.SUCCESS, message));
    }


    /**
     * 当前登录User
     *
     * @return
     */
    protected SessionUser getSessionUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (SessionUser) request.getSession().getAttribute(Constants.SESSION_KEY_LOGIN_USER);
    }


    /**
     * list
     *
     * @param value
     * @return
     */
    protected Map<String, Object> createList(Object value) {
        return createJsonMap("list", value);
    }

    /**
     * 简单json输入，复杂的通过resp包下的消息
     *
     * @param key
     * @param value
     * @return
     */
    protected Map<String, Object> createJsonMap(String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key, value);
        return map;
    }

    /**
     * 简单json输入，复杂的通过resp包下的消息
     *
     * @return
     */
    protected Map<String, Object> createJsonMap(String[] keys, Object[] values) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null && values[i] instanceof ArrayList) {
                values[i] = new JSONArray();
            }
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /**
     * 验证-全部为空
     *
     * @param strs
     */
    protected void validateParam(String... strs) {
        for (String str : strs) {
            if (StringUtils.isBlank(str)) {
                throw new REVException(Code.ERROR_PARAM);
            }
        }
    }

}
