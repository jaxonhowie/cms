package com.bd.service.impl;

import com.bd.model.ProjectInfo;
import com.bd.service.ProjectInfoService;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/22
 */
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Override
    public List<ProjectInfo> select(int page, int pageSize, String query) {
        return null;
    }

    @Override
    public int selectCount(String query) {
        return 0;
    }

    @Override
    public ProjectInfo selectById(int id) {
        return null;
    }

    @Override
    public boolean insert(ProjectInfo projectInfo) {
        return false;
    }

    @Override
    public boolean update(ProjectInfo user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
