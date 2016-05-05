package com.review.www.service;

import com.review.www.entity.Announcement;
import com.review.www.entity.ClassOne;
import com.review.www.entity.ClassThree;
import com.review.www.entity.ClassTwo;

import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
public interface ProductService {
    /**
     * do add classThree and announcement
     * @param announcement
     * @param classThree
     */
    void doAddProductAnnouncement(Announcement announcement, ClassThree classThree);

    /**
     * get classOne
     * @return
     */
    List<ClassOne> getClassOneList();

    /**
     * get classtwo
     * @return
     */
    List<ClassTwo> getClassTwoList();
}
