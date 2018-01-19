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
	<td>北京网控中心TES站网管系统检查</td>

	<td><c:choose>
			<c:when test="${vo.recordGz eq 'INNORMAL'}">
				<font>${vo.recordGz.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.recordGz.value}
		                    </c:otherwise>
		</c:choose></td>
	<td>${vo.recordGzBz}</td>
	<td><c:choose>
			<c:when test="${vo.recordManual eq 'INNORMAL'}">
				<font>${vo.recordManual.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.recordManual.value}
		                    </c:otherwise>
		</c:choose></td>
	<td>${vo.recordManualBz}</td>
	<td><c:choose>
			<c:when test="${vo.recordBj eq 'INNORMAL'}">
				<font>${vo.recordBj.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.recordBj.value}
		                    </c:otherwise>
		</c:choose></td>
	<td>${vo.recordBjBz}</td>
	<td>${vo.recordBf}</td>
	<td>${vo.recordBfBz}</td>

	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tescheck_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/tescheck/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tescheck_del']}">
			<a href="${rootUrl}duty/statellite/tescheck/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tescheck_update']}">
				<a href="${rootUrl}duty/statellite/tescheck/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>