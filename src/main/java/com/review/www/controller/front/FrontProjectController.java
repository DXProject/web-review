package com.review.www.controller.front;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.review.www.constants.Constants;
import com.review.www.controller.WebBaseController;
import com.review.www.entity.BaseConstant;
import com.review.www.entity.Project;
import com.review.www.entity.User;
import com.review.www.request.DeclareProjectReq;
import com.review.www.service.BaseDataService;
import com.review.www.service.ProjectService;
import com.review.www.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/15.
 */
@RestController
@RequestMapping("/front/project")
public class FrontProjectController extends WebBaseController {
    @Resource
    private ProjectService  projectService;
    @Resource
    private BaseDataService baseDataService;
    @Resource
    private UserService     userService;

    /**
     * 发布项目列表
     *
     * @return
     */
    @RequestMapping("applyProject.htm")
    public ModelAndView applyProject() {
        ModelAndView mv = getSessionUserMV("project/applyProject");
        List<BaseConstant> disciplineCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DISCIPLINE_CATEGORY);
        List<BaseConstant> subjectCategory = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_SUBJECT_CATEGORY);
        mv.addObject("disciplineCategory", disciplineCategory);
        mv.addObject("subjectCategory", subjectCategory);
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
        validateParam(getSessionUser().getUserId());
        Project project = req.parseProject(getSessionUser().getUserId());
        User user = userService.getById(project.getCreator());
        project.setDepartment(user.getDepartment());
        ModelAndView mv = null;
//        if (projectService.declareProject(project) == new Result(Code.SUCCESS)) {
//            mv = getSessionUserMV("project/applyProject");
//            return mv;
//        } else {
//            mv = getSessionUserMV("project/applyProject");
//            return mv;
//        }
        return projectService.declareProject(project);
    }
}
