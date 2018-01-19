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
			<c:when test="${vo.masterAbResult ne 'A' }">
				<font color="red">${vo.masterAbResult}</font>
			</c:when>
			<c:otherwise>
				${vo.masterAbResult}
			</c:otherwise>
		</c:choose></td>
	<td>${vo.receiveResultShow}</td>
	<td>${vo.transmitResultShow}</td>
	<td>${vo.attendownResult}</td>
	<td>${vo.attenupResult}</td>
	<td><c:choose>
			<c:when test="${vo.fixedResult ne 'GOOD' }">
				<font color="red">${vo.fixedResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.fixedResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.varResult ne 'GOOD' }">
				<font color="red">${vo.varResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.varResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.extpowerResult ne 'GOOD' }">
				<font color="red">${vo.extpowerResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.extpowerResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.exttempResult ne 'GOOD' }">
				<font color="red">${vo.exttempResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.exttempResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.lanResult ne 'GOOD' }">
				<font color="red">${vo.lanResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.lanResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.summaryResult ne 'GOOD' }">
				<font color="red">${vo.summaryResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.summaryResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.extResult ne 'GOOD' }">
				<font color="red">${vo.extResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.extResult.value}
			</c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.redundantResult ne 'GOOD' }">
				<font color="red">${vo.redundantResult.value}</font>
			</c:when>
			<c:otherwise>
				${vo.redundantResult.value}
			</c:otherwise>
		</c:choose></td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_day_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:600}"
				href="${rootUrl}duty/satellitedayauto/view.do?id=${vo.id}&optType=dsODU">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['satellite_auto_dsodu_del']}">
			<a href="${rootUrl}duty/satellitedayauto/dsodu/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['satellite_auto_dsodu_update']}">
				<a
					href="${rootUrl}duty/satellitedayauto/dsodu/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>
