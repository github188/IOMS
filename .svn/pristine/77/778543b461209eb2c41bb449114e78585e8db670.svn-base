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
	<td>${vo.n1001}</td>
	<td>${vo.n1002}</td>
	<td>${vo.n1003}</td>
	<td>${vo.n1004}</td>
	<td>${vo.n1005}</td>
	<td>${vo.n1006}</td>
	<td>${vo.n1007}</td>
	<td>${vo.n1008}</td>
	<td>${vo.n1009}</td>
	<td>${vo.n100a}</td>
	<td>${vo.n100b}</td>
	<td>${vo.n100e}</td>
	<td>${vo.n100f}</td>
	<td>${vo.n1010}</td>
	<td>${vo.n1011}</td>
	<td>${vo.n1012}</td>

	<td><c:choose>
			<c:when test="${vo.s1001 eq 'INNORMAL'}">
				<font>${vo.s1001.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1001.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1002 eq 'INNORMAL'}">
				<font>${vo.s1002.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1002.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1003 eq 'INNORMAL'}">
				<font>${vo.s1003.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1003.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1004 eq 'INNORMAL'}">
				<font>${vo.s1004.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1004.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1005 eq 'INNORMAL'}">
				<font>${vo.s1005.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1005.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1006 eq 'INNORMAL'}">
				<font>${vo.s1006.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1006.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1007 eq 'INNORMAL'}">
				<font>${vo.s1007.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1007.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1008 eq 'INNORMAL'}">
				<font>${vo.s1008.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1008.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1009 eq 'INNORMAL'}">
				<font>${vo.s1009.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1009.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s100a eq 'INNORMAL'}">
				<font>${vo.s100a.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s100a.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s100b eq 'INNORMAL'}">
				<font>${vo.s100b.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s100b.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s100e eq 'INNORMAL'}">
				<font>${vo.s100e.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s100e.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s100f eq 'INNORMAL'}">
				<font>${vo.s100f.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s100f.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1010 eq 'INNORMAL'}">
				<font>${vo.s1010.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1010.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1011 eq 'INNORMAL'}">
				<font>${vo.s1011.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1011.value}
		                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.s1012 eq 'INNORMAL'}">
				<font>${vo.s1012.value}</font>
			</c:when>
			<c:otherwise>
		                        ${vo.s1012.value}
		                    </c:otherwise>
		</c:choose></td>


	<td>${vo.operator.name }</td>
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesequ_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/statellite/tesequ/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <%-- <sec:authorize
			ifAnyGranted="${jspAuthorities['sta_check_tesequ_del']}">
			<a href="${rootUrl}duty/statellite/tesequ/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> --%> <c:if
			test="${(vo.operator.id eq currentUser.id and isflag eq 'yes' ) or currentUser.id eq 'admin'}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tesequ_update']}">
				<a href="${rootUrl}duty/statellite/tesequ/update.do?id=${vo.id}"
					class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
			</sec:authorize>
		</c:if></td>
</tr>