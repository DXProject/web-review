package com.review.www.response;

import com.review.www.entity.ReviewProgram;

import java.util.Date;

/**
 * Created by zhangtianfeng on 16/5/9.
 */
public class ReviewProgramResp {
    private String id;
    private String name;
    private int    type;
    private Date   creationTime;
    private String creator;

    public ReviewProgramResp(ReviewProgram reviewProgram) {
        this.id = reviewProgram.getId();
        this.name = reviewProgram.getName();
        this.type = reviewProgram.getType();
        this.creationTime = reviewProgram.getCreationTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
