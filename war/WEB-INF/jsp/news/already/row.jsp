<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${fn:escapeXml(vo.news.columns.value)}</td>
	<td><div title='${fn:escapeXml(vo.news.title)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.news.title)}</div></td>
	<td>${fn:escapeXml(vo.news.createUser.loginName)}</td>
	<td>${fn:escapeXml(vo.newsStatusEnum.value)}</td> 
	<td>${fn:escapeXml(vo.info)}</td> 
	<td>
		<fmt:formatDate value="${vo.optTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.optUser.loginName)}</td> 
	<td>
		<sec:authorize ifAnyGranted="${jspAuthorities['news_find']}">
			<a href="${rootUrl }news/find.do?id=${vo.news.id}"
				class="my_edit {boxwidth:900,boxheight:610}">详细</a>
		</sec:authorize>
		
		<c:if test="${vo.news.status!='MODIFI' && vo.news.status!='DRAFT'&& vo.news.status!='PUBLISHED'&& vo.news.status!='DELET'}">
			<a class="my_edit {boxwidth:700,boxheight:610}" 
			href='${rootUrl }news/graphimage.dox?id=${vo.news.id}' 
			title="点击查看流程图">流程图</a>	
		</c:if>
	</td>
</tr>
