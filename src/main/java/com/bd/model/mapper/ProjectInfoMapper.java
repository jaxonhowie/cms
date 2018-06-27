package com.bd.model.mapper;

import com.bd.model.ProjectInfo;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Administrator
 */
public interface ProjectInfoMapper {

    /**
     * 根据ID删除
     *
     * @param oid
     * @return
     */
    @Delete({
            "update  project_info set isdel =1 ",
            "where oid = #{oid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String oid);

    @Insert({
            "insert into project_info (oid, `name`, ",
            "abbr_name, project_desc, ",
            "`status`, oitime, outime, ",
            "isdel)",
            "values (#{oid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{abbrName,jdbcType=VARCHAR}, #{projectDesc,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=CHAR}, #{oitime,jdbcType=TIMESTAMP}, #{outime,jdbcType=TIMESTAMP}, ",
            "#{isdel,jdbcType=CHAR})"
    })
    int insert(ProjectInfo record);

    @Select({
            "select",
            "oid, `name`, abbr_name, project_desc, `status`, oitime, outime, isdel",
            "from project_info",
            "where oid = #{oid,jdbcType=VARCHAR} "
    })
    @Results({
            @Result(column = "oid", property = "oid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "abbr_name", property = "abbrName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_desc", property = "projectDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "oitime", property = "oitime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "outime", property = "outime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "isdel", property = "isdel", jdbcType = JdbcType.CHAR)
    })
    ProjectInfo selectByPrimaryKey(String oid);

    /**
     * 分页查询所有项目信息
     *
     * @param begin
     * @param pageSize
     * @return
     */
    @Select({
            "select",
            "oid, `name`, abbr_name, project_desc, `status`, oitime, outime, isdel",
            "from project_info  where isdel = 0 LIMIT #{begin},#{pagesize}"
    })
    @Results({
            @Result(column = "oid", property = "oid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "abbr_name", property = "abbrName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_desc", property = "projectDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "oitime", property = "oitime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "outime", property = "outime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "isdel", property = "isdel", jdbcType = JdbcType.CHAR)
    })
    List<ProjectInfo> selectAll(@Param("begin") int begin, @Param("pagesize") int pageSize);

    @Update({
            "update project_info",
            "set `name` = #{name,jdbcType=VARCHAR},",
            "abbr_name = #{abbrName,jdbcType=VARCHAR},",
            "project_desc = #{projectDesc,jdbcType=VARCHAR},",
            "`status` = #{status,jdbcType=CHAR},",
            "oitime = #{oitime,jdbcType=TIMESTAMP},",
            "outime = #{outime,jdbcType=TIMESTAMP},",
            "isdel = #{isdel,jdbcType=CHAR}",
            "where oid = #{oid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ProjectInfo record);

    /**
     * 获取总数
     *
     * @param name
     * @return
     */
    @Select({"SELECT COUNT(1) FROM project_info"})
    int selectCount(String name);

}