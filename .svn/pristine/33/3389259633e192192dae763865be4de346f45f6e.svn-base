<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.currentTaskName}"></c:set>
	<td>${fn:escapeXml(vo.columns.value)}</td>
	<td>${fn:escapeXml(vo.title)}</td>
	<td>${fn:escapeXml(vo.createUser.loginName)}</td>
	<%-- <td>${fn:escapeXml(vo.createTime.time)}</td> --%>
	<td>
		<fmt:formatDate value="${vo.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.status.value)}</td>
	<c:if test="${vo.status!='PUBLISHED'&&vo.status!='ZANCUN'}">
	<td>
		<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${tn}</a>	
	</td>
	</c:if>
	<c:if test="${vo.status=='PUBLISHED'}">
	 <td>${fn:escapeXml(vo.status.value)}</td> 
	</c:if>
	<c:if test="${vo.status=='ZANCUN'}">
	 <td>${fn:escapeXml(vo.status.value)}</td> 
	</c:if>
	
	<td class="tdbtn">
	<c:if test="${vo.status=='MODIFIED'&&vo.status!='ZANCUN'}">
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnotice_mod']}">
			<a href="${rootUrl }publicnotice/pn/mod.do?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:330}">修改后申请</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnotice_del']}">
			<a href="${rootUrl }publicnotice/pn/del.do?id=${vo.id}"
				confirm_message="你确定要撤销此公告申请？" class="my_remove">撤销</a>
		</sec:authorize>
		</c:if>
		<c:if test="${vo.status=='ZANCUN'}">
			<a href="${rootUrl }publicnotice/pn/delay.do?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:330}">继续申请</a>
				<sec:authorize ifAnyGranted="${jspAuthorities['publicnotice_del']}">
			<a href="${rootUrl }publicnotice/pn/del.do?id=${vo.id}"
				confirm_message="你确定要撤销此公告申请？" class="my_remove">撤销</a>
		</sec:authorize>
		</c:if>
		<c:if test="${vo.status!='ZANCUN'}">
		<a href="${rootUrl }publicnotice/pn/log.dox?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:330}">审批日志</a>
				</c:if>
		<%-- <c:if test="${vo.status=='DELETED'||vo.status='ZANCUN'}">
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnotice_del']}">
			<a href="${rootUrl }publicnotice/pn/del.do?id=${vo.id}"
				confirm_message="你确定要撤销此公告申请？" class="my_remove">申请撤销</a>
		</sec:authorize>
		</c:if> --%>
		</td>





</tr>
