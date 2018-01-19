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
<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#modForm").validate({
			rules : {			
				/* info : {
					required : true,
					maxlength : 50
				} */
			},
			submitHandler : function(form) {
				parent.editSubmit(form);
			}
		});
		$("#submit").click(function() {
			$("#modForm").trigger("submit");
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }operstat/tes/service/mod.do" method="post">
		<form:hidden path="id" />
		<div class="window">
			<dl class="title">
				<dd>TES全网统计--TES电路配置信息--修改备注</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>TES电路信息</h1>
			<table width="96%">		
			<tr>
					<th width="20%">电路名:</th>
					<td width="30%">${pageModel.circuitName}</td>
				</tr>
				<tr>
					<th width="20%">主叫机箱号:</th>
					<td>${pageModel.activeNodeCode}</td>	
							
					<th width="20%">被叫机箱号:</th>
					<td>${pageModel.passiveNodeCode}</td>
		
				</tr>
				<tr>
					<th width="20%">主叫槽位号:</th>
					<td>${pageModel.activeSlot}</td>
					<th width="20%">被叫槽位号:</th>
					<td>${pageModel.passiveSlot}</td>
				</tr>
		
				<tr>
					<th width="20%">同异步:</th>
					<td width="30%">${pageModel.sync}</td>
					<th width="20%">电路速率:</th>
					<td width="30%">${pageModel.rate}</td>
				</tr>
				
				<tr>
					<th width="20%">频带池:</th>
					<td width="30%">${pageModel.bandWidthPool}</td>
					<%-- <th width="20%">所属地区:</th>
					<td width="30%"><form:select path="bureau"
							cssStyle="width:105px">
							<form:options items="${bureaus}" itemLabel="value" />
						</form:select></td> --%>
				</tr>
				
				<tr>
					<th width="20%">收端信息:</th>
					<td colspan="3">
					${pageModel.serviceMemo}</td>
				</tr>
				<tr>
					<th width="20%">客户备注:</th>
					<td colspan="3">
					${pageModel.clientInfo}</td>
				</tr>	
				<tr>
					<th width="20%">备注:</th>
					<td colspan="3"><form:textarea path="info" cssStyle="width:470px" /></td>
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