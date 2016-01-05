package com.review.www.entity;

public class Project {
    private String id;

    private String name;

    private String file;

    private String backupOne;

    private String backupTwo;

    private String backupThree;

    private String backupFour;

    private String backupFive;

    private String classThreeId;

    private String userId;

    private String subjectcategoryId;

    private String disciplinecategoryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
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

    public String getClassThreeId() {
        return classThreeId;
    }

    public void setClassThreeId(String classThreeId) {
        this.classThreeId = classThreeId == null ? null : classThreeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSubjectcategoryId() {
        return subjectcategoryId;
    }

    public void setSubjectcategoryId(String subjectcategoryId) {
        this.subjectcategoryId = subjectcategoryId == null ? null : subjectcategoryId.trim();
    }

    public String getDisciplinecategoryId() {
        return disciplinecategoryId;
    }

    public void setDisciplinecategoryId(String disciplinecategoryId) {
        this.disciplinecategoryId = disciplinecategoryId == null ? null : disciplinecategoryId.trim();
    }
}