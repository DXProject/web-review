package com.review.www.dao;

import com.review.www.entity.Title;

public interface TitleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Title record);

    int insertSelective(Title record);

    Title selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
}