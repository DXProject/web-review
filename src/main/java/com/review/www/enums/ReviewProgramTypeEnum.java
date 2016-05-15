package com.review.www.enums;

/**
 * Created by zhangtianfeng on 16/5/13.
 */
public enum ReviewProgramTypeEnum {
    /**
     * 1：开发模式，2：测试模式，3：正式环境
     */
    TYPE_ONE(1, "等级评定"), TYPE_TWO(2, "通过与否"), TYPE_THREE(3, "分数评定"),TYPE_FOUR(4, "细则评定");

    private int value;
    private String name;

    private ReviewProgramTypeEnum(int value, String name) {
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

    public static ReviewProgramTypeEnum valueOf(int value) {
        ReviewProgramTypeEnum result = TYPE_ONE;
        for (ReviewProgramTypeEnum e : ReviewProgramTypeEnum.values()) {
            if (e.getValue() == value) {
                result = e;
            }
        }
        return result;
    }
}
