<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${rootUrl }css/main.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/top_b.css" />
<link rel="stylesheet" type="text/css" href="${rootUrl }css/pager.css" />
<link rel="stylesheet" href="${rootUrl}css/window.css" type="text/css" />
<link rel="stylesheet" href="${rootUrl}css/main.css" type="text/css" />

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
			<dd>公告详情</dd>
			<dt>
				<a href="#none" class="closeButton"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div class="mtab">
			<table id="dataTable" width="100%" border="0" cellspacing="0"
				cellpadding="2" class="tablesorter">
				<thead>
					<tr>
						<th>栏目</th>
						<th>标题</th>
						<th>内容</th>
						<th>提交用户</th>
						<th>提交时间</th>
					</tr>
				</thead>
				<tbody>
					<tr>
				<td>${fn:escapeXml(pnnotice.columns.value)}</td>
				<td>${fn:escapeXml(pnnotice.title)}</td>
				<td>${pnnotice.content}</td>
				<td>${fn:escapeXml(pnnotice.createUser.loginName)}</td>
				<td>${fn:escapeXml(pnnotice.createTime)}</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="window">
		<dl class="title">
			<dd>审批日志</dd>
		</dl>
		<div class="mtab">
			<table id="dataTable" width="100%" border="0" cellspacing="0"
				cellpadding="2" class="tablesorter">
				<thead>
					<tr>
						<th>操作类型</th>
						<th>起始状态</th>
						<th>结束状态</th>
						<th>操作用户</th>
						<th>操作时间</th>
						<th>备注信息</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pnnoticeOptLogs}" var="pnnoticeOptLog">
						<td width="20%">${pnnoticeOptLog.pnNoticeOptType.value}</td>
						<td width="20%">${pnnoticeOptLog.fromPnNoticeStatusEnum.value }</td>
						<td width="20%">${pnnoticeOptLog.toPnNoticeStatusEnum.value }</td>
						<td width="10%">${pnnoticeOptLog.optUser.loginName }</td>
						<td width="10%">${pnnoticeOptLog.optTime }</td>
						<%-- <td width="10%"><fmt:formatDate
								value="${pnnoticeOptLog.optTime.time}" type="date"
								pattern="yyyy-MM-dd HH:mm:ss" /></td> --%>
						<td width="10%">${pnnoticeOptLog.info }</td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
