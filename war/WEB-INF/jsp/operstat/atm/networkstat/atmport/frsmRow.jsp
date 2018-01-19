<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.port.node.bureau.value }</td>
	<td>${vo.port.node.atmNodeCode }</td>
	<td>${vo.port.card.cardSlot }</td>
	<td>${vo.SLOT_NUM }</td>
	<td>${vo.PORT_LINE_NUM }</td>
	<td>${vo.PORT_NUM }</td>
	<td>${vo.PORT_ROW_STATUS }</td>
	<td>${vo.PORT_SPEED }</td>
	<td>${vo.PORT_EQUEUE_SERVICE_RATIO }</td>
	<td>${vo.SIGNAL_PROTOCOL_TYPE }</td>
	<td>${vo.t391_LINE }</td>
	<td>${vo.t392_POLL }</td>
	<td>${vo.n391_FULL }</td>
	<td>${vo.n392_POLL }</td>
	<td>${vo.n393_MONITOR }</td>
	<td>${vo.PORT_TYPE }</td>
	<td>${vo.PORT_SIGNAL }</td>
	<td>${vo.ENHANCED }</td>
</tr>
