package com.review.www.request;

import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.entity.Announcement;
import com.review.www.entity.ClassThree;

import java.util.Date;

/**
 * Created by zhangtianfeng on 16/5/6.
 */
public class AddProjectAnnouncementReq {
    private String title; //公告标题
    private int    type;//公告类型
    private String content; //公告内容
    private String timeStart; //项目申报时间
    private String timeEnd;
    private String name;//项目名称
    private String remark;//项目备注
    private String classOne; //项目等地
    private String classTwo;
    private String reviewProgram;//评审方案

    public Announcement parseAnnouncement(String userId, DateParam dateParam) {
        Announcement announcement = new Announcement();
        announcement.setId(UUIDUtils.createId());
        announcement.setTitle(this.title);
        announcement.setType(this.type);
        announcement.setContent(this.content);
        announcement.setStartTime(dateParam.getTimeStart());
        announcement.setEndTime(dateParam.getTimeEnd());
        announcement.setCreator(userId);
        announcement.setCreationTime(new Date());
        return announcement;
    }

    public ClassThree parseThree(String userId, DateParam dateParam) {
        ClassThree classThree = new ClassThree();
        classThree.setId(UUIDUtils.createId());
        classThree.setClassOneId(this.classOne);
        classThree.setClassTwoId(this.classTwo);
        classThree.setName(this.name);
        classThree.setRemark(this.remark);
        classThree.setIsDeleted(false);
        //classThree.setStatus();
        classThree.setStartTime(dateParam.getTimeStart());
        classThree.setEndTime(dateParam.getTimeEnd());
        classThree.setReviewprogramId(reviewProgram);
        classThree.setCreator(userId);
        classThree.setCreationTime(new Date());
        return classThree;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getClassOne() {
        return classOne;
    }

    public void setClassOne(String classOne) {
        this.classOne = classOne;
    }

    public String getClassTwo() {
        return classTwo;
    }

    public void setClassTwo(String classTwo) {
        this.classTwo = classTwo;
    }

    public String getReviewProgram() {
        return reviewProgram;
    }

    public void setReviewProgram(String reviewProgram) {
        this.reviewProgram = reviewProgram;
    }
}
