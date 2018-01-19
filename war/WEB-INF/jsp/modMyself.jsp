<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${rootUrl }css/window.css" rel="stylesheet" type="text/css" />
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$.ajaxSetup ({ cache: false}); 
	$("#modForm").validate({
		rules:{
			name:{required:true},
			email:{email:true}
		},
		submitHandler: function(form) {
			form.submit();
			parent.$.nyroModalRemove();
		}
	});
	$('.closeButton').click(function(){
		parent.$.nyroModalRemove();
	});
	$('#saveButton').click(function(){
		$('#modForm').submit();
	});
});
</script>
</head>

<body>
	<div class="window">
		<form:form modelAttribute="user" id="modForm" name="modForm"
			action="${rootUrl }modMyself.do" method="post">
			<form:hidden path="id" />
			<form:hidden path="status" />
			<dl class="title">
				<dd>用户管理--用户修改</dd>
				<dt>
					<a href="#none" class="closeButton"><img
						src="${rootUrl }images/close.png" alt="关闭" />
					</a>
				</dt>
			</dl>
			<h1>用户修改</h1>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<c:if test="${my_result=='my_error' }">
					<tr>
						<th width="150px"><img
							src="${rootUrl }images/validator/note_no.gif"></img>
						</th>
						<td style="color: red">${my_message}</td>
					</tr>
				</c:if>
				<c:if test="${my_result=='my_success' }">
					<tr>
						<th width="150px"><img
							src="${rootUrl }images/validator/note_yes.gif"></img>
						</th>
						<td style="color: green">${my_message}</td>
					</tr>
				</c:if>
				<tr>
					<th width="30%">登录名：</th>
					<td><form:input path="loginName" maxlength="20"
							readonly="true" />
					</td>
				</tr>
				<tr>
					<th>姓名：</th>
					<td><form:input path="name" maxlength="20" />
					</td>
				</tr>
				<tr>
					<th>性别：</th>
					<td><form:radiobutton path="male" value="true" label="男" /> <form:radiobutton
							path="male" value="false" label="女" /></td>
				</tr>
				<tr>
					<th>电子邮箱：</th>
					<td><form:input path="email" maxlength="50" />
					</td>
				</tr>
				<tr>
					<th>手机：</th>
					<td><form:input path="mobile" maxlength="50" />
					</td>
				</tr>
				<tr>
					<th>电话：</th>
					<td><form:input path="tel" maxlength="50" />
					</td>
				</tr>
				<tr>
					<th>传真：</th>
					<td><form:input path="fax" maxlength="50" />
					</td>
				</tr>
			</table>
			<div class="boxbtn">
				<div class="btn">
					<a href="#none" id="saveButton">确认</a>
				</div>
				<div class="btn">
					<a href="#none" class="closeButton">取消</a>
				</div>
			</div>
		</form:form>
		<br />
	</div>
</body>
</html>