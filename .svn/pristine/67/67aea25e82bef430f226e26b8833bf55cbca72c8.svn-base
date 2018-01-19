<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${fn:escapeXml(vo.columns.value)}</td>
	<td><div title='${fn:escapeXml(vo.title)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.title)}</div></td>
	<td>${fn:escapeXml(vo.createUser.name)}-${fn:escapeXml(vo.createUser.loginName)}</td>
	<td>${fn:escapeXml(vo.status.value)}</td> 
	<td>
		<fmt:formatDate value="${vo.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
		<fmt:formatDate value="${vo.publishTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn">
		<sec:authorize ifAnyGranted="${jspAuthorities['news_find']}">
			<a href="${rootUrl }news/find.do?id=${vo.id}"
				class="my_edit {boxwidth:900,boxheight:610}">详细</a>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['news_modify']}">
			<c:if test="${vo.status=='DRAFT'}">
				<a href="${rootUrl }news/modify.do?id=${vo.id}"
					class="my_edit {boxwidth:700,boxheight:610}">修改</a>
			</c:if>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['news_modify']}">
			<c:if test="${vo.status=='FIRSTDISSENT' || vo.status=='SECONDDISSENT'}">
				<a href="${rootUrl }news/modify.do?id=${vo.id}"
					class="my_edit {boxwidth:700,boxheight:610}">纠正</a>
			</c:if>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['news_delete']}">
		<c:if test="${vo.status=='FIRSTDISSENT' || vo.status=='SECONDDISSENT'}">
			<a href="${rootUrl }news/delete.do?id=${vo.id}"
				confirm_message="你确定要删除该审批？" class="my_remove">删除</a>
		</c:if>
		</sec:authorize>
		<sec:authorize ifAnyGranted="${jspAuthorities['news_remove']}">
		<c:if test="${vo.status=='DRAFT'}">
			<a href="${rootUrl }news/remove.do?id=${vo.id}"
				confirm_message="你确定要删除此草稿？" class="my_remove">删除</a>
		</c:if>
		</sec:authorize>
	</td>
</tr>
