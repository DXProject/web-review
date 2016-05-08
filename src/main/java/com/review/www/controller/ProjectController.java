package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.review.www.entity.*;
import com.review.www.request.AddProjectAnnouncementReq;
import com.review.www.request.DateParam;
import com.review.www.request.DeclareProjectReq;
import com.review.www.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@Controller
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
        ModelAndView mv = getSessionUserMV("product/addProjectAnnouncement");
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
}