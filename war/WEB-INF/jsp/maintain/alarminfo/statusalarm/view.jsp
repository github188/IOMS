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
<body style="overflow-x:hidden">
	<div class="window">
		<dl class="title">
			<dd>状态告警详情</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>

		<!--begin 详情内容-->		

		<div
			style="float: right; padding-right: 70px; color: blue; padding-bottom: 5px;"></div>
		<div class="mtab">
	<table id="dataTable" width="100%" border="0" cellspacing="0"
	       cellpadding="2" class="tablesorter">
	            <tr>
				<th colspan="4"
						style="color: gray; width: 100%; text-align: center;">状态告警详情</th>
				</tr>
				<tr>
					<th width="30%">节点名称：</th>
					<td width="20%">${fn:escapeXml(pageModel.equipId.satelliteSite.proxy.proxyName)}</td>
					<th width="30%">站点名称：</th>
					<td width="20%">${fn:escapeXml(pageModel.equipId.satelliteSite.siteName)}</td>
				</tr>
				<tr>
					<th width="30%">设备名称：</th>
					<td width="20%">${fn:escapeXml(pageModel.equipId.name)}</td>
					<th width="30%">设备类型：</th>
					<td width="20%">${fn:escapeXml(pageModel.equipId.type.name)}</td>
				</tr>
				<tr>
					<th width="30%">告警类型：</th>
					<td width="20%">${fn:escapeXml(pageModel.type.value)}</td>
					<th width="30%">严重程度：</th>
					<td width="20%">${fn:escapeXml(pageModel.severity.value)}</td>
				</tr>
				<tr>
					<th width="30%">开始时间：</th>
					<td width="20%">
					<fmt:formatDate value="${pageModel.startTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<th width="30%">结束时间：</th>
					<td width="20%">
					<fmt:formatDate value="${pageModel.endTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<th width="30%">相应次数：</th>
					<td width="20%">${fn:escapeXml(pageModel.repTimes)}</td>
					<th width="30%">采集时间：</th>
					<td width="20%">
					<fmt:formatDate value="${pageModel.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<th width="30%">告警信息：</th>
					<td colspan="3" width="20%">${fn:escapeXml(pageModel.info)}</td>
				</tr>
    </table>
			<br/>
		</div>
		<!-- end 详情内容-->
	</div>
	<button style="width: 60px; height: 36px;" class="closeButton">关闭</button>
</body>
</html>