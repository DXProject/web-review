package com.review.www.dao;

import com.review.www.entity.ReviewProgramRules;

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
}