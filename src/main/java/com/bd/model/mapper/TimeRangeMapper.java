package com.bd.model.mapper;

import com.bd.model.TimeRange;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Administrator
 */
public interface TimeRangeMapper {
    @Insert({
            "insert into time_range (oid, content, ",
            "isdel, oitime)",
            "values (#{oid,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
            "#{isdel,jdbcType=CHAR}, #{oitime,jdbcType=TIMESTAMP})"
    })
    int insert(TimeRange record);

    @Select({
            "select",
            "oid, content, isdel, oitime",
            "from time_range"
    })
    @Results({
            @Result(column = "oid", property = "oid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "isdel", property = "isdel", jdbcType = JdbcType.CHAR),
            @Result(column = "oitime", property = "oitime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<TimeRange> selectAll();
}