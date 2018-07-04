package com.bd.controller;

import com.bd.common.Constants;
import com.bd.model.AdminUser;
import com.bd.model.ProjectInfo;
import com.bd.model.Report;
import com.bd.model.WebResult;
import com.bd.service.ProjectInfoService;
import com.bd.service.ReportService;
import com.bd.service.TimeRangeService;
import com.bd.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author NiuJian
 * @date 2018/6/27
 */

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private TimeRangeService timeRangeService;

    @Autowired
    private ProjectInfoService projectInfoService;

    private Logger logger = LoggerFactory.getLogger(ReportController.class);


    /**
     * 当前用户周报列表
     *
     * @param page
     * @param pageSize
     * @param query
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/index")
    private String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                         @RequestParam(defaultValue = "") String query, ModelMap map, HttpSession session) {

        AdminUser loginUser = (AdminUser) session.getAttribute("loginUser");
        List<Report> reports = reportService.selectReportInfo(page, pageSize, loginUser.getId());

        map.put("reports", reports);
        int count = reportService.selectCount(loginUser.getId());
        map.put("count", count);
        map.put("maxPage", count / 10);
        map.put("page", page);
        map.put("pageSize", pageSize);
        map.put("query", query);
        map.put("nowBegin", pageSize * (page - 1) + 1);
        map.put("nowEnd", pageSize * (page - 1) + reports.size());

        List<Report> reportAll = reportService.selectReportByManager(Constants.SDF.format(DateUtil.getThisWeekMonday(new Date())));
        genReportTxt(reportAll);
        return "/report/index";
    }

    /**
     * 测试
     */
    private void genReportTxt(List<Report> reports) {

//        String result = "【%s】%s （%s） 实际进度：%s %  负责人：%s ";


        List<String> reportText=new ArrayList<String>();
        String str = null;
        for (Report report : reports) {
            if (StringUtils.equals(report.getType(), "0")) {
                str = Constants.REPORT_CONTENT_THIS_WEEK.replaceAll("%PROJECT%", report.getProjectname());
                str = str.replaceAll("%CONTENT%", report.getContent());
                str = str.replaceAll("%RANGE%", report.getRangeid());
                str = str.replaceAll("%PROGRESS%", report.getProgress());
                str = str.replaceAll("%LOGINNAME%", report.getLoginname());
            } else {
                str = Constants.REPORT_CONTENT_NEXT_WEEK.replaceAll("%PROJECT%", report.getProjectname());
                str = str.replaceAll("%CONTENT%", report.getContent());
                str = str.replaceAll("%RANGE%", report.getRangeid());
                str = str.replaceAll("%PROGRESS%", report.getProgress());
                str = str.replaceAll("%LOGINNAME%", report.getLoginname());
            }
            reportText.add(str);
//            System.out.println(String.format(result,report.getProjectname(),report.getContent(), report.getRangeid(), report.getProgress(), report.getLoginname()));
//            logger.info("RESULT:" + str);
            System.out.println(str);
        }

    }

    /**
     * 打开编辑页面
     *
     * @param map
     * @param reportId
     * @return
     */
    @RequestMapping("/edit")
    private String edit(ModelMap map, @RequestParam(defaultValue = "") String reportId) {

        List<ProjectInfo> projectInfos = projectInfoService.selectAll();
        Report report = reportService.selectById(reportId);
        map.put("report", report);
        map.put("projects", projectInfos);

        return "/report/edit";
    }


    /**
     * 打开新增页面
     *
     * @param map
     * @param ReportId
     * @return
     */
    @RequestMapping("/addReport")
    private String addReport(ModelMap map, @RequestParam(defaultValue = "") String ReportId) {

        List<ProjectInfo> projectInfos = projectInfoService.selectAll();
        map.put("projects", projectInfos);

        return "/report/add";
    }


    @RequestMapping("/editReport")
    @ResponseBody
    private WebResult editReport(Report report, HttpSession session) {

        report.setIsdel("0");
        if (StringUtils.isEmpty(report.getOid())) {
            return WebResult.needParams("缺少ID参数");
        }

        if (reportService.update(report)) {
            return WebResult.success();
        } else {
            return WebResult.unKnown();
        }
    }


    @RequestMapping("/add")
    @ResponseBody
    private WebResult add(Report report, HttpSession session) {
        AdminUser loginUser = (AdminUser) session.getAttribute("loginUser");


        report.setUserid(loginUser.getId() + "");
        if (reportService.insert(report) > Constants.DB_SUCCESS_FLAG) {
            return WebResult.success();
        } else {
            return WebResult.unKnown();
        }
    }


    @RequestMapping("/del")
    @ResponseBody
    private WebResult del(@RequestParam(defaultValue = "") String oid) {
        if (reportService.delete(oid) > Constants.DB_SUCCESS_FLAG) {
            return WebResult.success();
        } else {
            return WebResult.unKnown();
        }
    }


}
