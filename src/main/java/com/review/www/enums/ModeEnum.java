package com.review.www.enums;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public enum ModeEnum {
    /**
     * 1：开发模式，2：测试模式，3：正式环境
     */
    DEVELOP(1, "开发"), SNAPSHOT(2, "测试"), RELEASE(3, "正式");

    private int value;
    private String name;

    private ModeEnum(int value, String name) {
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

    public static ModeEnum valueOf(int value) {
        ModeEnum result = DEVELOP;
        for (ModeEnum e : ModeEnum.values()) {
            if (e.getValue() == value) {
                result = e;
            }
        }
        return result;
    }

}

