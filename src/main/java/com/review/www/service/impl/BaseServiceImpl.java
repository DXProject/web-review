/* 
 * @(#)BaseRemoteServiceImpl.java    Created on 2013-11-7
 * Copyright (c) 2013 HzBenhe, Inc. All rights reserved.
 * $Id$
 */
package com.review.www.service.impl;


import com.review.www.dao.SequenceFactoryMapper;
import com.review.www.entity.SequenceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * RemoteServiceImpl基类
 *
 * @author gex
 * @version $Revision: 1.0 $, $Date: 2013-11-7 下午5:11:02 $
 */
public class BaseServiceImpl {

    protected static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Resource
    private SequenceFactoryMapper sequenceFactoryMapper;


    /**
     * 生成序列号
     *
     * @param prefix
     * @return
     */
    protected String createNumber(String prefix) {
        SequenceFactory sequenceFactory = new SequenceFactory();
        sequenceFactoryMapper.generateSequence(sequenceFactory);
        return String.format("%1$s%2$08d", prefix, sequenceFactory.getSequence());
    }

}
