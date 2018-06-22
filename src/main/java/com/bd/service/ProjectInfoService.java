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
     * @param id
     * @return
     */
    public ProjectInfo selectById(int id);

    /**
     * 添加一个项目
     *
     * @param projectInfo
     * @return
     */
    public boolean insert(ProjectInfo projectInfo);

    /**
     * 更新一个系统用户
     *
     * @param user
     * @return
     */
    public boolean update(ProjectInfo user);

    /**
     * 删除指定id的系统用户
     *
     * @param id
     * @return
     */
    public boolean delete(int id);
}


