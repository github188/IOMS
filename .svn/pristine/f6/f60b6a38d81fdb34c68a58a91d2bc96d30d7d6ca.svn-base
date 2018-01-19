<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }js/jquery/jquery.js" type="text/javascript"></script>
<script src="${rootUrl }js/jquery/jquery.nyroModal.js"
	type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$(".roleButton").nyroModal({
		forceType : "iframe",
		minWidth : 1000,
		minHeight : 450,
		closeButton : null
	});
});
</script>
<table cellpadding="0" cellspacing="0" border="0"
	style="padding: 0 0 10px; width: 100%">
	<tr>
		<td style="height: auto; width: 100%" class="td1" colspan="2">
			<div class="mtab" style="width: auto; height: auto;">
				<table style="margin: 0px" class="title">
					<tr>
						<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />节点告警信息</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="width: 100%">
			<div class="mtab" style="width: auto; height: 157px; overflow: auto;">
				<table id="dataTable" border="0" cellspacing="0" cellpadding="2"
					class="tablesorter"
					style="table-layout: fixed; margin: 0px; width: 100%">
					<thead>
						<tr>
							<th data-options="20%">Alarm Type</th>
							<th data-options="10%">Critical</th>
							<th data-options="10%">Major</th>
							<th data-options="10%">Minor</th>
							<th data-options="20%">是否告警</th>
							<th width="20%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${atmpagn}" var="vo" varStatus="voStatus">
							<tr>
								<td>${vo.nodeAlarmType.value }</td>
								<td>${vo.nodeCriticalSum }</td>
								<td>${vo.nodeMajorSum}</td>
								<td>${vo.nodeMinorSum}</td>
								<td>${vo.isAlarm.value}</td>
								<td class="tdbtn">
									<c:choose>
										<c:when test="${vo.nodeAlarmType=='Environment' || vo.nodeAlarmType=='Card' }">
											<a href="#" onclick="javascript:alert('请在下方查找对应告警的详情信息!');">详情</a>
										</c:when>
										<c:otherwise>
											<a href="#" onclick="javascript:alert('欲了解详情,请联系北京网控中心!');">详情</a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td style="height: auto; width: 50%" class="td1">
			<div class="mtab" style="width: auto; height: auto;">
				<table style="margin: 0px" class="title">
					<tr>
						<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />运行环境</td>
					</tr>
				</table>
			</div>
		</td>
		<td style="height: auto; width: 50%" class="td1">
			<div class="mtab" style="width: auto; height: auto;">
				<table style="margin-left: 0px" class="title">
					<tr>
						<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />板卡告警</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%">
			<div class="mtab"
				style="width: 100%;; height: 200px; overflow: auto;">
				<table id="dataTable" class="tablesorter"
					style="table-layout: fixed; margin: 0px; width: 100%">
					<thead>
						<tr>
							<th data-options="20%">Alarm Type</th>
							<th data-options="10%">Unit</th>
							<th data-options="10%">Threshold</th>
							<th data-options="10%">DataType</th>
							<th data-options="20%">Value</th>
							<th data-options="20%">State</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${envpagn}" var="vo" varStatus="voStatus">
							<tr>
								<td>${vo.nodeEnvAlarmType }</td>
								<td>${vo.nodeEnvUnit }</td>
								<td>${vo.nodeEnvThreshold}</td>
								<td>${vo.nodeEnvDataType}</td>
								<td>${vo.nodeEnvValue}</td>
								<td>${vo.nodeEnvState}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</td>
		<td style="width: 50%">
			<div class="mtab" style="width: 100%; height: 200px; overflow: auto;">
				<table id="dataTable" class="tablesorter"
					style="table-layout: fixed; margin-left: 0px; width: 100%">
					<thead>
							   <tr>
									<th rowspan="2">槽位号</th>
									<th rowspan="2">CardType</th>
									<th colspan="3">告警等级</th>
									<th rowspan="2">是否告警</th>
									<th rowspan="2">操作</th>
								</tr>
								<tr>
									<th width="15%">Critical</th>
									<th width="15%">Major</th>
									<th width="15%">Minor</th>
								</tr>
					</thead>
					<tbody>
						<c:forEach items="${cardpagn}" var="vo"
							varStatus="voStatus">
							<tr>
								<td>${vo.cardSlot }</td>
								<td>${vo.cardType }</td>
								<td>${vo.cardCriticalSum}</td>
								<td>${vo.cardMajorSum}</td>
								<td>${vo.cardMinorSum}</td>
								<td>${vo.isAlarm=='true'?'告警':'正常' }</td>
								<td class="tdbtn">
								    <a class="roleButton" href="${rootUrl}networkstat/getAtmCardAlarmDetail.dox?cardId=${vo.card.id}">详情</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td style="height: auto;" class="td1" colspan="2">
			<div class="mtab" style="width: auto; height: auto;">
				<table style="margin: 0px" class="title">
					<tr>
						<td class="td1"><img src="${rootUrl}images/pl1.gif" alt="" />业务告警</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<div class="mtab" style="width: auto; height: 200px; overflow: auto;">
				<table id="dataTable" border="0" cellspacing="0" cellpadding="2"
					class="tablesorter"
					style="table-layout: fixed; margin: 0px; width: 100%">
					<thead>
						<tr>
							<th rowspan="2">序号</th>
							<th rowspan="2">业务名称</th>
							<th colspan="3">本地节点</th>
							<th colspan="3">远端节点</th>
							<th rowspan="2">速率（kbps）</th>
							<th rowspan="2">服务等级</th>
							<th rowspan="2">状态</th>
							<th rowspan="2">操作</th>
						</tr>
						<tr>
							<th>节点名称</th>
							<th>端口号</th>
							<th>dlci/ vpi.vci</th>

							<th>节点名称</th>
							<th>端口号</th>
							<th>dlci/ vpi.vci</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${servicepagn}" var="vo"
							varStatus="voStatus">
							<tr>
								<td>${voStatus.index+1}</td>
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
									<a class="roleButton" 
									href="${rootUrl }basedata/atm/service/view.do?id=${vo.service.id}">详情</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</td>
	</tr>
</table>