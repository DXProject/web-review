package com.review.www.dao;

import com.review.www.entity.ClassThree;

public interface ClassThreeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassThree record);

    int insertSelective(ClassThree record);

    ClassThree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassThree record);

    int updateByPrimaryKey(ClassThree record);
}