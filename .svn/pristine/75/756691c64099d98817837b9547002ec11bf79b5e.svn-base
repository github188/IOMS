<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td width="10%">${vo.number}</td>
	<td width="10%">${vo.circuitType.name}</td>
	<td width="10%">${vo.applyUserName}</td>
	<td width="10%">${vo.applyCompany}</td>
	<td width="8%"><fmt:formatDate value="${vo.planOpenTime.time}"
			type="date" pattern="yyyy-MM-dd" /></td>
	<td width="8%"><fmt:formatDate value="${vo.planEndTime.time}"
			type="date" pattern="yyyy-MM-dd" /></td>
	<td width="10%"><c:if
			test="${fn:startsWith(vo.circuitApplyType,'ATNCSUBMITTED')}">
			<c:if
				test="${vo.circuitStatus == 'DONE' || vo.circuitStatus == 'DELETED'|| vo.circuitStatus == 'ACKDELETED'}">${vo.circuitStatus.name}</c:if>
			<c:if
				test="${vo.circuitStatus != 'DONE' && vo.circuitStatus != 'DELETED' && vo.circuitStatus != 'ACKDELETED'}">
				<a href='#'
					onclick="getTempCircuitMngTrace('${vo.processInstanceId}')"
					title="点击查看流程图">${vo.circuitStatus.name}</a>
			</c:if>
		</c:if> <c:if test="${fn:startsWith(vo.circuitApplyType,'SUBMITTED')}">
			<c:if
				test="${vo.circuitStatus == 'DONE' || vo.circuitStatus == 'DELETED'|| vo.circuitStatus == 'ACKDELETED'}">${vo.circuitStatus.name}</c:if>
			<c:if
				test="${vo.circuitStatus != 'DONE' && vo.circuitStatus != 'DELETED' && vo.circuitStatus != 'ACKDELETED'}">
				<a class="trace" href='#'
					onclick="getTempCircuitTrace('${vo.processInstanceId}')"
					title="点击查看流程图">${vo.circuitStatus.name}</a>
			</c:if>
		</c:if> <c:if test="${vo.applyDelay == true}"> 已延期
	</c:if><c:if test="${vo.circuitExpireType == 'UPCOMING'}"> 即将到期
	</c:if> <c:if test="${vo.circuitExpireType == 'EXPIRE'}"> 已到期
	</c:if></td>
	<td width="10%"><fmt:formatDate value="${vo.updateTime.time}"
			type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td class="tdbtn" width="14%"><a
		href="${rootUrl }tempcircuit/log.do?tempcircuitid=${vo.id}"
		class="my_add{boxwidth:850,boxheight:500}">日志</a> <c:if
			test="${vo.circuitType=='FRATM'}">
			<a
				href="${rootUrl}tempcircuit/atmfratm/view.do?tempcircuitid=${vo.id}"
				class="my_view {boxwidth:850,boxheight:500}">电路明细</a>
		</c:if> <c:if test="${vo.circuitType=='MPLSVPN'}">
			<a
				href="${rootUrl}tempcircuit/atmmplsvpn/view.do?tempcircuitid=${vo.id}"
				class="my_view {boxwidth:850,boxheight:500}">电路明细</a>
		</c:if> <c:if test="${vo.circuitType=='TESDATA' || vo.circuitType=='TESBROADCAST'}">
			<a href="${rootUrl}tempcircuit/tesdb/view.do?tempcircuitid=${vo.id}"
				class="my_view {boxwidth:850,boxheight:500}">电路明细</a>
		</c:if> <c:if test="${vo.circuitType=='TESVOICE'}">
			<a
				href="${rootUrl}tempcircuit/tesaudio/view.do?tempcircuitid=${vo.id}"
				class="my_view {boxwidth:850,boxheight:500}">电路明细</a>
		</c:if> <c:if test="${vo.circuitType=='KUDATA'|| tempcircuit.circuitType=='KUBROADCAST'}">
			<a href="${rootUrl}tempcircuit/ku/view.do?tempcircuitid=${vo.id}"
				class="my_view {boxwidth:850,boxheight:500}">电路明细</a>
		</c:if></td>
	<td class="tdbtn" width="10%"><a href="#"
		onclick="cancel('${vo.id}')">电路撤单</a></td>
</tr>
