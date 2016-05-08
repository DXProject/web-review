package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.ReviewProgram;
import com.review.www.entity.Rules;

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
    Result addReviewProgram(ReviewProgram reviewProgram, List<Rules> rules);

    /**
     * get reviewProgram by id
     *
     * @param id
     * @return
     */
    ReviewProgram getReviewProgramById(String id);

    /**
     *
     * @param reviewProgram
     * @param rules
     * @return
     */
    Result modifyReviewProgram(ReviewProgram reviewProgram, List<Rules> rules);
}
