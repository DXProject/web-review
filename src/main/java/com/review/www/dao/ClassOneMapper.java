package com.review.www.dao;

import com.review.www.entity.ClassOne;

import java.util.List;

public interface ClassOneMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassOne record);

    int insertSelective(ClassOne record);

    ClassOne selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassOne record);

    int updateByPrimaryKey(ClassOne record);

    /**
     * select all
     * @return
     */
    List<ClassOne> selectAllClassOne();
}