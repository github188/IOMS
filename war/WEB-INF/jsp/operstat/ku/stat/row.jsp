<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td><fmt:formatDate value="${vo.statDate.time}" type="date"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.statusStandard}</td>
	<td>${vo.statusOver}</td>
	<td>[${vo.rxLevelLow},${vo.rxLevelTop}]</td>
	<td>${vo.rxLevelOver}</td>
	<td>${vo.ebnoTop}</td>
	<td>${vo.ebnoOver}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['kunodestatusinfo']}">
			<a
				href="${rootUrl }operstat/ku/node/manage.do?kuNodeStatusStatId=${vo.id}"
				class="my_view {boxwidth:800,boxheight:900}">节点运行状态</a>
		</sec:authorize></td>
</tr>
