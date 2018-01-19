<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
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
		$("#modForm").validate({
			rules : {
				info : {
					maxlength : 20
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
		action="${rootUrl }acl/role/mod.do" method="post">
		<form:hidden path="id" />
		<form:hidden path="system" />
		<div class="window">
			<dl class="title">
				<dd>角色管理--修改</dd>
				<dt>
					<a href="#" onclick="parent.$.nyroModalRemove();"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>角色信息</h1>
			<table width="96%">
				<tr>
					<th width="20%">角色名称</th>
					<td><form:hidden path="name" />${pageModel.name }</td>
				</tr>
				<tr>
					<th width="20%">描述</th>
					<td><form:textarea rows="2" cols="18" path="info" /></td>
				</tr>
			</table>
			<div class="boxbtn">
				<div class="btn">
					<a href="#" id="submit">保存</a>
				</div>
				<div class="btn">
					<a href="#" onclick="parent.$.nyroModalRemove();">取消</a>
				</div>
			</div>
		</div>

	</form:form>
</body>
</html>