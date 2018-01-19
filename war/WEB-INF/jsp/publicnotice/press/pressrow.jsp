<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<%-- <tr id="${pnnoticelist.id }" tid="${pnnoticelist.id }"> --%>
	<td>${fn:escapeXml(pnnoticelist.columns.value)}</td>
	<td>${fn:escapeXml(pnnoticelist.title) }</td>
	<td>${fn:escapeXml(pnnoticelist.createUser.name)}</td>
	<%-- <td>${fn:escapeXml(vo.createTime.time)}</td> --%>
	<td>
		<fmt:formatDate value="${pnnoticelist.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(pnnoticelist.status.value)}</td>
	<td class="tdbtn">
		<sec:authorize ifAnyGranted="${jspAuthorities['publicnoticeapplypress']}">
			<a href="${rootUrl }publicnotice/pn/applyPress.do?id=${pnnoticelist.id}&&processInstanceId=${pnnoticelist.task.id}"
				class="my_edit {boxwidth:850,boxheight:330}">发布</a>
		</sec:authorize>
			<a href="${rootUrl }publicnotice/pn/log.dox?id=${pnnoticelist.id}"
				class="my_edit {boxwidth:850,boxheight:330}">审批日志</a>
		
	</td>





</tr>
