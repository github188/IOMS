<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var rootUrl = '${rootUrl }';
	$(function() {
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
				}
			}
		});
		getDetail();
		$("#submit").click(function() {
			if ($('input:radio[name="pass"]:checked').val() == 'true') {
				if (confirm("您确定移交？")) {
					if ($('#engineer').attr("value") == '') {
						alert("请选择具体负责工程师！");
						return;
					}
					$("#addForm").ajaxSubmit({
						beforeSubmit : validateAddForm,
						dataType : "json",
						success : function(data, status, xhr) {
							if (data.success == true) {
								alert("电路配置移交完成!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("电路配置移交失败，请联系技术支持!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						}
					})
				}
			} else {
				if (confirm("您确定配置完成？")) {
					$("#addDetail").ajaxSubmit({
						beforeSubmit : validate,
						dataType : "json",
						success : function(data, status, xhr) {
							if (data.success == true) {
								$("#addForm").ajaxSubmit({
									beforeSubmit : validateAddForm,
									dataType : "json",
									success : function(data, status, xhr) {
										if (data.success == true) {
											alert("电路配置完成!")
											parent.$.nyroModalRemove();
											window.top.location.reload();
										} else {
											alert("电路配置失败，请联系技术支持!")
											parent.$.nyroModalRemove();
											window.top.location.reload();
										}
									}
								})
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
	function validate(formData, jqForm, options) {
		return $("#addDetail").valid();
	}
	function validateAddForm(formData, jqForm, options) {
		return $("#addForm").valid();
	}
	function getDetail() {
		var tempcircuitid = $("#tempcircuitid").val();
		var circuitType = $("#circuitType").val();
		var url;
		if (circuitType == 'FRATM') {
			url = rootUrl + "tempcircuit/atmfratm/add.do?";
		}
		if (circuitType == 'MPLSVPN') {
			url = rootUrl + "tempcircuit/atmmplsvpn/add.do?";
		}
		if (circuitType == 'TESDATA' || circuitType=='TESBROADCAST') {
			url = rootUrl + "tempcircuit/tesdb/add.do?";
		}
		if (circuitType == 'TESVOICE') {
			url = rootUrl + "tempcircuit/tesaudio/add.do?";
		}
		if (circuitType == 'KUDATA'|| circuitType=='KUBROADCAST') {
			url = rootUrl + "tempcircuit/ku/add.do?";
		}
		$.ajax({
			url : url,// 需要链接到服务器地址
			type : 'GET',
			data : {
				tempcircuitid : tempcircuitid
			},
			success : function(html) {
				$("#detail").html(html);
			}
		})
	}
	function checkTransEngineer() {
		if ($('input:radio[name="pass"]:checked').val() == 'true') {
			$('#engineer').removeAttr("disabled");
			$("#detail").html("");
		} else {
			$('#engineer').attr("disabled", "");
			getDetail();
		}
	}
</script>
</head>
<body>
	<dl class="title">
		<dd>工程师办理</dd>
		<dt>
			<a href="#none" class="close"><img
				src="${rootUrl }images/close.png" alt="关闭" /></a>
		</dt>
	</dl>
	<!--begin 详情内容-->
	<div class="mtab" style="padding-left: 10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="title">
			<tr>
				<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />电路审批日志</td>
				<td class="td2" id="noteInfo"></td>
			</tr>
		</table>
		<table id="dataTable" width="80%" border="0" cellspacing="0"
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
					<tr>
						<td width="20%">${tempCircuitOptLog.circuitOptType.name}</td>
						<td width="20%">${tempCircuitOptLog.fromStatus.name }</td>
						<td width="20%">${tempCircuitOptLog.toStatus.name }</td>
						<td width="10%">${tempCircuitOptLog.optUser }</td>
						<td width="10%"><fmt:formatDate
								value="${tempCircuitOptLog.optTime.time}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td width="20%">${tempCircuitOptLog.circuitInfo }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<dl class="title">
			<dd>电路审批</dd>
		</dl>
		<form id="addForm" action="${rootUrl}tempcircuit/auditApply.do"
			method="post">
			<table>
				<tr>
					<td colspan="2"><input id="tempcircuitid" name="tempcircuitid"
						value="${tempcircuitid}" style="visibility: hidden;" /> <input
						name="tempcircuitpi" value="${tempcircuitpi}"
						style="visibility: hidden;" /> <input name="circuitStatus"
						value="${circuitStatus}" style="visibility: hidden;" /><input
						id="circuitType" value="${circuitType}"
						style="visibility: hidden;" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>是否移交*：</th>
					<td><input type="radio" name="pass" value="true"
						onclick="checkTransEngineer()">是</input> <input type="radio"
						name="pass" value="false" checked="checked"
						onclick="checkTransEngineer()">否 </input></td>
				</tr>
				<tr>
					<th width="20%">备注信息：</th>
					<td><textarea name="remark" cols="6" style="width: 90%"></textarea></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>选择移交工程师：</th>
					<td><select name="engineer" id="engineer" disabled="disabled">
							<option value='' selected="selected">请选择</option>
							<c:forEach items="${engineers}" var="engineer">
								<option value='${engineer.id}'>${engineer.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr id="configtr">
					<td colspan="2">
						<div id="detail"></div>
					</td>
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
		</form>
	</div>
</body>
</html>
