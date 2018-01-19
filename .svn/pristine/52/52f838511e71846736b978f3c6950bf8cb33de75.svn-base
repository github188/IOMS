<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<c:set var="pi" value="${vo.processInstanceId}" />
	<c:set var="tn" value="${vo.taskName}"></c:set>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.applyBaseInfo.serialNumber }</td>
	<td>${vo.applyBaseInfo.applyUser.name }</td>
	<td>${vo.applyBaseInfo.applyCom }</td>
	<td>${vo.applyBaseInfo.applyLinkman }</td>
	<td>${vo.applyBaseInfo.applyPhone}</td>
	<td><fmt:formatDate value="${vo.applyBaseInfo.applyTime.time}"
			type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	<td>${vo.applyBaseInfo.applyType.value}</td>
	<td class="tdbtn"><c:choose>
			<c:when test="${vo.applyBaseInfo.applyType.value eq '数据通信网'}">
				<c:choose>
					<c:when
						test="${vo.approveStatNWS eq 'unsubmitted' or vo.approveStatNWS eq 'deal'}">
						${vo.approveStatNWS.value}
					</c:when>
					<c:otherwise>
						<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.approveStatNWS.value}</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType.value eq '自动转报网'}">
				<c:choose>
					<c:when
						test="${vo.approveStatTNS eq 'unsubmitted' or vo.approveStatTNS eq 'deal'}">
						${vo.approveStatTNS.value}
					</c:when>
					<c:otherwise>
						<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.approveStatTNS.value}</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when
				test="${vo.applyBaseInfo.applyType.value eq 'ATM正式电路' ||
				vo.applyBaseInfo.applyType.value eq 'KU正式电路'||vo.applyBaseInfo.applyType.value eq 'TES正式电路'
				|| vo.applyBaseInfo.applyType.value eq 'PES正式电路'}">
				<c:choose>
					<c:when
						test="${vo.formalStatEnum eq 'unsubmitted' or vo.formalStatEnum eq 'deal'}">
						${vo.formalStatEnum.value}
					</c:when>
					<c:otherwise>
						<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.formalStatEnum.value}</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when
				test="${vo.applyBaseInfo.applyType.value eq 'ATM退网'  or vo.applyBaseInfo.applyType.value eq 'PES系统退网' or vo.applyBaseInfo.applyType.value eq 'TES系统退网'
				or vo.applyBaseInfo.applyType.value eq 'ku系统退网'}">
				<c:choose>
					<c:when
						test="${vo.approveStatus eq 'unsubmitted' or vo.approveStatus eq 'evaluated'}">
						${vo.approveStatus.value}
					</c:when>
					<c:otherwise>
						<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.approveStatus.value}</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType.value eq '卫星通信网地球站'}">
				<c:choose>
					<c:when
						test="${vo.approveStatus eq 'unsubmitted' or vo.approveStatus eq 'evaluated'}">
						${vo.approveStatus.value}
					</c:when>
					<c:otherwise>
						<a class="trace" href='#' pid="${pi}" title="点击查看流程图"> <c:if
								test="${vo.approveStatus eq 'returned'}">已退回</c:if> <c:if
								test="${vo.approveStatus ne 'returned'}">${vo.approveStatus.value}</c:if>
						</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when
				test="${vo.applyBaseInfo.applyType.value eq '转报地址' or vo.applyBaseInfo.applyType.value eq '转报电路'}">
				<c:choose>
					<c:when
						test="${vo.tgasStat eq 'unsubmitted' or vo.tgasStat eq 'evaluated'}">
						${vo.tgasStat.value}
					</c:when>
					<c:otherwise>
						<a class="trace" href='#' pid="${pi}" title="点击查看流程图">${vo.tgasStat.value}</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
			无
			</c:otherwise>
		</c:choose></td>
	<td class="tdbtn"><a class="my_view {boxwidth:1000,boxheight:500}"
		href="${rootUrl}taskrecord/detail.do?id=${vo.applyBaseInfo.id}">详情</a><br>
		<c:choose>
			<c:when test="${vo.applyBaseInfo.applyType eq 'satellite_ku'}">
				<a href="${rootUrl}kusatellite/previewApply.dox?id=${vo.id}"
					target="_blank">下载申请表</a>
				<br>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType eq 'telegraph'}">
				<a href="${rootUrl}telegraph/previewApply.dox?id=${vo.id}"
					target="_blank">下载申请表</a>
				<br>
				<c:if
					test="${vo.tgasStat eq 'local_evaluate' or vo.tgasStat eq 'evaluated'}">
					<a href="${rootUrl}telegraph/previewConfig.dox?id=${vo.id}"
						target="_blank">下载配置表</a>
					<br>
				</c:if>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType eq 'telegraph_circuit'}">
				<a href="${rootUrl}telegraphcircuit/previewApply.dox?id=${vo.id}"
					target="_blank">下载申请表</a>
				<br>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType eq 'datacomnetwork'}">
				<a href="${rootUrl}datacomnetwork/previewApply.dox?id=${vo.id}"
					target="_blank">下载申请表</a>
				<br>
				<c:if
					test="${vo.tgasStat eq 'local_evaluate' or vo.tgasStat eq 'evaluated'}">
					<a href="${rootUrl}datacomnetwork/previewConfig.dox?id=${vo.id}"
						target="_blank">下载记录表</a>
					<br>
				</c:if>
			</c:when>
			<c:when test="${vo.applyBaseInfo.applyType eq 'transfernet'}">
				<a href="${rootUrl}transfernet/previewApply.dox?id=${vo.id}"
					target="_blank">下载申请表</a>
				<br>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${vo.applyBaseInfo.applyType eq 'formalcircuit_atm'}">
						<a href="${rootUrl}formalcircuit/previewATM.dox?id=${vo.id}"
							target="_blank">下载申请表</a>
						<br>
						<a href="${rootUrl}formalcircuit/previewATMConfig.dox?id=${vo.id}"
							target="_blank">下载配置表</a>
						<br>
					</c:when>
					<c:when test="${vo.applyBaseInfo.applyType eq 'formalcircuit_tes'}">
						<a href="${rootUrl}formalcircuit/previewTES.dox?id=${vo.id}"
							target="_blank">下载申请表</a>
						<br>
						<a href="${rootUrl}formalcircuit/previewTESConfig.dox?id=${vo.id}"
							target="_blank">下载配置表</a>
						<br>
					</c:when>
					<c:when test="${vo.applyBaseInfo.applyType eq 'formalcircuit_pes'}">
						<a href="${rootUrl}formalcircuit/previewPES.dox?id=${vo.id}"
							target="_blank">下载申请表</a>
						<br>
						<a href="${rootUrl}formalcircuit/previewPESConfig.dox?id=${vo.id}"
							target="_blank">下载配置表</a>
						<br>
					</c:when>
					<c:when test="${vo.applyBaseInfo.applyType eq 'formalcircuit_ku'}">
						<a href="${rootUrl}formalcircuit/previewKU.dox?id=${vo.id}"
							target="_blank">下载申请表</a>
						<br>
						<a href="${rootUrl}formalcircuit/previewKUConfig.dox?id=${vo.id}"
							target="_blank">下载配置表</a>
						<br>
					</c:when>
					<c:when
						test="${vo.applyBaseInfo.applyType eq 'signoutnet_atm' 
						or vo.applyBaseInfo.applyType eq 'signoutnet_pes'
						or vo.applyBaseInfo.applyType eq 'signoutnet_tes' 
						or vo.applyBaseInfo.applyType eq 'signoutnet_ku' }">
						<a href="${rootUrl}signoutnet/previewApply.dox?id=${vo.id}"
							target="_blank">下载申请表</a>
					</c:when>
				</c:choose>
			</c:otherwise>
		</c:choose></td>
</tr>
