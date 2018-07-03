<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>周报信息</title>

    <meta name="description" content="Static &amp; Dynamic Tables"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<#--<link rel="stylesheet" href="/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>-->
    <link rel="stylesheet" href="/assets/font-awesome-4.7.0/css/font-awesome.min.css">
<#--<link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>-->

    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="/assets/css/jquery-ui-1.10.3.custom.min.css"/>
    <link rel="stylesheet" href="/assets/css/chosen.css"/>
    <link rel="stylesheet" href="/assets/css/datepicker.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap-timepicker.css"/>
    <link rel="stylesheet" href="/assets/css/daterangepicker.css"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>
    <!-- ace styles -->
<#--<link rel="stylesheet" href="/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style"/>-->
    <link rel="stylesheet" href="/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>


    <!-- ace settings handler -->
    <script src="/assets/js/ace-extra.min.js"></script>


    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="/assets/js/html5shiv.min.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">


<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>


    <div class="page-content">

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('main-container')
                } catch (e) {
                }
            </script>


            <div class="page-content">
                <div class="col-sm-5 widget-box widget-color-blue2">
                    <div class="widget-header">
                        <h4 class="widget-title lighter smaller">填写周报</h4>
                    </div>
                    <form class="form-horizontal" id="reportform" name="reportform" role="form"
                          style="margin-top: 20px;">
                    <#--<input type="hidden" name="id" id="id" value="${(role.id)!}" />-->

                        <div class="form-group">
                            <label class=" col-sm-3 control-label no-padding-right"> 时间范围 </label>
                            <div class="col-sm-9">
                                <div class="input-group col-xs-10 col-sm-8">
                                    <span class="input-group-addon">
                                        <i class="fa fa-calendar bigger-110"></i>
                                    </span>
                                    <input class="form-control" type="text" name="date-range-picker"
                                           id="rangeid"/>
                                </div>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class=" col-sm-3 control-label no-padding-right"> 相关项目 </label>
                            <div class="col-sm-9">
                                <select name="parentId" class="col-xs-10 col-sm-5" id="projectid">
                                    <option value="" selected="selected">---请选择---</option>
                                <#list projects as item>
                                    <option value="${item.oid}">
                                    ${item.name}
                                    </option>
                                </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class=" col-sm-3 control-label no-padding-right"> 类型 </label>
                            <div class="col-sm-9">
                                <select class="col-xs-10 col-sm-5" id="type">
                                    <option value="">&nbsp;</option>
                                    <option value="0">本周周报</option>
                                    <option value="1">下周周报</option>
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 进度 </label>
                            <div class="col-sm-9">
                                <input type="text" id="progress" name="progress" placeholder="实际进度（百分比）"
                                       class="col-xs-10 col-sm-5">
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 工作内容 </label>
                            <div class="col-sm-9">
                                <input type="text" id="content1" name="content1" placeholder=" 工作内容"
                                       class="col-md-9 ">
                            </div>

                        </div>

                        <button class="btn btn-info " type="button" style="margin-left: 20px; margin-bottom:20px;"
                                onclick="add()">
                            <i class="ace-icon fa fa-check bigger-110"></i>
                            保存
                        </button>

                    </form>
                </div>

            </div><!-- /.page-content -->


        </div><!-- /.main-container -->
        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="/assets/js/jquery-2.1.4.min.js"></script>

        <!-- <![endif]-->

        <!--[if IE]>
        <script src="/assets/js/jquery-1.11.3.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>
        <script src="/assets/js/bootstrap.min.js"></script>

        <!-- page specific plugin scripts -->

        <script src="/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
        <script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
        <script src="/assets/js/chosen.jquery.min.js"></script>
        <script src="/assets/js/fuelux/fuelux.spinner.min.js"></script>
        <script src="/assets/js/date-time/bootstrap-datepicker.min.js"></script>
        <script src="/assets/js/date-time/bootstrap-timepicker.min.js"></script>
        <script src="/assets/js/date-time/moment.min.js"></script>
        <script src="/assets/js/date-time/daterangepicker.min.js"></script>
        <script src="/assets/js/bootstrap-colorpicker.min.js"></script>
        <script src="/assets/js/jquery.knob.min.js"></script>
        <script src="/assets/js/jquery.autosize.min.js"></script>
        <script src="/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
        <script src="/assets/js/jquery.maskedinput.min.js"></script>
        <script src="/assets/js/bootstrap-tag.min.js"></script>

        <!-- validate -->
        <script src="/assets/js/jquery.validate.min.js"></script>

        <!-- ace scripts -->
        <script src="/assets/js/ace-elements.min.js"></script>
        <script src="/assets/js/ace.min.js"></script>
        <script src="/assets/js/page.js"></script>

        <script src="/assets/js/bootbox.js"></script>
        <script src="/assets/js/utils.js"></script>
        <!-- inline scripts related to this page -->
        <script type="text/javascript">


            $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
                $(this).prev().focus();
            });

            $('input[name=date-range-picker]').daterangepicker(
                    {
                        locale: {
                            applyLabel: '确认',
                            cancelLabel: '取消',
                            fromLabel: '起始时间',
                            toLabel: '结束时间',
                            customRangeLabel: '自定义',
                            firstDay: 1
                        },
                        format: 'YYYY/MM/DD'
                    }
            ).prev().on(ace.click_event, function () {
                $(this).next().focus();
            });


            function isNo(str) {
                var reg = /\D/;
                return reg.test(str.val());
                /*进行验证*/
            }


            function add() {
                if (!vali($("#rangeid"))) {
                    alert("时间范围不能为空");
                    return;
                }
                if (!vali($("#projectid"))) {
                    alert("相关项目不能为空");
                    return;
                }
                if (!vali($("#type"))) {
                    alert("周报类型不能为空");
                    return;
                }
                if (!vali($("#progress"))) {
                    alert("时间进度不能为空");
                    return;
                }
                if (isNo($("#progress"))) {
                    alert("时间进度必须是0-100的数字");
                    return;
                }
                if (!vali($("#content1"))) {
                    alert("工作内容不能为空");
                    return;
                }
                quickAjax({
                    url: '/report/add',
                    method: "POST",
                    data: {
                        userid: $("#userid").val(),
                        rangeid: $("#rangeid").val(),
                        projectid: $("#projectid").val(),
                        type: $("#type").val(),
                        content: $("#content1").val(),
                        progress: $("#progress").val()
                    },
                    success: function (response) {
                        if (response.code == 1) {
                            alert("添加成功", function () {
                                self.location = document.referrer;
                            });
                        }
                    },
                    error: function (response) {
                        alert("链接服务器失败");
                    }
                });
            }

        </script>
</body>
</html>
