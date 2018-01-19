<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${fn:escapeXml(vo.wafr08Port0Stat.equipId.satelliteSite.bureau.value)}</td>
	<td>${vo.equipCircuit.kuService.serviceName}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.code)}</td> 
	<c:choose>
	    <c:when test="${vo.wafr08Port0Stat.dcd == 'UP'}">
	    	<td>正常</td>
	    </c:when>
	    <c:when test="${vo.wafr08Port0Stat.dcd == 'DOWN'}">
	    	<td style="background-color:#ff3300">告警</td>
	    </c:when>
	    <c:otherwise>
	    	<td>暂无信息</td>
	    </c:otherwise>
	</c:choose>
	<td ${vo.wafr08Port0Stat.charactersRatio eq '告警'? "style='background-color:#ff3300'" : ''}>${fn:escapeXml(vo.wafr08Port0Stat.charactersRatio)}</td>
	<td>${fn:escapeXml(vo.wafr08Port0Stat.currBitErr)}</td>
	<td>${fn:escapeXml(vo.wafr08Port0Stat.totalBitErr)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.circuitType)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.rateType.value)}</td>
	<td>${vo.equipCircuit.kuService.configTime}</td> 
	<td>${fn:escapeXml(vo.equipCircuit.kuService.txNode.kuNodeCode)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.txNode.equip.satellite.siteName)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.txNode.kuNodeNo)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.txGib)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.txChan)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.rxNode.kuNodeCode)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.rxNode.equip.satellite.siteName)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.rxNode.kuNodeNo)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.rxGib)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.rxChan)}</td>
	<td>${fn:escapeXml(vo.equipCircuit.kuService.memo)}</td>
	<td>
	    <fmt:formatDate value="${vo.wafr08Port0Stat.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
	</td>
</tr>
