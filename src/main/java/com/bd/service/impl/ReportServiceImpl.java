package com.bd.service.impl;

import com.bd.model.Report;
import com.bd.model.mapper.ReportMapper;
import com.bd.service.ReportService;
import com.bd.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/27
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportMapper reportMapper;

    @Override
    public List<Report> select(int page, int pageSize, String query) {
        return null;
    }

    @Override
    public int selectCount(int query) {
        return reportMapper.selectCount(query);
    }

    @Override
    public Report selectById(String oid) {
        return null;
    }

    @Override
    public int insert(Report report) {
        report.setOid(StringUtils.getUUID());
        return reportMapper.insert(report);
    }

    @Override
    public boolean update(Report report) {
        return false;
    }

    @Override
    public int delete(String id) {
        return reportMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Report> selectReportInfo(int page, int pageSize, int userid) {
        return reportMapper.selectReportInfo((page - 1) * pageSize, pageSize, userid);
    }


}
