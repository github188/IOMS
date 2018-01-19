<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.faultType.name }</td>
	<td>${vo.faultKey }</td>
	<td>${vo.contactPerson }</td>
	<td>
		<fmt:formatDate value="${vo.faultTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.faultStatus.name}</td>
	<td>
		<fmt:formatDate value="${vo.updateTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn">
	    <a class="my_view {boxwidth:1000,boxheight:500}" href="${rootUrl}techsupport/consult/deal/detail.do?id=${vo.id}">详情</a>
		<a class="my_edit {boxwidth:1000,boxheight:700}" href="${rootUrl}techsupport/consult/deal/reply.do?id=${vo.id}">回复</a>
	</td>
</tr>
