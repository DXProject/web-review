package com.review.www.entity;

import java.util.Date;

public class Project {
    private String id;

    private String classThreeId;

    private String reviewProgramId;

    private String userId;

    private String subjectCategory;

    private String disciplineCategory;

    private String name;

    private Byte status;

    private String topicBase;

    private String research;

    private String funds;

    private String file;

    private Boolean isDeleted;

    private String creator;

    private Date creationTime;

    private String backupOne;

    private String backupTwo;

    private String backupThree;

    private String backupFour;

    private String backupFive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassThreeId() {
        return classThreeId;
    }

    public void setClassThreeId(String classThreeId) {
        this.classThreeId = classThreeId == null ? null : classThreeId.trim();
    }

    public String getReviewProgramId() {
        return reviewProgramId;
    }

    public void setReviewProgramId(String reviewProgramId) {
        this.reviewProgramId = reviewProgramId == null ? null : reviewProgramId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory == null ? null : subjectCategory.trim();
    }

    public String getDisciplineCategory() {
        return disciplineCategory;
    }

    public void setDisciplineCategory(String disciplineCategory) {
        this.disciplineCategory = disciplineCategory == null ? null : disciplineCategory.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTopicBase() {
        return topicBase;
    }

    public void setTopicBase(String topicBase) {
        this.topicBase = topicBase == null ? null : topicBase.trim();
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research == null ? null : research.trim();
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds == null ? null : funds.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getBackupOne() {
        return backupOne;
    }

    public void setBackupOne(String backupOne) {
        this.backupOne = backupOne == null ? null : backupOne.trim();
    }

    public String getBackupTwo() {
        return backupTwo;
    }

    public void setBackupTwo(String backupTwo) {
        this.backupTwo = backupTwo == null ? null : backupTwo.trim();
    }

    public String getBackupThree() {
        return backupThree;
    }

    public void setBackupThree(String backupThree) {
        this.backupThree = backupThree == null ? null : backupThree.trim();
    }

    public String getBackupFour() {
        return backupFour;
    }

    public void setBackupFour(String backupFour) {
        this.backupFour = backupFour == null ? null : backupFour.trim();
    }

    public String getBackupFive() {
        return backupFive;
    }

    public void setBackupFive(String backupFive) {
        this.backupFive = backupFive == null ? null : backupFive.trim();
    }
}