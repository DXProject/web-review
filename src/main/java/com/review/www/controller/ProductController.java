package com.review.www.controller;

import com.jopool.jweb.entity.Result;
import com.jopool.jweb.enums.Code;
import com.review.www.entity.Announcement;
import com.review.www.entity.ClassOne;
import com.review.www.entity.ClassThree;
import com.review.www.entity.ClassTwo;
import com.review.www.request.AddProductAnnouncementReq;
import com.review.www.request.DateParam;
import com.review.www.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@Controller
@RequestMapping("/product")
public class ProductController extends WebBaseController {
    @Resource
    private ProductService productService;

    /**
     * 发布新项目申请
     *
     * @return
     */
    @RequestMapping("addProductAnnouncement.htm")
    public ModelAndView addProductAnnouncement() {
        ModelAndView mv = getSessionUserMV("product/addProductAnnouncement");
        List<ClassOne> classOnes = productService.getClassOneList();
        List<ClassTwo> classTwos = productService.getClassTwoList();
        mv.addObject("classOnes",classOnes);
        mv.addObject("classTwos",classTwos);
        return mv;
    }

    @RequestMapping("doAddProductAnnouncement.htm")
    public Result doAddProductAnnouncement(AddProductAnnouncementReq req){
        DateParam dateParam = getDateParam(req.getTimeStart(),req.getTimeEnd());
        Announcement announcement = req.parseAnnouncement(getSessionUser().getUserId(),dateParam);
        ClassThree classThree =req.parseThree(getSessionUser().getUserId(),dateParam);
        productService.doAddProductAnnouncement(announcement,classThree);
        return new Result(Code.SUCCESS);
    }
}
