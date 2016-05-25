package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.mybatis.page.Pagination;
import com.review.www.entity.Comment;
import com.review.www.entity.ReviewProgram;
import com.review.www.entity.ReviewProgramRules;
import com.review.www.entity.Rules;
import com.review.www.vo.SearchBaseDataVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/7.
 */
public interface ProgramService {
    /**
     * add rules
     *
     * @param rules
     * @return
     */
    Result addRules(Rules rules);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    Rules getRulesById(String id);

    /**
     * modify rules
     *
     * @param rules
     * @return
     */
    Result modify(Rules rules);

    /**
     * remove rules
     *
     * @param id
     * @return
     */
    Result removeRules(String id);

    /**
     * add reviewProgram
     *
     * @param reviewProgram
     * @param
     * @return
     */
    Result addReviewProgram(ReviewProgram reviewProgram);

    /**
     * get reviewProgram by id
     *
     * @param id
     * @return
     */
    ReviewProgram getReviewProgramById(String id);

    /**
     * @param reviewProgram
     * @param
     * @return
     */
    Result modifyReviewProgram(ReviewProgram reviewProgram);

    /**
     * search
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Rules> searchRules(SearchBaseDataVo searchBaseDataVo, Pagination page);

    /**
     * get rules info
     *
     * @param id
     * @return
     */
    Result getRulesInfo(String id);

    /**
     * search reviewProgram
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<ReviewProgram> searchReviewProgram(SearchBaseDataVo searchBaseDataVo, Pagination page);

    /**
     * search ReviewProgramRules
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<ReviewProgramRules> searchReviewProgramRules(SearchBaseDataVo searchBaseDataVo, Pagination page);

    /**
     * add rules to reviewProgram
     *
     * @param userId
     * @param reviewProgramId
     * @param split
     * @return
     */
    Result addRulesToReviewProgramRules(String userId, String reviewProgramId, String[] split);

    /**
     * remove reviewProgram
     *
     * @param id
     * @return
     */
    Result removeReviewProgram(String id);

    /**
     * get all review Program
     *
     * @return
     */
    List<ReviewProgram> getAllReviewProgram();

    /**
     * get comments by expertId
     *
     * @param id
     * @param page
     * @return
     */
    List<Comment> getCommentsByExpertId(String id, RowBounds page);
}
