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
	<td>通信基地TES网管工作站主备状态</td>
	<td>${vo.tes081}</td>
	<td>${vo.tes281}</td>
	<td>${vo.tes381}</td>
	<td>${vo.tes481}</td>
	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesmainstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/tesmainstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesmainstate_del']}">
			<a
				href="${rootUrl}duty/statelliteday/tesmainstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tesmainstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/tesmainstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>