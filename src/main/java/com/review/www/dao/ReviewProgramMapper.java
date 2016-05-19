package com.review.www.dao;

import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.ReviewProgram;
import com.review.www.vo.SearchBaseDataVo;

import java.util.List;

public interface ReviewProgramMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReviewProgram record);

    int insertSelective(ReviewProgram record);

    ReviewProgram selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReviewProgram record);

    int updateByPrimaryKey(ReviewProgram record);

    /**
     * search reviewProgram
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<ReviewProgram> searchReviewProgram(SearchBaseDataVo searchBaseDataVo, Pagination page);

    /**
     * selelct all
     *
     * @return
     */
    List<ReviewProgram> selectAll();
}