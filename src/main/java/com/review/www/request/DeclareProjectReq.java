package com.review.www.request;

import com.jopool.jweb.utils.UUIDUtils;
import com.review.www.entity.Project;

import java.util.Date;

/**
 * Created by zhangtianfeng on 16/5/6.
 */
public class DeclareProjectReq {
    private String classThree;
    private String reviewProgram;
    private String subjectCategory;
    private String disciplineCategory;
    private String name;//项目名称
    private String topicBase;//选题依据
    private String research;//研究内容
    private String funds;//经费

    public Project parseProject(String userId) {
        Project project = new Project();
        project.setId(UUIDUtils.createId());
        project.setClassThreeId(this.classThree);
        project.setReviewProgramId(this.reviewProgram);
        project.setUserId(userId);
        project.setSubjectCategory(this.subjectCategory);
        project.setDisciplineCategory(this.disciplineCategory);
        project.setName(this.name);
        project.setTopicBase(this.topicBase);
        project.setResearch(this.research);
        project.setFunds(this.funds);
        project.setIsDeleted(false);
        project.setCreationTime(new Date());
        project.setCreator(userId);
        return project;
    }

    public String getClassThree() {
        return classThree;
    }

    public void setClassThree(String classThree) {
        this.classThree = classThree;
    }

    public String getReviewProgram() {
        return reviewProgram;
    }

    public void setReviewProgram(String reviewProgram) {
        this.reviewProgram = reviewProgram;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getDisciplineCategory() {
        return disciplineCategory;
    }

    public void setDisciplineCategory(String disciplineCategory) {
        this.disciplineCategory = disciplineCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopicBase() {
        return topicBase;
    }

    public void setTopicBase(String topicBase) {
        this.topicBase = topicBase;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }
}
