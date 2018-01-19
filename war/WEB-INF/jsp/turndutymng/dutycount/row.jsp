
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.name}</td>
	<td>
	  <fmt:formatNumber type="number" value="${vo.managetimes}" maxFractionDigits="2"/>
	</td>
	<td>
	  <fmt:formatNumber type="number" value="${vo.engineertimes}" maxFractionDigits="2"/>
	</td>
	
	<td>
       <fmt:formatNumber type="number" value="${vo.sumtimes}" maxFractionDigits="2"/>
	</td> 
</tr>
