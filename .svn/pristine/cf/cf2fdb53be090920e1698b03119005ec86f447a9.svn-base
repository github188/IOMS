<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${fn:escapeXml(vo.proxy.proxyName)}</td>
	<td>${fn:escapeXml(vo.satelliteSite.siteName)}</td> 
	<td>${fn:escapeXml(vo.satelliteSite.siteCode)}</td>
	<td>${fn:escapeXml(vo.satelliteSite.type)}</td>
	<td ${vo.status eq '告警'? "style='background-color:#ff3300'" : ''}>${fn:escapeXml(vo.status)}</td>
	<td>
	<c:choose>
	    <c:when test="${vo.ftpLink eq null}">无记录</c:when>
	    <c:when test="${vo.ftpLink ne null}">
	        <fmt:formatDate value="${vo.ftpLink.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	    </c:when>
	</c:choose>
	</td>
</tr>
