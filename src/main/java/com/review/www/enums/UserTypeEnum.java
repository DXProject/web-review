package com.review.www.enums;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public enum UserTypeEnum {
    /**
     * 1：运营，2：项目申请者，3：二级学院管理员
     */
    ADMIN(1, "运营"), APPLICANT(2, "项目申请者"), SECONDARY_COLLEGE(3, "二级学院管理员");

    private int value;
    private String name;

    private UserTypeEnum(int value, String name) {
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

    public static UserTypeEnum valueOf(int value) {
        UserTypeEnum result = ADMIN;
        for (UserTypeEnum e : UserTypeEnum.values()) {
            if (e.getValue() == value) {
                result = e;
            }
        }
        return result;
    }

}

