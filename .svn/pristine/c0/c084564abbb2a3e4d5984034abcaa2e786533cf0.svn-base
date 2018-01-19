
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${svo.creater.name}</td>
	<td>${svo.dutyRoles.value}</td>
	<td>${svo.dutyPlaces.value}</td>
	<td>${svo.remark}</td>
	<td>
		<fmt:formatDate value="${svo.creatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
	  <c:if test="${svo.creater.name eq username or (isManager eq 'yes' and svo.dutyRoles ne 'DUTYMANAGER')}">
	 	<a href="${rootUrl }turndutymng/change/mod.do?id=${svo.id}"
			class="my_edit  {boxwidth:700,boxheight:350}">修改</a>
		<a href="${rootUrl }turndutymng/change/del.do?id=${svo.id}"
		confirm_message="你确定要删除该记录吗？" class="my_remove">删除</a>
	  </c:if>
	 
	</td>
	
</tr>
