package com.bd.dao.mapper;

import com.bd.model.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;


public interface RoleMenuMapper extends Mapper<RoleMenu> {

    @Delete({
            "delete from role_menu",
            "where roleid = #{roleid}"
    })
    int deleteByRoleid(String roleid);


}