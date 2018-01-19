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
<link rel="stylesheet" type="text/css" href="${rootUrl }js/jqueryui/themes/jquery-ui.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jqueryui/jquery-ui.js" type="text/javascript"></script>
<script src="${rootUrl }js/autocompleteExtends.js" type="text/javascript"></script>

<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js" type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style type="text/css">
<!--
	select {
		width: 80px;
	}
-->
</style>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#editForm").validate({
			rules : {

			},
			submitHandler : function(form) {
				if (confirm("您确定更新ups季检记录吗？")) {
					parent.addSubmit(form);
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent("td"));
			}
		});
		$("#submit").click(function() {
			$("#editForm").ajaxSubmit({
				beforeSubmit : validateEditForm,
				dataType : "json",
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("更新记录成功!")
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("更新记录失败，请检查!")
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				}
			})
		});
		function validateEditForm(formData, jqForm, options) {
			return $("#editForm").valid();
		}
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>ups设备季检--更新</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="editForm" name="editForm" action="${rootUrl}duty/upsdutyquarter/zjups/update.do" method="post">
				<input type="hidden" id="upsCheckId" name="upsCheckId" value="${upsCheck.id }"/>
				<%@include file="updatedetail.jsp" %>
				<br />
			</form:form>
		</div>
	</div>
</body>
</html>