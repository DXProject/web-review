package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.*;
import com.review.www.vo.SearchProjectVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
public interface ProjectService {
    /**
     * do add classThree and announcement
     *
     * @param announcement
     * @param classThree
     */
    void doAddProjectAnnouncement(Announcement announcement, ClassThree classThree);

    /**
     * get classOne
     *
     * @return
     */
    List<ClassOne> getClassOneList();

    /**
     * get classtwo
     *
     * @return
     */
    List<ClassTwo> getClassTwoList();

    /**
     * declare project
     *
     * @param project
     * @return
     */
    Result declareProject(Project project);

    /**
     * search project
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    List<Project> searchProject(SearchProjectVo searchProjectVo, RowBounds page);

    /**
     * search projectAnnouncementList
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    List<ClassThree> searchProjectAnnouncementList(SearchProjectVo searchProjectVo, RowBounds page);

    /**
     * search Announcement
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    List<Announcement> searchAnnouncementList(SearchProjectVo searchProjectVo, RowBounds page);

    /**
     * remove announcement
     *
     * @param id
     * @return
     */
    Result removeAnnouncment(String id);

    /**
     * remove ClassThree
     *
     * @param id
     * @return
     */
    Result removeClassThree(String id);

    /**
     * remove project
     *
     * @param id
     * @return
     */
    Result removeProject(String id);

    /**
     * add file
     */
    void addFile(File file);

    /**
     * get index announmentList
     *
     * @return
     */
    List<Announcement> getIndexAnnouncementList();

    /**
     * distributionExpert
     *
     * @param id
     * @param split
     * @return
     */
    Result distributionExpert(String userId, String id, String[] split);

    /**
     * get expert by projectId
     *
     * @param id
     * @return
     */
    List<Comment> getExpertByProjectId(String id, RowBounds page);

    /**
     * get announcementList by type
     *
     * @param type
     * @param page
     * @return
     */
    List<Announcement> getAnnouncementListByType(int type, RowBounds page);

    /**
     * get announcement info
     *
     * @param id
     * @return
     */
    Announcement getAnnouncementInfo(String id);

    /**
     * get classThreeInfo
     *
     * @param classThreeId
     * @return
     */
    ClassThree getClassThreeInfo(String classThreeId);

    /**
     * get file by projectId
     *
     * @param id
     * @return
     */
    List<File> getFilesByProjectId(String id);

    /**
     * get project by userId
     *
     * @param id
     * @return
     */
    List<Project> getProjectByUserId(String id, RowBounds page);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    Project getById(String id);
}
