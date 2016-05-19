package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.enums.ModeEnum;
import com.jopool.jweb.utils.DateUtils;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.helper.ApplicationConfigHelper;
import com.review.www.utils.Zip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipOutputStream;

/**
 * Created by gexin on 15/3/22.
 * JP003文件上传
 */
@Controller
@RequestMapping("/common/file")
public class CommonFileController extends WebBaseController {
    private static final Logger logger = LoggerFactory.getLogger(CommonFileController.class);

    /**
     * JP003001文件上传
     * http://wiki.jopool.net/pages/viewpage.action?pageId=4227204
     *
     * @param request
     * @param response
     * @param file
     * @return
     */
    @RequestMapping("upload.htm")
    public
    @ResponseBody
    Result upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file, @RequestParam(defaultValue = "true") boolean isFullPath) {
        String fileId = UUIDUtils.generateShortUuid();
        String saveDir = ApplicationConfigHelper.getFilePath();
        if (ModeEnum.DEVELOP == ApplicationConfigHelper.getMode()) {
            saveDir = request.getSession().getServletContext().getRealPath(ApplicationConfigHelper.getFilePath());
        }
        String saveContextPath = DateUtils.date2String(new Date(), "yyyyMMdd");
        String savePath = saveDir + File.separator + saveContextPath;
        String suffix = "";
        String fileName = file.getOriginalFilename();
        if ((fileName != null) && (fileName.length() > 0)) {
            int dot = fileName.lastIndexOf(".");
            if ((dot > -1) && (dot < (fileName.length() - 1))) {
                suffix = fileName.substring(dot + 1);
            }
        }
        String newFileName = fileId + "." + suffix;
        File targetFile = new File(savePath, newFileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/files/";
        String filePath = saveContextPath + File.separator + newFileName;
        if (isFullPath) {
            filePath = basePath + filePath;
        }
        return new Result(Code.SUCCESS, Result.createJsonMap("path", filePath));
    }

    /**
     * JP003002 base64文件上传
     * http://wiki.jopool.net/pages/viewpage.action?pageId=4555051
     *
     * @param request
     * @param response
     * @param fileBase64
     * @param fileFormat
     * @return
     */
    @RequestMapping("uploadBase64.htm")
    public
    @ResponseBody
    Result uploadBase64(HttpServletRequest request, HttpServletResponse response, String fileBase64, String fileFormat) {
        String fileId = UUIDUtils.generateShortUuid();
        String saveDir = ApplicationConfigHelper.getFilePath();
        if (ModeEnum.DEVELOP == ApplicationConfigHelper.getMode()) {
            saveDir = request.getSession().getServletContext().getRealPath(ApplicationConfigHelper.getFilePath());
        }
        String saveContextPath = DateUtils.date2String(new Date(), "yyyyMMdd");
        String savePath = saveDir + File.separator + saveContextPath;

        String newFileName = fileId + "." + fileFormat;
        try {
            File targetFile = new File(savePath, newFileName);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            byte[] bytes = new BASE64Decoder().decodeBuffer(fileBase64);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            FileOutputStream out = new FileOutputStream(targetFile);
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread); //文件写操作
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/files/";
        return new Result(Code.SUCCESS, Result.createJsonMap("path", basePath + saveContextPath + File.separator + newFileName));
    }
    /**
     * 多文件上传
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("uploads.htm")
    public
    @ResponseBody
    Result uploads(HttpServletRequest request, HttpServletResponse response, @RequestParam("files")MultipartFile[] files, @RequestParam(defaultValue = "true") boolean isFullPath) {
        String[] strs = new String[10];
        //判断file数组不能为空并且长度大于0
        if(files!=null&&files.length>0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String fileId = UUIDUtils.generateShortUuid();
                String saveDir = ApplicationConfigHelper.getFilePath();
                if (ModeEnum.DEVELOP == ApplicationConfigHelper.getMode()) {
                    saveDir = request.getSession().getServletContext().getRealPath(ApplicationConfigHelper.getFilePath());
                }
                String saveContextPath = DateUtils.date2String(new Date(), "yyyyMMdd");
                String savePath = saveDir + File.separator + saveContextPath;
                String suffix = "";
                String fileName = file.getOriginalFilename();
                if ((fileName != null) && (fileName.length() > 0)) {
                    int dot = fileName.lastIndexOf(".");
                    if ((dot > -1) && (dot < (fileName.length() - 1))) {
                        suffix = fileName.substring(dot + 1);
                    }
                }
                String newFileName = fileId + "." + suffix;
                File targetFile = new File(savePath, newFileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String path = request.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/files/";
                String filePath = saveContextPath + File.separator + newFileName;
                if (isFullPath) {
                    filePath = basePath + filePath;
                    strs[i]=filePath;
                }
            }
        }
        return new Result(Code.SUCCESS, Result.createJsonMap("path", strs));
    }
    /**
     * 文件下载(多文件下载)
     */
    /**
     *  批量打包下载文件生成zip文件下载
     */
    @RequestMapping("downloadZip")
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
