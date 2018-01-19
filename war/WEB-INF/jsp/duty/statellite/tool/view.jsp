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
			<dd>卫星工具借用--查看</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">

			<table width="100%" border="1">
				<tr>
					<th colspan="4" scope="col">借用工具登记表</th>
				</tr>
				<tr>
					<th scope="row">序号</th>
					<td>工具名称</td>
					<td>数量</td>
					<td>备注</td>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td>${vo.name1 }</td>
					<td>${vo.num1 }</td>
					<td>${vo.remark1 }</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>${vo.name2 }</td>
					<td>${vo.num2 }</td>
					<td>${vo.remark2 }</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>${vo.name3 }</td>
					<td>${vo.num3 }</td>
					<td>${vo.remark3 }</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>${vo.name4 }</td>
					<td>${vo.num4 }</td>
					<td>${vo.remark4 }</td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>${vo.name5 }</td>
					<td>${vo.num5 }</td>
					<td>${vo.remark5 }</td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>${vo.name6 }</td>
					<td>${vo.num6 }</td>
					<td>${vo.remark6 }</td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>${vo.name7 }</td>
					<td>${vo.num7 }</td>
					<td>${vo.remark7 }</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>${vo.name8 }</td>
					<td>${vo.num8 }</td>
					<td>${vo.remark8 }</td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>${vo.name9 }</td>
					<td>${vo.num9 }</td>
					<td>${vo.remark9 }</td>
				</tr>
				<tr>
					<th scope="row">10</th>
					<td>${vo.name10 }</td>
					<td>${vo.num10 }</td>
					<td>${vo.remark10 }</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>