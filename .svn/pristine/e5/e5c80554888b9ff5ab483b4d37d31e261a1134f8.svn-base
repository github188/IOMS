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
<script type="text/javascript">
	$(function() {
		//预加载数据
	});
</script>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.equipName.value }</td>

	<td>${vo.carrierPeakShow }</td>
	<td>${vo.carrierNoiseShow }</td>

	<td>${vo.operator.name }</td>
	<td>
		<%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_slhpes_del']}">
			<a
				href="${rootUrl}duty/satellitedayauto/slhpes/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['satellite_auto_slhpes_update']}">
				<a
					href="${rootUrl}duty/satellitedayauto/slhpes/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if>
	</td>
</tr>
