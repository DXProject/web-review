package com.review.www.service.impl;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.spring.SelfBeanAware;
import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.dao.DegreeMapper;
import com.review.www.dao.TitleMapper;
import com.review.www.entity.Degree;
import com.review.www.entity.Title;
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
    private BaseDataService selfService;
    @Resource
    private TitleMapper     titleMapper;
    @Resource
    private DegreeMapper    degreeMapper;

    @Override
    public void setSelfBean(BaseDataService object) {
        this.selfService = object;
    }

    @Override
    public Title getTitleById(String id) {
        return titleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result addTitle(Title title) {
        title.setId(UUIDUtils.createId());
        title.setNumber("");//TODO
        title.setCreationTime(new Date());
        titleMapper.insert(title);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Result modifyTitle(Title title) {
        titleMapper.updateByPrimaryKeySelective(title);
        return new Result(Code.SUCCESS);
    }

    @Override
    public List<Title> searchTitle(SearchBaseDataVo searchBaseDataVo, RowBounds page) {
        return titleMapper.searchTitle(searchBaseDataVo, page);
    }

    @Override
    public Degree getDegreeById(String id) {
        return degreeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result addDegree(Degree degree) {
        degree.setId(UUIDUtils.createId());
        degree.setNumber("");//TODO
        degree.setCreationTime(new Date());
        degreeMapper.insert(degree);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Result modifyDegree(Degree degree) {
        degreeMapper.updateByPrimaryKeySelective(degree);
        return new Result(Code.SUCCESS);
    }

    @Override
    public List<Degree> searchDegree(SearchBaseDataVo searchBaseDataVo, RowBounds page) {
        return degreeMapper.searchDegree(searchBaseDataVo, page);
    }

    @Override
    public Result doRemoveTitle(String id) {
        titleMapper.deleteByPrimaryKey(id);
        return new Result(Code.SUCCESS);
    }

    @Override
    public Result doRemoveDegree(String id) {
        degreeMapper.deleteByPrimaryKey(id);
        return new Result(Code.SUCCESS);
    }
}
