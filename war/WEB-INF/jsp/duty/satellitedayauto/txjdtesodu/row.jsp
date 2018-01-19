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

	<td><c:choose>
			<c:when test="${vo.txaResult ne 'OK' }">
				<font color="red">${vo.txaResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.txaResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.rxaResult ne 'OK' }">
				<font color="red">${vo.rxaResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.rxaResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.txbResult ne 'OK' }">
				<font color="red">${vo.txbResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.txbResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.rxbResult ne 'OK' }">
				<font color="red">${vo.rxbResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.rxbResult.value}
			</c:otherwise>
		</c:choose></td>
	<td>${vo.txfreqA}</td>
	<td>${vo.rxfreqA}</td>
	<td>${vo.usAresult}</td>
	<td>${vo.dcAresult}</td>
	<td>${vo.txfreqB}</td>
	<td>${vo.rxfreqB}</td>
	<td>${vo.usBresult}</td>
	<td>${vo.dcBresult}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_day_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:600}"
				href="${rootUrl}duty/satellitedayauto/view.do?id=${vo.id}&optType=txjdTesODU">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_tesodu_del']}">
			<a
				href="${rootUrl}duty/satellitedayauto/tesodu/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['satellite_auto_tesodu_update']}">
				<a
					href="${rootUrl}duty/satellitedayauto/tesodu/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>