package com.review.www.dao;

import com.review.www.entity.Project;
import com.review.www.vo.SearchProjectVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    /**
     * search Project
     *
     * @param searchProjectVo
     * @param page
     * @return
     */
    List<Project> searchProject(SearchProjectVo searchProjectVo, RowBounds page);
}