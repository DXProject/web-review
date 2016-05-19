package com.review.www.controller.front;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.utils.PasswordHash;
import com.jopool.jweb.utils.StringUtils;
import com.review.www.constants.Constants;
import com.review.www.controller.WebBaseController;
import com.review.www.entity.Announcement;
import com.review.www.entity.BaseConstant;
import com.review.www.entity.User;
import com.review.www.enums.UserType;
import com.review.www.service.BaseDataService;
import com.review.www.service.ProjectService;
import com.review.www.service.UserService;
import com.review.www.vo.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.print.attribute.IntegerSyntax;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zrl on 16/5/16.
 */

@RestController
@RequestMapping("/front")
public class FrontIndexController extends WebBaseController {
    private static final Logger log = LoggerFactory.getLogger(FrontIndexController.class);
    @Resource
    private BaseDataService baseDataService;
    @Resource
    private UserService     userService;
    @Resource
    private ProjectService  projectService;

    /**
     * login
     *
     * @return
     */
    @RequestMapping("doLoginFront.htm")
    @ResponseBody
    public Result doLoginFront(HttpServletRequest request, String number, String password, String identity) {
        log.debug("name:{},password:{},identity:{}", number, password, identity);
        if (StringUtils.isEmpty(number) || StringUtils.isEmpty(password)) {
            return new Result(2, "请输入教工号或密码");
        }
        //identity: 1-项目申请者 2-砖家
        User user;
        if (Integer.parseInt(identity) == 2) {
            user = userService.getExpertByNumberAndType(number, 3);//查询砖家是否存在
        } else {
            user = userService.getByNumberAndType(number, 1);//项目申报者
        }
        if (null == user) {
            return new Result(2, "教工号或密码错误");
        }
        if (StringUtils.isEmpty(user.getPassword()) || !PasswordHash.validatePassword(password, user.getPassword())) {
            return new Result(2, "教工号或密码错误");
        } else {
            String userId = user.getId();
            if (StringUtils.isEmpty(userId)) {
                return new Result(2, "教工号或密码错误");
            }
            SessionUser userSession = new SessionUser();
            userSession.setType(user.getType());
            userSession.setName(user.getName());
            userSession.setUserId(userId);
            request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_USER, userSession);
        }
        return new Result(1, "登录成功!");
    }

    /**
     * 退出登陆
     *
     * @param request
     * @return
     */
    @RequestMapping("logout.htm")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.SESSION_KEY_LOGIN_USER);
        return "redirect:index.htm";
    }

    /**
     * 注册页面
     */
    @RequestMapping("register")
    public ModelAndView register() {
        List<BaseConstant> list = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DEPARTMENT);
        List<BaseConstant> list1 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_TITLE);
        return new ModelAndView("/front/register").addObject("list", list).addObject("list1", list1);
    }

    @RequestMapping("doRegister")
    public Result doRegister(User user) {
        log.debug("user:{}{}", user.getNumber(), user.getPassword());
        User user1 = userService.getByNumberAndType(user.getNumber(), 1);//项目申报者
        if (user1 == null) {
            userService.addUserManage(1, user);
            return new Result(1, "成功!");
        }
        return new Result(2, "该教工号已经存在!");

    }

    /**
     * 前台主页
     *
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = getSessionUserMV("/front/index");
        List<Announcement> announcements = projectService.getIndexAnnouncementList();
        mv.addObject("announcements",announcements);
        return mv;
    }
}