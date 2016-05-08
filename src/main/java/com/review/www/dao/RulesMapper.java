package com.review.www.dao;

import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.Rules;
import com.review.www.vo.SearchBaseDataVo;

import java.util.List;

public interface RulesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Rules record);

    int insertSelective(Rules record);

    Rules selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rules record);

    int updateByPrimaryKey(Rules record);

    /**
     * search Rules
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Rules> searchRules(SearchBaseDataVo searchBaseDataVo, Pagination page);
}