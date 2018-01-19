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
				},
				num11 : {
					number : true
				},
				num12 : {
					number : true
				},
				num13 : {
					number : true
				},
				num14 : {
					number : true
				},
				num15 : {
					number : true
				},
				num16 : {
					number : true
				},
				num17 : {
					number : true
				},
				num18 : {
					number : true
				},
				num19 : {
					number : true
				},
				num20 : {
					number : true
				},
				num21 : {
					number : true
				},
				num22 : {
					number : true
				},
				num23 : {
					number : true
				},
				num24 : {
					number : true
				},
				num25 : {
					number : true
				},
				num26 : {
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
			<c:if test="${checkType eq 'QUARTER' }">
				<dd>仪器仪表清查季检</dd>
			</c:if>
			<c:if test="${checkType eq 'YEAR' }">
				<dd>仪器仪表清查年检</dd>
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
				action="${rootUrl}duty/statellite/check/add.do" method="post">
				<input type="hidden" id="checkType" name="checkType"
					value="${checkType }" />
				<input type="hidden" id="optType" name="optType" value="${optType }" />
				<%@include file="recordContent.jsp"%>
				<br />
			</form:form>
		</div>
	</div>
</body>
</html>