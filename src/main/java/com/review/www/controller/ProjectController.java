package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.*;
import com.review.www.request.AddProjectAnnouncementReq;
import com.review.www.request.DateParam;
import com.review.www.request.DeclareProjectReq;
import com.review.www.service.ProjectService;
import com.review.www.vo.SearchProjectVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends WebBaseController {
    @Resource
    private ProjectService projectService;

    /**
     * 发布新项目申请
     *
     * @return
     */
    @RequestMapping("addProjectAnnouncement.htm")
    public ModelAndView addProjectAnnouncement() {
        ModelAndView mv = getSessionUserMV("project/addProjectAnnouncement");
        List<ClassOne> classOnes = projectService.getClassOneList();
        List<ClassTwo> classTwos = projectService.getClassTwoList();
        mv.addObject("classOnes", classOnes);
        mv.addObject("classTwos", classTwos);
        return mv;
    }

    @RequestMapping("doAddProjectAnnouncement.htm")
    public Result doAddProjectAnnouncement(AddProjectAnnouncementReq req) {
        DateParam dateParam = getDateParam(req.getTimeStart(), req.getTimeEnd());
        Announcement announcement = req.parseAnnouncement(getSessionUser().getUserId(), dateParam);
        ClassThree classThree = req.parseThree(getSessionUser().getUserId(), dateParam);
        projectService.doAddProjectAnnouncement(announcement, classThree);
        return new Result(Code.SUCCESS);
    }

    /**
     * 发布项目列表
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    @RequestMapping("AnnouncementList.htm")
    public ModelAndView AnnouncementList(SearchProjectVo searchProjectVo, Pagination page) {
        List<Announcement> announcements = projectService.searchAnnouncementList(searchProjectVo, page.page());
        ModelAndView mv = getPageMv("project/AnnouncementList", announcements, page);
        return mv;
    }

    /**
     * 发布项目列表
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    @RequestMapping("projectAnnouncementList.htm")
    public ModelAndView projectAnnouncementList(SearchProjectVo searchProjectVo, Pagination page) {
        List<ClassThree> projects = projectService.searchProjectAnnouncementList(searchProjectVo, page.page());
        ModelAndView mv = getPageMv("project/projectAnnouncementList", projects, page);
        return mv;
    }

    /**
     * 项目申报
     *
     * @param req
     * @return
     */
    @RequestMapping("declareProject.htm")
    public Result declareProject(DeclareProjectReq req) {
        Project project = req.parseProject(getSessionUser().getUserId());
        return projectService.declareProject(project);
    }

    /**
     * 申报项目列表
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    @RequestMapping("projectList.htm")
    public ModelAndView projectList(SearchProjectVo searchProjectVo, Pagination page) {
        List<Project> projects = projectService.searchProject(searchProjectVo, page.page());
        ModelAndView mv = getPageMv("project/projectList", projects, page);
        return mv;
    }

    /**
     * 删除 Announcment
     *
     * @param id
     * @return
     */
    @RequestMapping("removeAnnouncment.htm")
    public Result removeAnnouncment(String id) {
        validateParam(id);
        return projectService.removeAnnouncment(id);
    }

    /**
     * 删除 classThree
     *
     * @param id
     * @return
     */
    @RequestMapping("removeClassThree.htm")
    public Result removeClassThree(String id) {
        validateParam(id);
        return projectService.removeClassThree(id);
    }
}
