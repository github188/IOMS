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
				businessName : {
					required : true,
					maxlength : 50
				},
				name : {
					required : true,
					maxlength : 50
				},
				vrfName : {
					required : true,
					VRF : true,
					maxlength : 50
				},
				rdValue : {
					required : true,
					RDRT : true,
					maxlength : 50
				},
				rtValue : {
					required : true,
					RDRT : true,
					maxlength : 50
				},
				port : {
					required : true,
					MPLSVPNPORT : true,
					maxlength : 50
				},
				vlan : {
					required : true,
					digits : true,
					maxlength : 10
				},
				ip : {
					required : true,
					MPLSVPNPORTIP : true,
					maxlength : 50
				},
				routeType : {
					required : true
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
					dataType : "json",
					beforeSubmit : validate,
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
			<dd>电路配置明细--MPLS/VPN--修改</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl }tempcircuit/atmmplsvpn/mod.do" method="post">
				<table width="96%">
					<form:hidden path="id" />
					<form:hidden path="tempCircuit.id" />
					<tr>
						<th width="20%"><font color="red">(*)</font>业务名称:</th>
						<td style="text-align: left;"><form:input path="businessName"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>节点名称:</th>
						<td style="text-align: left;"><form:input path="name"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>VRF名称:</th>
						<td style="text-align: left;"><form:input path="vrfName"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>RD值:</th>
						<td style="text-align: left;"><form:input path="rdValue"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>RT值:</th>
						<td style="text-align: left;"><form:input path="rtValue"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>端口:</th>
						<td style="text-align: left;"><form:input path="port"
								size="50" /></td>
					</tr>

					<tr>
						<th width="20%"><font color="red">(*)</font>VLAN号:</th>
						<td style="text-align: left;"><form:input path="vlan"
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>IP地址:</th>
						<td style="text-align: left;"><form:input path="ip" size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>路由接入方式:</th>
						<td style="text-align: left;"><form:select path="routeType"
								cssStyle="width:90px">
								<form:option value="">请选择</form:option>
								<form:options items="${routerTypes}" itemLabel="name" />
							</form:select></td>
					</tr>
					<tr>
						<th width="20%">备注信息:</th>
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