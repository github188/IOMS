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

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
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
		$("#addDetail").validate({
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
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="addDetail" name="addDetail"
		action="${rootUrl }tempcircuit/atmmplsvpn/add.do" method="post">
		<dl class="title">
			<dd>电路配置明细--MPLS/VPN--新建</dd>
		</dl>
		<table width="96%">
			<form:hidden path="tempCircuit.id" />
			<tr>
				<th width="20%"><font color="red">(*)</font>业务名称:</th>
				<td style="text-align: left;"><form:input path="businessName"
						size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>节点名称:</th>
				<td style="text-align: left;"><form:input path="name" size="80" /></td>
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
				<td style="text-align: left;"><form:input path="port" size="50" /></td>
			</tr>

			<tr>
				<th width="20%"><font color="red">(*)</font>VLAN号:</th>
				<td style="text-align: left;"><form:input path="vlan" size="50" /></td>
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
						cols="77" rows="10" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>