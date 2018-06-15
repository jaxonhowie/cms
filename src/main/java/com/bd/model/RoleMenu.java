package com.bd.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;


/**
 * @author NiuJian
 * @date 2018/6/15
 */

/**
 * 角色和菜单关联
 * Create by Raye on 2018年3月1日21:13:41
 */
@Data
public class RoleMenu {
    @Id
    private Integer menuid;
    @Id
    private Integer roleid;

    private Integer flag;

    private Integer creator;

    private Date createtime;


}