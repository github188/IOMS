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
<link rel="stylesheet" type="text/css"
	href="${rootUrl}js/autocomplete/jquery.autocomplete.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${rootUrl }js/autocomplete/jquery.autocomplete.js"></script>
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
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td").next("td")[0]);
			}
		});
		$("#submit").click(function() {
			if ($('input:radio[name="pass"]:checked').val() == 'false') {
				if (confirm("您确定取消申请？")) {
					$("#addForm").ajaxSubmit({
						dataType : "json",
						beforeSubmit : validateAddForm,
						success : function(data, status, xhr) {
							if (data.success == true) {
								alert("电路申请取消!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("电路申请取消失败，请联系技术支持!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						}
					})
				}
			} else {
				if (confirm("您确定配置完成？")) {
					var equips = $("#yourTable input[name='zEquipIdSelect']");
					var equipParam = "";
					url = $("#tempCircuit").attr("action") + "?zEquipIdSelect=" + $(equips[0]).val();
			        for ( var i = 1; i < equips.length; i++) {
			        	url = url + "&zEquipIdSelect=" + $(equips[i]).val();
			        }	
			        $("#tempCircuit").attr("action", url);
					$("#tempCircuit").ajaxSubmit({
						beforeSubmit : validate,
						dataType : "json",
						success : function(data, status, xhr) {
							if (data.success == true) {
								$("#addForm").ajaxSubmit({
									dataType : "json",
									beforeSubmit : validateAddForm,
									success : function(data, status, xhr) {
										if (data.success == true) {
											alert("电路配置完成!");
											url="${rootUrl}tempcircuit/modApply.do";
		                                	$("#tempCircuit").attr("action", url);
											parent.$.nyroModalRemove();
											window.top.location.reload();
										} else {
											alert("电路配置失败，请联系技术支持!");
											url="${rootUrl}tempcircuit/modApply.do";
											$("#tempCircuit").attr("action", url);
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
		url="${rootUrl}tempcircuit/modApply.do";
		$("#tempCircuit").attr("action", url);
		return $("#tempCircuit").valid();
	}
	function validateAddForm(formData, jqForm, options) {
		var isValid = $("#addForm").valid();
		var equips = $("#yourTable input[name='zEquipIdSelect']");
		var cirType = $("#circuitTypeMod").val();
		if ((cirType == 'TESBROADCAST' || cirType == 'KUBROADCAST')
				&& equips.length == 0) {
			alert("对(收)端节点必须添加！");
			$("#yourTable").after(
					"<font id='entAdd' color='red'>"
							+ "添加！" + "</font>");
			$("#entAdd").delay(1000).fadeOut("slow");
			isValid = false;
		}		
		url="${rootUrl}tempcircuit/modApply.do";
		$("#tempCircuit").attr("action", url);
		
		return isValid;
	}
	function getDetail() {
		var tempcircuitid = $("#tempcircuitid").val();
		$.ajax({
			url : rootUrl + "tempcircuit/modApply.do",// 需要链接到服务器地址
			type : 'GET',
			data : {
				tempcircuitid : tempcircuitid
			},
			success : function(html) {
				$("#detail").html(html);
			}
		})
	}
	function checkReply() {
		if ($('input:radio[name="pass"]:checked').val() == 'true') {
			getDetail();
		} else {
			$("#detail").html("");
		}
	}
	$(".close").click(function() {
		parent.$.nyroModalRemove();
	});
</script>
</head>
<body>
	<dl class="title">
		<dd>工程师审批</dd>
		<dt>
			<a href="#none" class="close"><img
				src="${rootUrl }images/close.png" alt="关闭" /></a>
		</dt>
	</dl>
	<!--begin 详情内容-->
	<div class="mtab">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="title">
			<tr>
				<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />电路审批日志</td>
				<td class="td2" id="noteInfo"></td>
			</tr>
		</table>
		<div id="lmsx">
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
						<tr>
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
			<dl class="title">
				<dd>电路审批</dd>
			</dl>
			<form id="addForm" action="${rootUrl}tempcircuit/auditApply.do"
				method="post">
				<table>
					<tr>
						<td colspan="2"><input id="tempcircuitid"
							name="tempcircuitid" value="${tempcircuitid}"
							style="visibility: hidden;" /> <input name="tempcircuitpi"
							value="${tempcircuitpi}" style="visibility: hidden;" /> <input
							name="circuitStatus" value="${circuitStatus}"
							style="visibility: hidden;" /><input id="circuitType"
							value="${circuitType}" style="visibility: hidden;" /> <input
							name="remark" value="" style="visibility: hidden;" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>是否重新申请*：</th>
						<td><input type=radio name="pass" value="true"
							onclick="checkReply()">是</input> <input type=radio name="pass"
							value="false" checked="checked" onclick="checkReply()">否
						</input></td>
					</tr>
					<tr>
						<td colspan="2"><div id="detail"></div></td>
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
	</div>
</body>
</html>
