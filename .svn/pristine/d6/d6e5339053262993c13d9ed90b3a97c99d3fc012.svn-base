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
			<dd>通信基地TES网管工作站连通性</dd>
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
					<th rowspan="4" scope="col">网管工作站连通性</th>
					<th scope="col">081丢包率(%)</th>
					<th scope="col">${vo.workstationcon081}</th>
					<th rowspan="4" scope="col">0%</th>
					<th rowspan="4" scope="col">UCX窗口Ping四台工作站10个数据包。081/281/381/481IP地址分别为172.16.100.8（21/31/41）</th>
				</tr>
				<tr>
					<th scope="col">281丢包率(%)</th>
					<th scope="col">${vo.workstationcon281}</th>
				</tr>
				<tr>
					<th scope="col">381丢包率(%)</th>
					<th scope="col">${vo.workstationcon381}</th>
				</tr>
				<tr>
					<th scope="col">481丢包率(%)</th>
					<th scope="col">${vo.workstationcon481}</th>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>