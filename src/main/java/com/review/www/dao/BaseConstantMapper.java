package com.review.www.dao;

import com.review.www.entity.BaseConstant;
import com.review.www.vo.SearchBaseDataVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseConstantMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseConstant record);

    int insertSelective(BaseConstant record);

    BaseConstant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseConstant record);

    int updateByPrimaryKey(BaseConstant record);

    /**
     * search BaseConstant
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<BaseConstant> searchBaseConstant(SearchBaseDataVo searchBaseDataVo, RowBounds page);
}