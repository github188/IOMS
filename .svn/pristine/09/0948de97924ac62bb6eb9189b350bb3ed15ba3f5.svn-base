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
				businessRate : {
					required : true,
					DLCIVPIVCI : true,
					maxlength : 10
				},
				localNodeName : {
					required : true,
					maxlength : 50
				},
				localNodeSlot : {
					required : true,
					digits : true,
					maxlength : 10
				},
				localNodePort : {
					required : true,
					digits : true,
					maxlength : 10
				},
				localNodePortRate : {
					required : true,
					DLCIVPIVCI : true,
					maxlength : 10
				},
				localDlciVpiVci : {
					required : true,
					DLCIVPIVCI : true,
					maxlength : 50
				},
				oppositeNodeName : {
					required : true,
					maxlength : 50
				},
				oppositeNodeSlot : {
					required : true,
					digits : true,
					maxlength : 10
				},
				oppositeNodePort : {
					required : true,
					digits : true,
					maxlength : 10
				},
				oppositeNodePortRate : {
					required : true,
					DLCIVPIVCI : true,
					maxlength : 10
				},
				oppositeDlciVpiVci : {
					required : true,
					DLCIVPIVCI : true,
					maxlength : 50
				},
				qosType : {
					required : true,
					maxlength : 50
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
		action="${rootUrl }tempcircuit/atmfratm/add.do" method="post">
		<dl class="title">
			<dd>业务开通明细--FR/ATM--新建</dd>
		</dl>
		<table width="80%">
			<form:hidden path="tempCircuit.id" />
			<tr>
				<th width="20%"><font color="red">(*)</font>业务名称:</th>
				<td style="text-align: left;"><form:input path="businessName"
						size="50" /></td>
			</tr>
			<tr align="center">
				<td colspan="2">本端节点参数</td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>本端节点名称:</th>
				<td style="text-align: left;"><form:input path="localNodeName"
						size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>槽位:</th>
				<td style="text-align: left;"><form:input path="localNodeSlot"
						size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>端口:</th>
				<td style="text-align: left;"><form:input path="localNodePort"
						size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>端口速率（kbps）:</th>
				<td style="text-align: left;"><form:input
						path="localNodePortRate" size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>DLCI或VPI.VCI:</th>
				<td style="text-align: left;"><form:input
						path="localDlciVpiVci" size="50" /></td>
			</tr>
			<tr align="center">
				<td colspan="2">对端节点参数</td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>对端节点名称:</th>
				<td style="text-align: left;"><form:input
						path="oppositeNodeName" size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>槽位:</th>
				<td style="text-align: left;"><form:input
						path="oppositeNodeSlot" size="50" /></td>
			</tr>
			<tr>
				<th width="20%">端口:</th>
				<td style="text-align: left;"><form:input
						path="oppositeNodePort" size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>端口速率（kbps）:</th>
				<td style="text-align: left;"><form:input
						path="oppositeNodePortRate" size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>DLCI或VPI.VCI:</th>
				<td style="text-align: left;"><form:input
						path="oppositeDlciVpiVci" size="50" /></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>QoS类型:</th>
				<td style="text-align: left;"><form:input path="qosType"
						size="80" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>业务速率（kbps）:</th>
				<td style="text-align: left;"><form:input path="businessRate"
						size="80" /></td>
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