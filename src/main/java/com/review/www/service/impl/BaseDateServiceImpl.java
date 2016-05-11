package com.review.www.service.impl;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.spring.SelfBeanAware;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.constants.Constants;
import com.review.www.dao.BaseConstantMapper;
import com.review.www.entity.BaseConstant;
import com.review.www.service.BaseDataService;
import com.review.www.service.UserService;
import com.review.www.vo.SearchBaseDataVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/2.
 */
@Service
public class BaseDateServiceImpl extends BaseServiceImpl implements BaseDataService, SelfBeanAware<BaseDataService> {
    private BaseDataService    selfService;
    @Resource
    private BaseConstantMapper baseConstantMapper;

    @Override
    public void setSelfBean(BaseDataService object) {
        this.selfService = object;
    }

    @Override
    public BaseConstant getBaseConstantById(String id) {
        return baseConstantMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result addBaseConstant(BaseConstant baseConstant) {
        baseConstant.setId(UUIDUtils.createId());
        baseConstant.setNumber(createNumber(Constants.NUMBER_BASE_CONSTANT));
        baseConstant.setCreationTime(new Date());
        baseConstantMapper.insert(baseConstant);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Result modifyBaseConstant(BaseConstant baseConstant) {
        baseConstantMapper.updateByPrimaryKeySelective(baseConstant);
        return new Result(Code.SUCCESS);
    }

    @Override
    public List<BaseConstant> searchBaseConstant(SearchBaseDataVo searchBaseDataVo, RowBounds page) {
        return baseConstantMapper.searchBaseConstant(searchBaseDataVo, page);
    }

    @Override
    public Result doRemoveBaseConstant(String id) {
        baseConstantMapper.deleteByPrimaryKey(id);
        return new Result(Code.SUCCESS);
    }

    @Override
    public List<BaseConstant> getBaseConstantByKey(String key) {
        return baseConstantMapper.searchBaseConstantByKey(key);
    }
}
