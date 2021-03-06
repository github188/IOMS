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
				circuitName : {
					required : true,
					KUCIRCUITNAME : true,
					maxlength : 50
				},
				aNodeName : {
					required : true,
					//chineseName : true,
					maxlength : 50
				},
				aBoxNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				aSlotNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				bNodeName : {
					required : true,
					//chineseName : true,
					maxlength : 50
				},
				bBoxNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				bSlotNumber : {
					required : true,
					digits : true,
					maxlength : 10
				},
				rate : {
					required : true,
					DLCIVPIVCI : true,
					maxlength : 10
				},
				circuitType : {
					required : true
				},
				frequencePool : {
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
			<dd>电路配置明细--TES双向数据/广播--修改</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<!--begin 详情内容-->
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl }tempcircuit/tesdb/mod.do" method="post">
				<table width="50%">
					<form:hidden path="id" />
					<form:hidden path="tempCircuit.id" />
					<%-- <tr>
						<th><font color="red">(*)</font>业务名称:</th>
						<td style="text-align: left;"><form:input path="businessName"
								size="35" /></td>
					</tr> --%>
					<tr>
						<th><font color="red">(*)</font>电路名称:</th>
						<td style="text-align: left;"><form:input path="circuitName"
								size="35" /></td>
					</tr>
					<tr>
						<td colspan="2">节点A/广播源</td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>节点:</th>
						<td style="text-align: left;"><form:input path="aNodeName"
								size="35" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>机箱:</th>
						<td style="text-align: left;"><form:input path="aBoxNumber"
								size="35" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>槽位:</th>
						<td style="text-align: left;"><form:input path="aSlotNumber"
								size="35" /></td>
					</tr>
					<tr>
						<td colspan="2">节点B</td>
					</tr>
					<c:if test="${tempcircuit.circuitType eq 'TESBROADCAST'}">
						<c:forEach items="${tesBroadcastList}" var="vo"
							varStatus="voStatus">
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
					<c:if test="${tempcircuit.circuitType eq 'TESDATA'}">
						<tr>
							<th width="20%"><font color="red">(*)</font>节点:</th>
							<td style="text-align: left;"><form:input path="bNodeName"
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
				<%-- 	<tr>
						<th width="20%"><font color="red">(*)</font>电路类型:</th>
						<td style="text-align: left;"><form:select path="circuitType"
								cssStyle="width:180px">
								<form:option value="">请选择</form:option>
								<form:options items="${kutypes}" itemLabel="name" />
							</form:select></td>
					</tr> --%>
					<tr>
						<th width="20%"><font color="red">(*)</font>速率:</th>
						<td style="text-align: left;"><form:input path="rate"
								size="35" /></td>
					</tr>
					<tr>
						<th width="20%">频带池:</th>
						<td style="text-align: left;"><form:input
								path="frequencePool" size="35" /></td>
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