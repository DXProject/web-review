package com.review.www.dao;

import com.review.www.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据教工号查询
     *
     * @param number
     * @return
     */
    User selectByNumber(String number);
}