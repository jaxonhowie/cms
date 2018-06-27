package com.bd.controller;

import com.bd.service.ReportService;
import com.bd.service.TimeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping("/index")
    private String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
                         @RequestParam(defaultValue = "") String query, ModelMap map) {

        return "/report/index";
    }

}
