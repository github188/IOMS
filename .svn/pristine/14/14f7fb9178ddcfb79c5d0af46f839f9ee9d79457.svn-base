<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
font {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.checkEquip.value}</td>
	<td>${vo.oduOnSide}</td>
	<td>${vo.oduLevel}</td>
	<td>${vo.occCarrNoise}</td>

	<td><c:choose>
			<c:when test="${vo.blowerState eq 'normal' }">
	${vo.blowerState.value}
	</c:when>
			<c:otherwise>
				<font>${vo.blowerState.value}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.linkState eq 'normal' }">
	${vo.linkState.value}
	</c:when>
			<c:otherwise>
				<font>${vo.linkState.value}</font>
			</c:otherwise>
		</c:choose></td>
	<c:if
		test="${vo.checkEquip eq 'TxjdOutTesEquip' or vo.checkEquip eq 'MhjOutTesEquip'}">
		<td>${vo.temperatureA}</td>
		<td>${vo.temperatureB}</td>
	</c:if>
	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_outside_equip_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:500}"
				href="${rootUrl}duty/statellite/outsideequip/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_outside_equip_del']}">
			<a
				href="${rootUrl}duty/statellite/outsideequip/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_outside_equip_update']}">
				<a
					href="${rootUrl}duty/statellite/outsideequip/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:500}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>