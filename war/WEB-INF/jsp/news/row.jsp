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
		<a href="${rootUrl }news/find.do?id=${vo.id}"
			class="my_edit {boxwidth:900,boxheight:610}">详细</a>
		
		<c:if test="${vo.status!='DELETED' && vo.status!='PUBLISHED' && vo.status!='DRAFT'}">
		<sec:authorize ifAnyGranted="${jspAuthorities['news_delete']}">
			<a href="${rootUrl }news/delete.do?id=${vo.id}"
				confirm_message="你确定要删除此公告申请？" class="my_update">删除</a>
		</sec:authorize>
		</c:if>
		<c:if test="${vo.status=='DRAFT'}">
		<sec:authorize ifAnyGranted="${jspAuthorities['news_remove']}">
			<a href="${rootUrl }news/remove.do?id=${vo.id}"
				confirm_message="你确定要删除此草稿？" class="my_remove">删除</a>
		</sec:authorize>
		</c:if>
	</td>
</tr>
