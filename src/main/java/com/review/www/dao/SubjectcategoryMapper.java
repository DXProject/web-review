package com.review.www.dao;

import com.review.www.entity.Subjectcategory;

public interface SubjectcategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Subjectcategory record);

    int insertSelective(Subjectcategory record);

    Subjectcategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Subjectcategory record);

    int updateByPrimaryKey(Subjectcategory record);
}