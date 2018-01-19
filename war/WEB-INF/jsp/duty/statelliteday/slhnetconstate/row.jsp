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
	<td>十里河PES网管连通性</td>
	<td><c:choose>
			<c:when test="${vo.con3 eq '0'}">
	${vo.con3}
	</c:when>
			<c:otherwise>
				<font>${vo.con3}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.con4 eq '0'}">
	${vo.con4}
	</c:when>
			<c:otherwise>
				<font>${vo.con4}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.con5 eq '0'}">
	${vo.con5}
	</c:when>
			<c:otherwise>
				<font>${vo.con5}</font>
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.con6 eq '0'}">
	${vo.con6}
	</c:when>
			<c:otherwise>
				<font>${vo.con6}</font>
			</c:otherwise>
		</c:choose></td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhnetconstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/slhnetconstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhnetconstate_del']}">
			<a
				href="${rootUrl}duty/statelliteday/slhnetconstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_slhnetconstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/slhnetconstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>