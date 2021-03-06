<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.taskName}"></c:set>
	<td>${vo.applyBaseInfo.applyUser.name }</td>
	<td>${vo.applyBaseInfo.applyCom }</td>
	<td>${vo.applyBaseInfo.applyLinkman }</td>
	<td>${vo.applyBaseInfo.applyPhone }</td>
	<td>
		<fmt:formatDate value="${vo.applyBaseInfo.applyTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn">
		<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.approveStat.value}</a>
	</td>
	<td class="tdbtn">
		<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_detail']}">
	    	<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}kusatellite/detail.do?id=${vo.id}">详情</a><br>
	    </sec:authorize>
		<c:if test="${fn:contains(role, '|csStaff|')}">
			<c:if test="${vo.approveStat == 'csstaff_audit' }"> 
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_deal']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/deal.do?id=${vo.id}&pid=${pi}">审核</a><br>
				</sec:authorize>
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_draft']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/draft.do?id=${vo.id}">暂存</a><br>
				</sec:authorize>	
			</c:if>
			<c:if test="${vo.approveStat == 'csstaff_deal' }"> 
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_deal']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/deal.do?id=${vo.id}&pid=${pi}">办理</a><br>	
				</sec:authorize>
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_draft']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/draft.do?id=${vo.id}">暂存</a><br>
				</sec:authorize>	
			</c:if>
		</c:if>
		<c:if test="${fn:contains(role, '|engineer|')}">
			<c:if test="${vo.approveStat == 'engineer_config' or vo.approveStat == 'assist_config'}"> 
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_deal']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/deal.do?id=${vo.id}&pid=${pi}">配置</a><br>
				</sec:authorize>
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_draft']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/draft.do?id=${vo.id}">暂存</a><br>
				</sec:authorize>	
			</c:if>
			<c:if test="${vo.approveStat == 'engineer_audit' or vo.approveStat == 'engineer_firstaudit'}"> 
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_deal']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/deal.do?id=${vo.id}&pid=${pi}">审核</a><br>
				</sec:authorize>
				<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_draft']}">
					<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/draft.do?id=${vo.id}">暂存</a><br>
				</sec:authorize>	
			</c:if>
		</c:if>
		<c:if test="${fn:contains(role, '|atncLeader|') or fn:contains(role, '|csLeader|') or
					fn:contains(role, '|manager|') or fn:contains(role, '|netmanager|') or
					fn:contains(role, '|fundmanager|') or fn:contains(role, '|leader|')}">
			<sec:authorize ifAnyGranted="${jspAuthorities['kusatellite_deal']}">		
				<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}kusatellite/deal.do?id=${vo.id}&pid=${pi}">审批</a><br>
			</sec:authorize>
		</c:if>
		<a href="${rootUrl}kusatellite/previewApply.dox?id=${vo.id}" target="_blank">下载申请表</a><br>
	</td>
</tr>
