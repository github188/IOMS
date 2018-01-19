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
	<td>通信基地TES查看网管同步状态</td>
	<td>${vo.syn081cu}</td>
	<td>${vo.syn081ckt}</td>
	<td>${vo.syn081hg}</td>
	<td>${vo.syn081dd}</td>
	<td>${vo.syn081router}</td>

	<td>${vo.syn281cu}</td>
	<td>${vo.syn281ckt}</td>
	<td>${vo.syn281hg}</td>
	<td>${vo.syn281dd}</td>
	<td>${vo.syn281router}</td>

	<td>${vo.syn381cu}</td>
	<td>${vo.syn381ckt}</td>
	<td>${vo.syn381hg}</td>
	<td>${vo.syn381dd}</td>
	<td>${vo.syn381router}</td>

	<td>${vo.syn481cu}</td>
	<td>${vo.syn481ckt}</td>
	<td>${vo.syn481hg}</td>
	<td>${vo.syn481dd}</td>
	<td>${vo.syn481router}</td>
	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tessynstate_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/tessynstate/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tessynstate_del']}">
			<a
				href="${rootUrl}duty/statelliteday/tessynstate/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tessynstate_update']}">
				<a
					href="${rootUrl}duty/statelliteday/tessynstate/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>