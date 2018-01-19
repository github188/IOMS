<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${rootUrl }css/window.css" rel="stylesheet" type="text/css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
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
		$("#modPwForm").validate({
			rules : {
				oldPasswd : {
					required : true
				},
				password : {
					required : true,
					password : true
				},
				confirm_pw : {
					required : true,
					equalTo : "#password"
				},
			}
		});
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
		$('#submitButton').click(function() {
			$('#modPwForm').submit();
			//parent.$.nyroModalRemove();
		});
	});
</script>
</head>

<body>
	<div class="window">
		<form:form modelAttribute="passwdModel" id="modPwForm"
			name="modPwForm" action="${rootUrl }modPasswd.dox" method="post">
			<dl class="title">
				<dd>修改密码</dd>
				<dt>
					<a href="#none" class="closeButton"><img
						src="${rootUrl }images/close.png" alt="关闭" /></a>
				</dt>
			</dl>
			<h1>修改密码</h1>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<c:if test="${modTag=='N' }">
					<tr>
						<th width="150px"><img
							src="${rootUrl }images/validator/note_no.gif"></img></th>
						<td style="color: red">${reason}</td>
					</tr>
				</c:if>
				<c:if test="${modTag=='Y' }">
					<tr>
						<th width="150px"><img
							src="${rootUrl }images/validator/note_yes.gif"></img></th>
						<td style="color: green">密码修改成功</td>
					</tr>
				</c:if>
				<tr>
					<th width="150px">原始密码：</th>
					<td><form:password path="oldPasswd" /></td>
				</tr>
				<tr>
					<th width="150px">新密码：</th>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<th width="150px">确认密码：</th>
					<td><input id="confirm_pw" name="confirm_pw" type="password" /></td>
				</tr>
			</table>
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="submitButton">修改</a>
				</div>
				<div class="btn">
					<a href="#none" class="closeButton">关闭</a>
				</div>
			</div>
			<br />
			<br />
		</form:form>
	</div>
</body>
</html>