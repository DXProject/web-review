package com.review.www.service.impl;

import com.jopool.jweb.cache.Cache;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.spring.SelfBeanAware;
import com.jopool.jweb.utils.PasswordHash;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.constants.CodeMessage;
import com.review.www.constants.Constants;
import com.review.www.dao.ExpertMapper;
import com.review.www.dao.UserMapper;
import com.review.www.entity.Expert;
import com.review.www.entity.User;
import com.review.www.enums.ModeEnum;
import com.review.www.enums.UserTypeEnum;
import com.review.www.helper.ApplicationConfigHelper;
import com.review.www.request.LoginReq;
import com.review.www.response.LoginResp;
import com.review.www.response.UserResp;
import com.review.www.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService, SelfBeanAware<UserService> {
    private UserService  selfService;
    @Resource
    private ExpertMapper expertMapper;
    @Resource
    private UserMapper   userMapper;
    @Resource
    private Cache        cacheBean;

    @Override
    public Result addUser(User user) {
        user.setId(UUIDUtils.createId());
        user.setPassword(PasswordHash.createHash(user.getPassword(), UUIDUtils.createId()));
        userMapper.insert(user);
        return new Result(Code.SUCCESS);
    }

    @Override
    public User getByNumberAndType(String number, int type) {
        return userMapper.selectByNumberAndType(number, type);
    }

    @Override
    public User getById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Result changePassword(String number, String password, int type) {
        User userExist = selfService.getByNumberAndType(number, type);
        if (null == userExist) {
            return new Result(Code.ERROR, CodeMessage.PASSPORT_NOT_EXIST);
        }
        userExist.setPassword(PasswordHash.createHash(password, UUIDUtils.createId()));
        userMapper.updateByPrimaryKeySelective(userExist);
        return new Result(Code.SUCCESS);
    }

    @Override
    public void setSelfBean(UserService object) {

        this.selfService = object;
    }

    public List<UserResp> getByType(int type) {
        List<UserResp> resps = new ArrayList<UserResp>();
        if (type == 3) {
            List<Expert> experts = expertMapper.selectListAll();
            for (Expert user : experts) {
                UserResp resp = new UserResp();
                resp.setId(user.getId());
                resp.setDepartmentId(user.getSchool());
                resp.setDegreeId(user.getDegree());
                resp.setTitleId(user.getTitle());
                resp.setNumber(user.getNumber());
                resp.setAvatar(user.getAvatar());
                resp.setName(user.getName());
                resp.setPassword(user.getPassword());
                resp.setPhone(user.getPhone());
                resp.setEmail(user.getEmail());
                resp.setCreator(user.getCreator());
                resp.setCreationTime(user.getCreationTime());
                resps.add(resp);
            }
        } else {
            List<User> users = userMapper.selectByType(type);
            for (User user : users) {
                UserResp resp = new UserResp();
                resp.setId(user.getId());
                resp.setNumber(user.getNumber());
                resp.setAvatar(user.getAvatar());
                resp.setName(user.getName());
                resp.setSex(user.getSex());
                resp.setType(user.getType());
                resp.setPassword(user.getPassword());
                resp.setPhone(user.getPhone());
                resp.setEmail(user.getEmail());
                resp.setBirthday(user.getBirthday());
                resp.setDegreeId(user.getDegree());
                resp.setTitleId(user.getTitle());
                resp.setEductionId(user.getEduction());
                resp.setDepartmentId(user.getDepartment());
                resp.setCreator(user.getCreator());
                resp.setCreationTime(user.getCreationTime());
                resps.add(resp);
            }
        }
        return resps;
    }

    @Override
    public int addUserManage(int type, User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(PasswordHash.createHash("12345", UUIDUtils.createId()));
        }
        if (type == 3) {
            Expert expert = new Expert();
            expert.setId(UUIDUtils.createId());
            expert.setPassword(PasswordHash.createHash(user.getPassword(), UUIDUtils.createId()));
            expert.setNumber(user.getNumber());
            expert.setAvatar(user.getAvatar());
            expert.setName(user.getName());
            expert.setPhone(user.getPhone());
            expert.setEmail(user.getEmail());
            expert.setCreationTime(new Date());
            expert.setTitle(user.getTitle());
            expert.setDegree(user.getDegree());
            expert.setSchool(user.getDepartment());
            expertMapper.insert(expert);
        } else {
            user.setType(type);
            user.setId(UUIDUtils.createId());
            user.setPassword(PasswordHash.createHash(user.getPassword(), UUIDUtils.createId()));
            user.setIsDeleted(false);
            user.setCreationTime(new Date());
            userMapper.insert(user);
        }
        return 0;
    }

    @Override
    public int editUserManage(int type, User user) {
        if (type == 3) {
            Expert expert = new Expert();
            expert.setId(user.getId());
            expert.setNumber(user.getNumber());
            expert.setAvatar(user.getAvatar());
            expert.setName(user.getName());
            if (!user.getPassword().isEmpty()) {
                expert.setPassword(PasswordHash.createHash(user.getPassword(), UUIDUtils.createId()));
            }
            expert.setPhone(user.getPhone());
            expert.setEmail(user.getEmail());
            expert.setCreator(user.getCreator());
            expert.setCreationTime(new Date());
            expert.setTitle(user.getTitle());
            expert.setDegree(user.getDegree());
            expert.setSchool(user.getDepartment());
            expertMapper.updateByPrimaryKeySelective(expert);
        } else {
            if (!user.getPassword().isEmpty()) {
                user.setPassword(PasswordHash.createHash(user.getPassword(), UUIDUtils.createId()));
            }
            user.setCreationTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return 0;
    }

    @Override
    public int delUserManage(int type, String id) {
        if (type == 3) {
            expertMapper.deleteByPrimaryKey(id);
        } else {
            userMapper.deleteById(id);
        }
        return 0;
    }

    @Override
    public UserResp getByTypeAndId(int type, String id) {
        UserResp resp = new UserResp();
        if (type == 3) {
            Expert expert = expertMapper.selectByPrimaryKey(id);
            resp.setId(expert.getId());
            resp.setDepartmentId(expert.getSchool());
            resp.setDegreeId(expert.getDegree());
            resp.setTitleId(expert.getTitle());
            resp.setNumber(expert.getNumber());
            resp.setAvatar(expert.getAvatar());
            resp.setName(expert.getName());
            resp.setPassword(expert.getPassword());
            resp.setPhone(expert.getPhone());
            resp.setEmail(expert.getEmail());
            resp.setCreator(expert.getCreator());
            resp.setCreationTime(expert.getCreationTime());
        } else {
            User user = userMapper.selectByPrimaryKey(id);
            resp.setId(user.getId());
            resp.setNumber(user.getNumber());
            resp.setAvatar(user.getAvatar());
            resp.setName(user.getName());
            resp.setSex(user.getSex());
            resp.setType(user.getType());
            resp.setPassword(user.getPassword());
            resp.setPhone(user.getPhone());
            resp.setEmail(user.getEmail());
            resp.setBirthday(user.getBirthday());
            resp.setDegreeId(user.getDegree());
            resp.setTitleId(user.getTitle());
            resp.setEductionId(user.getEduction());
            resp.setDepartmentId(user.getDepartment());
            resp.setCreator(user.getCreator());
            resp.setCreationTime(user.getCreationTime());
        }
        return resp;
    }

    @Override
    public List<UserResp> getByNumberOrName(int type, String keyword) {
        List<UserResp> resps = new ArrayList<UserResp>();
        if (type == 3) {
            List<Expert> experts = expertMapper.selectListByNumberOrName(keyword);
            for (Expert user : experts) {
                UserResp resp = new UserResp();
                resp.setId(user.getId());
                resp.setDepartmentId(user.getSchool());
                resp.setDegreeId(user.getDegree());
                resp.setTitleId(user.getTitle());
                resp.setNumber(user.getNumber());
                resp.setAvatar(user.getAvatar());
                resp.setName(user.getName());
                resp.setPassword(user.getPassword());
                resp.setPhone(user.getPhone());
                resp.setEmail(user.getEmail());
                resp.setCreator(user.getCreator());
                resp.setCreationTime(user.getCreationTime());
                resps.add(resp);
            }
        } else {
            List<User> users = userMapper.selectListByNumberOrName(keyword);
            for (User user : users) {
                UserResp resp = new UserResp();
                resp.setId(user.getId());
                resp.setNumber(user.getNumber());
                resp.setAvatar(user.getAvatar());
                resp.setName(user.getName());
                resp.setSex(user.getSex());
                resp.setType(user.getType());
                resp.setPassword(user.getPassword());
                resp.setPhone(user.getPhone());
                resp.setEmail(user.getEmail());
                resp.setBirthday(user.getBirthday());
                resp.setDegreeId(user.getDegree());
                resp.setTitleId(user.getTitle());
                resp.setEductionId(user.getEduction());
                resp.setDepartmentId(user.getDepartment());
                resp.setCreator(user.getCreator());
                resp.setCreationTime(user.getCreationTime());
                resps.add(resp);
            }
        }
        return resps;
    }

    @Override
    public User getExpertByNumberAndType(String number, int type) {
        Expert expert = expertMapper.selectByNumberAndType(number, type);
        if (expert == null) {
            return null;
        }
        User user = new User();
        user.setNumber(expert.getNumber());
        user.setPassword(expert.getPassword());
        return user;
    }

    @Override
    public List<Expert> getExpertByDisciplineCategoryId(String id, RowBounds page) {
        return expertMapper.selectByDisciplineCategoryId(id, page);
    }

    @Override
    public Expert getExpertById(String expertId) {
        return expertMapper.selectByPrimaryKey(expertId);
    }

}
