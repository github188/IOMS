<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td width="8%"><c:if test="${vo.kuNode==null }">${vo.kuNodeNo}</c:if>
		<c:if test="${vo.kuNode!=null }">${vo.kuNode.kuNodeNo }</c:if></td>
	
	
	<td width="8%">${vo.kuNode.equip.bureau.value}</td>
	<td width="8%">${vo.kuNode.equip.satellite.siteName }</td>
	<td width="8%">${vo.status}</td>
	<td width="8%">
		<c:if test="${vo.UP eq null or (vo.UP + vo.DOWN) eq 0}">
			--
		</c:if>
		<c:if test="${vo.UP ne null and (vo.UP + vo.DOWN) ne 0 }">
			<fmt:formatNumber value="${vo.UP / (vo.UP + vo.DOWN)*100}" pattern="0.00"></fmt:formatNumber>%
		</c:if>
		
	</td>
	<c:choose>
		<c:when test="${vo.status == 'DOWN' }">
			<td width="10%">--</td>
		</c:when>
		<c:otherwise>
			<td width="10%">${vo.rxLevel}</td>
		</c:otherwise>
		
	</c:choose>
	<c:choose>
		<c:when test="${vo.status == 'DOWN' }">
			<td width="10%">--</td>
		</c:when>
		<c:otherwise>
			<td width="10%">${vo.ebno}</td>
		</c:otherwise>
		
	</c:choose>
	<td><fmt:formatDate value="${vo.ebnoTime.time}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.info}</td>
	<td width="10%" class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['kunodestatuslog']}">
			<c:if test="${vo.kuNode!=null }">

				<a class="my_view {boxwidth:700,boxheight:700}"
					href="${rootUrl }operstat/ku/log/manage.do?kuNodeId=${vo.kuNode.id }">
					变更日志</a>
			</c:if>
		</sec:authorize></td>

</tr>
