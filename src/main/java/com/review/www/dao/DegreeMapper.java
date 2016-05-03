package com.review.www.dao;

import com.review.www.entity.Degree;
import com.review.www.vo.SearchBaseDataVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DegreeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Degree record);

    int insertSelective(Degree record);

    Degree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Degree record);

    int updateByPrimaryKey(Degree record);

    /**
     * search degree
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Degree> searchDegree(SearchBaseDataVo searchBaseDataVo, RowBounds page);
}