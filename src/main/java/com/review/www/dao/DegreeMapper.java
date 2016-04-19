package com.review.www.dao;

import com.review.www.entity.Degree;

public interface DegreeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Degree record);

    int insertSelective(Degree record);

    Degree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Degree record);

    int updateByPrimaryKey(Degree record);
}