<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
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
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		//表单验证
		$("#addForm").validate({
			rules : {},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});
		//防止重复提交
		var flag = true;
		$("#submit").click(
				function() {
					//获取延迟超时时间长度
					var timeOutSeconds = getTimeOutSeconds();
					if (flag == false) {
						alert("正在提交，请稍后!");
						return;
					}
					//表单验证
					var validStatus = $("#addForm").valid();
					//防止重复提交标志位
					if (validStatus == true) {
						//表单验证通过，标志位设置为false，不允许再次提交
						flag = false;
						$('input,select,textarea', $('#addForm')).prop(
								'readonly', true);
					} else {
						//表单验证未通过，标志位设置为true，不允许再次提交
						flag = true;
					}
					$("#addForm").ajaxSubmit({
						beforeSubmit : validateAddForm,
						dataType : "json",
						timeout : timeOutSeconds,
						success : function(data, status, xhr) {
							if (data.success == true) {
								alert("添加成功");
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("事件单添加失败");
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						},
						error : function(xmlHttpRequest, error) {
							alert("请求超时");
							parent.$.nyroModalRemove();
							window.top.location.reload();
						}
					});
				});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
		$("#goback").click(function() {
			parent.$.nyroModalRemove();
		});
	});
	function validateAddForm(formData, jqForm, options) {
		return $("#addForm").valid();
	}
</script>
<style>
th {
	width: 25% ! important;
	background-color: #DDDDDD;
	text-align: center ! important;
	font-weight: bold ! important;
	color: #5F5765 ! important;
}

td {
	width: 25% ! important;
	word-break: break-all;
}
</style>
</head>
<body style="overflow-x: hidden">
	<div class="window"
		style="overflow-y: hidden; overflow-x: hidden; margin-left: 1px;">
		<dl class="title">
			<dd>ku告警信息生成事件单</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<div style="margin: 10px 20px 0px; padding: 0px; width: 710px;">
				<dl class="title">
					<dd>ku告警信息生成事件单</dd>
				</dl>
			</div>
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl }faultmng/addFaultAlarm.do" method="post">
				<input type="hidden" id="alarmId" name="alarmId"
					value="${faultAlarm.id }" />
				<table width="100%">
					<tr>
						<th>告警设备名称</th>
						<td>${faultAlarm.equip.name}</td>
						<th>告警设备类型</th>
						<td>${faultAlarm.equip.type.name}</td>
					</tr>
					<tr>
						<th>站点名称</th>
						<td>${faultAlarm.satelliteSite.siteName}</td>
						<th>所属区域</th>
						<td>${faultAlarm.satelliteSite.bureau.value}</td>
					</tr>
					<tr>
						<th>事件级别</th>
						<td>A级</td>
						<th>事件类别</th>
						<td>卫星</td>
					</tr>
					<tr>
						<th>当前处理人</th>
						<td>${currentHandleUser}</td>
						<th>告警时间</th>
						<td><fmt:formatDate value="${faultAlarm.alarmTime}"
								type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th>提示</th>
						<td colspan="3"><span style="color: red;">请前往KU维保模块查询告警详情</span></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4">告警信息描述</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="4"><textarea
								id="remark" name="remark" rows="3" cols="90">${faultAlarm.alarmInfo }</textarea></td>
					</tr>
					<tr align="center">
						<td colspan="4" align="center" valign="middle"><span
							class="btn" id="btnSubmit" style="margin-left: 300px"> <a
								href="#none" id="submit">提交</a>
						</span> <span class="btn"> <a href="#none" id="goback"
								class="goback">取消</a>
						</span></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>