<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${vo.port.node.bureau.value }</td>
	<td>${vo.port.node.atmNodeCode }</td>
	<td>${vo.port.card.cardSlot }</td>
	<td>${vo.IF_NUM }</td>
	<td>${vo.LINE_NUM }</td>
	<td>${vo.ADMIN_STATE }</td>
	<td>${vo.OPER_STATE }</td>
	<td>${vo.GUARANTEED_BANDWIDTH }</td>
	<td>${vo.MAX_BANDWIDTH }</td>
	<td>${vo.SCT_ID }</td>
	<td>${vo.IF_TYPE }</td>
	<td>${vo.VPI }</td>
	<td>${vo.MIN_VPI }</td>
	<td>${vo.MAX_VPI }</td>
	<td>${vo.IMAGRP_NUM }</td>
</tr>
