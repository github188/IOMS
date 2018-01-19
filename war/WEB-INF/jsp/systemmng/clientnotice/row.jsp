<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>

		<td>${voStatus.count+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.phoneNo}</td>
	<td>${vo.email}</td>
	<td>${vo.noticeState.name}</td>
	<td>${vo.noticeType.value}</td>
	<td><fmt:formatDate value="${vo.sendTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
</td>
	<td style="word-wrap:break-word">${vo.info}</td>

</tr>
