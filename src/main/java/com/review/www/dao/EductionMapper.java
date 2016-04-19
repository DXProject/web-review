package com.review.www.dao;

import com.review.www.entity.Eduction;

public interface EductionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Eduction record);

    int insertSelective(Eduction record);

    Eduction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Eduction record);

    int updateByPrimaryKey(Eduction record);
}