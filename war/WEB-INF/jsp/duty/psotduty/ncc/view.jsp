<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>传输设备与通讯线路巡检详情</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
                <tr>
                    <th width="25%">设备名称</th>
                    <th width="75%" colspan="3">${psOtCheck.name }</th>
                </tr>
                <c:forEach items="${psOtCheck.psOtCheckContent }" var="pocc">
                    <tr>
                        <th width="25%">本月线路运行情况</th>
                        <th width="75%" colspan="3">${pocc.monthLrs }</th>
                    </tr>
                    <tr>
                        <th width="25%">本月新增线路情况</th>
                        <th width="75%" colspan="3">${pocc.monthLas }</th>
                    </tr>
                    <tr>
                        <th width="25%">本月删减线路情况</th>
                        <th width="75%" colspan="3">${pocc.monthLcs }</th>
                    </tr>
                    <tr>
                        <th width="25%">本月线路故障情况</th>
                        <th width="75%" colspan="3">${pocc.monthLfs }</th>
                    </tr>
                        <tr>
                        <th width="25%">本月线路割接情况</th>
                        <th width="75%" colspan="3">${pocc.monthLcsc }</th>
                    </tr>
                </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>