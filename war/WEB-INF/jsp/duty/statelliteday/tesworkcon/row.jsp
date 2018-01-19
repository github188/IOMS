<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
<!--
font {
	color: red;
	font-weight: bold;
}
-->
</style>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>通信基地TES网管工作站连通性</td>
	<td><c:choose>
			<c:when test="${vo.workstationcon081 eq '0'}">
	${vo.workstationcon081}
	</c:when>
			<c:otherwise>
				<font>${vo.workstationcon081}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.workstationcon281 eq '0'}">
	${vo.workstationcon281}
	</c:when>
			<c:otherwise>
				<font>${vo.workstationcon281}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.workstationcon381 eq '0'}">
	${vo.workstationcon381}
	</c:when>
			<c:otherwise>
				<font>${vo.workstationcon381}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.workstationcon481 eq '0'}">
	${vo.workstationcon481}
	</c:when>
			<c:otherwise>
				<font>${vo.workstationcon481}</font>
			</c:otherwise>
		</c:choose></td>
	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesworkcon_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/tesworkcon/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesworkcon_del']}">
			<a
				href="${rootUrl}duty/statelliteday/tesworkcon/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tesworkcon_update']}">
				<a
					href="${rootUrl}duty/statelliteday/tesworkcon/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>