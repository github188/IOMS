<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${fn:escapeXml(vo.columns.value)}</td>
	<td><div title='${fn:escapeXml(vo.title)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.title)}</div></td>
	<td>${fn:escapeXml(vo.createUser.loginName)}</td>
	<td>${fn:escapeXml(vo.status.value)}</td> 
	<td>
		<fmt:formatDate value="${vo.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td class="tdbtn">
		<c:if test="${vo.status!='MODIFI' && vo.status!='DRAFT'&& vo.status!='PUBLISHED'&& vo.status!='DELET'}">
			<a class="my_edit {boxwidth:700,boxheight:610}" 
			href='${rootUrl }news/graphimage.dox?id=${vo.id}' 
			title="点击查看流程图">流程图</a>	
		</c:if>
		<sec:authorize ifAnyGranted="${jspAuthorities['news_find']}">
			<a href="${rootUrl }news/find.do?id=${vo.id}"
				class="my_edit {boxwidth:900,boxheight:610}">详细</a>
		</sec:authorize>
		<c:if test="${vo.status=='MODIFI' || vo.status=='DRAFT'}">
		<sec:authorize ifAnyGranted="${jspAuthorities['news_modify']}">
			<a href="${rootUrl }news/modify.do?id=${vo.id}"
				class="my_edit {boxwidth:700,boxheight:610}">修改</a>
		</sec:authorize>
		</c:if>
	</td>
</tr>
