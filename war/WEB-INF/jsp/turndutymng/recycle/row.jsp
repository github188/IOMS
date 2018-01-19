
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.creater.name}</td>
	<td>${vo.dutyRoles.value}</td>
	<td>${vo.dutyPlaces.value}</td>
	
	<td>${vo.remark}</td>
	<td>
		<fmt:formatDate value="${vo.creatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	
	<td>${vo.operator.name}</td>
	<td>
	    <fmt:formatDate value="${vo.operatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	
</tr>
