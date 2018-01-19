<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${vo.name}</td>
	<td>${vo.code}</td>
	<td><c:forEach items="${vo.kuMobiles}" var="ve"
			varStatus="veStatus">
	${ve.name}&nbsp;&nbsp;
	</c:forEach></td>
	<td><c:forEach items="${vo.kuMobiles}" var="vf"
			varStatus="vfStatus">
			<c:if test="${vf.sendmsgFlag eq 'yes' }">
	${vf.name}&nbsp;&nbsp;
	</c:if>
		</c:forEach></td>
	<td>${vo.bureau.value}</td>
	<td class="tdbtn"><sec:authorize
			ifAnyGranted="${jspAuthorities['equipmobile_config']}">
			<a href="${rootUrl }maintain/equipmobile/config.do?equipId=${vo.id}"
				class="my_edit {boxwidth:900,boxheight:600}">配置</a>
		</sec:authorize></td>
</tr>
