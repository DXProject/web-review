package com.review.www.dao;

import com.review.www.entity.Title;
import com.review.www.vo.SearchBaseDataVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TitleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Title record);

    int insertSelective(Title record);

    Title selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);

    /**
     * search title
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Title> searchTitle(SearchBaseDataVo searchBaseDataVo, RowBounds page);
}