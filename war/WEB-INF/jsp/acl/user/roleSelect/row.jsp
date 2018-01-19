<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
	<tr>
		<td>
			<input type="checkbox""  name="roleId" value="${vo.id }" id="roleId${vo.id }"/>
			<input type="hidden" value="${vo.name }" name="roleName" id="roleName${vo.id}"/>
		</td>
		<td>${fn:escapeXml(vo.name)}</td>
		<td>${fn:escapeXml(vo.info)}</td>
	</tr>
		