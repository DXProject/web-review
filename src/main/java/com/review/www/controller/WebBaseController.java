package com.review.www.controller;

import com.alibaba.fastjson.JSONArray;
import com.jopool.jweb.utils.DateUtils;
import com.review.www.constants.Constants;
import com.review.www.exception.REVException;
import com.review.www.helper.PaginationHelper;
import com.review.www.request.DateParam;
import com.review.www.utils.Zip;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipOutputStream;

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

    /**
     * 时间常数
     *
     * @param timeStartStr
     * @param timeEndStr
     * @return
     */
    protected DateParam getDateParam(String timeStartStr, String timeEndStr) {
        DateParam dateParam = new DateParam();
        if (!StringUtils.isEmpty(timeStartStr)) {
            dateParam.setTimeStart(DateUtils.getStartDate(DateUtils.string2Date(timeStartStr, "yyyy-MM-dd")));
        }
        if (!StringUtils.isEmpty(timeEndStr)) {
            dateParam.setTimeEnd(DateUtils.getEndDate(DateUtils.string2Date(timeEndStr, "yyyy-MM-dd")));
        }
        return dateParam;
    }

    public String downloadFiles(String tcLwIds, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //tcLwIds="http://127.0.0.1:8080/files/20160518/U6YB4Fje.docx,http://127.0.0.1:8080/files/20160518/U6YB4Fkf.docx";
        if(""==tcLwIds||null==tcLwIds){
            System.out.println("下载的文件不存在");
            return "失败!";
        }
        Zip zip = new Zip();
        tcLwIds = overWriter(tcLwIds,request);
        List<File> files = new ArrayList<File>();

        String[] tcLwIdArray = tcLwIds.split(",");
        for(String tcLwId : tcLwIdArray)
        {
            File file = new File(tcLwId);
            files.add(file);
        }

        String fileName = UUID.randomUUID().toString() + ".zip";
        //在服务器端创建打包下载的临时文件
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/files/";
        String s =request.getSession().getServletContext().getRealPath("/files/");
        String outFilePath = s+"/zip/";

        zip.createFile(outFilePath,fileName);
        File file = new File(outFilePath+fileName);
        //文件输出流
        FileOutputStream outStream = new FileOutputStream(file);
        //压缩流
        ZipOutputStream toClient = new ZipOutputStream(outStream);
        zip.zipFile(files, toClient);
        toClient.close();
        outStream.close();
        zip.downloadFile(file, response,true);
        return null;
    }
    /**
     * 将 http://127.0.0.1:8080/files/20160518/U6YB4Fje.docx
     * 路径取/Users/zrl/Desktop/web-review/src/main/webapp/files/20160518/U6YB4Fje.docx
     */
    public String overWriter(String strs,HttpServletRequest request){
        String s =request.getSession().getServletContext().getRealPath("/files/");
        String[] strs1 = strs.split(",");
        String returnStr = "";
        for(int i=0;i<strs1.length;i++){
            String[] sts = strs1[i].split("/");
            returnStr+=s+"/"+sts[sts.length-2]+"/"+sts[sts.length-1]+",";
        }
        // System.out.println("returnStr:"+returnStr.substring(0,returnStr.length()-1));
        return returnStr.substring(0,returnStr.length()-1);
    }

}
