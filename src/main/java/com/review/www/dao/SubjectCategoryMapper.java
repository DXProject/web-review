package com.review.www.dao;

import com.review.www.entity.SubjectCategory;

public interface SubjectCategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(SubjectCategory record);

    int insertSelective(SubjectCategory record);

    SubjectCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SubjectCategory record);

    int updateByPrimaryKey(SubjectCategory record);
}