package com.bd.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Report implements Serializable {
    private String oid;

    private String userid;

    private String projectid;

    private String rangeid;

    private String content;

    private String progress;

    private Date startTime;

    private Date endTime;

    private Date oitime;

    private String type;

    private String isdel;

    //负责人
    private String loginname;

    //项目名称
    private String projectname;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    private static final long serialVersionUID = 1L;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getRangeid() {
        return rangeid;
    }

    public void setRangeid(String rangeid) {
        this.rangeid = rangeid == null ? null : rangeid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getOitime() {
        return oitime;
    }

    public void setOitime(Date oitime) {
        this.oitime = oitime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    @Override
    public String toString() {
        return "Report{" +
                "oid='" + oid + '\'' +
                ", userid='" + userid + '\'' +
                ", projectid='" + projectid + '\'' +
                ", rangeid='" + rangeid + '\'' +
                ", content='" + content + '\'' +
                ", progress='" + progress + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", oitime=" + oitime +
                ", type='" + type + '\'' +
                ", isdel='" + isdel + '\'' +
                ", loginname='" + loginname + '\'' +
                ", projectname='" + projectname + '\'' +
                '}';
    }
}