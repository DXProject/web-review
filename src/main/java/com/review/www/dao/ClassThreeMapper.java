package com.review.www.dao;

import com.review.www.entity.ClassThree;
import com.review.www.vo.SearchProjectVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ClassThreeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ClassThree record);

    int insertSelective(ClassThree record);

    ClassThree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ClassThree record);

    int updateByPrimaryKey(ClassThree record);

    /**
     * search
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    List<ClassThree> search(SearchProjectVo searchProjectVo, RowBounds page);
}