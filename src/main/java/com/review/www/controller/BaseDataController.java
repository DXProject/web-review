package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.jopool.jweb.mybatis.page.Pagination;
import com.jopool.jweb.utils.StringUtils;
import com.review.www.entity.Title;
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
    @RequestMapping("titleList.htm")
    public ModelAndView spreadList(SearchBaseDataVo searchBaseDataVo, Pagination page) {
        List<Title> titles = baseDataService.searchTitle(searchBaseDataVo, page.page());
        ModelAndView mv = getPageMv("baseData/titleList", titles, page);
        mv.addObject("keyword", searchBaseDataVo.getKeyword());
        return mv;
    }

    @RequestMapping("getTitleInfo.htm")
    public Result getTitleInfo(String id){
        return new Result(Code.SUCCESS,baseDataService.getTitleById(id));
    }

    /**
     * do add/modify title
     *
     * @return
     */
    @RequestMapping("doAddOrModifyTitle.htm")
    public Result doAddOrModifyTitle(Title title) {
        if(StringUtils.isEmpty(title.getId())){
            title.setCreator(getSessionUser().getUserId());
            return baseDataService.addTitle(title);
        }else{
            return baseDataService.modifyTitle(title);
        }
    }

}
