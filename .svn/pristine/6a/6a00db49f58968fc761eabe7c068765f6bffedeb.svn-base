
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>
	  <c:if test="${isManager=='yes' }">
	    <input type="checkbox"
				onclick="checkActiveSelect(this)" name="activeCheck"
				id="activeCheck_${vo.id}" value="${vo.id}"  />
	  </c:if>
	   <c:if test="${isManager=='no' }">
	       <c:if test="${username==vo.userName }">
	           <input type="checkbox"
				onclick="checkActiveSelect(this)" name="activeCheck"
				id="activeCheck_${vo.id}" value="${vo.id}"  />
	       </c:if>
	   </c:if>
	</td>
	<td>${vo.atncType.value }</td>
	<td>${vo.callonNumber}</td>
	<td>${vo.calledNumber}</td>
	<td>
		<fmt:formatDate value="${vo.ringingTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
		
	</td>
	<td>
		<fmt:formatDate value="${vo.pickupTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
		<c:if test="${vo.userName==null }">
	          ${vo.callState.value }
	     </c:if>
	</td>
	<td>
		<fmt:formatDate value="${vo.callendTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
	<td>${vo.callDuration}</td>
	<td>${vo.callonProvince}-${vo.callonCity}</td>
	<td>
	      ${vo.userName}
	      
	      </td>
	
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
