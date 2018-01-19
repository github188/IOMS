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
			<dd>客户信息--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">客户信息</th>
				</tr>
				<tr>
					<th width="20%">姓名:</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${fn:escapeXml(pageModel.name)}</td>
					<th width="20%">性别:</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.sex.name}</td>
				</tr>
				<tr>
					<th width="20%">年龄:</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.age}</td>
					<th width="20%">角色:</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.role.info}</td>
				</tr>
				<tr>
					<th width="20%">所属区域:</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.bureau.value}</td>
					<th width="20%">单位名称：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.newCompany.company}</td>
				</tr>
				<tr>
					<th width="20%">单位地址:</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.newCompany.address}</td>
					<th width="20%">单位邮编：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.newCompany.postcode}</td>
				</tr>
				<tr>
					<th width="20%">手机号码：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.mobilephone}</td>
					<th width="20%">座机号码：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.phone}</td>
				</tr>
				<tr>
					<th width="20%">状态：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.status.value}</td>
					<th width="20%">个人邮箱：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.email}</td>
				</tr>
				<tr>
					<th width="20%">职务：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.job}</td>
					<th width="20%">传真：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.fax}</td>
				</tr>
				<tr>
					<th width="20%">登录名：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.loginName}</td>
					<th width="20%">部门：</th>
					<td width="30%" style="word-break:break-all;word-wrap:break-word;">${pageModel.branch}</td>
				</tr>
				<tr>	
					<th width="20%">审核理由：</th>
					<td colspan="3" style="word-break:break-all;word-wrap:break-word;">${pageModel.auditReason}</td>
				</tr>
				
				<tr style="height:50px">
					<th width="20%">备注：</th>
					<td colspan="3" style="word-break:break-all;word-wrap:break-word;">${pageModel.info}</td>
				</tr>
			</table>
			<br />
		</div>
		<div
				style="float: right; padding-right: 70px; color: blue; padding-bottom: 2px;"></div>
			<div class="mtab">
				<table width="950px">
					<tr>
						<th colspan="4"
							style="color: gray; width: 100%; text-align: center;">注册答题信息</th>
					</tr>
					<c:if test="${questionModel.size == 3}">
						<tr>
							<th width="20%">问题一：</th>
							<td colspan="3" style="text-align: left;">${questionModel.description1 }</td>
						</tr>
						<tr>
							<th width="20%">回答一：</th>
							<td colspan="3" style="text-align: left;">
								${questionModel.answer1 }</td>
						</tr>
						<tr>
							<th width="20%">问题二：</th>
							<td colspan="3" style="text-align: left;">${questionModel.description2 }</td>
						</tr>
						<tr>
							<th width="20%">回答二：</th>
							<td colspan="3" style="text-align: left;">${questionModel.answer2 }</td>
						</tr>
						<tr>
							<th width="20%">问题三：</th>
							<td colspan="3" style="text-align: left;">${questionModel.description3 }</td>
						</tr>
						<tr>
							<th width="20%">回答三：</th>
							<td colspan="3" style="text-align: left;">${questionModel.answer3 }</td>
						</tr>
					</c:if>
					<c:if test="${questionModel.size == 0}">
						<tr>
							<td colspan="4"
								style=" width: 100%; text-align: center;">暂无信息！</td>
						</tr>
					</c:if>
				</table>
				<br />
			</div>
		<!-- end 详情内容-->
		<div class="boxbtn">
			<div class="btn">
				<a href="#none" class="closeButton">关闭</a>
			</div>
		</div><br/>
	</div>
</body>
</html>