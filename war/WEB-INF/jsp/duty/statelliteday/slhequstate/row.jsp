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
	<td>十里河PES网管设备状态</td>
	<td>${vo.dpc38}</td>
	<td>${vo.dpc58}</td>
	<td><c:choose>
			<c:when test="${vo.NCC62 eq 'Offline'}">
				<font>${vo.NCC62.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.NCC62.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.NCC63 eq 'Offline'}">
				<font>${vo.NCC63.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.NCC63.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.umodup eq 'R'}">
				<font>${vo.umodup.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.umodup.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.umoddown eq 'R'}">
				<font>${vo.umoddown.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.umoddown.value} 
                    </c:otherwise>
		</c:choose></td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhequstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/slhequstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhequstate_del']}">
			<a
				href="${rootUrl}duty/statelliteday/slhequstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_slhequstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/slhequstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>