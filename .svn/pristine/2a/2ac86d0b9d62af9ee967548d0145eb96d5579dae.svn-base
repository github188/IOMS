<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	<td>${fn:escapeXml(vo.loginName)}</td>
	<td>${fn:escapeXml(vo.name)}</td>
	<td><c:forEach items="${vo.roles}" var="role">
							${role.name}
		</c:forEach></td>
	<td><c:if test="${!vo.system }">自定义</c:if> <c:if
			test="${vo.system }">系统保留</c:if>
	</td>
	<td class="tdbtn" width="250px;"><c:if test="${!vo.system }">
			<sec:authorize ifAnyGranted="${jspAuthorities['usermng_view']}">
				<a href="${rootUrl }acl/user/view.do?id=${vo.id}"
					class="my_view {boxwidth:600,boxheight:290}">查看</a>
			</sec:authorize>
			<sec:authorize ifAnyGranted="${jspAuthorities['usermng_mod']}">
				<a href="${rootUrl }acl/user/mod.do?id=${vo.id}"
					class="my_edit {boxwidth:600,boxheight:460}">修改</a>
			</sec:authorize>

			<sec:authorize ifAnyGranted="${jspAuthorities['usermng_status']}">
				<c:if test="${vo.valid}">
					<a href="${rootUrl }acl/user/status.do?id=${vo.id}&status=false"
						class="my_remove" confirm_message="你确定要删除此用户？">删除</a>
				</c:if>
			</sec:authorize>
		</c:if></td>





</tr>
