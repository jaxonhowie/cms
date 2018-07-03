package com.bd.service;

import com.bd.model.ProjectInfo;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/22
 */
public interface ProjectInfoService {


    /**
     * 获取所有
     *
     * @param page
     * @param pageSize
     * @param query
     * @return
     */
    public List<ProjectInfo> select(int page, int pageSize, String query);


    /**
     * 查询数据总数
     *
     * @return
     */
    public int selectCount(String query);

    /**
     * 根据id查询项目
     *
     * @param oid
     * @return
     */
    public ProjectInfo selectById(String oid);

    /**
     * 添加一个项目
     *
     * @param projectInfo
     * @return
     */
    public int insert(ProjectInfo projectInfo);

    /**
     * 更新一个系统用户
     *
     * @param projectInfo
     * @return
     */
    public int update(ProjectInfo projectInfo);

    /**
     * 删除指定id的系统用户
     *
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 获取所有项目信息
     * @return
     */
    public List<ProjectInfo> selectAll();
}


