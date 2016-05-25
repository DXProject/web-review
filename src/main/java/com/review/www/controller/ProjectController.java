package com.review.www.controller;

import com.jopool.jweb.entity.Page;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.constants.Constants;
import com.review.www.entity.*;
import com.review.www.request.AddProjectAnnouncementReq;
import com.review.www.request.DateParam;
import com.review.www.request.DeclareProjectReq;
import com.review.www.response.ProjectListResp;
import com.review.www.response.UserResp;
import com.review.www.service.BaseDataService;
import com.review.www.service.ProgramService;
import com.review.www.service.ProjectService;
import com.review.www.service.UserService;
import com.review.www.vo.SearchProjectVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends WebBaseController {
    @Resource
    private ProjectService  projectService;
    @Resource
    private UserService     userService;
    @Resource
    private ProgramService  programService;
    @Resource
    private BaseDataService baseDataService;

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
        List<ReviewProgram> reviewPrograms = programService.getAllReviewProgram();
        mv.addObject("classOnes", classOnes);
        mv.addObject("classTwos", classTwos);
        mv.addObject("reviewPrograms", reviewPrograms);
        return mv;
    }

    @RequestMapping("doAddProjectAnnouncement.htm")
    public Result doAddProjectAnnouncement(AddProjectAnnouncementReq req) {
        DateParam dateParam = getDateParam(req.getTimeStart(), req.getTimeEnd());
        Announcement announcement = req.parseAnnouncement(getSessionUser().getUserId(), dateParam);
        ClassThree classThree = null;
        if (announcement.getType() == 2) {
            classThree = req.parseThree(getSessionUser().getUserId(), dateParam);
        }
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

    /**
     * 下载文件
     *
     * @param id
     * @return
     */
    @RequestMapping("uploadFile.htm")
    public void uploadFile(String id, HttpServletRequest request, HttpServletResponse response) {
        validateParam(id);
        String address = "";
        List<File> files = projectService.getFilesByProjectId(id);
        for (File file : files) {
            address += file.getFileAddress() + ",";
        }
        address = address.substring(0, address.length() - 1);
        try {
            downloadFiles(address, request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 项目申报
     *
     * @return
     */
    @RequestMapping("applyProject.htm")
    public ModelAndView applyProject(String id) {
        validateParam(id, getSessionUser().getUserId());
        ModelAndView mv = getSessionUserMV("project/applyProject");
        Announcement announcement = projectService.getAnnouncementInfo(id);
        ClassThree classThree = projectService.getClassThreeInfo(announcement.getClassThreeId());
        List<BaseConstant> disciplineCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DISCIPLINE_CATEGORY);
        List<BaseConstant> subjectCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_SUBJECT_CATEGORY);
        User application = userService.getById(getSessionUser().getUserId());
        if (null != application) {
            BaseConstant department = baseDataService.getBaseConstantById(application.getDepartment());
            mv.addObject("department", department);
        }
        mv.addObject("disciplineCategory", disciplineCategory);
        mv.addObject("subjectCategory", subjectCategory);
        mv.addObject("classThree", classThree);
        mv.addObject("reviewProgram", classThree.getReviewprogramId());
        mv.addObject("application", application);
        return mv;
    }

    /**
     * 项目提交
     *
     * @param req
     * @return
     */
    @RequestMapping("declareProject.htm")
    public ModelAndView declareProject(DeclareProjectReq req, String paths) {
        validateParam(getSessionUser().getUserId());
        Project project = req.parseProject(getSessionUser().getUserId());
        User user = userService.getById(project.getCreator());
        project.setDepartment(user.getDepartment());
        //文件存路径
        String ids = "";
        String[] strs = paths.split(",");
        for (String str : strs) {
            File file = new File();
            file.setId(UUIDUtils.createId());
            file.setFileAddress(str);
            file.setProjectId(project.getId());
            file.setIsDeleted(false);
            file.setCreationTime(new Date());
            file.setCreator(file.getId());
            ids += file.getId() + ",";
            projectService.addFile(file);
        }
        project.setFile(ids.substring(0, ids.length() - 1));
        projectService.declareProject(project);
        return new ModelAndView("redirect:getMyProjectList.htm");
    }

    /**
     * 获取我的项目
     *
     * @param
     * @return
     */
    @RequestMapping("getMyProjectList.htm")
    public ModelAndView getMyProjectList(Pagination page) {
        User user = userService.getById(getSessionUser().getUserId());
        List<Project> projects = null;
        if (null != user) {
            projects = projectService.getProjectByUserId(user.getId(), page.page());
        }
        ModelAndView mv = getPageMv("project/getMyProjectList", projects, page);
        BaseConstant department = baseDataService.getBaseConstantById(user.getDepartment());
        mv.addObject("user", user);
        mv.addObject("department", department);
        return mv;
    }

    /**
     * 获取我的评审项目
     *
     * @param
     * @return
     */
    @RequestMapping("getMyReviewProjectList.htm")
    public ModelAndView getMyReviewProjectList(Pagination page) {
        Expert expert = userService.getExpertById(getSessionUser().getUserId());
        List<ProjectListResp> resps = new ArrayList<ProjectListResp>();
        List<Comment> comments = null;
        if (null != expert) {
            comments = programService.getCommentsByExpertId(expert.getId(), page.page());
        }
        for (Comment comment : comments) {
            ProjectListResp resp = new ProjectListResp();
            Project project = projectService.getById(comment.getProjectId());
            if (null == project) {
                continue;
            }
            resp.setId(project.getId());
            resp.setName(project.getName());
            User user = userService.getById(project.getUserId());
            resp.setCreator(user.getName());
            resp.setStatus(project.getStatus());
            resp.setCreationTime(project.getCreationTime());
            resps.add(resp);
        }
        ModelAndView mv = getPageMv("project/getMyReviewProjectList", resps, page);
        mv.addObject("expert", expert);
        return mv;
    }

    /**
     * 获取我的项目详情
     *
     * @param
     * @return
     */
    @RequestMapping("getMyProjectInfo.htm")
    public ModelAndView getMyProjectInfo(String id) {
        Project project = projectService.getById(id);
        User user = userService.getById(getSessionUser().getUserId());
        ModelAndView mv = getSessionUserMV("project/getMyProjectInfo");
        BaseConstant department = baseDataService.getBaseConstantById(project.getDepartment());
        List<BaseConstant> disciplineCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DISCIPLINE_CATEGORY);
        List<BaseConstant> subjectCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_SUBJECT_CATEGORY);
        mv.addObject("project", project);
        mv.addObject("application", user);
        mv.addObject("department", department);
        mv.addObject("disciplineCategory", disciplineCategory);
        mv.addObject("subjectCategory", subjectCategory);
        //mv.addObject("classThree", classThree);
        //mv.addObject("reviewProgram", classThree.getReviewprogramId());
        //mv.addObject("application", application);
        return mv;
    }

    /**
     * 获取我的项目详情
     *
     * @param
     * @return
     */
    @RequestMapping("getProjectInfo.htm")
    public ModelAndView getProjectInfo(String id) {
        Project project = projectService.getById(id);
        User user = userService.getById(project.getUserId());
        ModelAndView mv = getSessionUserMV("project/getProjectInfo");
        BaseConstant department = baseDataService.getBaseConstantById(project.getDepartment());
        List<BaseConstant> disciplineCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DISCIPLINE_CATEGORY);
        List<BaseConstant> subjectCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_SUBJECT_CATEGORY);
        ReviewProgram reviewProgram = programService.getReviewProgramById(project.getReviewProgramId());
        mv.addObject("project", project);
        mv.addObject("application", user);
        mv.addObject("department", department);
        mv.addObject("disciplineCategory", disciplineCategory);
        mv.addObject("subjectCategory", subjectCategory);
        //mv.addObject("classThree", classThree);
        mv.addObject("reviewProgramType", reviewProgram.getType());
        //mv.addObject("application", application);
        return mv;
    }
}
