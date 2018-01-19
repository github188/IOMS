<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td style="width: 100px"><a
		href="${rootUrl }systemmng/client/view.do?id=${vo.client.id}"
		class="my_view {boxwidth:600,boxheight:360}">${fn:escapeXml(vo.client.loginName)}</a>
	</td>
	<td style="width: 100px"><a
		href="${rootUrl }systemmng/client/view.do?id=${vo.client.id}"
		class="my_view {boxwidth:600,boxheight:360}">${fn:escapeXml(vo.client.name)}</a>
	</td>
	<td>${vo.ip }</td>
	<td style="width: 140px"><fmt:formatDate
			value="${vo.optTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td style="width: 100px">${vo.menu.value }</td>
	<td style="width: 100px">${vo.subMenu.value }</td>
	<td style="width: 150px">${vo.optType }</td>
	<td>${fn:escapeXml(vo.info)}</td>
</tr>
