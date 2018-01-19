<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body style="overflow-x: hidden">
	<div class="window">
		<dl class="title">
			<dd>衰减器管理--查看</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
			<table width="100%">
				<tr>
					<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">衰减器信息</th>
				</tr>
				<tr>
					<th width="20%">站点名称</th>
					<td width="30%">${pageModel.site.siteName}</td>
					<th width="20%">站点代码</th>
					<td width="30%">${pageModel.site.siteCode}</td>
				</tr>
				<tr>
					<th width="20%">区域</th>
					<td width="30%">${pageModel.site.bureau.value}</td>
					<th width="20%">站点类型</th>
					<td width="30%">${pageModel.site.type}</td>
				</tr>
				<tr>
					<th width="20%">中频发射固定/可调衰减值</th>
					<td width="30%">${pageModel.solidLanch}</td>
					<th width="20%">中频接收固定/可调衰减值</th>
					<td width="30%">${fn:escapeXml(pageModel.solidReceive)}</td>
				</tr>



				<tr>
					<th width="20%">修改人</th>
					<td width="30%">${pageModel.client.name}</td>
					<th width="20%">修改时间</th>
					<td width="30%"><fmt:formatDate
							value="${pageModel.clientOptTime.time}" type="date"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>

				<tr>
					<th width="20%">备注</th>
					<td colspan="3">${pageModel.info}</td>
				</tr>
			</table>
			<br />
		</div>
		<!-- end 详情内容-->
	</div>
</body>
</html>