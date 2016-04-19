package com.review.www.dao;

import com.review.www.entity.ReviewProgram;

public interface ReviewProgramMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReviewProgram record);

    int insertSelective(ReviewProgram record);

    ReviewProgram selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReviewProgram record);

    int updateByPrimaryKey(ReviewProgram record);
}