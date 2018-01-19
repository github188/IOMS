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
	<td>卫星工具借用</td>
	<td>${vo.name1}</td>
	<td>${vo.num1}</td>
	<td>${vo.remark1}</td>
	<td>${vo.name2}</td>
	<td>${vo.num2}</td>
	<td>${vo.remark2}</td>
	<td>${vo.name3}</td>
	<td>${vo.num3}</td>
	<td>${vo.remark3}</td>
	<td>${vo.name4}</td>
	<td>${vo.num4}</td>
	<td>${vo.remark4}</td>
	<td>${vo.name5}</td>
	<td>${vo.num5}</td>
	<td>${vo.remark5}</td>
	<td>${vo.name6}</td>
	<td>${vo.num6}</td>
	<td>${vo.remark6}</td>
	<td>${vo.name7}</td>
	<td>${vo.num7}</td>
	<td>${vo.remark7}</td>
	<td>${vo.name8}</td>
	<td>${vo.num8}</td>
	<td>${vo.remark8}</td>
	<td>${vo.name9}</td>
	<td>${vo.num9}</td>
	<td>${vo.remark9}</td>
	<td>${vo.name10}</td>
	<td>${vo.num10}</td>
	<td>${vo.remark10}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tool_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/tool/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize ifAnyGranted="${jspAuthorities['sta_check_tool_del']}">
			<a href="${rootUrl}duty/statellite/tool/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sta_check_tool_update']}">
				<a href="${rootUrl}duty/statellite/tool/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>