<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="${rootUrl}css/window.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />


<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		//预加载设备
		ajaxGetEquip();
		$.ajaxSetup({
			cache : false
		});
		$("#addForm").validate({
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});
		$("#submit").click(function() {
			$("#addForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});

	function ajaxGetEquip() {
		var subnetType = $("#subnetType").val();
		//异步加载
		$.ajax({
			url : "${rootUrl }maintain/equipnode/ajaxEquip.dox",
			type : "GET",
			dataType : "json",
			data : {
				subnetType : subnetType
			},
			success : function(data) {
				var equipHtm = "";
				$("#equipId option").remove();
				$.each(data, function(i, cd) {
					equipHtm += "<option value='" + cd.equip.id + "'>"
							+ cd.kuNodeNo + "</option>"
				});
				$("#equipId").append(equipHtm);
				//加载节点名称
				ajaxGetEquipName();
			},
			error : function(e) {
			}
		});
	}
	function ajaxGetEquipName() {
		var equipId = $("#equipId").val();
		//异步加载
		$.ajax({
			url : "${rootUrl }maintain/equipnode/ajaxEquipName.dox",
			type : "GET",
			dataType : "json",
			data : {
				equipId : equipId
			},
			success : function(data) {
				if (data != null) {
					$("#kuNodeName").val(data.name);
				} else {
					$("#kuNodeName").val("");
				}
			}
		});
	}
</script>
</head>
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="addForm" name="addForm"
		action="${rootUrl }maintain/equipnode/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>设备节点--配置</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>设备节点配置</h1>
			<table width="100%">
				<tr>
					<th width="20%">维保设备名称</th>
					<td width="30%"><form:select path="maintainEquip"
							cssStyle="width:135px;">
							<form:options items="${maintainEquips}" itemLabel="name"
								itemValue="id"></form:options>
						</form:select></td>
					<th width="20%">子网类型</th>
					<td width="30%"><select id="subnetType" name="subnetType"
						style="width: 135px;" onchange="ajaxGetEquip()">
							<c:forEach items="${subnetTypes}" var="subnetType">
								<option value="${subnetType }">${subnetType.value }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th width="20%">节点号</th>
					<td width="30%"><select id="equipId" name="equipId"
						style="width: 135px" onchange="ajaxGetEquipName()">
					</select></td>
					<th width="20%">节点名称</th>
					<td width="30%"><input type="text" readonly="readonly"
						id="kuNodeName" name="kuNodeName" /></td>
				</tr>
			</table>

			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#none" class="close">取消</a>
				</div>
			</div>
			<br />
		</div>

	</form:form>
</body>
</html>