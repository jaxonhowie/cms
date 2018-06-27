package com.bd.service.impl;

import com.bd.model.TimeRange;
import com.bd.service.TimeRangeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/27
 */
@Service
public class TimeRangeServiceImpl implements TimeRangeService {
    @Override
    public List<TimeRange> select(int page, int pageSize, String query) {
        return null;
    }

    @Override
    public int selectCount(String query) {
        return 0;
    }

    @Override
    public TimeRange selectById(String oid) {
        return null;
    }

    @Override
    public int insert(TimeRange timeRange) {
        return 0;
    }

    @Override
    public boolean update(TimeRange timeRange) {
        return false;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
