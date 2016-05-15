package com.review.www.controller;

import com.alibaba.fastjson.JSONArray;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.utils.StringUtils;
import com.review.www.entity.ReviewProgram;
import com.review.www.entity.ReviewProgramRules;
import com.review.www.entity.Rules;
import com.review.www.entity.User;
import com.review.www.response.ReviewProgramResp;
import com.review.www.service.ProgramService;
import com.review.www.service.UserService;
import com.review.www.vo.SearchBaseDataVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/7.
 */
@RestController
@RequestMapping("/program")
public class ProgramController extends WebBaseController {
    @Resource
    private ProgramService programService;
    @Resource
    private UserService    userService;

    /**
     * 细则列表
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    @RequestMapping("rulesList.htm")
    public ModelAndView rulesList(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        List<Rules> rules = programService.searchRules(searchBaseDataVo, page);
        ModelAndView mv = getPageMv("program/rulesList", rules, page);
        mv.addObject("keyword", searchBaseDataVo.getKeyword());
        return mv;
    }

    /**
     * add or modify rules
     *
     * @return
     */
    @RequestMapping("doAddOrModifyRules.htm")
    public Result doAddOrModifyRules(Rules rules) {
        validateParam(rules.getName(), rules.getName());
        if (StringUtils.isEmpty(rules.getId())) {
            rules.setCreator(getSessionUser().getUserId());
            return programService.addRules(rules);
        } else {
            return programService.modify(rules);
        }
    }

    /**
     * get rules info
     *
     * @param id
     * @return
     */
    @RequestMapping("getRulesInfo.htm")
    public Result getRulesInfo(String id) {
        validateParam(id);
        return programService.getRulesInfo(id);
    }

    /**
     * 删除 rules
     *
     * @param id
     * @return
     */
    @RequestMapping("removeRules.htm")
    public Result removeRules(String id) {
        validateParam(id);
        return programService.removeRules(id);
    }

    /**
     * 评审方案列表
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    @RequestMapping("reviewProgramList.htm")
    public ModelAndView reviewProgramList(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        List<ReviewProgramResp> resps = new ArrayList<ReviewProgramResp>();
        List<ReviewProgram> reviewPrograms = programService.searchReviewProgram(searchBaseDataVo, page);
        for (ReviewProgram reviewProgram : reviewPrograms) {
            ReviewProgramResp resp = new ReviewProgramResp(reviewProgram);
            User user = userService.getById(reviewProgram.getCareator());
            if (null != user) {
                resp.setCreator(user.getName());
            }
            resps.add(resp);
        }
        ModelAndView mv = getPageMv("program/reviewProgramList", resps, page);
        mv.addObject("keyword", searchBaseDataVo.getKeyword());
        return mv;
    }

    /**
     * 评审方案已有细则
     *
     * @param searchBaseDataVo
     * @param
     * @param page
     * @return
     */
    @RequestMapping("getAlreadyAddedRules.htm")
    public ModelAndView getRulesByReviewProgramId(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        List<ReviewProgramRules> reviewProgramRules = programService.searchReviewProgramRules(searchBaseDataVo, page);
        List<Rules> resps = new ArrayList<Rules>();
        for (ReviewProgramRules rpr : reviewProgramRules) {
            Rules rules = programService.getRulesById(rpr.getRulesId());
            resps.add(rules);
        }
        ModelAndView mv = getPageMv("program/getAlreadyAddedRules", resps, page);
        mv.addObject("keyword", searchBaseDataVo.getKeyword());
        return mv;
    }

    /**
     * 细则列表
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    @RequestMapping("addFromRulesList.htm")
    public ModelAndView addFromRulesList(SearchBaseDataVo searchBaseDataVo, String reviewProgramId, Pagination page) {
        List<Rules> rules = programService.searchRules(searchBaseDataVo, page);
        ModelAndView mv = getPageMv("program/addFromRulesList", rules, page);
        mv.addObject("reviewProgramId", reviewProgramId);
        mv.addObject("keyword", searchBaseDataVo.getKeyword());
        return mv;
    }

    /**
     * 评审方案添加评审细则
     *
     * @param reviewProgramId
     * @param rules
     * @return
     */
    @RequestMapping("addRulesToReviewProgramRules.htm")
    public Result addRulesToReviewProgramRules(String reviewProgramId, String rules) {
        return programService.addRulesToReviewProgramRules(getSessionUser().getUserId(), reviewProgramId, rules.split(","));
    }

    /**
     * 评审方案未有细则
     *
     * @param searchBaseDataVo
     * @param
     * @param page
     * @return
     */
    @RequestMapping("getNoAddRules.htm")
    public ModelAndView getNoAddRules(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        List<ReviewProgramRules> reviewProgramRules = programService.searchReviewProgramRules(searchBaseDataVo, page);
        ModelAndView mv = getPageMv("program/rulesList", reviewProgramRules, page);
        mv.addObject("keyword", searchBaseDataVo.getKeyword());
        return mv;
    }

    /**
     * 评审方案列表
     *
     * @param id
     * @return
     */
    @RequestMapping("reviewProgramInfo.htm")
    public ModelAndView reviewProgramInfo(String id) {
        ModelAndView mv = getSessionUserMV("program/reviewProgramInfo");
        return mv;
    }

    /**
     * add or modify reviewProgram
     *
     * @param id
     * @param name
     * @param type
     * @return
     */
    @RequestMapping("doAddOrModifyReviewProgram.htm")
    public Result doAddOrModifyReviewProgram(String id, String name, int type) {
        validateParam(name);
        //List<Rules> rules = JSONArray.parseArray(rulesList, Rules.class);
        if (StringUtils.isEmpty(id)) {
            ReviewProgram reviewProgram = new ReviewProgram();
            reviewProgram.setName(name);
            reviewProgram.setType(type);
            reviewProgram.setCareator(getSessionUser().getUserId());
            return programService.addReviewProgram(reviewProgram);
        } else {
            ReviewProgram reviewProgram = programService.getReviewProgramById(id);
            reviewProgram.setName(name);
            reviewProgram.setType(type);
            return programService.modifyReviewProgram(reviewProgram);
        }
    }
}
