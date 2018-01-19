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
	<td>${vo.checkContent.value}</td>
	<td>${vo.tes081.value}</td>
	<td>${vo.tes281.value}</td>
	<td>${vo.tes381.value}</td>
	<td>${vo.tes481.value}</td>
	<td>${vo.creater.name }<br /> <fmt:formatDate
			value="${vo.createTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.auditer.name }<br /> <fmt:formatDate
			value="${vo.auditTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td><c:if
			test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tes_day_audit']}">
				<a
					href="${rootUrl}duty/satellite/day/tes/audit.do?id=${vo.id}&optType=txjdmainstate"
					class="my_edit {boxwidth:1000,boxheight:600}">审核</a>
			</sec:authorize>
		</c:if> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:600}"
				href="${rootUrl}duty/satellite/day/tes/view.do?id=${vo.id}&optType=txjdmainstate">查看</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_del']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/delete.do?id=${vo.id}&optType=txjdmainstate"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_tes_day_main_update']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/tesmainstate/update.do?id=${vo.id}&optType=txjdmainstate"
				class="my_edit {boxwidth:1000,boxheight:600}">修改</a>
		</sec:authorize></td>
</tr>