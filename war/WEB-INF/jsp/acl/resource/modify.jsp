<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$.ajaxSetup({
			cache : false
		});
		$("#modForm").validate({
			rules : {
				name : {
					required : true,
					maxlength : 10,
					description : true
				},
				list : {
					required : true,
					digits : true,
					min : 1,
					max : 99
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
<body>
	<form:form modelAttribute="pageModel" id="modForm" name="modForm"
		action="${rootUrl }acl/resource/mod.do" method="post">
		<form:hidden path="type" />
		<form:hidden path="pid" />
		<form:hidden path="id" />
		<div class="window" style="height: 390px">
			<dl class="title">
				<dd>资源信息--修改</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>资源信息</h1>
			<table width="100%">
				<tr>
					<th width="20%">资源ID:</th>
					<td>${pageModel.id }</td>
				</tr>
				<tr>
					<th width="20%">资源名:</th>
					<td><form:input path="name" size="32" width="50" /></td>
				</tr>
				<tr>
					<th width="20%">资源URL:</th>
					<td>${pageModel.url}<form:hidden path="url" /></td>
				</tr>
				<tr>
					<th width="20%">排序号：</th>
					<td><form:input path="list" size="32" /></td>
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