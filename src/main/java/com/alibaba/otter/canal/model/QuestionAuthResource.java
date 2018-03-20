package com.alibaba.otter.canal.model;

import java.util.Date;

/**
 * Created by SoleGlory on 2018/3/3.
 */
public class QuestionAuthResource extends BaseIndex {

    private String quesId;
    private String name;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;
    private String choice6;
    private String choice7;
    private String choice8;
    private String ptypeids;
    private String typeids;
    private String type;
    private String answer;
    private String degree;
    private String questionSyllabusIds;
    private Integer isGroup;
    private String pid;
    private String practice;
    private String typeId;
    private String modelId;
    private String requirement;
    private Double inuseDifficulty;
    private Double forecastDifficulty;
    private Integer status;
    private Integer isUse;
    private String delFlag;
    private String subjectId;
    private String questionkinds;

    private String arId;
    private Date arAuthBeginTime;		// 授权有效开始日期
    private Date arAuthEndTime;		// 授权有效结束日期
    private Integer arResourceType;
    private String arResourceId;
    private String arProductId;
    private String arOfficeId;
    private Integer arStatus;
    private String arDelFlag;
    private String arQuestionkinds;

    public QuestionAuthResource(){}

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getQuestionkinds() {
        return questionkinds;
    }

    public void setQuestionkinds(String questionkinds) {
        this.questionkinds = questionkinds;
    }

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public Date getArAuthBeginTime() {
        return arAuthBeginTime;
    }

    public void setArAuthBeginTime(Date arAuthBeginTime) {
        this.arAuthBeginTime = arAuthBeginTime;
    }

    public Date getArAuthEndTime() {
        return arAuthEndTime;
    }

    public void setArAuthEndTime(Date arAuthEndTime) {
        this.arAuthEndTime = arAuthEndTime;
    }

    public Integer getArResourceType() {
        return arResourceType;
    }

    public void setArResourceType(Integer arResourceType) {
        this.arResourceType = arResourceType;
    }

    public String getArResourceId() {
        return arResourceId;
    }

    public void setArResourceId(String arResourceId) {
        this.arResourceId = arResourceId;
    }

    public String getArProductId() {
        return arProductId;
    }

    public void setArProductId(String arProductId) {
        this.arProductId = arProductId;
    }

    public String getArOfficeId() {
        return arOfficeId;
    }

    public void setArOfficeId(String arOfficeId) {
        this.arOfficeId = arOfficeId;
    }

    public Integer getArStatus() {
        return arStatus;
    }

    public void setArStatus(Integer arStatus) {
        this.arStatus = arStatus;
    }

    public String getArDelFlag() {
        return arDelFlag;
    }

    public void setArDelFlag(String arDelFlag) {
        this.arDelFlag = arDelFlag;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getChoice5() {
        return choice5;
    }

    public void setChoice5(String choice5) {
        this.choice5 = choice5;
    }

    public String getChoice6() {
        return choice6;
    }

    public void setChoice6(String choice6) {
        this.choice6 = choice6;
    }

    public String getChoice7() {
        return choice7;
    }

    public void setChoice7(String choice7) {
        this.choice7 = choice7;
    }

    public String getChoice8() {
        return choice8;
    }

    public void setChoice8(String choice8) {
        this.choice8 = choice8;
    }

    public String getPtypeids() {
        return ptypeids;
    }

    public void setPtypeids(String ptypeids) {
        this.ptypeids = ptypeids;
    }

    public String getTypeids() {
        return typeids;
    }

    public void setTypeids(String typeids) {
        this.typeids = typeids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getQuestionSyllabusIds() {
        return questionSyllabusIds;
    }

    public void setQuestionSyllabusIds(String questionSyllabusIds) {
        this.questionSyllabusIds = questionSyllabusIds;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Double getInuseDifficulty() {
        return inuseDifficulty;
    }

    public void setInuseDifficulty(Double inuseDifficulty) {
        this.inuseDifficulty = inuseDifficulty;
    }

    public Double getForecastDifficulty() {
        return forecastDifficulty;
    }

    public void setForecastDifficulty(Double forecastDifficulty) {
        this.forecastDifficulty = forecastDifficulty;
    }

    public String getArQuestionkinds() {
        return arQuestionkinds;
    }

    public void setArQuestionkinds(String arQuestionkinds) {
        this.arQuestionkinds = arQuestionkinds;
    }
}
