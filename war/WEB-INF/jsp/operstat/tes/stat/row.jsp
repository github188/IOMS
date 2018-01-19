<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>
		<fmt:formatDate value="${vo.statDate.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.over)}</td>
	<td>${fn:escapeXml(vo.normal)}</td>
	<td>${fn:escapeXml(vo.standard)}</td>
	<td class="tdbtn">
		<a href="${rootUrl }operstat/tes/stat/find.do?id=${vo.id}"
			class="my_edit {boxwidth:700,boxheight:800}">查看</a>
	</td>
</tr>
