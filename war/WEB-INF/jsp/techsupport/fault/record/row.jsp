<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td width="10%">${vo.faultType.name }</td>
	<td width="10%">${vo.faultKey }</td>
	<td width="15%">${vo.contactPerson}</td>
	<td width="15%">
		<fmt:formatDate value="${vo.faultTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	</td>
	<td width="10%">${vo.faultStatus.name }</td>
	<td width="20%">
		<fmt:formatDate value="${vo.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	</td>
	<td class="tdbtn" width="10%">
		<a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}techsupport/fault/record/detail.do?id=${vo.id}" >详情</a>
	</td>
</tr>
