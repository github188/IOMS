<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.proxy.proxyName)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.siteName)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.siteCode)}</td>
	<td>${fn:escapeXml(vo.equipId.name)}</td>
	<td>${fn:escapeXml(vo.equipId.type.name)}</td>
	<td>${fn:escapeXml(vo.type.value)}</td>
	<td>${fn:escapeXml(vo.severity.value)}</td>
	<td>
	<fmt:formatDate value="${vo.startTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
	<fmt:formatDate value="${vo.endTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.repTimes)}</td>
	<td>
	<fmt:formatDate value="${vo.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.info)}</td>
</tr>
