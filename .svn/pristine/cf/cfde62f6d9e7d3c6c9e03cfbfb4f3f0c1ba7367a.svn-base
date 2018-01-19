<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr id="${vo.id }" tid="${vo.id }">
	<td>${fn:escapeXml(vo.columns.value)}</td>
	<td><div title='${fn:escapeXml(vo.title)}' style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${fn:escapeXml(vo.title)}</div></td>
	<td>${fn:escapeXml(vo.createUser.name)}-${fn:escapeXml(vo.createUser.loginName)}</td>
	<td>${fn:escapeXml(vo.status.value)}</td> 
	<td>
		<fmt:formatDate value="${vo.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
	<c:if test="${vo.status=='SUBMITTED' || vo.status=='MODIFIED'}">
	
		<a class="trace"
		href='#' pid='${vo.id }'
		title="点击查看流程图">部门经理查看</a>	
	</c:if>
	<c:if test="${vo.status=='FIRSTPASSED'}">
		
		<a class="trace" 
		href='#' pid='${vo.id }'
		title="点击查看流程图">事业部领导查看</a>	
	</c:if>
	<c:if test="${vo.status=='SECONDPASSED'}">
		
		<a class="trace" 
		href='#' pid='${vo.id }'
		title="点击查看流程图">发布专员查看</a>	
	</c:if>
	</td>
	<td class="tdbtn">
		<a href="${rootUrl }news/find.do?id=${vo.id}" class="my_edit {boxwidth:900,boxheight:610}">详细</a>
		<c:if test="${vo.status=='SUBMITTED'||vo.status=='FIRSTPASSED'||vo.status=='MODIFIED'}">
			<sec:authorize ifAnyGranted="${jspAuthorities['news_approve']}">
				<a href="${rootUrl }news/approve/approve.do?id=${vo.id}&processInstanceId=${vo.task.id}"
					class="my_edit {boxwidth:700,boxheight:610}">审批</a>
			</sec:authorize>
		</c:if>
		<c:if test="${vo.status=='SECONDPASSED'}">
		<sec:authorize ifAnyGranted="${jspAuthorities['news_publish']}">
			<a href="${rootUrl }news/publish.do?id=${vo.id}&processInstanceId=${vo.task.id}"
				class="my_edit {boxwidth:700,boxheight:610}">发布</a>
		</sec:authorize>
		</c:if>
	</td>
</tr>
