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
			<dd>十里河PES网管设备状态</dd>
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
					<th scope="col">检查内容</th>
					<th scope="col">检查结果</th>
					<th scope="col">评判标准</th>
					<th scope="col">检查方法</th>
				</tr>
				<tr>
					<th scope="col">DPC组1备用</th>
					<th scope="col">${vo.dpc38}</th>
					<th scope="col">DPC38</th>
					<th rowspan="6" scope="col">BBBB</th>
				</tr>
				<tr>
					<th scope="col">DPC组1备用</th>
					<th scope="col">${vo.dpc58}</th>
					<th scope="col">DPC58</th>
				</tr>
				<tr>
					<th scope="col">NCC2（62）</th>
					<th scope="col">${vo.NCC62.value}</th>
					<th rowspan="2" scope="col">Online OR Offline</th>
				</tr>
				<tr>
					<th scope="col">NCC2（63）</th>
					<th scope="col">${vo.NCC63.value}</th>
				</tr>
				<tr>
					<th scope="col">UMOD（上）</th>
					<th scope="col">${vo.umodup.value}</th>
					<th rowspan="2" scope="col">L（主用） OR R （备用）</th>
				</tr>
				<tr>
					<th scope="col">UMOD（下）</th>
					<th scope="col">${vo.umoddown.value}</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>