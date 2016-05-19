package com.review.www.response;

import java.util.Date;

/**
 * Created by zhangtianfeng on 16/5/16.
 */
public class ProjectListResp {
    private String id;
    private String number;
    private String name;
    private String creator;
    private String creatorNumber;
    private String disciplineCategory;
    private int    status;
    private Date   creationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorNumber() {
        return creatorNumber;
    }

    public void setCreatorNumber(String creatorNumber) {
        this.creatorNumber = creatorNumber;
    }

    public String getDisciplineCategory() {
        return disciplineCategory;
    }

    public void setDisciplineCategory(String disciplineCategory) {
        this.disciplineCategory = disciplineCategory;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
