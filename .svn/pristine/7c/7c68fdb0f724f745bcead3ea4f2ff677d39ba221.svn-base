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

<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.tablesorter.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js"
	type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
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
		$("#addForm").validate({
			rules : {
				transferUser :{
					required : true
				}
			},
			submitHandler : function(form) {
				parent.addSubmit(form);
			}
		});
		$("#submit").click(function() {
			$("#addForm").trigger("submit");
			//window.top.location.reload();
		});

		$(".close").click(function() {
			parent.$.nyroModalRemove();
		});

	});
</script>
</head>
<body style="overflow-x: hidden">
	<form:form id="addForm" name="addForm" action="${rootUrl }roletransfer/add.do" method="post">
		<div class="window">
			<dl class="title">
				<dd>代理人管理--添加</dd>
				<dt>
					<a href="#none" class="close"><img
						src="${rootUrl }images/close.png" alt="关闭" /> </a>
				</dt>
			</dl>
			<table width="100%">
				<tr>
					<th width="20%"><font color="red">(*)</font>姓名:</th>
					<td>${user.name}</td>
				</tr>
				<tr>
					<th width="20%"><font color="red">(*)</font>部门:</th>
					<td>${user.dept}</td>
				</tr>
				<%-- <tr>
					<th width="20%"><font color="red">(*)</font>当前角色:</th>
					<td>
						<c:forEach items="${user.baseRoles}" var="role" varStatus="status">
							<c:choose>
								<c:when test="${status.count == user.baseRoles.size()}">${role.name}</c:when>
								<c:otherwise>${role.name},</c:otherwise>
							</c:choose>
						
						</c:forEach>
					</td>
				</tr> --%>
				<tr>
					<th width="20%"><font color="red">(*)</font>被授权人:</th>
					<td>
						<select id="transferUser" name="transferUser">
							<option value="" selected="selected">请选择</option>
							<c:forEach items="${users}" var="vo">
								<option value="${vo.id}">${vo.name}</option>
							</c:forEach>
						</select>
					</td>
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