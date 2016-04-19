package com.review.www.entity;

import java.util.Date;

public class ReviewProgramRules {
    private String id;

    private String reviewProgramId;

    private String rulesId;

    private String percentage;

    private String creator;

    private Date creationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReviewProgramId() {
        return reviewProgramId;
    }

    public void setReviewProgramId(String reviewProgramId) {
        this.reviewProgramId = reviewProgramId == null ? null : reviewProgramId.trim();
    }

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId == null ? null : rulesId.trim();
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage == null ? null : percentage.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}