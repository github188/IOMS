<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
font {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.createTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>通信基地TES网管工作站连通性</td>
	<td><c:choose>
			<c:when test="${vo.packetLoss081 eq '0'}">
	${vo.packetLoss081}
	</c:when>
			<c:otherwise>
				<font>${vo.packetLoss081}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.packetLoss281 eq '0'}">
	${vo.packetLoss281}
	</c:when>
			<c:otherwise>
				<font>${vo.packetLoss281}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.packetLoss381 eq '0'}">
	${vo.packetLoss381}
	</c:when>
			<c:otherwise>
				<font>${vo.packetLoss381}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.packetLoss481 eq '0'}">
	${vo.packetLoss481}
	</c:when>
			<c:otherwise>
				<font>${vo.packetLoss481}</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.creater.name }<br /> <fmt:formatDate
			value="${vo.createTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.auditer.name }<br /> <fmt:formatDate
			value="${vo.auditTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td><c:if
			test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tes_day_audit']}">
				<a
					href="${rootUrl}duty/satellite/day/tes/audit.do?id=${vo.id}&optType=txjdworkcon"
					class="my_edit {boxwidth:1000,boxheight:400}">审核</a>
			</sec:authorize>
		</c:if> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:400}"
				href="${rootUrl}duty/satellite/day/tes/view.do?id=${vo.id}&optType=txjdworkcon">查看</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_del']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/delete.do?id=${vo.id}&optType=txjdworkcon"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_workcon_update']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/tesworkcon/update.do?id=${vo.id}&optType=txjdworkcon"
				class="my_edit {boxwidth:1000,boxheight:400}">修改</a>
		</sec:authorize></td>
</tr>