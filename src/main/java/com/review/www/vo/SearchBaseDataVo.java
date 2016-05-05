package com.review.www.vo;

import com.review.www.constants.Constants;

/**
 * Created by zhangtianfeng on 16/5/2.
 */
public class SearchBaseDataVo {
    private String key = Constants.BASE_CONSTANT_TITLE;
    private String keyword;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
