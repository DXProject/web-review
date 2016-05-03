package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.Degree;
import com.review.www.entity.Title;
import com.review.www.vo.SearchBaseDataVo;
import com.sun.javafx.font.directwrite.DWFactory;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/2.
 */
public interface BaseDataService {
    /**
     * get by id
     *
     * @param id
     * @return
     */
    Title getTitleById(String id);

    /**
     * add title
     *
     * @param title
     */
    Result addTitle(Title title);

    /**
     * modify title
     *
     * @param title
     * @return
     */
    Result modifyTitle(Title title);

    /**
     * search title
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Title> searchTitle(SearchBaseDataVo searchBaseDataVo, RowBounds page);

    /**
     * get by id
     *
     * @param id
     * @return
     */
    Degree getDegreeById(String id);

    /**
     * add degree
     *
     * @param degree
     */
    Result addDegree(Degree degree);

    /**
     * modify degree
     *
     * @param degree
     * @return
     */
    Result modifyDegree(Degree degree);

    /**
     * search degree
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Degree> searchDegree(SearchBaseDataVo searchBaseDataVo, RowBounds page);

    /**
     * do remove title
     *
     * @param id
     * @return
     */
    Result doRemoveTitle(String id);

    /**
     * do remove degree
     *
     * @param id
     * @return
     */
    Result doRemoveDegree(String id);
}
