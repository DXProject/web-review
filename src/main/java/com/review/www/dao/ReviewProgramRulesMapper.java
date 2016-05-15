package com.review.www.dao;

import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.ReviewProgramRules;
import com.review.www.vo.SearchBaseDataVo;

import java.util.List;

public interface ReviewProgramRulesMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReviewProgramRules record);

    int insertSelective(ReviewProgramRules record);

    ReviewProgramRules selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReviewProgramRules record);

    int updateByPrimaryKey(ReviewProgramRules record);

    /**
     * deleted by reviewProgram
     *
     * @param reviewProgramId
     */
    void deleteByReviewProgram(String reviewProgramId);

    /**
     * search
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<ReviewProgramRules> search(SearchBaseDataVo searchBaseDataVo, Pagination page);
}