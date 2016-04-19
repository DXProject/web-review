package com.review.www.dao;

import com.review.www.entity.ClassTwo;

public interface ClassTwoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassTwo record);

    int insertSelective(ClassTwo record);

    ClassTwo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassTwo record);

    int updateByPrimaryKey(ClassTwo record);
}