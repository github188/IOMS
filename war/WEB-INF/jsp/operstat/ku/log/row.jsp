<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${vo.kuNode.kuNodeNo }</td>
	<td>${vo.param }</td>
	<td>${vo.from}</td>
	<td>${vo.to}</td>
	<td><fmt:formatDate value="${vo.recordTime.time}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
</tr>
