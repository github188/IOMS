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
		$("#modForm")
				.validate(
						{
							rules : {
								serviceType :{
									required : true,
									maxlength : 16,
									remote : "${rootUrl}basedata/atm/type/checkExist.dox?r=" + Math.random()
								}
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
<body style="overflow-x: hidden">
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }basedata/atm/type/mod.do" method="post">
		<form:hidden path="id" />
		<%-- <form:hidden path="equipId" /> --%>
		<div class="window" style="height:320px">
			<dl class="title">
				<dd>数据管理--ATM业务类型--修改</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>ATM业务类型</h1>
			<table width="96%">
				<tr>
					<th width="25%"><font color="red">(*)</font>业务类型:</th>
					<td><form:input path="serviceType" /></td>
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