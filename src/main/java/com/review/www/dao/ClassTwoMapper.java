package com.review.www.dao;

import com.review.www.entity.ClassTwo;

import java.util.List;

public interface ClassTwoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassTwo record);

    int insertSelective(ClassTwo record);

    ClassTwo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassTwo record);

    int updateByPrimaryKey(ClassTwo record);

    /**
     * select all
     *
     * @return
     */
    List<ClassTwo> selectAllClassTwo();
}