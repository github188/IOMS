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
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			rules : {
				name : {
					required : true,
					//chineseName : true,
					maxlength : 50
				},
				boxNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				slotNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				teleNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				freqPool : {
					maxlength : 50
				},
				remark : {
					maxlength : 200
				}
			}
		});

		function validate(formData, jqForm, options) {
			return $("#addForm").valid();
		}

		$("#submit").click(function() {
			if (confirm("您确定提交修改吗？")) {
				$("#addForm").ajaxSubmit({
					beforeSubmit : validate,
					dataType : "json",
					success : function(data, status, xhr) {
						if (data.success == true) {
							alert("电路配置修改完成!")
							parent.$.nyroModalRemove();
							window.top.location.reload();
						}
					}
				})
			}
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>电路配置明细--TES话音--修改</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<!--begin 详情内容-->
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl }tempcircuit/tesaudio/mod.do" method="post">
				<table width="96%">
					<form:hidden path="id" />
					<form:hidden path="tempCircuit.id" />
					<tr>
						<th width="20%"><font color="red">(*)</font>节点名称:</th>
						<td style="text-align: left;"><form:input path="name"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>机箱号:</th>
						<td style="text-align: left;"><form:input path="boxNumber"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>槽位号:</th>
						<td style="text-align: left;"><form:input path="slotNumber"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>电话号码:</th>
						<td style="text-align: left;"><form:input path="teleNumber"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%">频带池:</th>
						<td style="text-align: left;"><form:input path="freqPool"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%">备注:</th>
						<td style="text-align: left;"><form:textarea path="remark"
								cols="50" rows="10" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="boxbtn">
			<div class="btn">
				<a href="#none" id="submit">修改</a>
			</div>
			<div class="btn">
				<a href="#none" class="close">关闭</a>
			</div>
		</div>
		<br />
	</div>
</body>
</html>