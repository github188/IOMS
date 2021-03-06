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
				sic : {
					required : true,
					number : true
				},
				sicb : {
					required : true,
					number : true
				},
				ncc : {
					required : true
				},
				nccb : {
					required : true
				},
				dpc1 : {
					required : true,
					number : true
				},
				dpc2 : {
					required : true,
					number : true
				},
				dpc3 : {
					required : true,
					number : true
				},
				dpcb : {
					required : true,
					number : true
				},
				suplim1 : {
					required : true,
					number : true
				},
				suplim2 : {
					required : true,
					number : true
				},
				suplim3 : {
					required : true,
					number : true
				},
				suplim4 : {
					required : true,
					number : true
				},
				suplim5 : {
					required : true,
					number : true
				},
				suplim6 : {
					required : true,
					number : true
				},
				suplimb : {
					required : true,
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
			<dd>十里河PES基带机架运行情况--添加</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /> </a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<form:form modelAttribute="pageModel" id="addForm" name="addForm"
				action="${rootUrl}duty/statelliteday/slhjdjjstate/add.do"
				method="post">

				<%@include file="recordContent.jsp"%>
				<br />
			</form:form>
		</div>
	</div>
</body>
</html>