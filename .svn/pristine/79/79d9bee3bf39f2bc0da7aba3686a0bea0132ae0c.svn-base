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
			<dd>卫星备件查看--查看</dd>
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
					<th colspan="1">记录名称</th>
					<th colspan="2">卫星备件信息库</th>
				</tr>
				<tr>
					<th width="30%" rowspan="8">巡检内容</th>
					<th width="30%">所属系统</th>
					<th width="40%"><input id="system" name="system"
						value="${vo.system }" readonly="readonly" type="text" /></th>
				</tr>
				<tr>
					<th width="30%">设备名称</th>
					<th width="40%"><input id="equipName" name="equipName"
						value="${vo.equipName }" readonly="readonly" type="text" /></th>
				</tr>
				<tr>
					<th width="30%">序列号</th>
					<th width="40%"><input id="sn" name="sn" value="${vo.sn }"
						readonly="readonly" type="text" /></th>
				</tr>
				<tr>
					<th width="30%">存放位置</th>
					<th width="40%"><input id="address" name="address"
						value="${vo.address }" readonly="readonly" type="text" /></th>
				</tr>
				<tr>
					<th width="30%">测试人</th>
					<th width="40%">${vo.tester.name}</th>
				</tr>
				<tr>
					<th width="30%">测试时间</th>
					<th width="40%"><fmt:formatDate value="${vo.testTime}"
							type="both" pattern="yyyy-MM-dd HH:mm:ss" /></th>
				</tr>
				<tr>
					<th width="30%">测试结果</th>
					<th width="40%"><input id="result" name="result"
						value="${vo.result }" readonly="readonly" type="text" /></th>
				</tr>
				<tr>
					<th width="30%">备注</th>
					<th width="40%"><textarea id="remark" name="remark" rows="2"
							readonly="readonly">${vo.remark }</textarea></th>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>