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
	<td>十里河网管进程状态</td>
	<td>${vo.tesBusiness}</td>
	<td>${vo.tesFault}</td>
	<td>${vo.tesRemark}</td>

	<td>${vo.pesBusiness}</td>
	<td>${vo.pesFault}</td>
	<td>${vo.pesRemark}</td>

	<td>${vo.ku1Business}</td>
	<td>${vo.ku1Fault}</td>
	<td>${vo.kuNet1Remark}</td>

	<td>${vo.ku2Business}</td>
	<td>${vo.ku2Fault}</td>
	<td>${vo.kuNet2Remark}</td>

	<td>${vo.ku3Business}</td>
	<td>${vo.ku3Fault}</td>
	<td>${vo.kuNet3Remark}</td>

	<td>${vo.kuBusiness}</td>
	<td>${vo.kuFault}</td>
	<td>${vo.kuRemark}</td>

	<td>${vo.comBusiness}</td>
	<td>${vo.comFault}</td>
	<td>${vo.comRemark}</td>

	<td>${vo.slhKuBusiness}</td>
	<td>${vo.slhKuFault}</td>
	<td>${vo.slhKuRemark}</td>

	<td>${vo.mhjTesBusiness}</td>
	<td>${vo.mhjTesFault}</td>
	<td>${vo.mhjTesReamrk}</td>

	<td>${vo.mhjKuBusiness}</td>
	<td>${vo.mhjKuFault}</td>
	<td>${vo.mhjKuRemark}</td>

	<td>${vo.sumBusiness}</td>
	<td>${vo.sumFault}</td>
	<td>${vo.sumRemark}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_cir_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/cir/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize ifAnyGranted="${jspAuthorities['sta_check_cir_del']}">
			<a href="${rootUrl}duty/statellite/cir/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_cir_update']}">
				<a href="${rootUrl}duty/statellite/cir/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>