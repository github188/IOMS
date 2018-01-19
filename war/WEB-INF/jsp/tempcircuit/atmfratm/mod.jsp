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
				businessRate : {
					required : true,
					BUSINESSRATE : true,
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
			<dd>业务开通明细--ATM-FR-ATM----修改</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl }tempcircuit/atmfratm/mod.do" method="post">
				<table width="80%">
					<form:hidden path="id" />
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
						<td style="text-align: left;"><form:input
								path="localNodeName" size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>槽位:</th>
						<td style="text-align: left;"><form:input
								path="localNodeSlot" size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>端口:</th>
						<td style="text-align: left;"><form:input
								path="localNodePort" size="50" /></td>
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
								size="50" /></td>
					</tr>
					<tr>
						<th width="20%"><font color="red">(*)</font>业务速率（kbps）:</th>
						<td style="text-align: left;"><form:input path="businessRate"
								size="50" /></td>
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
	</div>
</body>
</html>