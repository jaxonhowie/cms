package com.bd.controller;

import com.bd.model.ProjectInfo;
import com.bd.model.WebResult;
import com.bd.service.ProjectInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author NiuJian
 * @date 2018/6/22
 */

@Controller
@RequestMapping("project")
public class ProjectController {

    private Logger logger = LoggerFactory.getLogger(ProjectInfo.class);

    @Autowired
    private ProjectInfoService projectService;

    /**
     * 分页查询用户查询
     *
     * @param page
     * @param pageSize
     * @param query
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                        @RequestParam(defaultValue = "") String query, ModelMap map) {
        List<ProjectInfo> projectinfos = projectService.select(page, pageSize, query);
        map.put("projectinfos", projectinfos);
        int count = projectService.selectCount(query);
        map.put("count", count);
        map.put("maxPage", count / 10);
        map.put("page", page);
        map.put("pageSize", pageSize);
        map.put("query", query);
        map.put("nowBegin", pageSize * (page - 1) + 1);
        map.put("nowEnd", pageSize * (page - 1) + projectinfos.size());
        return "project/index";
    }


    /**
     * 打开编辑用户页面
     *
     * @param oid
     * @param map
     * @return
     */
    @RequestMapping("/edit")
    public String editProjectInfo(@RequestParam(defaultValue = "") String oid, ModelMap map) {
        if (StringUtils.isNotEmpty(oid)) {
            map.put("projectinfo", projectService.selectById(oid));
        }
        return "project/edit";
    }


    /**
     * 新增项目信息
     *
     * @param projectInfo
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public WebResult addProject(ProjectInfo projectInfo) {

        logger.info("参数：" + projectInfo.toString());

        if (projectInfo == null) {
            return WebResult.unKnown();
        }

        if (projectService.insert(projectInfo) > 0) {
            logger.info("新增项目信息：" + projectInfo.toString());
            return WebResult.success();
        } else {
            return WebResult.unKnown();
        }

    }

    /**
     * 删除项目
     *
     * @param oid
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public WebResult delProject(String oid) {

        if (StringUtils.isEmpty(oid)) {
            return WebResult.needParams("oid");
        }

        if (projectService.delete(oid) > 0) {
            return WebResult.success();
        } else {
            return WebResult.unKnown();
        }


    }
}
