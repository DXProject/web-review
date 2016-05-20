package com.review.www.controller.front;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.constants.Constants;
import com.review.www.controller.WebBaseController;
import com.review.www.entity.*;
import com.review.www.request.DeclareProjectReq;
import com.review.www.service.BaseDataService;
import com.review.www.service.ProjectService;
import com.review.www.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
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
     * 通告列表
     *
     * @return
     */
    @RequestMapping("announcementList.htm")
    public ModelAndView announcementList(@RequestParam(defaultValue = "-1") int type, Pagination page) {
        List<Announcement> announcements = projectService.getAnnouncementListByType(type, page.page());
        ModelAndView mv = getPageMv("front/announcementList", announcements, page);
        mv.addObject("type", type);
        return mv;
    }

    /**
     * 详情
     *
     * @return
     */
    @RequestMapping("announcementInfo.htm")
    public ModelAndView announcementInfo(String id) {
        Announcement announcement = projectService.getAnnouncementInfo(id);
        ModelAndView mv = getSessionUserMV("front/announcementInfo");
        mv.addObject("announcement", announcement);
        return mv;
    }
}
