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
<link rel="stylesheet" type="text/css"
	href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js"
	type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
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
			<dd>通信基地TES网管进程状态</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">

			<table width="100%" border="0">
				<tr>
					<th colspan="2" scope="col">检查内容</th>
					<th scope="col">检查结果</th>
					<th scope="col">评判标准</th>
					<th scope="col">检查方法</th>
				</tr>
				<tr>
					<th rowspan="4" scope="col">网管工作站进程</th>
					<th scope="col">081</th>
					<th scope="col"><label> ${vo.PROCESS_STATE081.value} </label></th>
					<th rowspan="4" scope="col">ALL NCP PROCESSES ARE OPEARTIONAL
					</th>
					<th rowspan="4" scope="col">DEC Term 中使用Check proc 命令</th>
				</tr>
				<tr>
					<th scope="col">281</th>
					<th scope="col"><label> ${vo.PROCESS_STATE281.value} </label></th>
				</tr>
				<tr>
					<th scope="col">381</th>
					<th scope="col"><label> ${vo.PROCESS_STATE381.value} </label></th>
				</tr>
				<tr>
					<th scope="col">481</th>
					<th scope="col"><p>${vo.PROCESS_STATE481.value}</p></th>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>