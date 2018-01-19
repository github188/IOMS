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
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style type="text/css">
<!--
select {
	width: 80px;
}

.tdWidth {
	width: 100%;
}
-->
</style>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		//表单校验
		$("#addForm").validate({
			rules : {
				cpu : {
					required : true
				},
			},
			submitHandler : function(form) {
				if (confirm("您确定填写相关总结信息吗？")) {
					//parent.addSubmit(form);
					$("#addForm").ajaxSubmit({
						beforeSubmit : validateAddForm,
						dataType : "json",
						success : function(data, status, xhr) {
							if (data.success) {
								alert("填写信息成功!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							} else {
								alert("填写信息失败，请检查!")
								parent.$.nyroModalRemove();
								window.top.location.reload();
							}
						}
					})
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td"));
			}
		});
		function validateAddForm(formData, jqForm, options) {
			return $("#addForm").valid();
		}
		$("#submit").click(function() {
			$("#addForm").trigger("submit");
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
			<dd>报表数据填写</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl}maintain/satellite/write.do" method="post">
				<input type="hidden" id="id" name="id" value="${id}" />
				<div style="margin: 10px 20px 0px; padding: 0px">
					<dl class="title">
						<dd>报表数据</dd>
					</dl>
				</div>

				<table width="100%" border="1">
					<tr>
						<th width="30%" scope="col">站点基本情况</th>
						<td><textarea id="baseInfo" name="baseInfo" rows="5"
								class="tdWidth" placeholder="内容不能超过100个字">${kuReportData.baseInfo }</textarea></td>
					</tr>
					<tr>
						<th width="30%" scope="col">故障处理情况</th>
						<td><textarea id="faultInfo" name="faultInfo" rows="5"
								class="tdWidth" placeholder="内容不能超过100个字">${kuReportData.faultInfo}</textarea></td>
					</tr>
					<tr>
						<th width="30%" scope="col">运行情况总结</th>
						<td><textarea id="operSummary" name="operSummary" rows="5"
								class="tdWidth" placeholder="内容不能超过100个字">${kuReportData.operSummary}</textarea></td>
					</tr>
					<tr>
						<th width="30%" scope="col">运行维护建议</th>
						<td><textarea id="operAdvice" name="operAdvice" rows="5"
								class="tdWidth" placeholder="内容不能超过100个字">${kuReportData.operAdvice}</textarea></td>
					</tr>
				</table>
				<div style="margin: 10px 20px 10px; padding: 0px"></div>

				<div class="boxbtn">
					<div class="btn">
						<a href="#none" id="submit">保存</a>
					</div>
					<div class="btn">
						<a href="#none" class="close">取消</a>
					</div>
				</div>
				<br />
			</form:form>
		</div>
	</div>
</body>
</html>