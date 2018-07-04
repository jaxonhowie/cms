package com.bd.model.mapper;

import com.bd.model.Report;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ReportMapper {
    @Delete({
            "delete from report",
            "where oid = #{oid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String oid);

    @Insert({
            "insert into report (oid, userid, ",
            "projectid, rangeid, ",
            "content, progress, ",
            "start_time, end_time, oitime, ",
            "`type`)",
            "values (#{oid,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
            "#{projectid,jdbcType=VARCHAR}, #{rangeid,jdbcType=VARCHAR}, ",
            "#{content,jdbcType=VARCHAR}, #{progress,jdbcType=VARCHAR}, ",
            "#{startTime,jdbcType=DATE}, #{endTime,jdbcType=DATE}, #{oitime,jdbcType=TIMESTAMP}, ",
            "#{type,jdbcType=CHAR})"
    })
    int insert(Report record);

    @Select({
            "select",
            "oid, userid, projectid, rangeid, content, progress, start_time, end_time, oitime, ",
            "`type`, isdel",
            "from report",
            "where oid = #{oid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "oid", property = "oid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "projectid", property = "projectid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "rangeid", property = "rangeid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "progress", property = "progress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.DATE),
            @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.DATE),
            @Result(column = "oitime", property = "oitime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "type", property = "type", jdbcType = JdbcType.CHAR),
            @Result(column = "isdel", property = "isdel", jdbcType = JdbcType.CHAR)
    })
    Report selectByPrimaryKey(String oid);

    @Select({
            "select",
            "oid, userid, projectid, rangeid, content, progress, start_time, end_time, oitime, ",
            "`type`, isdel",
            "from report"
    })
    @Results({
            @Result(column = "oid", property = "oid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "projectid", property = "projectid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "rangeid", property = "rangeid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "progress", property = "progress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.DATE),
            @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.DATE),
            @Result(column = "oitime", property = "oitime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "type", property = "type", jdbcType = JdbcType.CHAR),
            @Result(column = "isdel", property = "isdel", jdbcType = JdbcType.CHAR)
    })
    List<Report> selectAll();


    @Select({
            "SELECT" +
                    "    a.oid ," +
                    "    b.loginname as loginname," +
                    "    c.name as projectname," +
                    "    a.content ," +
                    "    a.rangeid ," +
                    "    a.progress ," +
                    "    a.oitime ," +
                    "     a.type " +
                    "FROM" +
                    "    report a," +
                    "    admin_user b ," +
                    "    project_info c" +
                    " WHERE" +
                    "    a.userid =b.id" +
                    " AND a.projectid=c.oid  AND a.userid=#{userid} order by a.oitime desc  LIMIT #{page},#{pagesize}"
    })
    @Results({
            @Result(column = "oid", property = "oid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "loginname", property = "loginname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "projectname", property = "projectname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "rangeid", property = "rangeid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "progress", property = "progress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "oitime", property = "oitime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Report> selectReportInfo(@Param("page") int page, @Param("pagesize") int pageSize, @Param("userid") int userid);

    @Update({
            "update report",
            "set userid = #{userid,jdbcType=VARCHAR},",
            "projectid = #{projectid,jdbcType=VARCHAR},",
            "rangeid = #{rangeid,jdbcType=VARCHAR},",
            "content = #{content,jdbcType=VARCHAR},",
            "progress = #{progress,jdbcType=VARCHAR},",
            "start_time = #{startTime,jdbcType=DATE},",
            "end_time = #{endTime,jdbcType=DATE},",
            "oitime = #{oitime,jdbcType=TIMESTAMP},",
            "`type` = #{type,jdbcType=CHAR},",
            "isdel = #{isdel,jdbcType=CHAR}",
            "where oid = #{oid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Report record);

    @Select("select count(1) from report where userid=#{userid} ")
    int selectCount(@Param("userid") int userid);


    /**
     * 获取本周周报
     *
     * @param queryDate
     * @return
     */
    @Select({"SELECT " +
            "    a.oid ," +
            "    a.userid," +
            "    a.type ," +
            "    b.loginname AS loginname," +
            "    c.name      AS projectname," +
            "    a.content ," +
            "    a.rangeid ," +
            "    a.progress ," +
            "    a.oitime" +
            " FROM" +
            "    report a," +
            "    admin_user b ," +
            "    project_info c" +
            " WHERE" +
            "    a.userid =b.id" +
            " AND a.projectid=c.oid" +
            " AND a.oitime >#{queryDate}" +
            " ORDER BY " +
            "    projectname," +
            "    loginname," +
            "    a.type," +
            "    a.oitime DESC"})
    List<Report> selectReportByManager(@Param("queryDate") String queryDate);
}