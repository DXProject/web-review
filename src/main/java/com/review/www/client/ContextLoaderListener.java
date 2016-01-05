/* 
 * @(#)ContextLoaderListener.java    Created on 2013年9月12日
 * Copyright (c) 2013 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.review.www.client;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author huangwq
 * @version $Revision: 1.0 $, $Date: 2013年9月12日 下午9:28:19 $
 */
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent c) {
        // WebApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(c
        // .getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent c) {

    }
}
