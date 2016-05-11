package com.review.www.enums;

/**
 * Created by zhangtianfeng on 16/1/5.
 */
public enum AnnouncementTypeEnum {
    /**
     * 1：公告类型，2：普通公告，3：项目公告
     */
    NORMAL_ANNOUNCEMENT(1, "开发"), PROJECT_ANNOUNCEMENT(2, "测试");

    private int value;
    private String name;

    private AnnouncementTypeEnum(int value, String name) {
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

    public static AnnouncementTypeEnum valueOf(int value) {
        AnnouncementTypeEnum result = NORMAL_ANNOUNCEMENT;
        for (AnnouncementTypeEnum e : AnnouncementTypeEnum.values()) {
            if (e.getValue() == value) {
                result = e;
            }
        }
        return result;
    }

}

