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
	<td><fmt:formatDate value="${vo.recordTime}" type="both"
			pattern="yyyy-MM-dd HH:mm" /></td>
	<!------------- 远程访问 ------------>
	<td><c:choose>
			<c:when test="${vo.telnet eq 'UNNORMAL'}">
				<font>${vo.telnet.value}</font>
			</c:when>
			<c:otherwise>
                        ${vo.telnet.value}
                    </c:otherwise>
		</c:choose></td>
	<!------------- CPU利用率 ------------>
	<td>${vo.cpu }</td>
	<!-- 业务数据传输情况 -->
	<c:forEach items="${vo.atmDaySons}" var="atmDaySon">
		<td><c:choose>
				<c:when test="${atmDaySon.result eq 'NO'}">
					<font>${atmDaySon.result.value }</font>
				</c:when>
				<c:otherwise>
                        ${atmDaySon.result.value }
                    </c:otherwise>
			</c:choose></td>
	</c:forEach>
	<!------------- 操作人及时间 ------------>
	<td>${vo.creater.name }<br /> <fmt:formatDate
			value="${vo.recordTime}" type="both" pattern="yyyy-MM-dd HH:mm" />
	</td>
	<td>${vo.auditer.name }<br /> <fmt:formatDate
			value="${vo.auditTime}" type="both" pattern="yyyy-MM-dd HH:mm" /></td>
	<!-- 其他信息 -->
	<td><sec:authorize
			ifAnyGranted="${jspAuthorities['atm_check_router_view']}">
			<a class="my_edit {boxwidth:1000,boxheight:700}"
				href="${rootUrl}duty/atmday/router/view.do?id=${vo.id}">查看</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['atm_check_router_update']}">
			<a href="${rootUrl}duty/atmday/router/update.do?id=${vo.id}"
				class="my_edit {boxwidth:1000,boxheight:700}">修改</a>
		</sec:authorize> <sec:authorize
			ifAnyGranted="${jspAuthorities['atm_check_router_audit']}">
			<c:if
				test="${vo.creater.name ne currentUser.name and empty vo.auditer}">
				<a class="my_edit {boxwidth:1000,boxheight:700}"
					href="${rootUrl}duty/atmday/router/audit.do?id=${vo.id}">审核</a>
			</c:if>
		</sec:authorize>
		 <sec:authorize
			ifAnyGranted="${jspAuthorities['atm_check_router_del']}">
			<a href="${rootUrl}duty/atmday/router/delete.do?id=${vo.id}"
				id="removeRecord" confirm_message="你确定要删除此记录？" class="my_remove">删除</a>
		</sec:authorize>
		</td>
</tr>