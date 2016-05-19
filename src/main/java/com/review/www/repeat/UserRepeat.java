package com.review.www.repeat;

import com.review.www.enums.UserType;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zrl on 16/5/19.
 */
public class UserRepeat {

    /**
     * type and model
     * @return ModelAndView model
     */
    public ModelAndView compareType(int type, ModelAndView model){
        if(type== UserType.APPLICANT){
            model.addObject("title","项目申报者");
        }
        else if(type==UserType.SECONDARY_COLLEGE){
            model.addObject("title","二级学院管理人员");
        }
        else if(type==UserType.EXPERT){
            model.addObject("title","专家");
        }
        else if(type==UserType.ADMIN){
            model.addObject("title","科研室管理人员");
        }
        return model;
    }
}
