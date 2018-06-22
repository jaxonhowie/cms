package com.bd.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class ProjectInfo {
    @Id
    private String oid;

    private String name;

    private String abbrName;

    private String projectDesc;

    private String status;

    private Date oitime;

    private Date outime;

    private String isdel;


}