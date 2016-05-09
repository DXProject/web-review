package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.enums.ModeEnum;
import com.jopool.jweb.utils.DateUtils;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.helper.ApplicationConfigHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
}
