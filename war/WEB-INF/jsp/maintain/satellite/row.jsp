<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.satelliteSite.bureau.value}</td>
	<td>${vo.satelliteSite.siteName}</td>
	<td>${vo.reportDate}</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['satellitereport_write']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl }maintain/satellite/write.do?id=${vo.id}">补全信息</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['satellitereport_preview']}">
			<a
				href="${rootUrl }maintain/satellite/preview.do?id=${vo.id}">月度报表</a>
		</sec:authorize></td>
</tr>
