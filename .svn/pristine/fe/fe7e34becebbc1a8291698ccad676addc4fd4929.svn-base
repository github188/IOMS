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
<script src="${rootUrl }js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.pager.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.manage.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.validate.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.metadata.js" type="text/javascript"></script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>公告详情</dd>
			<dt>
				<a href="#none" class="closeButton"><img src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div class="mtab">
			<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="2" class="tablesorter">
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
						<td>${fn:escapeXml(news.columns.value)}</td>
						<td>${fn:escapeXml(news.title)}</td>
						<td>${news.content}</td>
						<td>${fn:escapeXml(news.createUser.loginName)}</td>
						<td>${fn:escapeXml(news.createTime)}</td>
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
			<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="2" class="tablesorter">
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
					<c:forEach items="${newsOptlogs}" var="newsOptlog">
						<td width="20%">${newsOptlog.newsStatusEnum.value}</td>
						<td width="20%">${newsOptlog.inNewsStatusEnum.value }</td>
						<td width="20%">${newsOptlog.outNewsStatusEnum.value }</td>
						<td width="10%">${newsOptlog.optUser.loginName }</td>
						<td width="10%">${newsOptlog.optTime }</td>
						<td width="10%">${newsOptlog.info }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		$(function() {
			$('.closeButton').click(function() {
				parent.$.nyroModalRemove();
			});
		});
	</script>
</body>
</html>
