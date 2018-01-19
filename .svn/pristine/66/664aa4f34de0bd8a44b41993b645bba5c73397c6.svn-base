<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${fn:escapeXml(vo.equipId.equip.name)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.bureau.value)}</td>
	<td>${fn:escapeXml(vo.equipId.satelliteSite.siteName)}</td> 
	<td>
	<fmt:formatDate value="${vo.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['kucarrierfreq_view']}">
		<a href="${rootUrl }maintain/pollinginfo/kucarrierfreqview.do?equipId=${vo.equipId.id}&recordTime=<fmt:formatDate value='${vo.recordTime}' type='date' pattern='yyyy-MM-dd HH:mm:ss' />"
		class="my_view {boxwidth:900,boxheight:420}">详情</a>
		</sec:authorize>
	</td>
</tr>
