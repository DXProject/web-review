package com.review.www.controller;

import com.alibaba.fastjson.JSONArray;
import com.jopool.jweb.entity.Result;
import com.jopool.jweb.utils.StringUtils;
import com.review.www.entity.ReviewProgram;
import com.review.www.entity.Rules;
import com.review.www.service.ProgramService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/7.
 */
@Controller
@RequestMapping("/program")
public class ProgramController extends WebBaseController {
    @Resource
    private ProgramService programService;

    /**
     * add or modify rules
     *
     * @param id
     * @param name
     * @param details
     * @return
     */
    @RequestMapping("doAddOrModifyRules.htm")
    public Result doAddOrModifyRules(String id, String name, String details) {
        validateParam(name, details);
        if (StringUtils.isEmpty(id)) {
            Rules rules = new Rules();
            rules.setName(name);
            rules.setDetails(details);
            rules.setCreator(getSessionUser().getUserId());
            return programService.addRules(rules);
        } else {
            Rules rules = programService.getRulesById(id);
            rules.setName(name);
            rules.setDetails(details);
            return programService.modify(rules);
        }
    }

    /**
     * remove rules
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
     * add or modify reviewProgram
     *
     * @param id
     * @param name
     * @param type
     * @return
     */
    @RequestMapping("doAddOrModifyReviewProgram.htm")
    public Result doAddOrModifyReviewProgram(String id, String name, int type,String rulesList) {
        validateParam(name);
        List<Rules> rules = JSONArray.parseArray(rulesList,Rules.class);
        if (StringUtils.isEmpty(id)) {
            ReviewProgram reviewProgram = new ReviewProgram();
            reviewProgram.setName(name);
            reviewProgram.setType(type);
            reviewProgram.setCareator(getSessionUser().getUserId());
            return programService.addReviewProgram(reviewProgram,rules);
        } else {
            ReviewProgram reviewProgram = programService.getReviewProgramById(id);
            reviewProgram.setName(name);
            reviewProgram.setType(type);
            return programService.modifyReviewProgram(reviewProgram,rules);
        }
    }
}
