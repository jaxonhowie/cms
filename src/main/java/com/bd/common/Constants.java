package com.bd.common;

import java.text.SimpleDateFormat;

/**
 * @author NiuJian
 * @date 2018/6/21
 */
public class Constants {

    /**
     * 默认字段，有权限
     */
    public static final String ROLE_FLAG_TRUE = "1";

    /**
     * 没有权限
     */
    public static final String ROLE_FLAG_FALSE = "0";

    /**
     * 数据库成功标识
     */
    public static final int DB_SUCCESS_FLAG = 0;

    /**
     * 本周报展示内容
     */
    public static final String REPORT_CONTENT_THIS_WEEK = "【%PROJECT%】%CONTENT% （%RANGE%） 实际进度：%PROGRESS% 负责人：%LOGINNAME% ";

    /**
     * 下周报展示内容
     */
    public static final String REPORT_CONTENT_NEXT_WEEK = "【%PROJECT%】%CONTENT% （%RANGE%） 预计进度：%PROGRESS% 负责人：%LOGINNAME% ";

    /**
     * 获取周一时间格式化
     */
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
}
