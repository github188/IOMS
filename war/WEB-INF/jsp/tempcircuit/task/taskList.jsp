<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>临时电路审批任务</title>
<script type="text/javascript">
	var rootUrl = '${rootUrl }';
	$(function() {
		$('.trace').click(graphTempCircuitTrace);
		$('.tracemng').click(graphTempCircuitMngTrace);
	});
</script>
</head>
<body>
	<table id="dataTable" width="100%" border="0" cellspacing="0"
		cellpadding="2">
		<thead>
			<tr>
				<th>电路类型</th>
				<th>申请人</th>
				<th>申请单位</th>
				<th>当前状态</th>
				<th>当前节点</th>
				<th>申请时间</th>
				<th>查看</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${taskList}" var="tempcircuit">
				<c:set var="task" value="${tempcircuit.task }" />
				<c:set var="pi" value="${tempcircuit.processInstance}" />
				<tr id="${tempcircuit.id }" tid="${tempcircuit.id }">
					<td>${tempcircuit.circuitType.name }</td>
					<td>${tempcircuit.applyUserName }</td>
					<td>${tempcircuit.applyCompany }</td>
					<td>${tempcircuit.circuitStatus.name}</td>
					<td class="tdbtn"><c:if
							test="${fn:startsWith(tempcircuit.circuitApplyType,'ATNCSUBMITTED')}">
							<a class="tracemng" href='#' pid="${pi.id }" title="点击查看流程图">${task.name }</a>
						</c:if> <c:if
							test="${fn:startsWith(tempcircuit.circuitApplyType,'SUBMITTED')}">
							<a class="trace" href='#' pid="${pi.id }" title="点击查看流程图">${task.name }</a>
						</c:if></td>
					<td><fmt:formatDate value="${tempcircuit.recordTime.time}"
							type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="tdbtn"><c:if
							test="${tempcircuit.circuitType =='FRATM'}">
							<a
								href="${rootUrl}tempcircuit/atmfratm/view.do?tempcircuitid=${tempcircuit.id}"
								class="my_view{boxwidth:850,boxheight:500}">电路申请信息</a>
						</c:if> <c:if test="${tempcircuit.circuitType  =='MPLSVPN'}">
							<a
								href="${rootUrl}tempcircuit/atmmplsvpn/view.do?tempcircuitid=${tempcircuit.id}"
								class="my_view{boxwidth:850,boxheight:500}">电路申请信息</a>
						</c:if> <c:if
							test="${tempcircuit.circuitType  =='TESDATA' || tempcircuit.circuitType=='TESBROADCAST'}">
							<a
								href="${rootUrl}tempcircuit/tesdb/view.do?tempcircuitid=${tempcircuit.id}"
								class="my_view{boxwidth:850,boxheight:500}">电路申请信息</a>
						</c:if> <c:if test="${tempcircuit.circuitType =='TESVOICE'}">
							<a
								href="${rootUrl}tempcircuit/tesaudio/view.do?tempcircuitid=${tempcircuit.id}"
								class="my_view{boxwidth:850,boxheight:500}">电路申请信息</a>
						</c:if> <c:if
							test="${tempcircuit.circuitType  =='KUDATA'|| tempcircuit.circuitType=='KUBROADCAST'}">
							<a
								href="${rootUrl}tempcircuit/ku/view.do?tempcircuitid=${tempcircuit.id}"
								class="my_view{boxwidth:850,boxheight:500}">电路申请信息</a>
						</c:if><a
						href="${rootUrl }tempcircuit/log.do?tempcircuitid=${tempcircuit.id}"
						class="my_view{boxwidth:850,boxheight:500} tdbtn">日志</a></td>
					<td class="tdbtn"><a
						href="${rootUrl}tempcircuit/audit.do?tempcircuitid=${tempcircuit.id}&&tempcircuitpi=${task.id}&&circuitStatus=${tempcircuit.circuitStatus}"
						class="my_add {boxwidth:1000,boxheight:650}">办理</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<br />
	<!--查询结果-->
</body>
</html>
