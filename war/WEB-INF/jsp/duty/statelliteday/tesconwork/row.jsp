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
	<td>通信基地TES控制信道</td>
	<td><c:choose>
			<c:when test="${vo.control100101 eq 'Failed'}">
				<font>${vo.control100101.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100101.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100102 eq 'Failed'}">
				<font>${vo.control100102.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100102.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100103 eq 'Failed'}">
				<font>${vo.control100103.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100103.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100104 eq 'Failed'}">
				<font>${vo.control100104.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100104.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100201 eq 'Failed'}">
				<font>${vo.control100201.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100201.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100202 eq 'Failed'}">
				<font>${vo.control100202.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100202.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100203 eq 'Failed'}">
				<font>${vo.control100203.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100203.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100204 eq 'Failed'}">
				<font>${vo.control100204.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100204.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100301 eq 'Failed'}">
				<font>${vo.control100301.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100301.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100302 eq 'Failed'}">
				<font>${vo.control100302.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100302.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100303 eq 'Failed'}">
				<font>${vo.control100303.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100303.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100304 eq 'Failed'}">
				<font>${vo.control100304.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100304.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100401 eq 'Failed'}">
				<font>${vo.control100401.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100401.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100402 eq 'Failed'}">
				<font>${vo.control100402.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100402.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100403 eq 'Failed'}">
				<font>${vo.control100403.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100403.value}
	                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.control100404 eq 'Failed'}">
				<font>${vo.control100404.value}</font>
			</c:when>
			<c:otherwise>
	                        ${vo.control100404.value}
	                    </c:otherwise>
		</c:choose></td>


	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesconwork_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statelliteday/tesconwork/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesconwork_del']}">
			<a
				href="${rootUrl}duty/statelliteday/tesconwork/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tesconwork_update']}">
				<a
					href="${rootUrl}duty/statelliteday/tesconwork/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>