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
	});
</script>
<tr>
	<td><fmt:formatDate value="${vo.checkTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.equipName.value }</td>
	<td>${vo.cpuResult}</td>
	<td><c:choose>
			<c:when test="${vo.jdmdPortResult eq 'up'}">
	${vo.jdmdPortResult.value}
	</c:when>
			<c:otherwise>
				<font>${vo.jdmdPortResult.value}</font>
			</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.ygPortResult eq 'up'}">
	${vo.ygPortResult.value}
	</c:when>
			<c:otherwise>
				<font>${vo.ygPortResult.value}</font>
			</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.nbePortResult eq 'online'}">
	${vo.nbePortResult.value}
	</c:when>
			<c:otherwise>
				<font>${vo.nbePortResult.value}</font>
			</c:otherwise>
		</c:choose></td>

	<td><c:choose>
			<c:when test="${vo.ygResult eq 'online'}">
	${vo.ygResult.value}
	</c:when>
			<c:otherwise>
				<font>${vo.ygResult.value}</font>
			</c:otherwise>
		</c:choose></td>

	<td>${vo.jdmdAddrResult}</td>
	<td>${vo.ygAddrResult}</td>
	<td>${vo.kmAddrResult}</td>
	<td>${vo.laAddrResult}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_day_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:600}"
				href="${rootUrl}duty/satellitedayauto/view.do?id=${vo.id}&optType=txjdOverseaHW">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_overseahw_del']}">
			<a
				href="${rootUrl}duty/satellitedayauto/overseahw/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['satellite_auto_overseahw_update']}">
				<a
					href="${rootUrl}duty/satellitedayauto/overseahw/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>
