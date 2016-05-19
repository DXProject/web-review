package com.review.www.controller;

import com.jopool.jweb.entity.Page;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.*;
import com.review.www.request.AddProjectAnnouncementReq;
import com.review.www.request.DateParam;
import com.review.www.response.ProjectListResp;
import com.review.www.response.UserResp;
import com.review.www.service.ProjectService;
import com.review.www.service.UserService;
import com.review.www.vo.SearchProjectVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends WebBaseController {
    @Resource
    private ProjectService projectService;
    @Resource
    private UserService    userService;

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
     * 申报项目列表
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    @RequestMapping("projectList.htm")
    public ModelAndView projectList(SearchProjectVo searchProjectVo, Pagination page) {
        List<ProjectListResp> resps = new ArrayList<ProjectListResp>();
        List<Project> projects = projectService.searchProject(searchProjectVo, page.page());
        for (Project project : projects) {
            ProjectListResp resp = new ProjectListResp();
            resp.setId(project.getId());
            resp.setName(project.getName());
            resp.setDisciplineCategory(project.getDisciplineCategory());
            resp.setNumber(project.getNumber());
            User user = userService.getById(project.getCreator());
            if (null != user) {
                resp.setCreator(user.getName());
                resp.setCreatorNumber(user.getNumber());
            }
            resp.setStatus(1);
            resp.setCreationTime(project.getCreationTime());
            resps.add(resp);
        }
        ModelAndView mv = getPageMv("project/projectList", resps, page);
        mv.addObject("keyword", searchProjectVo.getKeyword());
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

    /**
     * 删除 removeProject
     *
     * @param id
     * @return
     */
    @RequestMapping("removeProject.htm")
    public Result removeProject(String id) {
        validateParam(id);
        return projectService.removeProject(id);
    }

    /**
     * 根据学科门类获取专家
     *
     * @param id
     * @return
     */
    @RequestMapping("getExpertByDisciplineCategoryId.htm")
    public ModelAndView getExpertByDisciplineCategoryId(String id, String projectId, Pagination page) {
        validateParam(id);
        List<UserResp> resps = new ArrayList<UserResp>();
        List<Expert> experts = userService.getExpertByDisciplineCategoryId(id, page);
        for (Expert expert : experts) {
            UserResp resp = new UserResp();
            resp.setId(expert.getId());
            resp.setDepartmentId(expert.getSchool());
            resp.setDegreeId(expert.getDegree());
            resp.setTitleId(expert.getTitle());
            resp.setNumber(expert.getNumber());
            resp.setAvatar(expert.getAvatar());
            resp.setName(expert.getName());
            resp.setPhone(expert.getPhone());
            resp.setEmail(expert.getEmail());
            resp.setCreator(expert.getCreator());
            resp.setCreationTime(expert.getCreationTime());
            resps.add(resp);
        }
        ModelAndView mv = getPageMv("project/getExpertByDisciplineCategoryId", resps, page);
        mv.addObject("projectId", projectId);
        return mv;
    }

    /**
     * 分配专家
     *
     * @param id
     * @return
     */
    @RequestMapping("distributionExpert.htm")
    public Result distributionExpert(String id, String expertIds) {
        validateParam(id, expertIds);
        return projectService.distributionExpert(getSessionUser().getUserId(), id, expertIds.split(","));
    }

    /**
     * 本项目专家列表
     *
     * @param id
     * @return
     */
    @RequestMapping("getExpertByProjectId.htm")
    public ModelAndView getExpertByProjectId(String id, Pagination page) {
        validateParam(id);
        List<UserResp> resps = new ArrayList<UserResp>();
        List<Comment> comments = projectService.getExpertByProjectId(id, page.page());
        for (Comment comment : comments) {
            Expert expert = userService.getExpertById(comment.getExpertId());
            UserResp resp = new UserResp();
            resp.setId(expert.getId());
            resp.setDepartmentId(expert.getSchool());
            resp.setDegreeId(expert.getDegree());
            resp.setTitleId(expert.getTitle());
            resp.setNumber(expert.getNumber());
            resp.setAvatar(expert.getAvatar());
            resp.setName(expert.getName());
            resp.setPhone(expert.getPhone());
            resp.setEmail(expert.getEmail());
            resp.setCreator(expert.getCreator());
            resp.setCreationTime(expert.getCreationTime());
            resps.add(resp);
        }
        ModelAndView mv = getPageMv("project/getExpertByProjectId", resps, page);
        return mv;
    }
}
