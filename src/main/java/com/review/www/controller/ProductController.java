package com.review.www.controller;

import com.review.www.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zhangtianfeng on 16/5/4.
 */
@Controller
@RequestMapping("/product")
public class ProductController extends WebBaseController {
    @Resource
    private ProductService productService;

    @RequestMapping("addProduct.htm")
    public ModelAndView addProduct() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
