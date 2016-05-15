package com.review.www.service.impl;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.spring.SelfBeanAware;
import com.jopool.jweb.utils.StringUtils;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.constants.Constants;
import com.review.www.dao.ReviewProgramMapper;
import com.review.www.dao.ReviewProgramRulesMapper;
import com.review.www.dao.RulesMapper;
import com.review.www.entity.ReviewProgram;
import com.review.www.entity.ReviewProgramRules;
import com.review.www.entity.Rules;
import com.review.www.service.ProgramService;
import com.review.www.vo.SearchBaseDataVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/7.
 */
@Service
public class ProgramServiceImpl extends BaseServiceImpl implements ProgramService, SelfBeanAware<ProgramService> {
    private ProgramService           selfService;
    @Resource
    private RulesMapper              rulesMapper;
    @Resource
    private ReviewProgramMapper      reviewProgramMapper;
    @Resource
    private ReviewProgramRulesMapper reviewProgramRulesMapper;

    @Override
    public void setSelfBean(ProgramService object) {
        this.selfService = object;
    }

    @Override
    public Result addRules(Rules rules) {
        rules.setId(UUIDUtils.createId());
        rules.setNumber(createNumber(Constants.NUMBER_RULES));
        rules.setIsDeleted(false);
        rules.setCreationTime(new Date());
        rulesMapper.insert(rules);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Rules getRulesById(String id) {
        return rulesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result modify(Rules rules) {
        rulesMapper.updateByPrimaryKeySelective(rules);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Result removeRules(String id) {
        rulesMapper.deleteByPrimaryKey(id);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Result addReviewProgram(ReviewProgram reviewProgram) {
        reviewProgram.setId(UUIDUtils.createId());
        reviewProgram.setCreationTime(new Date());
        reviewProgram.setIsDeleted(false);
        reviewProgramMapper.insert(reviewProgram);
//        if (rules.size() != 0) {
//            addReviewProgramRules(reviewProgram, rules);
//        }
        return new Result(Code.SUCCESS);
    }

    @Override
    public ReviewProgram getReviewProgramById(String id) {
        return reviewProgramMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result modifyReviewProgram(ReviewProgram reviewProgram) {
        reviewProgramMapper.updateByPrimaryKeySelective(reviewProgram);
//        if (rules.size() != 0) {
//            reviewProgramRulesMapper.deleteByReviewProgram(reviewProgram.getId());
//            addReviewProgramRules(reviewProgram, rules);
//        }
        return new Result(Code.SUCCESS);
    }

    @Override
    public List<Rules> searchRules(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        return rulesMapper.searchRules(searchBaseDataVo,page);
    }

    @Override
    public Result getRulesInfo(String id) {
        return new Result(Code.SUCCESS,rulesMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<ReviewProgram> searchReviewProgram(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        return reviewProgramMapper.searchReviewProgram(searchBaseDataVo,page);
    }

    @Override
    public List<ReviewProgramRules> searchReviewProgramRules(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        return reviewProgramRulesMapper.search(searchBaseDataVo,page);
    }

    @Override
    public Result addRulesToReviewProgramRules(String userId, String reviewProgramId, String[] rulesIds) {
        if (rulesIds.length <= 0) {
            return new Result(Code.ERROR, "请选择评审细则");
        }
        for(String rulesId : rulesIds){
            if(StringUtils.isEmpty(rulesId)){
                continue;
            }
            ReviewProgramRules rpr = new ReviewProgramRules();
            rpr.setId(UUIDUtils.createId());
            rpr.setCreationTime(new Date());
            rpr.setCreator(userId);
            rpr.setReviewProgramId(reviewProgramId);
            rpr.setRulesId(rulesId);
            reviewProgramRulesMapper.insert(rpr);
        }
        return new Result(Code.SUCCESS);
    }

    private void addReviewProgramRules(ReviewProgram reviewProgram, List<Rules> rules) {
        Date date = new Date();
        for (Rules rule : rules) {
            ReviewProgramRules rpr = new ReviewProgramRules();
            rpr.setId(UUIDUtils.createId());
            rpr.setReviewProgramId(reviewProgram.getId());
            rpr.setRulesId(rule.getId());
            //rpr.setPercentage(rule);
            rpr.setCreator(reviewProgram.getCareator());
            rpr.setCreationTime(date);
            reviewProgramRulesMapper.insert(rpr);
        }
    }
}
