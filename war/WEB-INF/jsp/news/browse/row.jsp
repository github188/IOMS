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
		<sec:authorize ifAnyGranted="${jspAuthorities['news_browse_find']}">
			<a href="${rootUrl }news/browsefind.do?id=${vo.id}"
				class="my_edit {boxwidth:900,boxheight:610}">详细</a>
		</sec:authorize>
	</td>
</tr>
