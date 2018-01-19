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
	<td>${vo.equipName.value }</td>

	<td>${vo.link1001A }</td>
	<td>${vo.link1001B }</td>
	<td>${vo.link1001C }</td>
	<td>${vo.link1001D }</td>

	<td>${vo.link1002A }</td>
	<td>${vo.link1002B }</td>
	<td>${vo.link1002C }</td>
	<td>${vo.link1002D }</td>

	<td>${vo.link1003A }</td>
	<td>${vo.link1003B }</td>
	<td>${vo.link1003C }</td>
	<td>${vo.link1003D }</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_dspesteslink_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:500}"
				href="${rootUrl}duty/statelliteday/dsPesTesLink/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_dspesteslink_del']}">
			<a
				href="${rootUrl}duty/statelliteday/dsPesTesLink/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_dspesteslink_update']}">
				<a
					href="${rootUrl}duty/statelliteday/dsPesTesLink/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:500}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>