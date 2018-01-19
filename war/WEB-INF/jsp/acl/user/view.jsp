<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />

<script>
	$(function() {
		$('.closeButton').click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>用户管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->
		<h1></h1>

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">用户信息</th>
				</tr>
				<tr>
					<th>登录名:</th>
					<td>${fn:escapeXml(pageModel.loginName)}</td>
					<th>姓名:</th>
					<td>${fn:escapeXml(pageModel.name)}</td>
				</tr>
				<tr>
					<th>部门:</th>
					<td>${pageModel.dept}</td>
					<th>角色:</th>
					<td><c:forEach items="${pageModel.roles}" var="role">
							${role.name}
		</c:forEach></td>
				</tr>
				<tr>
					<th>邮箱:</th>
					<td>${fn:escapeXml(pageModel.email)}</td>
					<th>手机:</th>
					<td>${pageModel.mobilephone}</td>
				</tr>
			</table>
			<br />
		</div>
		<!-- end 详情内容-->
		<div class="boxbtn">
			<div class="btn">
				<a href="#none" class="closeButton">关闭</a>
			</div>
		</div>
		<br />
	</div>
</body>
</html>