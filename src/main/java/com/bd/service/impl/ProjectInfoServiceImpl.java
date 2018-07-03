package com.bd.service.impl;

import com.bd.model.ProjectInfo;
import com.bd.model.mapper.ProjectInfoMapper;
import com.bd.service.ProjectInfoService;
import com.bd.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/22
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    ProjectInfoMapper projectInfoMapper;


    @Override
    public List<ProjectInfo> select(int page, int pageSize, String query) {
        return projectInfoMapper.selectByPage((page - 1) * pageSize, pageSize);
    }

    @Override
    public int selectCount(String query) {
        return projectInfoMapper.selectCount(query);
    }

    @Override
    public ProjectInfo selectById(String oid) {
        return projectInfoMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int insert(ProjectInfo projectInfo) {
        projectInfo.setOid(StringUtils.getUUID());
        return projectInfoMapper.insert(projectInfo);
    }

    @Override
    public int update(ProjectInfo projectInfo) {
        return projectInfoMapper.updateByPrimaryKey(projectInfo);
    }

    @Override
    public int delete(String id) {
        return projectInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProjectInfo> selectAll() {
        return projectInfoMapper.selectAll();
    }
}
