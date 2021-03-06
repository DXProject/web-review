package com.review.www.dao;

import com.review.www.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * select by number and type
     *
     * @param number
     * @param type
     * @return
     */
    User selectByNumberAndType(@Param("number") String number, @Param("type") int type);


    /**
     * selectByType
     */
    List<User> selectByType(int type);

    int deleteById(String id);

    List<User> selectListByNumberOrName(@Param("keyword") String keyword);

}