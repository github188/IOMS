<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.pnniLocalNodeName }</td>
	<td>${vo.pnniLocalPortid }</td>
	<td>${vo.pnniRemoteNodeName }</td>
	<td>${vo.pnniMax }</td>
	<td>${vo.pnniAvlKbps }</td>
	<c:if test="${1-((vo.pnniAvlKbps/1000)/vo.pnniMax) >= 0.8}">
		<td class="red">
			<fmt:formatNumber value="${(1-((vo.pnniAvlKbps/1000)/vo.pnniMax))*100}" pattern="0.00"></fmt:formatNumber>%
		</td>
	</c:if>
	<c:if test="${1-((vo.pnniAvlKbps/1000)/vo.pnniMax) >= 0.6 && 1-((vo.pnniAvlKbps/1000)/vo.pnniMax) < 0.8}">
		<td class="yellow">
			<fmt:formatNumber value="${(1-((vo.pnniAvlKbps/1000)/vo.pnniMax))*100}" pattern="0.00"></fmt:formatNumber>%
		</td>
	</c:if>
	<c:if test="${1-((vo.pnniAvlKbps/1000)/vo.pnniMax) < 0.6}">
		<td>
			<fmt:formatNumber value="${(1-((vo.pnniAvlKbps/1000)/vo.pnniMax))*100}" pattern="0.00"></fmt:formatNumber>%
		</td>
	</c:if>  
</tr>
