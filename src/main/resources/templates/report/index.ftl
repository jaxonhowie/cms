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
    <#--<link rel="stylesheet" href="/assets/css/chosen.css"/>-->
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

        <div class="row">

            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">工作内容 </label>
                    <#--<label>工作内容</label>-->
                        <div class="col-sm-9">
                            <input type="text" id="form-field-1" placeholder="填写工作内容" class="col-xs-10 col-sm-5"/>
                        </div>
                    </div>

                    <div class="col-xs-12 col-sm-4">
                        <div>
                            <label class="col-sm-3 control-label no-padding-righ" for="form-field-select-1">项目名称</label>
                            <select class="form-control" id="form-field-select-1">
                                <option value="">&nbsp;</option>
                                <option value="ZNXG">智能写稿</option>
                                <option value="AK">测试项目1</option>
                                <option value="AZ">其他</option>
                            </select>
                        </div>


                        <label  class="col-sm-3 control-label no-padding-righ" for="id-date-range-picker-1">时间范围</label>
                        <div class="row">
                            <div class="col-xs-8 col-sm-11">
                                <div class="input-group">
																	<span class="input-group-addon">
																		<#--<i class="fa fa-calendar bigger-110"></i>-->
                                                                            <i class="fa fa-calendar bigger-110"></i>
																	</span>

                                    <input class="form-control" type="text" name="date-range-picker"
                                           id="id-date-range-picker-1"/>
                                </div>
                            </div>
                        </div>
                        <hr/>

                        <h1>测试</h1>

                </form>

            </div>
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
    $('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function () {
        $(this).next().focus();
    });

    $('#timepicker1').timepicker({
        minuteStep: 1,
        showSeconds: true,
        showMeridian: false
    }).next().on(ace.click_event, function () {
        $(this).prev().focus();
    });


    <#--new page({-->
    <#--&lt;#&ndash;pageMain: "pagination", nowPage:${page!'1'}, count:${count}, pageSize:${pageSize!'10'},&ndash;&gt;-->
    <#--&lt;#&ndash;url: "/project/list", params: "?pageSize=${pageSize}&query=${query}", pakey: "page"&ndash;&gt;});-->
    <#--})-->
    <#--;-->

</script>
</body>
</html>
