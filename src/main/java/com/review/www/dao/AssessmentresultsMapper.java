package com.review.www.dao;

import com.review.www.entity.Assessmentresults;

public interface AssessmentresultsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Assessmentresults record);

    int insertSelective(Assessmentresults record);

    Assessmentresults selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Assessmentresults record);

    int updateByPrimaryKey(Assessmentresults record);
}