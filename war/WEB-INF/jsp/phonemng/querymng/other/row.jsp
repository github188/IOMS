
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.callonNumber}</td>
	<td>${vo.calledNumber}</td>
	<td>
		<fmt:formatDate value="${vo.ringingTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
		
	</td>
	<td>
		<fmt:formatDate value="${vo.pickupTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
		<c:if test="${vo.userName==null }">
	          ${vo.callState.value }
	     </c:if>
	</td>
	<td>
		<fmt:formatDate value="${vo.callendTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.callDuration}</td>
	<td>${vo.callonProvince}-${vo.callonCity}</td>
	<td>
	      ${vo.userName}
	      
	      </td>
	
	
</tr>
