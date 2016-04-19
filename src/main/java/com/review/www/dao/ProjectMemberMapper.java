package com.review.www.dao;

import com.review.www.entity.ProjectMember;

public interface ProjectMemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectMember record);

    int insertSelective(ProjectMember record);

    ProjectMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectMember record);

    int updateByPrimaryKey(ProjectMember record);
}