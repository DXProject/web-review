package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.*;

import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
public interface ProjectService {
    /**
     * do add classThree and announcement
     * @param announcement
     * @param classThree
     */
    void doAddProjectAnnouncement(Announcement announcement, ClassThree classThree);

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

    /**
     * declare project
     * @param project
     * @return
     */
    Result declareProject(Project project);
}
