<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.taskName}"></c:set>
	<td>${vo.applyBaseInfo.applyUser.name }</td>
	<td>${vo.applyBaseInfo.applyCom }</td>
	<td>${vo.applyBaseInfo.applyLinkman }</td>
	<td>${vo.applyBaseInfo.applyPhone }</td>
	<td>${vo.applyBaseInfo.applyType.value }</td>
	<td>${vo.applyOpttype.value }</td>
	<td>
		<fmt:formatDate value="${vo.applyBaseInfo.applyTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn">
		<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.approveStat.value}</a>
	</td>
	<td class="tdbtn">
		<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_detial']}">
			<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}formalcircuit/detail.do?id=${vo.id}">详情</a><br> 
		</sec:authorize>
		<c:if test="${fn:contains(role, '|csStaff|')}">
			<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_deal']}">
				<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/deal.do?id=${vo.id}&pid=${pi}">办理</a><br>
			</sec:authorize>
			<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_draft']}">
				<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/draft.do?id=${vo.id}">暂存</a><br>
			</sec:authorize>
		</c:if> 
		<c:if test="${fn:contains(role, '|engineer|')}">
			<c:if test="${vo.approveStat == 'engineer_config' or vo.approveStat == 'engineer_transfer'}">
				<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_deal']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/deal.do?id=${vo.id}&pid=${pi}">配置</a><br>
				</sec:authorize>
				<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_draft']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/draft.do?id=${vo.id}">暂存</a><br>
				</sec:authorize>
			</c:if>
			<c:if test="${vo.approveStat == 'engineer_firstaudit' or vo.approveStat == 'engineer_secondaudit'}">
				<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_deal']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/deal.do?id=${vo.id}&pid=${pi}">审批</a><br>
				</sec:authorize>
				<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_draft']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/draft.do?id=${vo.id}">暂存</a><br>
				</sec:authorize>
			</c:if>
		</c:if> 
		<c:if test="${fn:contains(role, '|atncLeader|') or fn:contains(role, '|csLeader|') or
						fn:contains(role, '|manager|') or fn:contains(role, '|fundmanager|')}">
			<sec:authorize ifAnyGranted="${jspAuthorities['formalcircuit_deal']}">
				<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}formalcircuit/deal.do?id=${vo.id}&pid=${pi}">审批</a><br>
			</sec:authorize>
		</c:if> 
		<c:choose>
			<c:when test="${vo.applyBaseInfo.applyType.value eq 'ATM正式电路'}">
				<a href="${rootUrl}formalcircuit/previewATM.dox?id=${vo.id}" target="_blank">下载申请表</a><br>
				<a href="${rootUrl}formalcircuit/previewATMConfig.dox?id=${vo.id}" target="_blank">下载ATM配置</a>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType.value eq 'TES正式电路'}">
				<a href="${rootUrl}formalcircuit/previewTES.dox?id=${vo.id}" target="_blank">下载申请表</a><br>
				<a href="${rootUrl}formalcircuit/previewTESConfig.dox?id=${vo.id}" target="_blank">下载TES配置</a>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType.value eq 'PES正式电路'}">
				<a href="${rootUrl}formalcircuit/previewPES.dox?id=${vo.id}" target="_blank">下载申请表</a><br>
				<a href="${rootUrl}formalcircuit/previewPESConfig.dox?id=${vo.id}" target="_blank">下载PES配置</a>
			</c:when>
			<c:otherwise>
				<a href="${rootUrl}formalcircuit/previewKU.dox?id=${vo.id}" target="_blank">下载申请表</a><br>
				<a href="${rootUrl}formalcircuit/previewKUConfig.dox?id=${vo.id}" target="_blank">下载KU配置</a><br>
			</c:otherwise>
		</c:choose>
	</td>
</tr>
