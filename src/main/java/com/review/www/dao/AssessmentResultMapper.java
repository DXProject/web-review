package com.review.www.dao;

import com.review.www.entity.AssessmentResult;

public interface AssessmentResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssessmentResult record);

    int insertSelective(AssessmentResult record);

    AssessmentResult selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssessmentResult record);

    int updateByPrimaryKey(AssessmentResult record);
}