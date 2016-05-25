package com.review.www.dao;

import com.review.www.entity.Comment;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * select by prjectId
     *
     * @param projectId
     * @param page
     * @return
     */
    List<Comment> selectByProjectId(String projectId, RowBounds page);

    /**
     * select by expertId
     *
     * @param expertId
     * @param page
     * @return
     */
    List<Comment> selectByExpertId(String expertId, RowBounds page);
}