/* 
 * @(#)CacheProviderFactoryBean.java    Created on 2010-3-26
 * Copyright (c) 2010 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.review.www.cache;

import com.jopool.jweb.cache.Cache;
import com.jopool.jweb.cache.provider.SimpleCache;
import com.jopool.jweb.cache.provider.XMemcachedCache;
import com.jopool.jweb.utils.Validators;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * 用于动态创建 Cache 对象的 FactoryBean。
 *
 * @author huangwq
 * @version $Revision$, $Date$
 */
public class CacheProviderFactoryBean extends AbstractFactoryBean<Cache> {

    private static final Logger logger = LoggerFactory.getLogger(CacheProviderFactoryBean.class);
    private String servers;


    @Override
    protected Cache createInstance() throws Exception {
        String serverString = "";
        serverString = StringUtils.defaultString(serverString);

        // 获取 Memcached 服务器地址
        String[] servers = serverString.split(";");
        // 如果没有 Memcached 服务器地址定义，则创建本地缓存
        if (Validators.isEmpty(servers) || StringUtils.isEmpty(serverString)) {
            // logger.info("Cache provider: {}", SimpleCache.class);
            return new SimpleCache();
            // throw new IllegalArgumentException("memcached.url is not setted!");
        }

        // 创建一个 XMemcachedCache 缓存
        XMemcachedCache cache = new XMemcachedCache();

        // 设置 Memcached 服务器地址和权重
        String[] addresses = new String[servers.length];
        int[] weights = new int[servers.length];
        for (int i = 0; i < servers.length; i++) {
            String server = servers[i];
            logger.debug("memcached server: {}", server);

            String[] params = server.split(":");
            addresses[i] = (params[0] + ":" + params[1]);
            weights[i] = NumberUtils.toInt(params[2]);
        }
        cache.setServers(addresses);
        cache.setWeights(weights);

        cache.setCommandFactory(new BinaryCommandFactory()); // 设置客户端和服务端交互的协议为二进制协议
        cache.setSessionLocator(new KetamaMemcachedSessionLocator()); // 设置缓存的分布算法为一致性哈希算法
        cache.setOperationTimeout(30 * 1000); // 设置客户端访问服务端的超时时间为30秒
        cache.initialize();

        logger.info("Cache provider: {}", XMemcachedCache.class);
        return cache;
    }

    @Override
    public Class<?> getObjectType() {
        return Cache.class;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public String getServers() {
        return servers;
    }

}
