
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.callonNumber}</td>
	<td>${vo.calledNumber}</td>
	
	<td>
		<fmt:formatDate value="${vo.pickupTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>
		<fmt:formatDate value="${vo.callendTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.callDuration}</td>
	
	<td>${vo.userName}</td>
	
	<td>
	    <c:if test="${vo.recordFileName!='undefined'}">
			    <audio controls="controls">  
				  
				   <source src="${vo.fileServer}/${vo.recordFileName}" /> 
				   
				</audio> 
	        
	        &nbsp;
             <a href= "${vo.fileServer}/${vo.recordFileName}" target= "_blank" download >下载</a>
             
	    </c:if>
	</td>
</tr>
