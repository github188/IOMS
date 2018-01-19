<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<tr>
    
	<td>${vo.card.node.bureau.value}</td>
	<td>${vo.card.node.atmNodeCode}</td>
	<td>${vo.cardSlot }</td>
	<td>${vo.cardAlarmStatus }</td>
	<c:if test="${vo.cardRunTime >= 400}">
		<td class="red">${vo.cardRunTime }</td>
	</c:if>
	<c:if test="${vo.cardRunTime < 400 && vo.cardRunTime >-1}">
		<td>${vo.cardRunTime }</td>
	</c:if>
	<c:if test="${vo.cardRunTime == -1 }">
		<td>--</td>
	</c:if>
	<td>${vo.cardFbState }</td>
	<td>${vo.card.cardFrontType }</td>
	<td>${vo.card.cardFrontSerial }</td>
	<td>${vo.card.cardBackUpperType }</td>
	<td>${vo.card.cardBackUpperSerial }</td>
	<td>${vo.card.cardBackLowerType }</td>
	<td>${vo.card.cardBackLowerSerial }</td>
	<td>${vo.card.cardBackType }</td>
	<td>${vo.card.cardBackSerial }</td>
	<td><fmt:formatDate value="${vo.recordTime.time}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
	
	
</tr>
