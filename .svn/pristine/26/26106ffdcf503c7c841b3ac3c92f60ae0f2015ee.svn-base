
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.creater.name}</td>
	<td>${vo.dutyRoles.value}</td>
	<td>${vo.dutyPlaces.value}</td>
	<%-- <td>${vo.signRecord.dutyStatus.value}</td> --%>
	<td>${vo.remark}</td>
	<td>
		<fmt:formatDate value="${vo.creatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	
	<td>${vo.operator.name}</td>
	<td>
	    <fmt:formatDate value="${vo.operatime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
	  <c:if test="${vo.signRecord.dutyStatus!='LEAVE' }">
	   <c:if test="${vo.creater.name eq username or (isManager eq 'yes' and dutyplace eq vo.dutyPlaces and vo.dutyRoles ne 'DUTYMANAGER')}">
	 	<a href="${rootUrl }turndutymng/onduty/mod.do?id=${vo.id}"
			class="my_edit  {boxwidth:700,boxheight:350}">修改</a>
		<a href="${rootUrl }turndutymng/onduty/del.do?id=${vo.id}"
		confirm_message="你确定要删除此记录吗？" class="my_remove">删除</a>
	   </c:if>
	  </c:if>
	</td>
</tr>
