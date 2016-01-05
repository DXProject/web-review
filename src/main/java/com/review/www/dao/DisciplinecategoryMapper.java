package com.review.www.dao;

import com.review.www.entity.Disciplinecategory;

public interface DisciplinecategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Disciplinecategory record);

    int insertSelective(Disciplinecategory record);

    Disciplinecategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Disciplinecategory record);

    int updateByPrimaryKey(Disciplinecategory record);
}