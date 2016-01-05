package com.review.www.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangtianfeng on 15/12/27.
 */
@RestController
@RequestMapping("/demo")
public class IndexController extends WebBaseController {

    @RequestMapping("index.htm")
    public ModelAndView demo() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
