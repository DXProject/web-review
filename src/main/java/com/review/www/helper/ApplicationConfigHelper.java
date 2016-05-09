/* 
 * @(#)ApplicationConfigHelper.java    Created on 2012-1-19
 * Copyright (c) 2012 ZDSoft Networks, Inc. All rights reserved.
 * $Id: ApplicationConfigHelper.java 24913 2012-02-15 10:55:51Z huangwq $
 */
package com.review.www.helper;

import com.jopool.jweb.enums.ModeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置
 *
 * @author gex
 * @version $Revision: 24913 $, $Date: 2013-11-06 18:55:51 +0800 $
 */
public abstract class ApplicationConfigHelper {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfigHelper.class);

    private ApplicationConfigHelper() {
    }

    private static final String MODE = "app.mode";

    private static ModeEnum mode;
    private static String   filePath;
    private static String   jppushRestUrl;
    private static String   jppushAppId;
    private static String   jppushAppSecret;
    private static String   baseUrl;

    static {
        Properties p = new Properties();
        try {
            p.load(ApplicationConfigHelper.class.getResourceAsStream("/applicationResources.properties"));
        } catch (IOException e) {
            logger.error("#### ApplicationConfigHelper", "", e);
        }

        filePath = p.getProperty("file.path", "");
        mode = ModeEnum.valueOf(Integer.parseInt(p.getProperty(MODE, "0")));
        jppushRestUrl = p.getProperty("jppush.rest.url");
        jppushAppId = p.getProperty("jppush.appId");
        jppushAppSecret = p.getProperty("jppush.appSecret");
        baseUrl = p.getProperty("base.url");
    }


    public static String getFilePath() {
        return filePath;
    }

    public static ModeEnum getMode() {
        return mode;
    }

    public static String getJppushRestUrl() {
        return jppushRestUrl;
    }

    public static String getJppushAppId() {
        return jppushAppId;
    }

    public static String getJppushAppSecret() {
        return jppushAppSecret;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}