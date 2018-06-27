package com.bd.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ProjectInfo implements Serializable {
    @Id
    private String oid;

    private String name;

    private String abbrName;

    private String projectDesc;

    private String status;

    private Date oitime;

    private Date outime;

    private String isdel;

    private static final long serialVersionUID = 1L;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName == null ? null : abbrName.trim();
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getOitime() {
        return oitime;
    }

    public void setOitime(Date oitime) {
        this.oitime = oitime;
    }

    public Date getOutime() {
        return outime;
    }

    public void setOutime(Date outime) {
        this.outime = outime;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "oid='" + oid + '\'' +
                ", name='" + name + '\'' +
                ", abbrName='" + abbrName + '\'' +
                ", projectDesc='" + projectDesc + '\'' +
                ", status='" + status + '\'' +
                ", oitime=" + oitime +
                ", outime=" + outime +
                ", isdel='" + isdel + '\'' +
                '}';
    }
}