package com.review.www.dao;

import com.review.www.entity.DisciplineCategory;

public interface DisciplineCategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(DisciplineCategory record);

    int insertSelective(DisciplineCategory record);

    DisciplineCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DisciplineCategory record);

    int updateByPrimaryKey(DisciplineCategory record);
}