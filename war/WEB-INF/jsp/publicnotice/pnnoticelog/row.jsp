<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
	
	<td>${fn:escapeXml(vo.columns.value)}</td>
	<td>${fn:escapeXml(vo.title)}</td>
	<td>${fn:escapeXml(vo.createUser.loginName)}</td>
	<%-- <td>${fn:escapeXml(vo.createTime.time)}</td> --%>
	<td>
		<fmt:formatDate value="${vo.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${fn:escapeXml(vo.status.value)}</td>
	<td class="tdbtn">
	
		
			<a href="${rootUrl }publicnotice/pn/log.dox?id=${vo.id}"
				class="my_edit {boxwidth:850,boxheight:330}">详情</a>
		
		</td>





</tr>
