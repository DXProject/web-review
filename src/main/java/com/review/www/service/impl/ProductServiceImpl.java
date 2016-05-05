package com.review.www.service.impl;

import com.jopool.jweb.spring.SelfBeanAware;
import com.review.www.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService, SelfBeanAware<ProductService> {
    private ProductService selfService;

    @Override
    public void setSelfBean(ProductService object) {
        this.selfService = object;
    }
}
