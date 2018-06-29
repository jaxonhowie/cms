package com.bd.service;

import com.bd.model.Report;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/27
 */
public interface ReportService {


    /**
     * 获取所有
     *
     * @param page
     * @param pageSize
     * @param query
     * @return
     */
    public List<Report> select(int page, int pageSize, String query);


    /**
     * 查询数据总数
     *
     * @return
     */
    public int selectCount(int query);

    /**
     * 根据id查询
     *
     * @param oid
     * @return
     */
    public Report selectById(String oid);

    /**
     * 添加
     *
     * @param report
     * @return
     */
    public int insert(Report report);

    /**
     * 更新
     *
     * @param report
     * @return
     */
    public boolean update(Report report);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<Report> selectReportInfo(int page, int pageSize,int userid);
}
