<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.cardRunInfoType.value }</td>
	<td>${vo.cardCriticalSum}</td>
	<td>${vo.cardMajorSum}</td>
	<td>${vo.cardMinorSum}</td>
</tr>
