<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${fn:escapeXml(vo.news.columns.value)}</td>
	<td><div title='${fn:escapeXml(vo.news.title)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.news.title)}</div></td>
	<td>${fn:escapeXml(vo.news.createUser.name)}-${fn:escapeXml(vo.news.createUser.loginName)}</td>
	<td>${fn:escapeXml(vo.newsStatusEnum.value)}</td> 
	<td>${fn:escapeXml(vo.info)}</td> 
	<td>
		<fmt:formatDate value="${vo.optTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.optUser.loginName)}</td> 
</tr>
