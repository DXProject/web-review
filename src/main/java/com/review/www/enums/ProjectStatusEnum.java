package com.review.www.enums;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public enum ProjectStatusEnum {
    WAITING_FOR_REVIEW(1, "已申报项目"),  SECONDARY_COLLEGE_REVIEW(2, "二级学院通过项目"),RESEARCH_REVIEW(3,"科研室通过项目"),EPERT_REVIEW(4, "专家通过项目"),ELIMINATE(5, "可修改项目"), MODIFY_PROJECT(6, "被淘汰项目");

    private int value;
    private String name;

    private ProjectStatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.name();
    }

    public static ProjectStatusEnum valueOf(int value) {
        ProjectStatusEnum result = WAITING_FOR_REVIEW;
        for (ProjectStatusEnum e : ProjectStatusEnum.values()) {
            if (e.getValue() == value) {
                result = e;
            }
        }
        return result;
    }

}

