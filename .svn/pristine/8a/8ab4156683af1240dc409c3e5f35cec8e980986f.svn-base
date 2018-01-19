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
	<td>通信基地TES网管数据库</td>
	<td><c:choose>
			<c:when test="${vo.datastate eq 'INNORMAL'}">
				<font>${vo.datastate.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.datastate.value} 
                    </c:otherwise>
		</c:choose></td>
	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesdatastate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/tesdatastate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesdatastae_del']}">
			<a
				href="${rootUrl}duty/statelliteday/tesdatastate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tesdatestate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/tesdatastate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>