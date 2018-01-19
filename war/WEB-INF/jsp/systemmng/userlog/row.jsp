<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<%-- <td>${fn:escapeXml(vo.id)}</td> --%>
	<td>${fn:escapeXml(vo.user.name)}</td>	
	<td>${fn:escapeXml(vo.user.loginName)}</td>	
	<td>${fn:escapeXml(vo.user.dept)}</td>
	<td>${fn:escapeXml(vo.ip)}</td>
	<td>${fn:escapeXml(vo.menu)}</td>
	<td>${fn:escapeXml(vo.subMenu)}</td>
	<td>${fn:escapeXml(vo.optType)}</td>
	<td>
		<fmt:formatDate value="${vo.optTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	
	<%-- <td>${fn:escapeXml(vo.optTime)}</td> --%>
	<td>${fn:escapeXml(vo.info)}</td>
</tr>
