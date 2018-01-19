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
	<td>卫星转发器频带资源使用统计</td>
	<td>${vo.tesSum}</td>
	<td>${vo.tesUse}</td>
	<td>${vo.tesSur}</td>
	<td>${vo.tesDbm}</td>
	<td>${vo.tesDb}</td>
	<td>${vo.pesSum}</td>
	<td>${vo.pesUse}</td>
	<td>${vo.pesSur}</td>
	<td>${vo.pesDbm}</td>
	<td>${vo.pesDb}</td>
	<td>${vo.comSum}</td>
	<td>${vo.comUse}</td>
	<td>${vo.comSur}</td>
	<td>${vo.comDbm}</td>
	<td>${vo.comDb}</td>

	<td>${vo.vsatSum}</td>
	<td>${vo.vsatUse}</td>
	<td>${vo.vsatSur}</td>
	<td>${vo.vsatDbm}</td>
	<td>${vo.vsatDb}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_forward_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/forward/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_forward_del']}">
			<a href="${rootUrl}duty/statellite/forward/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>  --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_forward_update']}">
				<a href="${rootUrl}duty/statellite/forward/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>