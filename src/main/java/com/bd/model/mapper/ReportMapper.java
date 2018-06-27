package com.bd.model.mapper;

import com.bd.model.Report;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
            "`type`, isdel)",
            "values (#{oid,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
            "#{projectid,jdbcType=VARCHAR}, #{rangeid,jdbcType=VARCHAR}, ",
            "#{content,jdbcType=VARCHAR}, #{progress,jdbcType=VARCHAR}, ",
            "#{startTime,jdbcType=DATE}, #{endTime,jdbcType=DATE}, #{oitime,jdbcType=TIMESTAMP}, ",
            "#{type,jdbcType=CHAR}, #{isdel,jdbcType=CHAR})"
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
}