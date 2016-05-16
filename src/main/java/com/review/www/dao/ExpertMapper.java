package com.review.www.dao;

import com.review.www.entity.Expert;
import org.apache.ibatis.annotations.Param;

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

    List<Expert> selectListByNumberOrName(@Param("keyword") String keyword);

    Expert selectByNumberAndType(@Param("number")String number,@Param("type")int type);
}