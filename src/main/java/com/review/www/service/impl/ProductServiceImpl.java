package com.review.www.service.impl;

import com.jopool.jweb.spring.SelfBeanAware;
import com.review.www.dao.AnnouncementMapper;
import com.review.www.dao.ClassOneMapper;
import com.review.www.dao.ClassThreeMapper;
import com.review.www.dao.ClassTwoMapper;
import com.review.www.entity.Announcement;
import com.review.www.entity.ClassOne;
import com.review.www.entity.ClassThree;
import com.review.www.entity.ClassTwo;
import com.review.www.service.ProductService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService, SelfBeanAware<ProductService> {
    private ProductService     selfService;
    @Resource
    private AnnouncementMapper announcementMapper;
    @Resource
    private ClassOneMapper     classOneMapper;
    @Resource
    private ClassTwoMapper     classTwoMapper;
    @Resource
    private ClassThreeMapper   classThreeMapper;

    @Override
    public void setSelfBean(ProductService object) {
        this.selfService = object;
    }

    @Override
    public void doAddProductAnnouncement(Announcement announcement, ClassThree classThree) {
        announcement.setClassThreeId(classThree.getId());
        announcementMapper.insert(announcement);
        classThreeMapper.insert(classThree);
    }

    @Override
    public List<ClassOne> getClassOneList() {
        return classOneMapper.selectAllClassOne();
    }

    @Override
    public List<ClassTwo> getClassTwoList() {
        return classTwoMapper.selectAllClassTwo();
    }
}
