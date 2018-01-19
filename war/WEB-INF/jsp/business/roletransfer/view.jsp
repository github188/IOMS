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
			<dd>代理人管理--查看</dd>
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
					<th>姓名:</th>
					<td>${fn:escapeXml(user.name)}</td>
				</tr>
				<tr>
					<th>部门:</th>
					<td>${user.dept}</td>
				</tr>
				<tr>
					<th>当前角色:</th>
					<td>${user.baseRoleNames}</td>
				</tr>
				<tr>
					<th>拥有授权的角色:</th>
					<td>
						<c:forEach items="${user.transferRoles}" var="role" varStatus="status">
							<c:choose>
								<c:when test="${status.count == user.transferRoles.size()}">${role.name}</c:when>
								<c:otherwise>${role.name},</c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
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