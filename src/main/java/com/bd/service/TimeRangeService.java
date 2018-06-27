package com.bd.service;

import com.bd.model.TimeRange;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/27
 */
public interface TimeRangeService {


    /**
     * 获取所有
     *
     * @param page
     * @param pageSize
     * @param query
     * @return
     */
    public List<TimeRange> select(int page, int pageSize, String query);


    /**
     * 查询数据总数
     *
     * @return
     */
    public int selectCount(String query);

    /**
     * 根据id查询
     *
     * @param oid
     * @return
     */
    public TimeRange selectById(String oid);

    /**
     * 添加
     *
     * @param timeRange
     * @return
     */
    public int insert(TimeRange timeRange);

    /**
     * 更新
     *
     * @param timeRange
     * @return
     */
    public boolean update(TimeRange timeRange);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(String id);
}
