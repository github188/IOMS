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
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/datepicker/WdatePicker.js"
	type="text/javascript"></script>
<style type="text/css">
select {
	width: 80px;
}
</style>
<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		//表单校验
		$("#addForm").validate({
			rules : {
				name1 : {
					maxlength : 50
				},
				name2 : {
					maxlength : 50
				},
				name3 : {
					maxlength : 50
				},
				name4 : {
					maxlength : 50
				},
				name5 : {
					maxlength : 50
				},
				name6 : {
					maxlength : 50
				},
				name7 : {
					maxlength : 50
				},
				name8 : {
					maxlength : 50
				},
				name9 : {
					maxlength : 50
				},
				name10 : {
					maxlength : 50
				},
				num1 : {
					number : true
				},
				num2 : {
					number : true
				},
				num3 : {
					number : true
				},
				num4 : {
					number : true
				},
				num5 : {
					number : true
				},
				num6 : {
					number : true
				},
				num7 : {
					number : true
				},
				num8 : {
					number : true
				},
				num9 : {
					number : true
				},
				num10 : {
					number : true
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});
		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

		$("#submit").click(function() {
			$("#addForm").ajaxSubmit({
				beforeSubmit : validateAddForm,
				dataType : "json",
				success : function(data, status, xhr) {
					if (data.success == true) {
						alert("添加成功");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					} else {
						alert("添加失败");
						parent.$.nyroModalRemove();
						window.top.location.reload();
					}
				}
			})
		});
	});
	function validateAddForm(formData, jqForm, options) {
		return $("#addForm").valid();
	}
</script>



</head>
<body>
	<div class="window">
		<dl class="title">
			<c:if test="${checkType eq 'MONTH' }">
				<dd>卫星工具借用月检</dd>
			</c:if>
			<c:if test="${checkType eq 'QUARTER' }">
				<dd>卫星工具借用季检</dd>
			</c:if>
			<c:if test="${checkType eq 'YEAR' }">
				<dd>卫星工具借用年检</dd>
			</c:if>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl}duty/statellite/tool/add.do" method="post">
				<input type="hidden" id="checkType" name="checkType"
					value="${checkType }" />
				<%@include file="recordContent.jsp"%>
				<br />
			</form:form>
		</div>
	</div>
</body>
</html>