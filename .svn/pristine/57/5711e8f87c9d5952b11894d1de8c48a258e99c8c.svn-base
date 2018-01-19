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
	<td>${vo.name}</td>
	<td>${vo.total}</td>

	<td>${vo.num1}</td>
	<td>${vo.address1}</td>
	<td>${vo.remark1}</td>
	<td>${vo.num2}</td>
	<td>${vo.address2}</td>
	<td>${vo.remark2}</td>
	<td>${vo.num3}</td>
	<td>${vo.address3}</td>
	<td>${vo.remark3}</td>
	<td>${vo.num4}</td>
	<td>${vo.address4}</td>
	<td>${vo.remark4}</td>
	<td>${vo.num5}</td>
	<td>${vo.address5}</td>
	<td>${vo.remark5}</td>
	<td>${vo.num6}</td>
	<td>${vo.address6}</td>
	<td>${vo.remark6}</td>
	<td>${vo.num7}</td>
	<td>${vo.address7}</td>
	<td>${vo.remark7}</td>
	<td>${vo.num8}</td>
	<td>${vo.address8}</td>
	<td>${vo.remark8}</td>
	<td>${vo.num9}</td>
	<td>${vo.address9}</td>
	<td>${vo.remark9}</td>
	<td>${vo.num10}</td>
	<td>${vo.address10}</td>
	<td>${vo.remark10}</td>
	<td>${vo.num11}</td>
	<td>${vo.address11}</td>
	<td>${vo.remark11}</td>
	<td>${vo.num12}</td>
	<td>${vo.address12}</td>
	<td>${vo.remark12}</td>
	<td>${vo.num13}</td>
	<td>${vo.address13}</td>
	<td>${vo.remark13}</td>
	<td>${vo.num14}</td>
	<td>${vo.address14}</td>
	<td>${vo.remark14}</td>
	<td>${vo.num15}</td>
	<td>${vo.address15}</td>
	<td>${vo.remark15}</td>
	<td>${vo.num16}</td>
	<td>${vo.address16}</td>
	<td>${vo.remark16}</td>
	<td>${vo.num17}</td>
	<td>${vo.address17}</td>
	<td>${vo.remark17}</td>
	<td>${vo.num18}</td>
	<td>${vo.address18}</td>
	<td>${vo.remark18}</td>
	<td>${vo.num19}</td>
	<td>${vo.address19}</td>
	<td>${vo.remark19}</td>
	<td>${vo.num20}</td>
	<td>${vo.address20}</td>
	<td>${vo.remark20}</td>
	<td>${vo.num21}</td>
	<td>${vo.address21}</td>
	<td>${vo.remark21}</td>
	<td>${vo.num22}</td>
	<td>${vo.address22}</td>
	<td>${vo.remark22}</td>
	<td>${vo.num23}</td>
	<td>${vo.address23}</td>
	<td>${vo.remark23}</td>
	<td>${vo.num24}</td>
	<td>${vo.address24}</td>
	<td>${vo.remark24}</td>
	<td>${vo.num25}</td>
	<td>${vo.address25}</td>
	<td>${vo.remark25}</td>
	<td>${vo.num26}</td>
	<td>${vo.address26}</td>
	<td>${vo.remark26}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_check_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/check/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_check_del']}">
			<a href="${rootUrl}duty/statellite/check/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_check_update']}">
				<a href="${rootUrl}duty/statellite/check/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>