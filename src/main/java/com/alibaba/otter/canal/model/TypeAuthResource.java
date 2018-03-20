package com.alibaba.otter.canal.model;

import java.util.Date;

/**
 * Created by SoleGlory on 2018/3/3.
 */
public class TypeAuthResource extends BaseIndex {

    private String typeId;
    private String name;
    private String typeLevel;
    private String pid;
    private String delFlag;

    private String arId;
    private Date arAuthBeginTime;		// 授权有效开始日期
    private Date arAuthEndTime;		// 授权有效结束日期
    private Integer arResourceType;
    private String arResourceId;
    private String arProductId;
    private String arOfficeId;
    private Integer arStatus;
    private String arDelFlag;

    public TypeAuthResource(){}

    public TypeAuthResource(String typeId, String name, String typeLevel, String pid, String delFlag, String arId, Date arAuthBeginTime, Date arAuthEndTime, Integer arResourceType, String arResourceId, String arProductId, String arOfficeId, Integer arStatus, String arDelFlag) {
        this.typeId = typeId;
        this.name = name;
        this.typeLevel = typeLevel;
        this.pid = pid;
        this.delFlag = delFlag;
        this.arId = arId;
        this.arAuthBeginTime = arAuthBeginTime;
        this.arAuthEndTime = arAuthEndTime;
        this.arResourceType = arResourceType;
        this.arResourceId = arResourceId;
        this.arProductId = arProductId;
        this.arOfficeId = arOfficeId;
        this.arStatus = arStatus;
        this.arDelFlag = arDelFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(String typeLevel) {
        this.typeLevel = typeLevel;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

}
