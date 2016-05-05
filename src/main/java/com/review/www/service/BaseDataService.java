package com.review.www.service;

import com.jopool.jweb.entity.Result;
import com.review.www.entity.BaseConstant;
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
    BaseConstant getBaseConstantById(String id);

    /**
     * add BaseConstant
     *
     * @param BaseConstant
     */
    Result addBaseConstant(BaseConstant BaseConstant);

    /**
     * modify BaseConstant
     *
     * @param BaseConstant
     * @return
     */
    Result modifyBaseConstant(BaseConstant BaseConstant);

    /**
     * search BaseConstant
     *
     * @param searchBaseDataVo
     * @param page
     * @return
     */
    List<BaseConstant> searchBaseConstant(SearchBaseDataVo searchBaseDataVo, RowBounds page);

    /**
     * do remove BaseConstant
     *
     * @param id
     * @return
     */
    Result doRemoveBaseConstant(String id);
}
