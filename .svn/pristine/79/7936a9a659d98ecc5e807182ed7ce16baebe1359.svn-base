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
	<c:forEach items="${vo.txjdSynResults}" var="txjdSynResult">
		<td>${txjdSynResult.cu }</td>
		<td>${txjdSynResult.ckt }</td>
		<td>${txjdSynResult.hg }</td>
		<td>${txjdSynResult.dd }</td>
		<td>${txjdSynResult.route }</td>
	</c:forEach>
	<td>${vo.creater.name }<br /> <fmt:formatDate
			value="${vo.createTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.auditer.name }<br /> <fmt:formatDate
			value="${vo.auditTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td><c:if
			test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tes_day_audit']}">
				<a
					href="${rootUrl}duty/satellite/day/tes/audit.do?id=${vo.id}&optType=txjdsynstate"
					class="my_edit {boxwidth:1000,boxheight:700}">审核</a>
			</sec:authorize>
		</c:if> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/satellite/day/tes/view.do?id=${vo.id}&optType=txjdsynstate">查看</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_del']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/delete.do?id=${vo.id}&optType=txjdsynstate"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_syn_update']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/tessynstate/update.do?id=${vo.id}"
				class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize></td>
</tr>