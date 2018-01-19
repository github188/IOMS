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
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>卫星备件信息</td>

	<td>1</td>
	<td>${vo.sys1}</td>
	<td>${vo.name1}</td>
	<td>${vo.sn1}</td>
	<td>${vo.address1}</td>
	<td>${vo.testresolt1}</td>
	<td>${vo.testtime1}</td>
	<td>${vo.remark1}</td>
	<td>${vo.testp1}</td>

	<td>2</td>
	<td>${vo.sys2}</td>
	<td>${vo.name2}</td>
	<td>${vo.sn2}</td>
	<td>${vo.address2}</td>
	<td>${vo.testresolt2}</td>
	<td>${vo.testtime2}</td>
	<td>${vo.remark2}</td>
	<td>${vo.testp2}</td>

	<td>3</td>
	<td>${vo.sys3}</td>
	<td>${vo.name3}</td>
	<td>${vo.sn3}</td>
	<td>${vo.address3}</td>
	<td>${vo.testresolt3}</td>
	<td>${vo.testtime3}</td>
	<td>${vo.remark3}</td>
	<td>${vo.testp3}</td>

	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_info_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/info/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize ifAnyGranted="${jspAuthorities['sta_check_info_del']}">
			<a href="${rootUrl}duty/statellite/info/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_info_update']}">
				<a href="${rootUrl}duty/statellite/info/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>