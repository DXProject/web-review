package com.review.www.dao;

import com.review.www.entity.Expert;

import java.util.List;

public interface ExpertMapper {
    int deleteByPrimaryKey(String id);

    int insert(Expert record);

    int insertSelective(Expert record);

    Expert selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Expert record);

    int updateByPrimaryKey(Expert record);
    /**
     * selectListAll
     * 查找所有专家
     */
    List<Expert> selectListAll();


}