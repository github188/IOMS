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
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.name}</td>
	<td>${vo.address}</td>
	<td>${vo.num}</td>
	<td>${vo.keeper.name}</td>
	<td>${vo.remark}</td>
	<td><fmt:formatDate value="${vo.storeTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.lendStatus.value}</td>
	<td>${vo.borrower.name}</td>
	<td><fmt:formatDate value="${vo.lendTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td><fmt:formatDate value="${vo.backTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>

	<td>${vo.operator.name}</td>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>

	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_tool_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/satellitetool/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize ifAnyGranted="${jspAuthorities['satellite_tool_del']}">
			<a href="${rootUrl}duty/satellitetool/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['satellite_tool_update']}">
				<a href="${rootUrl}duty/satellitetool/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>