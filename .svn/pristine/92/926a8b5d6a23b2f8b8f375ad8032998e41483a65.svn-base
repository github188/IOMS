<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.bureau.value)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.siteName)}</td>
	<td ${vo.alarmStatus.value eq '异常'? "style='background-color:#ff3300'" : ''}>${fn:escapeXml(vo.alarmStatus.value)}</td>
	<td>${fn:escapeXml(vo.equipId.name)}</td> 
	<td>
	<fmt:formatDate value="${vo.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
	<c:choose>
	    <c:when test="${fn:escapeXml(vo.alarmStatus.value) eq '异常'}">
	        <sec:authorize ifAnyGranted="${jspAuthorities['statusalarm_view']}">
		         <a href="${rootUrl }maintain/alarminfo/statusalarmview.do?id=${vo.equipId.id}"
			        class="my_view {boxwidth:850,boxheight:300}">查看</a>
	        </sec:authorize>
	     </c:when>
	</c:choose>
	<sec:authorize ifAnyGranted="${jspAuthorities['statusalarm_history']}">
		<a href="${rootUrl }maintain/alarminfo/statusalarmhistory.do?equipId=${vo.equipId.id}"
		     class="my_view {boxwidth:1200,boxheight:460}">历史</a>
	</sec:authorize>
	</td>
</tr>
