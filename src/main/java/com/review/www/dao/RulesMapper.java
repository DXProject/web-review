package com.review.www.dao;

import com.review.www.entity.Rules;

public interface RulesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Rules record);

    int insertSelective(Rules record);

    Rules selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rules record);

    int updateByPrimaryKey(Rules record);
}