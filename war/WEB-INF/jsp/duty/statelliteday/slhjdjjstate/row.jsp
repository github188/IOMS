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
	<td>十里河PES基带机架运行情况</td>
	<td>${vo.sic}</td>
	<td>${vo.sicb}</td>
	<td>${vo.ncc}</td>
	<td>${vo.nccb}</td>
	<td>${vo.dpc1}</td>
	<td>${vo.dpc2}</td>
	<td>${vo.dpc3}</td>
	<td>${vo.dpcb}</td>
	<td>${vo.suplim1}</td>
	<td>${vo.suplim2}</td>
	<td>${vo.suplim3}</td>
	<td>${vo.suplim4}</td>
	<td>${vo.suplim5}</td>
	<td>${vo.suplim6}</td>
	<td>${vo.suplimb}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhjdjjstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/slhjdjjstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhjdjjstate_del']}">
			<a
				href="${rootUrl}duty/statelliteday/slhjdjjstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_slhjdjjstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/slhjdjjstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>