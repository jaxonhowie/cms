package com.bd.controller;

import com.bd.common.Constants;
import com.bd.model.AdminUser;
import com.bd.model.Report;
import com.bd.model.WebResult;
import com.bd.service.ReportService;
import com.bd.service.TimeRangeService;
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
import java.util.List;

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

    private Logger logger = LoggerFactory.getLogger(ReportController.class);


    @RequestMapping("/index")
    private String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                         @RequestParam(defaultValue = "") String query, ModelMap map, HttpSession session) {

        AdminUser loginUser = (AdminUser) session.getAttribute("loginUser");
        List<Report> reports = reportService.selectReportInfo(page, pageSize, loginUser.getId());

        genReportTxt(reports);

        map.put("reports", reports);
        int count = reportService.selectCount(loginUser.getId());
        map.put("count", count);
        map.put("maxPage", count / 10);
        map.put("page", page);
        map.put("pageSize", pageSize);
        map.put("query", query);
        map.put("nowBegin", pageSize * (page - 1) + 1);
        map.put("nowEnd", pageSize * (page - 1) + reports.size());

        return "/report/index";
    }

    /**
     * 测试
     */
    private void genReportTxt(List<Report> reports) {

//        String result = "【%s】%s （%s） 实际进度：%s %  负责人：%s ";

        String str = null;
        for (Report report : reports) {
            str = Constants.REPORT_CONTENT.replaceAll("%PROJECT%", report.getProjectname());
            str = str.replaceAll("%CONTENT%", report.getContent());
            str = str.replaceAll("%RANGE%", report.getRangeid());
            str = str.replaceAll("%PROGRESS%", report.getProgress());
            str = str.replaceAll("%LOGINNAME%", report.getLoginname());

//            System.out.println(String.format(result,report.getProjectname(),report.getContent(), report.getRangeid(), report.getProgress(), report.getLoginname()));
            logger.info("RESULT:" + str);
        }

    }


    @RequestMapping("/edit")
    private String edit(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                        @RequestParam(defaultValue = "") String query, ModelMap map) {

        return "/report/add";
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
