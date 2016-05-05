package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.utils.StringUtils;
import com.review.www.entity.BaseConstant;
import com.review.www.service.BaseDataService;
import com.review.www.service.impl.BaseDateServiceImpl;
import com.review.www.vo.SearchBaseDataVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/2.
 */
@RestController
@RequestMapping("/baseData")
public class BaseDataController extends WebBaseController {
    @Resource
    private BaseDataService baseDataService;

    /**
     * 职称列表
     *
     * @return
     */
    @RequestMapping("baseConstantList.htm")
    public ModelAndView baseConstantList(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        List<BaseConstant> baseConstants = baseDataService.searchBaseConstant(searchBaseDataVo, page.page());
        ModelAndView mv = getPageMv("baseData/baseConstantList", baseConstants, page);
        mv.addObject("key", searchBaseDataVo.getKey());
        return mv;
    }

    /**
     * get baseConstants info
     * @param id
     * @return
     */
    @RequestMapping("getBaseConstantsInfo.htm")
    public Result getBaseConstantsInfo(String id){
        return new Result(Code.SUCCESS,baseDataService.getBaseConstantById(id));
    }

    /**
     * do add/modify baseConstants
     *
     * @return
     */
    @RequestMapping("doAddOrModifyBaseConstants.htm")
    public Result doAddOrModifyBaseConstants(BaseConstant baseConstant) {
        if(StringUtils.isEmpty(baseConstant.getId())){
            baseConstant.setCreator(getSessionUser().getUserId());
            return baseDataService.addBaseConstant(baseConstant);
        }else{
            return baseDataService.modifyBaseConstant(baseConstant);
        }
    }

    /**
     * do remove baseConstant
     *
     * @return
     */
    @RequestMapping("doRemoveBaseConstant.htm")
    public Result doRemoveBaseConstant(String id) {
        validateParam(id);
        return baseDataService.doRemoveBaseConstant(id);
    }
}
