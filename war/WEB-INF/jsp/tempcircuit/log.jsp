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
		$('.close').click(function() {
			parent.$.nyroModalRemove();
		});
	});
</script>
</head>
<body>
	<div class="window">
		<dl class="title">
			<dd>审批日志</dd>
			<dt>
				<a href="#none" class="close"><img
					src="${rootUrl }images/close.png" alt="关闭" /></a>
			</dt>
		</dl>
		<div class="mtab">
			<table id="dataTable" width="100%" style="height: 500" border="0"
				cellspacing="0" cellpadding="2" class="tablesorter">
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
					<c:forEach items="${tempCircuitOptLogs}" var="tempCircuitOptLog">
						<tr>
							<td width="20%">${tempCircuitOptLog.circuitOptType.name}</td>
							<td width="20%">${tempCircuitOptLog.fromStatus.name }</td>
							<td width="20%">${tempCircuitOptLog.toStatus.name }</td>
							<td width="10%">${tempCircuitOptLog.optUser }</td>
							<td width="10%"><fmt:formatDate
									value="${tempCircuitOptLog.optTime.time}" type="date"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td width="10%">${tempCircuitOptLog.circuitInfo }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- end 详情内容-->
		<div class="boxbtn">
			<div class="btn">
				<a href="#none" class="close">关闭</a>
			</div>
		</div>
		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		<br /> <br /> <br /> <br />
		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		<br /> <br /> <br />

	</div>
</body>
</html>
