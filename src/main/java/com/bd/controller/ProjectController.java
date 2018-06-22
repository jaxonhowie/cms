package com.bd.controller;

import com.bd.model.AdminUser;
import com.bd.model.ProjectInfo;
import com.bd.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/22
 */

@Controller
public class ProjectController {

    @Autowired
    ProjectInfoService projectService;


    @GetMapping
    public String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                        @RequestParam(defaultValue = "") String query, ModelMap map) {
        List<ProjectInfo> projectinfos = projectService.select(page, pageSize, query);
        map.put("projectinfo", projectinfos);
        int count = projectService.selectCount(query);
        map.put("count", count);
        map.put("maxPage", count / 10);
        map.put("page", page);
        map.put("pageSize", pageSize);
        map.put("query", query);
        map.put("nowBegin", pageSize * (page - 1) + 1);
        map.put("nowEnd", pageSize * (page - 1) + projectinfos.size());
        return "user/index";
    }
}
