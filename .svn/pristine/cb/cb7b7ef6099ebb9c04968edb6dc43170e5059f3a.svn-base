<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<style type="text/css">
font {
	color: red;
	font-weight: bold;
}
</style>
<tr>
	<td><fmt:formatDate value="${vo.createTime}" type="both"
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.checkContent.value}</td>
	<td><c:choose>
			<c:when test="${vo.PROCESS_STATE081 eq 'unnormal'}">
				<font>${vo.PROCESS_STATE081.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.PROCESS_STATE081.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.PROCESS_STATE281 eq 'unnormal'}">
				<font>${vo.PROCESS_STATE281.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.PROCESS_STATE281.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.PROCESS_STATE381 eq 'unnormal'}">
				<font>${vo.PROCESS_STATE381.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.PROCESS_STATE381.value} 
                    </c:otherwise>
		</c:choose></td>
	<td><c:choose>
			<c:when test="${vo.PROCESS_STATE481 eq 'unnormal'}">
				<font>${vo.PROCESS_STATE481.value} </font>
			</c:when>
			<c:otherwise>
                        ${vo.PROCESS_STATE481.value} 
                    </c:otherwise>
		</c:choose></td>
	<td>${vo.creater.name }<br /> <fmt:formatDate
			value="${vo.createTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td>${vo.auditer.name }<br /> <fmt:formatDate
			value="${vo.auditTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<td><c:if
			test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
			<sec:authorize
				ifAnyGranted="${jspAuthorities['sat_check_tes_day_audit']}">
				<a
					href="${rootUrl}duty/satellite/day/tes/audit.do?id=${vo.id}&optType=txjdprostate"
					class="my_edit {boxwidth:1000,boxheight:600}">审核</a>
			</sec:authorize>
		</c:if> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:400}"
				href="${rootUrl}duty/satellite/day/tes/view.do?id=${vo.id}&optType=txjdprostate">查看</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_del']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/delete.do?id=${vo.id}&optType=txjdprostate"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['sat_check_day_tes_pro_update']}">
			<a
				href="${rootUrl}duty/satellite/day/tes/tesprostate/update.do?id=${vo.id}&optType=txjddatastate"
				class="my_edit {boxwidth:1000,boxheight:400}">修改</a>
		</sec:authorize></td>
</tr>