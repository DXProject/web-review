package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.utils.PasswordHash;
import com.review.www.constants.CodeMessage;
import com.review.www.constants.Constants;
import com.review.www.entity.BaseConstant;
import com.review.www.entity.User;
import com.review.www.request.LoginReq;
import com.review.www.response.UserResp;
import com.review.www.service.BaseDataService;
import com.review.www.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
@RestController
@RequestMapping("/user")
public class UserController extends WebBaseController {
    @Resource
    private UserService     userService;
    @Resource
    private BaseDataService baseDataService;

    /**
     * register
     */
    @RequestMapping("doAddUser.htm")
    private Result doAddUser(User user) {
        validateParam(user.getNumber());
        return userService.addUser(user);
    }

    /**
     * 我的账户信息
     *
     * @return
     */
    @RequestMapping("myAccountInfo.htm")
    public ModelAndView myAccountInfo() {
        ModelAndView mv = getSessionUserMV("user/myAccountInfo");
        User user = userService.getById(getSessionUser().getUserId());
        mv.addObject("user", user);
        return mv;
    }

    /**
     * 密码修改
     *
     * @return
     */
    @RequestMapping("modifyPassword.htm")
    public ModelAndView modifyPassword() {
        return getSessionUserMV("user/modifyPassword");
    }

    @RequestMapping("doModifyPassword.htm")
    public Result doModifyPassword(String oldPwd, String newPwd) {
        User user = userService.getById(getSessionUser().getUserId());
        if (null == user) {
            return new Result(Code.ERROR, CodeMessage.PASSPORT_NOT_EXIST);
        }
        if (!PasswordHash.validatePassword(oldPwd, user.getPassword())) {
            return new Result(Code.ERROR, "原密码错误");
        }
        userService.changePassword(user.getNumber(), newPwd, user.getType());
        return new Result(Code.SUCCESS);
    }

    /**
     * 用户管理
     * 1-项目申报者
     * 2-二级学院管理人员
     * 3-专家
     * 4-科研室管理人员
     */
    @RequestMapping("userPage{type}.htm")
    public ModelAndView userPage(@PathVariable int type) {
        ModelAndView model = new ModelAndView("/user/userList").addObject("type", type);
        if (type == 1) {
            model.addObject("title", "项目申报者");
        } else if (type == 2) {
            model.addObject("title", "二级学院管理人员");
        } else if (type == 3) {
            model.addObject("title", "专家");
        } else if (type == 4) {
            model.addObject("title", "科研室管理人员");
        }
        List<UserResp> userResps = userService.getByType(type);
        model.addObject("list", userResps);
        return model;
    }

    @RequestMapping("userAddPage{type}.htm")
    public ModelAndView userAddPage(@PathVariable int type) {
        ModelAndView model = new ModelAndView("/user/userAdd").addObject("type", type);
        List<BaseConstant> list1 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_TITLE);
        List<BaseConstant> list2 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DEGREE);
        List<BaseConstant> list3 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_EDUCATION);
        List<BaseConstant> list4 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DEPARTMENT);
        model.addObject("list1", list1);
        model.addObject("list2", list2);
        model.addObject("list3", list3);
        model.addObject("list4", list4);
        if (type == 1) {
            model.addObject("title", "项目申报者");
        } else if (type == 2) {
            model.addObject("title", "二级学院管理人员");
        } else if (type == 3) {
            model.addObject("title", "专家");
        } else if (type == 4) {
            model.addObject("title", "科研室管理人员");
        }
        return model;
    }

    @RequestMapping("doUserAddPage{type}.htm")
    @ResponseBody
    public Result doUserAddPage(@PathVariable int type, User user) {
        System.out.println("doUserAddPage");
        userService.addUserManage(type, user);
        return new Result(Code.SUCCESS, "成功!");
    }

    @RequestMapping("userEditPage{type}/{id}.htm")
    public ModelAndView userAddPage(@PathVariable int type, @PathVariable String id) {
        System.out.println("userEditPage");
        ModelAndView model = new ModelAndView("/user/userEdit").addObject("type", type);
        List<BaseConstant> list1 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_TITLE);
        List<BaseConstant> list2 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DEGREE);
        List<BaseConstant> list3 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_EDUCATION);
        List<BaseConstant> list4 = baseDataService.getBaseConstantByKey(Constants.BASE_CONSTANT_DEPARTMENT);
        model.addObject("list1", list1);
        model.addObject("list2", list2);
        model.addObject("list3", list3);
        model.addObject("list4", list4);
        UserResp userResp = userService.getByTypeAndId(type, id);
        model.addObject("user", userResp);
        if (type == 3) {
            model.addObject("title", "专家");
        } else {
            if (type == 1) {
                model.addObject("title", "项目申报者");
            } else if (type == 2) {
                model.addObject("title", "二级学院管理人员");
            } else if (type == 4) {
                model.addObject("title", "科研室管理人员");
            }
        }

        return model;
    }

    @RequestMapping("doUserEditPage{type}.htm")
    @ResponseBody
    public Result doUserEditPage(@PathVariable int type, User user) {
        System.out.println("doUserEditPage");
        userService.editUserManage(type, user);
        return new Result(Code.SUCCESS, "成功!");
    }

    @RequestMapping("userDelPage{type}/{id}.htm")
    @ResponseBody
    public Result userDelPage(@PathVariable int type, @PathVariable String id) {
        System.out.println("userDelPage");
        userService.delUserManage(type, id);
        return new Result(Code.SUCCESS, "成功!");
    }
}
