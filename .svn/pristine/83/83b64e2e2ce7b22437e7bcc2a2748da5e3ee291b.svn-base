<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	
	<td>
		<c:forEach items="${vo.transfer}" var="transfer" varStatus="status">
			<c:choose>
				<c:when test="${status.count == vo.transfer.size()}">${transfer.name}</c:when>
				<c:otherwise>${transfer.name},</c:otherwise>
			</c:choose>	
		</c:forEach>
	</td>
	<td>${fn:escapeXml(vo.name)}</td>
	<%-- <td>${fn:escapeXml(vo.loginName)}</td>
	<td>
		<c:forEach items="${vo.baseRoles}" var="role" varStatus="status">
			<c:choose>
				<c:when test="${status.count == vo.baseRoles.size()}">${role.name}</c:when>
				<c:otherwise>${role.name},</c:otherwise>
			</c:choose>	
		</c:forEach>
	</td>
	<td>
		<c:forEach items="${vo.transferRoles}" var="transferRole" varStatus="status">
			<c:choose>
				<c:when test="${status.count == vo.transferRoles.size()}">${transferRole.name}</c:when>
				<c:otherwise>${transferRole.name},</c:otherwise>
			</c:choose>	
		</c:forEach>
	</td> --%>
	<td class="tdbtn" width="250px;"><c:if test="${!vo.system }">
			<sec:authorize ifAnyGranted="${jspAuthorities['roletransfer_view']}">
				<a href="${rootUrl }roletransfer/view.do?id=${vo.id}"
					class="my_view {boxwidth:600,boxheight:290}">查看</a>
			</sec:authorize>
			<sec:authorize ifAnyGranted="${jspAuthorities['roletransfer_delete']}">
				<c:if test="${vo.valid}">
					<c:forEach items="${vo.transfer}" var="transfer">
						<c:if test="${transfer eq currentUser or currentUser.id eq 'admin' }">
							<a href="${rootUrl }roletransfer/delete.do?id=${vo.id}"
							class="my_remove" confirm_message="你确定要撤销授权角色吗？">撤销</a>
						</c:if>
					</c:forEach>
				</c:if>
			</sec:authorize>
		</c:if></td>
</tr>
