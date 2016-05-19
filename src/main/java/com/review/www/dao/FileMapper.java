package com.review.www.dao;

import com.review.www.entity.File;

import java.util.List;

public interface FileMapper {
    int deleteByPrimaryKey(String id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    /**
     * select by projectId
     *
     * @param id
     * @return
     */
    List<File> selectByProjectId(String id);
}