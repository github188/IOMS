<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script>
	$(function() {
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				pass : {
					required : true
				},
				remark : {
					maxlength : 200
				},
				engineer : {
					required : true
				}
			}
		});

		function validate(formData, jqForm, options) {
			return $("#addForm").valid();
		}
		$("#submit").click(function() {
			if ($('input:radio[name="pass"]:checked').val() == 'false') {
				if (confirm("您确定审批不通过？")) {
					if ($('#remark').val() == '') {
						alert("请填写审批不通过的原因！");
						return;
					}
					$("#addForm").ajaxSubmit({
						dataType : "json",
						beforeSubmit : validate,
						success : function(data, status, xhr) {
							if (data.success == true) {
								alert("审批完成!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("审批失败，请联系技术支持!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						}
					})
				}
			} else {
				if (confirm("您确定审批通过？")) {
					if ($('#engineer').attr("value") == '') {
						alert("请选择具体负责工程师！");
						return;
					}
					$("#addForm").ajaxSubmit({
						dataType : "json",
						beforeSubmit : validate,
						success : function(data, status, xhr) {
							if (data.success == true) {
								alert("审批完成!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("审批失败，请联系技术支持!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						}
					})
				}
			}
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
	function check() {
		if ($('input:radio[name="pass"]:checked').val() == 'true') {
			$('#engineer').removeAttr("disabled");
		} else {
			$('#engineer').attr("disabled", "");
		}
	}
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>电路审批</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div class="mtab">
			<dl class="title">
				<dd>电路审批记录</dd>
			</dl>
			<table id="dataTable" width="100%" border="0" cellspacing="0"
				cellpadding="2" class="tablesorter">
				<thead>
					<tr>
						<th>操作类型</th>
						<th>起始状态</th>
						<th>结束状态</th>
						<th>操作用户</th>
						<th>操作时间</th>
						<th>备注信息</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${tempCircuitOptLogs}" var="tempCircuitOptLog">
						<td width="20%">${tempCircuitOptLog.circuitOptType.name}</td>
						<td width="20%">${tempCircuitOptLog.fromStatus.name }</td>
						<td width="20%">${tempCircuitOptLog.toStatus.name }</td>
						<td width="10%">${tempCircuitOptLog.optUser }</td>
						<td width="10%"><fmt:formatDate
								value="${tempCircuitOptLog.optTime.time}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td width="10%">${tempCircuitOptLog.circuitInfo }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 网控经理审批页面 -->
			<dl class="title">
				<dd>电路审批</dd>
			</dl>
			<form id="addForm" action="${rootUrl}tempcircuit/auditApply.do"
				method="post">
				<table>
					<tr>
						<td colspan="2" height="0"><input name="tempcircuitid"
							value="${tempcircuitid}" style="visibility: hidden;" /> <input
							class="easyui-validatebox" name="tempcircuitpi"
							value="${tempcircuitpi}" style="visibility: hidden;" /> <input
							class="easyui-validatebox" name="circuitStatus"
							value="${circuitStatus}" style="visibility: hidden;" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>是否通过：</th>
						<td><input type=radio name="pass" value="true"
							onclick="check()">是</input>&nbsp;&nbsp;&nbsp;&nbsp;<input
							type=radio name="pass" value="false" checked="checked"
							onclick="check()">否 </input></td>
					</tr>
					<tr>
						<th width="20%">备注信息：</th>
						<td style="text-align: left"><textarea name="remark"
								id="remark" style="width: 100%" rows="6"></textarea></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>选择工程师：</th>
						<td style="text-align: left"><select name="engineer"
							id="engineer" style="width: 30%" disabled="disabled">
								<option value='' selected="selected">请选择</option>
								<c:forEach items="${engineers}" var="engineer">
									<option value='${engineer.id}'>${engineer.name}</option>
								</c:forEach>
								<select></td>
					</tr>
				</table>
				<div class="boxbtn">
					<div class="btn">
						<a href="#none" id="submit">提交</a>
					</div>
					<div class="btn">
						<a href="#none" class="close">取消</a>
					</div>
				</div>
				<br />
			</form>
		</div>
	</div>
</body>
</html>
