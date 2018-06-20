package com.bd.model;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

/**
 * 系统角色
 * @author Administrator
 */
@Data
public class Role {
    private Integer id;


    @Transient    private String name;

    private Date createtime;

    private Integer creator;

    private String description;

    private Integer updateuser;

    private Date updatetime;
    @Transient
    private int userid;
    private String createuser;
}