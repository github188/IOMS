<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
	<td>${voStatus.index+1+(pagn.currentPage-1)*pagn.pageSize}</td>
	<td>${vo.service.serviceName}</td>
	<td>${vo.service.localNodeNameCn}</td>
	<td>${vo.service.localPort }</td>
	<td>${vo.service.localPortDLCIVPIVCI }</td>
	<td>${vo.service.remoteNodeNameCn}</td>
	<td>${vo.service.remotePort }</td>
	<td>${vo.service.remotePortDLCIVPIVCI }</td>
	<td>${vo.service.serviceCir }</td>
	<td>${vo.service.serviceClass }</td>
	<td>${vo.isAlarm=='true'?'故障':'正常'}</td>
	<td class="tdbtn">
			<a href="${rootUrl }basedata/atm/service/view.do?id=${vo.service.id}"
				class="my_view {boxwidth:850,boxheight:480}">查看</a>
		</td>
</tr>
