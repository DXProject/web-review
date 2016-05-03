package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.Title;
import com.review.www.vo.SearchBaseDataVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/2.
 */
public interface BaseDataService {
    /**
     * get by id
     * @param id
     * @return
     */
    Title getTitleById(String id);

    /**
     * add title
     * @param title
     */
    Result addTitle(Title title);

    /**
     * modify title
     * @param title
     * @return
     */
    Result modifyTitle(Title title);

    /**
     * search title
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<Title> searchTitle(SearchBaseDataVo searchBaseDataVo, RowBounds page);
}
