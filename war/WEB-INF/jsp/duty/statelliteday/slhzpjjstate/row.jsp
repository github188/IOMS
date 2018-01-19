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
	<td>十里河PES中频机架运行情况</td>
	<td>${vo.inr1}</td>
	<td>${vo.inr2}</td>
	<td>${vo.inr3}</td>
	<td>${vo.inr4}</td>
	<td>${vo.inr5}</td>
	<td>${vo.inr6}</td>
	<td>${vo.inr7}</td>
	<td>${vo.inrb}</td>
	<td>${vo.ebi}</td>
	<td>${vo.ebt}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhzpjjstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/slhzpjjstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_slhzpjjstate_del']}">
			<a
				href="${rootUrl}duty/statelliteday/slhzpjjstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_slhzpjjstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/slhzpjjstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>