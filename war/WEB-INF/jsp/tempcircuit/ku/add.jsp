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
		$("#addDetail").validate({
			rules : {
				businessName : {
					required : true,
					maxlength : 50
				},
				circuitName : {
					required : true,
					KUCIRCUITNAME : true,
					maxlength : 50
				},
				aNodeNumber : {
					KUBOXNUM : true,
					required : true,
					maxlength : 50
				},
				aBoxNumber : {
					digits : true,
					required : true,
					maxlength : 10
				},
				aSlotNumber : {
					digits : true,
					required : true,
					maxlength : 10
				},
				bNodeNumber : {
					KUBOXNUM : true,
					required : true,
					maxlength : 50
				},
				bBoxNumber : {
					digits : true,
					required : true,
					maxlength : 10
				},
				bSlotNumber : {
					digits : true,
					required : true,
					maxlength : 10
				},
				rate : {
					DLCIVPIVCI : true,
					required : true,
					maxlength : 10
				},
				circuitType : {
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
		action="${rootUrl }tempcircuit/ku/add.do" method="post">
		<dl class="title">
			<dd>电路配置明细--KU双向数据/广播--新建</dd>
		</dl>
		<table width="96%">
			<form:hidden path="tempCircuit.id" />
			<%-- <tr>
				<th width="20%"><font color="red">(*)</font>业务名称:</th>
				<td style="text-align: left;"><form:input path="businessName"
						size="50" /></td>
			</tr> --%>
			<tr>
				<th width="20%"><font color="red">(*)</font>电路名称:</th>
				<td style="text-align: left;"><form:input path="circuitName"
						size="50" /></td>
			</tr>
			<tr>
				<td colspan="2">节点A/广播源</td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>节点:</th>
				<td style="text-align: left;"><form:input path="aNodeNumber"
						size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>槽位:</th>
				<td style="text-align: left;"><form:input path="aBoxNumber"
						size="50" /></td>
			</tr>
			<tr>
				<th width="20%"><font color="red">(*)</font>端口:</th>
				<td style="text-align: left;"><form:input path="aSlotNumber"
						size="50" /></td>
			</tr>
			<tr>
				<td colspan="2">节点B</td>
			</tr>
			<c:if test="${tempcircuit.circuitType eq 'KUBROADCAST'}">
				<c:forEach items="${kuBroadcastList}" var="vo" varStatus="voStatus">
					<tr>
						<td style="display: none"><input type="hidden"
							name="circuitDetailId" value="${vo.id}" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>节点:</th>
						<td style="text-align: left;"><input name="node"
							value="${vo.node}" size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>槽位:</th>
						<td style="text-align: left;"><input name="slot"
							value="${vo.slot}" size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>端口:</th>
						<td style="text-align: left;"><input name="port"
							value="${vo.port}" size="50" /></td>
					</tr>
					<tr>
						<td></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${tempcircuit.circuitType eq 'KUDATA'}">
				<tr>
					<th width="20%"><font color="red">(*)</font>节点:</th>
					<td style="text-align: left;"><form:input path="bNodeNumber"
							size="50" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>槽位:</th>
					<td style="text-align: left;"><form:input path="bBoxNumber"
							size="50" /></td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>端口:</th>
					<td style="text-align: left;"><form:input path="bSlotNumber"
							size="50" /></td>
				</tr>
			</c:if>
			<%-- <tr>
				<th width="20%"><font color="red">(*)</font>电路类型:</th>
				<td style="text-align: left;"><form:select path="circuitType">
						<form:option value="">请选择</form:option>
						<form:options items="${kutypes}" itemLabel="name" />
					</form:select></td>
			</tr> --%>
			<tr>
				<th width="20%"><font color="red">(*)</font>业务速率（kbps）:</th>
				<td style="text-align: left;"><form:input path="rate" size="80" /></td>
			</tr>
			<tr>
				<th width="20%">备注:</th>
				<td style="text-align: left;"><form:textarea path="remark"
						cols="77" rows="10" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>